/**
 * 
 */
package com.cerner.devessentials.unittesting.bmi;


import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runner.RunWith;

/**
 * @author SB051046
 *
 */

@RunWith(value = Parameterized.class)
public class BMICalculatorImplTest {

BMICalculatorImpl bmi=new BMICalculatorImpl();

    @Parameter(0)
    public double height;

    @Parameter(1)
    public double weight;

    @Parameter(2)
    public double expected;
    
    @Parameter(3)
    public Class<? extends Exception> expectedException;
    
    @Parameter(4)
    public String expectedExceptionMsg;

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Parameters(name = "{index}: bmi Of({0} and {1}) is {2}")
    public static Collection<Object[]> data() {
       
		return Arrays.asList(new Object[][]{
                {1.8, 55, 16.975308641975307,null,null},//Normal test case(Within  boundary)
                {3,500,55.55555555555556,null,null},	//max boundary value for height and weight
                {1,10,10,null,null}	,				//min boundary value for height and weight
                {0,9,-1,BMICalculationException.class,"Height and weight value is below limit"}, //height and weight below boundary
                {4,501,-1,BMICalculationException.class,"Weight and height value exceeds limit"},	//height and weight above boundary
                {-1,11,-1,BMICalculationException.class,"Height value is below limit"},	//height less than min height
                {2,-5,-1,BMICalculationException.class,"Weight value is below limit"},	// weight less than min weight
                {3.1,55,-1,BMICalculationException.class,"Height value exceeds limit"},	// height more than max height
                {2,501,-1,BMICalculationException.class,"Weight value exceeds limit"},	//weight more than max weight 
                
        });
    }

    @Test
    public void CalculateBMITest() {
  
        if (expectedException != null) {
            thrown.expect(expectedException);
            thrown.expectMessage(expectedExceptionMsg);
        }
		double delta=0.002;//precision value
		Assert.assertEquals(expected, bmi.calculateBMI(height, weight), delta);
    }
}

