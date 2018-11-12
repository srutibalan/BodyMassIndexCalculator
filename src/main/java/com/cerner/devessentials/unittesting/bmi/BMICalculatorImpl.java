package com.cerner.devessentials.unittesting.bmi;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author SB051046
 *
 */
public class BMICalculatorImpl implements BMICalculator{

	@Override

	public double calculateBMI(double height, double weight) throws BMICalculationException 
	{
		double bmi;	
	     try{  
		if(height>HumanRanges.MAX_HEIGHT.getValue()&&weight>HumanRanges.MAX_WEIGHT.getValue()){
		throw new BMICalculationException("Weight and height value exceeds limit");}
		if(height<HumanRanges.MIN_HEIGHT.getValue()&&weight<HumanRanges.MIN_WEIGHT.getValue()){
		throw new BMICalculationException("Height and weight value is below limit");}
		if(height>HumanRanges.MAX_HEIGHT.getValue()){
		throw new BMICalculationException("Height value exceeds limit");}
		if(height<HumanRanges.MIN_HEIGHT.getValue()){
		throw new BMICalculationException("Height value is below limit");}
		if(weight>HumanRanges.MAX_WEIGHT.getValue()){
		throw new BMICalculationException("Weight value exceeds limit");}
		if(weight<HumanRanges.MIN_WEIGHT.getValue()){
		throw new BMICalculationException("Weight value is below limit");}
		
		bmi=weight/(height*height);
		return bmi;
    }
    catch( InputMismatchException ime) {
		throw new BMICalculationException("Enter only integer values");
    }
	catch(NullPointerException npe){
		throw new BMICalculationException("Enter some value");
    }
	}

	@Override
	public String getBMIDiagnosticResults(double bmi, BMIDiagnosticResultLoader diagnosticResultLoader)
			throws BMIOutOfBoundsException {
		// TODO Auto-generated method stub
	try{
		if(bmi<=BMIRange.UNDERWEIGHT.getMin() || bmi>BMIRange.OBESE.getMax())
		{
			
			throw new BMIOutOfBoundsException("BMI out of range");
		}
		if(bmi>BMIRange.NORMAL.getMin()&&bmi<=BMIRange.NORMAL.getMax())
		{
			return diagnosticResultLoader.getResultsText(BMIRange.NORMAL);
		}
		if(bmi>BMIRange.OBESE.getMin()&&bmi<=BMIRange.OBESE.getMax())
		{
			return diagnosticResultLoader.getResultsText(BMIRange.OBESE);
		}
		if(bmi>BMIRange.OVERWEIGHT.getMin()&&bmi<=BMIRange.OVERWEIGHT.getMax())
		{
			return diagnosticResultLoader.getResultsText(BMIRange.OVERWEIGHT);
		}
		if(bmi>BMIRange.UNDERWEIGHT.getMin()&&bmi<=BMIRange.UNDERWEIGHT.getMax())
		{
			return diagnosticResultLoader.getResultsText(BMIRange.UNDERWEIGHT);
		}}
	catch(NullPointerException ne)
	{
		throw new BMICalculationException("Enter some value");
	}

		
		return null;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
	    Scanner input = new Scanner (System.in);
        
        double weight;
        double height;
        double bmi;
         	
        System.out.print ("Enter Your Weight in Kgs: ");
        weight = input.nextDouble();
        System.out.print ("Enter Your Height in Metres: ");
        height = input.nextDouble();
        BMICalculatorImpl bmiImpl=new BMICalculatorImpl();
    	bmi=bmiImpl.calculateBMI(height, weight);
    	System.out.println("your BMI is "+bmi);
        System.out.println(bmiImpl.getBMIDiagnosticResults(bmi,new BMIDiagnosticResultLoader()));
        input.close();
}
	
}
