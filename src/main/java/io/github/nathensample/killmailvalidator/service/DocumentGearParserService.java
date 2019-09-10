package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.model.Item;
import io.github.nathensample.killmailvalidator.model.ItemSet;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DocumentGearParserService
{
    private static final List<String> VALID_SLOTS = Arrays.asList("head", "mainhand", "offhand", "armor", "shoes", "cape");
    private final Logger logger;

    public DocumentGearParserService(@Autowired Logger logger)
    {
        this.logger = logger;
    }

    public ItemSet parseDocument(Document document)
    {
        logger.info("Detected:");
        Element gearDiv = document.select("div.row > div.col-xl-6:nth-child(2)").get(0);
        for (String slotName : VALID_SLOTS) {
            Element itemElement = gearDiv.select(".item." + slotName + " a>img").first();
            if (itemElement != null)
            {
                String itemName = itemElement.attr("title");
                if (itemName != null)
                {
                    Item item = new Item(itemName);
                    logger.info("{} tier: {}", item.getStandardizedName(), item.getTier());
                }
            }
        }
        return null;
    }
}
