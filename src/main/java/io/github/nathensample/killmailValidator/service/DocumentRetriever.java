package io.github.nathensample.killmailValidator.service;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface DocumentRetriever
{
    Document getDocument(String uri) throws IOException;
}
