package io.github.nathensample.killmailvalidator.range;

public class PositiveRange implements ComparableRange
{
    private final int lowerBound;
    private final int upperBound = Integer.MAX_VALUE;

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
        return upperBound;
    }
}
