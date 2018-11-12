
package com.cerner.devessentials.unittesting.bmi;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.mockito.*;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * @author SB051046
 *
 */
public class BMIresultLoaderTest {
	BMICalculatorImpl bmiImpl =new BMICalculatorImpl();
	public static double bmi;
	BMIDiagnosticResultLoader diagnosticResultLoader=new BMIDiagnosticResultLoader();
	@Test (expected =NullPointerException.class) //testcase for null objects to calcBMI function
	public void test1() {
		bmiImpl.calculateBMI(Double.parseDouble(null), 55);
	}
	@Test (expected =Exception.class) //testcase for input mismatch
	public void test2() {
		bmiImpl.calculateBMI('a', 55);
	}
	@Test (expected =BMIOutOfBoundsException.class) //testcase for bmi range higher than 100
	public void test3() {
		bmiImpl.getBMIDiagnosticResults(101, diagnosticResultLoader);
	}
	@Test (expected =BMIOutOfBoundsException.class) //testcase for bmi range lower than and equal to .01
	public void test4() {
		bmiImpl.getBMIDiagnosticResults(0.01, diagnosticResultLoader);
	}
	@Test //testcase for bmi boundary range for obese <=100
	public void test5() {
		Assert.assertEquals("Obese, please consult your doctor", bmiImpl.getBMIDiagnosticResults(100,diagnosticResultLoader));
	}
	@Test//testcase for bmi boundary range for obese >30
	public void test6() {
		Assert.assertEquals("Obese, please consult your doctor", bmiImpl.getBMIDiagnosticResults(30.01,diagnosticResultLoader));
	}
	@Test//testcase for bmi boundary range for underweight >0.01
	public void test7() {
		Assert.assertEquals("underweight, please consult your doctor", bmiImpl.getBMIDiagnosticResults(0.011,diagnosticResultLoader));
	}
	@Test //testcase for bmi boundary range for underweight <=18.5
	public void test8() {
		Assert.assertEquals("underweight, please consult your doctor", bmiImpl.getBMIDiagnosticResults(18.5,diagnosticResultLoader));
	}
	@Test//testcase for bmi boundary range for normal >18.5
	public void test9() {
		Assert.assertEquals("Normal, congratulations", bmiImpl.getBMIDiagnosticResults(18.55,diagnosticResultLoader));
	}
	@Test//testcase for bmi boundary range for normal <=25
	public void test10() {
		Assert.assertEquals("Normal, congratulations", bmiImpl.getBMIDiagnosticResults(25,diagnosticResultLoader));
	}
	@Test//testcase for bmi boundary range for overweight >25
	public void test11() {
		Assert.assertEquals("Overweight, please consult your doctor", bmiImpl.getBMIDiagnosticResults(25.1,diagnosticResultLoader));
	}
	@Test//testcase for bmi boundary range for overweight<=30
	public void test12() {
		Assert.assertEquals("Overweight, please consult your doctor", bmiImpl.getBMIDiagnosticResults(30,diagnosticResultLoader));
	}
	@Test (expected =NullPointerException.class) //testcase for null objects to getBMIDiagnosticResults function
	public void test13() {
		bmiImpl.getBMIDiagnosticResults(Double.parseDouble(null), diagnosticResultLoader);
	}
	@Test (expected =Exception.class) //testcase for input mismatch
	public void test14() {
		bmiImpl.getBMIDiagnosticResults(bmiImpl.calculateBMI('a', 55), diagnosticResultLoader);
			}
	
	@Test
	public void test15() {
		diagnosticResultLoader=mock(BMIDiagnosticResultLoader.class);
		when(diagnosticResultLoader.getResultsText(BMIRange.NORMAL)).thenReturn("Normal");
		Assert.assertEquals("Normal", bmiImpl.getBMIDiagnosticResults(20,diagnosticResultLoader));
	}
	
	@Test
	public void test16() {
		diagnosticResultLoader=mock(BMIDiagnosticResultLoader.class);
		when(diagnosticResultLoader.getResultsText(BMIRange.OBESE)).thenReturn("Obese");
		Assert.assertEquals("Obese", bmiImpl.getBMIDiagnosticResults(40,diagnosticResultLoader));
	}
	
	@Test
	public void test17() {
		diagnosticResultLoader=mock(BMIDiagnosticResultLoader.class);
		when(diagnosticResultLoader.getResultsText(BMIRange.OVERWEIGHT)).thenReturn("Overweight");
		Assert.assertEquals("Overweight", bmiImpl.getBMIDiagnosticResults(27,diagnosticResultLoader));
	}
	
	@Test
	public void test18() {
		diagnosticResultLoader=mock(BMIDiagnosticResultLoader.class);
		when(diagnosticResultLoader.getResultsText(BMIRange.UNDERWEIGHT)).thenReturn("Underweight");
		Assert.assertEquals("Underweight", bmiImpl.getBMIDiagnosticResults(2,diagnosticResultLoader));
	}
	

}
