package io.github.nathensample.killmailvalidator.model;

public class VerificationRequest
{
    private final String killmailUrl;

    public VerificationRequest(String killmailUrl)
    {
        this.killmailUrl = killmailUrl;
    }

    public String getKillmailUrl()
    {
        return killmailUrl;
    }
}
