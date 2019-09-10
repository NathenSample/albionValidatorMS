package io.github.nathensample.killmailvalidator.range;

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
}
