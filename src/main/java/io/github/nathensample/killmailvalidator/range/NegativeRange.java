package io.github.nathensample.killmailvalidator.range;

public class NegativeRange implements ComparableRange
{
    private final int lowerBound = 0;
    private final int upperBound;

    public NegativeRange(int upperBound)
    {
        this.upperBound = upperBound;
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
}
