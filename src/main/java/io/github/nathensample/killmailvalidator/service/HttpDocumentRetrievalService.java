package io.github.nathensample.killmailvalidator.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpDocumentRetrievalService implements DocumentRetriever
{
    @Override
    public Document getDocument(String uri) throws IOException
    {
        return Jsoup.connect(uri).get();
    }
}
