package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.model.Item;
import io.github.nathensample.killmailvalidator.model.ItemSet;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DocumentGearParserService
{
    private static final List<String> VALID_SLOTS = Arrays.asList("head", "mainhand", "offhand", "armor", "shoes", "cape");

    //TODO:Fix system outs
    public ItemSet parseDocument(Document document)
    {
        System.out.println("Detected:");
        Element gearDiv = document.select("div.row > div.col-xl-6:nth-child(2)").get(0);
        for (String slotName : VALID_SLOTS) {
            Element itemElement = gearDiv.select(".item." + slotName + " a>img").first();
            if (itemElement != null)
            {
                String itemName = itemElement.attr("title");
                if (itemName != null)
                {
                    Item item = new Item(itemName);
                    System.out.println(item.getStandardizedName() + " tier:" + item.getTier());
                }
            }
        }
        return null;
    }
}
