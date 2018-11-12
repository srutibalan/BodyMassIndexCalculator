package com.cerner.devessentials.unittesting.bmi;

public interface BMICalculator
{
    /**
     * This method will validate that the height and weight are within normal
     * human ranges and calculate the BMI using the height and weight in metric
     * units (meters and kilograms).
     * 
     * @param height
     *            in meters. Must be within ranges defined in
     *            {@link HumanRanges}.
     * @param weight
     *            in kilograms. Must be within ranges defined in
     *            {@link HumanRanges}.
     * @return double of calculated BMI
     * 
     * @throws a
     *             BMICalculationException if the height or weight fall outside
     *             of the ranges defined in {@link HumanRanges}.
     */
    public double calculateBMI(double height, double weight) throws BMICalculationException;

    /**
     * This method will return the appropriate diagnostic message based upon a
     * BMI and the passed BMIDiagnosticResultLoader. BMIRange will need to be
     * determined from the BMI to use the BMIDiagnosticResultLoader
     * 
     * @param bmi
     *            to use for diagnosis.
     * @param diagnosticResultLoader
     *            to provide diagnostic message based on the bmi. Cannot be
     *            null.
     * @return BMI diagnostic message.
     * 
     * @throws a
     *             {@link BMIOutOfBoundsException} if the provided bmi does not
     *             fall into the ranges defined in {@link BMIRange}.
     */
    public String getBMIDiagnosticResults(double bmi, BMIDiagnosticResultLoader diagnosticResultLoader)
            throws BMIOutOfBoundsException;

}
