package com.cerner.devessentials.unittesting.bmi;

import org.junit.Assert;
import org.junit.Test;

public class BMIDiagnosticLoaderTest
{
    @Test
    public void getResultsTextTest()
    {
        BMIDiagnosticResultLoader loader = new BMIDiagnosticResultLoader();
        String actual = loader.getResultsText(null);
        Assert.assertEquals(null, actual);
    }
}
