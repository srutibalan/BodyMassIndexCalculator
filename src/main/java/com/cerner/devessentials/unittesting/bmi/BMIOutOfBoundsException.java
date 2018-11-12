package com.cerner.devessentials.unittesting.bmi;

public class BMIOutOfBoundsException extends RuntimeException
{
    /**
     * Stub class for passing to API consumers that their BMI is not within a
     * valid range.
     */
    private static final long serialVersionUID = 9100032712198524992L;

    /**
     * Constructor for the exception.
     * 
     * @param message
     */
    public BMIOutOfBoundsException(String message)
    {
        super(message);
    }
}
