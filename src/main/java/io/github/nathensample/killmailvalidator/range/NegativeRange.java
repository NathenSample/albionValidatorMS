package io.github.nathensample.killmailvalidator.range;

import java.util.Objects;

public class NegativeRange implements ComparableRange
{
    private static final int LOWER_BOUND = 0;
    private final int upperBound;

    public NegativeRange(int upperBound)
    {
        this.upperBound = upperBound;
    }

    @Override
    public int getLowerBound()
    {
        return LOWER_BOUND;
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
        NegativeRange that = (NegativeRange) o;
        return upperBound == that.upperBound;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(upperBound);
    }
}
