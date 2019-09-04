package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.model.ItemSet;
import io.github.nathensample.killmailvalidator.model.VerificationRequest;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KillmailVerificationService
{
    private DocumentRetriever documentRetriever;
    private DocumentGearParserService documentGearParserService;

    public KillmailVerificationService(
            @Autowired HttpDocumentRetrievalService httpDocumentRetrievalService,
            @Autowired DocumentGearParserService documentGearParserService
    )
    {
        this.documentRetriever = httpDocumentRetrievalService;
        this.documentGearParserService = documentGearParserService;
    }

    public boolean verifyKillmail(VerificationRequest verificationRequest)
    {
        try
        {
            Document webDoc = documentRetriever.getDocument(verificationRequest.getKillmailUrl());
            ItemSet lostSet = documentGearParserService.parseDocument(webDoc);
        } catch (IOException e)
        {
            //TODO: Add sl4fj and log
        }
        return false;
    }
}
