package io.github.nathensample.killmailvalidator.range;

import java.util.Objects;

public class MultiValueRange implements ComparableRange
{
    private final int lowerBound;
    private final int upperBound;

    public MultiValueRange(int lowerBound, int upperBound)
    {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public MultiValueRange(int bound)
    {
        this.lowerBound = bound;
        this.upperBound = bound;
    }

    @Override
    public int getLowerBound()
    {
        return lowerBound;
    }

    @Override
    public int getHigherBound()
    {
        return upperBound;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiValueRange that = (MultiValueRange) o;
        return lowerBound == that.lowerBound &&
                upperBound == that.upperBound;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(lowerBound, upperBound);
    }
}
