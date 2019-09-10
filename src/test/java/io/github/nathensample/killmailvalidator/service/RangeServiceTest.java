package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.range.ComparableRange;
import io.github.nathensample.killmailvalidator.range.MultiValueRange;
import io.github.nathensample.killmailvalidator.range.NegativeRange;
import io.github.nathensample.killmailvalidator.range.PositiveRange;
import io.github.nathensample.killmailvalidator.range.exception.RangeParsingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class RangeServiceTest
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RangeService rangeService = new RangeService(logger);

    @Test
    public void givenSingleDigitShouldParse() throws Exception
    {
        String given = "8";
        MultiValueRange expected = new MultiValueRange(8);
        ComparableRange got = rangeService.getRange(given);


    }

    @Test
    public void givenDigitAndPlusSignShouldParse() throws Exception
    {
        String given = "8+";
        PositiveRange expected = new PositiveRange(8);
        ComparableRange got = rangeService.getRange(given);

    }

    @Test
    public void givenDigitAndMinusSignShouldParse() throws Exception
    {
        String given = "8-";
        NegativeRange expected = new NegativeRange(8);
        ComparableRange got = rangeService.getRange(given);

    }

    @Test
    public void givenRangeShouldParse() throws Exception
    {
        String given = "8-10";
        MultiValueRange expected = new MultiValueRange(8, 10);
        ComparableRange got = rangeService.getRange(given);

    }

    @Test(expected = RangeParsingException.class)
    public void givenTextShouldThrowException() throws Exception
    {
        String given = "pineapple";
        rangeService.getRange(given);
    }

    @Test(expected = RangeParsingException.class)
    public void givenMalformedShouldThrowException() throws Exception
    {
        String given = "+123";
        rangeService.getRange(given);
    }

    @Test(expected = RangeParsingException.class)
    public void givenMalformed2ShouldThrowException() throws Exception
    {
        String given = "-123";
        rangeService.getRange(given);
    }

    @Test(expected = RangeParsingException.class)
    public void givenMalformed3ShouldThrowException() throws Exception
    {
        String given = "!";
        rangeService.getRange(given);
    }
}