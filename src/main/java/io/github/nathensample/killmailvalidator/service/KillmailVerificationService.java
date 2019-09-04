package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.model.VerificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KillmailVerificationService
{
    private DocumentRetriever documentRetriever;

    public KillmailVerificationService(@Autowired HttpDocumentRetrievalService httpDocumentRetrievalService)
    {
        this.documentRetriever = httpDocumentRetrievalService;
    }

    public boolean verifyKillmail(VerificationRequest verificationRequest)
    {
        return false;
    }
}
