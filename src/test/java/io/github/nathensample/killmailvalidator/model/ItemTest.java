package io.github.nathensample.killmailvalidator.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ItemTest
{

    @Test
    public void shouldParseTier1()
    {
        Item item = new Item("Beginner's Cleric Robe");
        Assert.assertEquals("Beginner's Cleric Robe", item.getItemName());
        Assert.assertEquals("beginners cleric robe", item.getStandardizedName());
        Assert.assertEquals(1, item.getTier());
    }

    @Test
    public void shouldParseTier2()
    {
        Item item = new Item("Novice's Cleric Robe");
        Assert.assertEquals("Novice's Cleric Robe", item.getItemName());
        Assert.assertEquals("novices cleric robe", item.getStandardizedName());
        Assert.assertEquals(2, item.getTier());
    }

    @Test
    public void shouldParseTier3()
    {
        Item item = new Item("Journeyman's Cleric Robe");
        Assert.assertEquals("Journeyman's Cleric Robe", item.getItemName());
        Assert.assertEquals("journeymans cleric robe", item.getStandardizedName());
        Assert.assertEquals(3, item.getTier());
    }

    @Test
    public void shouldParseTier4()
    {
        Item item = new Item("Adept's Graveguard Boots");
        Assert.assertEquals("Adept's Graveguard Boots", item.getItemName());
        Assert.assertEquals("adepts graveguard boots", item.getStandardizedName());
        Assert.assertEquals(4, item.getTier());
    }

    @Test
    public void shouldParseTier5()
    {
        Item item = new Item("Expert's Wailing Bow");
        Assert.assertEquals("Expert's Wailing Bow", item.getItemName());
        Assert.assertEquals("experts wailing bow", item.getStandardizedName());
        Assert.assertEquals(5, item.getTier());
    }

    @Test
    public void shouldParseTier6()
    {
        Item item = new Item("Master's Cleric Robe");
        Assert.assertEquals("Master's Cleric Robe", item.getItemName());
        Assert.assertEquals("masters cleric robe", item.getStandardizedName());
        Assert.assertEquals(6, item.getTier());
    }

    @Test
    public void shouldParseTier7()
    {
        Item item = new Item("Grandmaster's Cleric Robe");
        Assert.assertEquals("Grandmaster's Cleric Robe", item.getItemName());
        Assert.assertEquals("grandmasters cleric robe", item.getStandardizedName());
        Assert.assertEquals(7, item.getTier());
    }

    @Test
    public void shouldParseTier8()
    {
        Item item = new Item("Elder's Knight Helmet");
        Assert.assertEquals("Elder's Knight Helmet", item.getItemName());
        Assert.assertEquals("elders knight helmet", item.getStandardizedName());
        Assert.assertEquals(8, item.getTier());
    }
}