package com.cerner.devessentials.unittesting.bmi;

public enum HumanRanges
{
    MAX_HEIGHT(3), MIN_HEIGHT(1), MAX_WEIGHT(500), MIN_WEIGHT(10);

    private double value;

    /**
     * Constructor.
     * 
     * @param value
     */
    HumanRanges(double value)
    {
        this.value = value;
    }

    /**
     * @return the value for human range.
     */
    public double getValue()
    {
        return value;
    }
}
