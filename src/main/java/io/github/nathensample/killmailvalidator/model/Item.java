package io.github.nathensample.killmailvalidator.model;

import java.util.Arrays;
import java.util.List;

public class Item
{
    private final String itemName;
    private final String standardizedName;
    private final int tier;
    private static final List<String> tiers = Arrays.asList("beginner", "novice", "journeyman", "adept", "expert", "master", "grandmaster", "elder");

    public Item(String itemName)
    {
        this.itemName = itemName;
        this.standardizedName = standardizeName(itemName);
        this.tier = parseTierFromName();
    }

    private String standardizeName(String itemName)
    {
        return itemName.toLowerCase().replace("'", "");
    }

    private int parseTierFromName()
    {
        for (int i = 0; i < tiers.size(); i++)
        {
            String tierPrefix = tiers.get(i);
            if (standardizedName.startsWith(tierPrefix))
            {
                return (i + 1);
            }
        }
        return -1;
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getStandardizedName()
    {
        return standardizedName;
    }

    public int getTier()
    {
        return tier;
    }
}
