package io.github.nathensample.killmailvalidator.range;

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
}
