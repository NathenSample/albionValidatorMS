package io.github.nathensample.killmailvalidator.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VerificationRequest
{
    private final String killmailUrl;

    @JsonCreator
    public VerificationRequest(@JsonProperty("killmailUrl") String killmailUrl)
    {
        this.killmailUrl = killmailUrl;
    }

    public String getKillmailUrl()
    {
        return killmailUrl;
    }
}
