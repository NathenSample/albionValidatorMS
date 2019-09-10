package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.range.ComparableRange;
import io.github.nathensample.killmailvalidator.range.MultiValueRange;
import io.github.nathensample.killmailvalidator.range.NegativeRange;
import io.github.nathensample.killmailvalidator.range.PositiveRange;
import io.github.nathensample.killmailvalidator.range.exception.RangeParsingException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static java.lang.Integer.*;

@Service
public class RangeService
{
    private static final Pattern RANGE_PATTERN = Pattern.compile("\\d+\\-\\d+");
    private static final String RESERVED_ERROR = "The given string %s started with reserved character";

    private final Logger logger;

    public RangeService(@Autowired Logger logger)
    {
        this.logger = logger;
    }

    public ComparableRange getRange(String rangeString) throws RangeParsingException
    {
        if (rangeString.startsWith("+") || rangeString.startsWith("-"))
        {
            throw new RangeParsingException(RESERVED_ERROR, rangeString);
        }
        //Check to see if we've literally just been given an int
        try
        {
            return parseRawIntegerFromString(rangeString);
        }
        catch (NumberFormatException e)
        {
            logger.debug("given rangeString {} was not an integer", rangeString);
        }

        if (rangeEndsWithSymbol(rangeString, '-'))
        {
            return new NegativeRange(valueOf(rangeString.substring(0, rangeString.length()-1)));
        }

        if (rangeEndsWithSymbol(rangeString, '+'))
        {
            return new PositiveRange(valueOf(rangeString.substring(0, rangeString.length()-1)));
        }

        if (RANGE_PATTERN.matcher(rangeString).matches())
        {
            String[] rangeSplit = rangeString.split("-");
            return new MultiValueRange(parseInt(rangeSplit[0]), parseInt(rangeSplit[1]));
        }

        throw new RangeParsingException(rangeString);
    }

    private MultiValueRange parseRawIntegerFromString(String rangeString)
    {
        int givenValue = parseInt(rangeString);
        return new MultiValueRange(givenValue);
    }

    private boolean rangeEndsWithSymbol(String rangeString, char symbol)
    {
        return rangeString.charAt(rangeString.length() - 1) == symbol;
    }
}
