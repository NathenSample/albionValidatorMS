package io.github.nathensample.killmailvalidator.model;

public class ItemSet
{
    private final Item helm;
    private final Item chest;
    private final Item boots;
    private final Item mainhand;
    private final Item offhand;
    private final Item cape;

    public ItemSet(ItemSetBuilder builder)
    {
        this.helm = builder.helm;
        this.chest = builder.chest;
        this.boots = builder.boots;
        this.mainhand = builder.mainhand;
        this.offhand = builder.offhand;
        this.cape = builder.cape;
    }

    @Override
    public String toString()
    {
        return "ItemSet{" +
                "helm=" + helm +
                ", chest=" + chest +
                ", boots=" + boots +
                ", mainhand=" + mainhand +
                ", offhand=" + offhand +
                ", cape=" + cape +
                '}';
    }

    public static ItemSetBuilder getBuilder()
    {
        return new ItemSetBuilder();
    }

    public static class ItemSetBuilder
    {
        private Item helm;
        private Item chest;
        private Item boots;
        private Item mainhand;
        private Item offhand;
        private Item cape;

        private ItemSetBuilder()
        {
            //Hide public constructor
        }

        public ItemSetBuilder setHelm(Item helm)
        {
            this.helm = helm;
            return this;
        }

        public ItemSetBuilder setChest(Item chest)
        {
            this.chest = chest;
            return this;
        }

        public ItemSetBuilder setBoots(Item boots)
        {
            this.boots = boots;
            return this;
        }

        public ItemSetBuilder setMainhand(Item mainhand)
        {
            this.mainhand = mainhand;
            return this;
        }

        public ItemSetBuilder setOffhand(Item offhand)
        {
            this.offhand = offhand;
            return this;
        }

        public ItemSetBuilder setCape(Item cape)
        {
            this.cape = cape;
            return this;
        }

        public void addPiece(ItemSlot slot, Item item)
        {
            switch (slot) {
                case MAINHAND:
                    setMainhand(item);
                    return;
                case OFFHAND:
                    setOffhand(item);
                    return;
                case HELM:
                    setHelm(item);
                    return;
                case CHEST:
                    setChest(item);
                    return;
                case BOOTS:
                    setBoots(item);
                    return;
                case CAPE:
                    setChest(item);
            }
        }

        public ItemSet build()
        {
            return new ItemSet(this);
        }
    }
}
