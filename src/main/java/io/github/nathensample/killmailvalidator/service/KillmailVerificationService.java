package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.model.ItemSet;
import io.github.nathensample.killmailvalidator.model.VerificationRequest;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KillmailVerificationService
{
    private final DocumentRetriever documentRetriever;
    private final DocumentGearParserService documentGearParserService;
    private final Logger logger;

    public KillmailVerificationService(
            @Autowired HttpDocumentRetrievalService httpDocumentRetrievalService,
            @Autowired DocumentGearParserService documentGearParserService,
            @Autowired Logger logger
            )
    {
        this.documentRetriever = httpDocumentRetrievalService;
        this.documentGearParserService = documentGearParserService;
        this.logger = logger;
    }

    public boolean verifyKillmail(VerificationRequest verificationRequest)
    {
        logger.info("Now processing: {}", verificationRequest.getKillmailUrl());
        try
        {
            Document webDoc = documentRetriever.getDocument(verificationRequest.getKillmailUrl());
            ItemSet lostSet = documentGearParserService.parseDocument(webDoc);
        } catch (IOException e)
        {
            logger.error("Exception whilst requesting url {} e: {}", verificationRequest.getKillmailUrl(), e);
        }
        return false;
    }
}
