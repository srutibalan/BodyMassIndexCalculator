package com.cerner.devessentials.unittesting.bmi;

import java.util.Properties;

/**
 * This class reads the diagnostic properties and returns the results.
 * 
 * @author OD025173
 * @author FS022367
 *
 */
public class BMIDiagnosticResultLoader
{
    private static Properties diagnosticResults = null;

    /**
     * Retrieved the text related to the BMI range provided.
     * 
     * @param range
     *            an {@link BMIRange} containing a key.
     * @return A possibly-null string with the results. Null if the results
     *         cannot be found, or range is null.
     */
    public String getResultsText(BMIRange range)
    {
        if (range == null)
        {
            return null;
        }
        loadDiagnosticResults();
        return diagnosticResults.getProperty(range.key());
    }

    private void loadDiagnosticResults()
    {
        if (diagnosticResults != null)
        {
            return;
        }

        Properties properties = new Properties();
        properties.setProperty("underweight", "underweight, please consult your doctor");
        properties.setProperty("normal", "Normal, congratulations");
        properties.setProperty("overweight", "Overweight, please consult your doctor");
        properties.setProperty("obese", "Obese, please consult your doctor");

        diagnosticResults = properties;
    }
}
