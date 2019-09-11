package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.model.Item;
import io.github.nathensample.killmailvalidator.model.ItemSet;
import io.github.nathensample.killmailvalidator.model.ItemSlot;
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
    private static final List<ItemSlot> VALID_SLOTS = Arrays.asList(ItemSlot.MAINHAND, ItemSlot.OFFHAND, ItemSlot.HELM, ItemSlot.CHEST, ItemSlot.BOOTS, ItemSlot.CAPE);
    private final Logger logger;

    public DocumentGearParserService(@Autowired Logger logger)
    {
        this.logger = logger;
    }

    public ItemSet parseDocument(Document document)
    {
        Element gearDiv = document.select("div.row > div.col-xl-6:nth-child(2)").get(0);
        ItemSet.ItemSetBuilder builder = ItemSet.getBuilder();
        for (ItemSlot slot : VALID_SLOTS) {
            Element itemElement = gearDiv.select(".item." + slot + " a>img").first();
            if (itemElement != null)
            {
                String itemName = itemElement.attr("title");
                if (itemName != null)
                {
                    Item item = new Item(itemName);
                    builder.addPiece(slot, item);
                }
            }
        }
        return builder.build();
    }
}
