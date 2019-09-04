package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.model.Item;
import io.github.nathensample.killmailvalidator.model.ItemSet;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentGearParserService
{
    private static final List<String> VALID_SLOTS = Arrays.asList("head", "mainhand", "offhand", "armor", "shoes", "cape");

    public ItemSet parseDocument(Document document)
    {
        Element gearDiv = document.select("div.row > div.col-xl-6:nth-child(2)").get(0);
        Elements items = gearDiv.select(".item");

        for (String slotName : VALID_SLOTS) {
            Element itemElement = items.select("." + slotName + " a>img").first();
            String itemName = itemElement.attr("data-original-title");
            Item item = new Item(itemName);
            System.out.print(item.getStandardizedName() + " tier:" + item.getTier());
        }
        return null;
    }
}
