package io.github.nathensample.killmailvalidator.service;

import io.github.nathensample.killmailvalidator.range.MultiValueRange;
import io.github.nathensample.killmailvalidator.range.NegativeRange;
import io.github.nathensample.killmailvalidator.range.PositiveRange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RangeServiceTest
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RangeService rangeService = new RangeService(logger);

    @Test
    public void givenSingleDigitShouldParse()
    {
        String given = "8";
        MultiValueRange expected = new MultiValueRange(8);
    }

    @Test
    public void givenDigitAndPlusSignShouldParse()
    {
        String given = "8+";
        PositiveRange expected = new PositiveRange(8);
    }

    @Test
    public void givenDigitAndMinusSignShouldParse()
    {
        String given = "8-";
        NegativeRange expected = new NegativeRange(8);
    }

    @Test
    public void givenRangeShouldParse()
    {
        String given = "8-10";
        MultiValueRange expected = new MultiValueRange(8, 10);
    }

    @Test
    public void givenTextShouldThrowException()
    {
    }

    @Test
    public void givenMalformedShouldThrowException()
    {
    }
}