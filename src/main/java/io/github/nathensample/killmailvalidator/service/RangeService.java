package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.range.ComparableRange;
import io.github.nathensample.killmailvalidator.range.MultiValueRange;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RangeService
{
    private final Logger logger;

    public RangeService(@Autowired Logger logger)
    {
        this.logger = logger;
    }

    public ComparableRange getRange(String rangeString)
    {
        //Check to see if we've literally just been given an int
        try
        {
            return parseRawIntegerFromString(rangeString);
        }
        catch (NumberFormatException e)
        {
            logger.debug("given rangeString {} was not an integer", rangeString);
        }
        //TODO: Finish me
        return null;
    }

    private MultiValueRange parseRawIntegerFromString(String rangeString)
    {
        int givenValue = Integer.parseInt(rangeString);
        return new MultiValueRange(givenValue);
    }
}
