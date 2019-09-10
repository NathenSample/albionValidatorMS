package io.github.nathensample.killmailvalidator.range;

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
}
