package io.github.nathensample.killmailvalidator.range;

import java.util.Objects;

public class PositiveRange implements ComparableRange
{
    private static final int UPPER_BOUND = Integer.MAX_VALUE;
    private final int lowerBound;

    public PositiveRange(int lowerBound)
    {
        this.lowerBound = lowerBound;
    }

    @Override
    public int getLowerBound()
    {
        return lowerBound;
    }

    @Override
    public int getHigherBound()
    {
        return UPPER_BOUND;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveRange that = (PositiveRange) o;
        return lowerBound == that.lowerBound;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(lowerBound);
    }
}
