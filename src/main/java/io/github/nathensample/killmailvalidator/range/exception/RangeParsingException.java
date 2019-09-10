package io.github.nathensample.killmailvalidator.range.exception;

public class RangeParsingException extends Exception
{
    public RangeParsingException(String givenRange)
    {
        super(String.format("Unable to parse range from: %s", givenRange));
    }
}
