package io.github.nathensample.killmailvalidator.model;

public enum  ItemSlot
{
    MAINHAND("mainhand"),
    OFFHAND("offhand"),
    HELM("head"),
    CHEST("armor"),
    BOOTS("shoes"),
    CAPE("cape");

    private final String cssName;

    ItemSlot(String cssName)
    {
        this.cssName = cssName;
    }

    public String toString()
    {
        return this.cssName;
    }
}
