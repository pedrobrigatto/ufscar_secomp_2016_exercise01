package br.ufscar.dc.secomp.business.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.ufscar.dc.secomp.AppConfig;
import br.ufscar.dc.secomp.business.Calculator;
import br.ufscar.dc.secomp.business.exceptions.InvalidDenominatorException;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (classes = {AppConfig.class})
public class CalculatorTest {
	
	@Autowired
	private Calculator calculator;

	@Test
	public void testSum() {
		assertTrue(10d == calculator.sum(1.0, 3.0, 6.0).doubleValue());
	}
	
	@Test
	public void testSubtraction() {
		assertTrue(10d == calculator.sub(20.0, 10.0).doubleValue());
	}
	
	@Test
	public void testDivision() throws InvalidDenominatorException {
		assertTrue(10d == calculator.divide(100.0, 10.0).doubleValue());
	}
	
	@Test (expected = InvalidDenominatorException.class)
	public void testDivisionByZero() throws InvalidDenominatorException {
		assertTrue(10d == calculator.divide(100.0, 0.0).doubleValue());
	}
	
	@Test
	public void testMultiplication() {
		assertTrue(100.0 == calculator.multiply(10.0, 10.0));
	}
}
