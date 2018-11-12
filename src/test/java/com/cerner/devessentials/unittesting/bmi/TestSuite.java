/**
 * 
 */
package com.cerner.devessentials.unittesting.bmi;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author SB051046
 *
 */
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({BMICalculatorImplTest.class, BMIDiagnosticLoaderTest.class,BMIresultLoaderTest.class})
public class TestSuite {


}
