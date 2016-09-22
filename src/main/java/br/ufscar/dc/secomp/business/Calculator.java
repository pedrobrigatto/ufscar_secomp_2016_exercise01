package br.ufscar.dc.secomp.business;

import br.ufscar.dc.secomp.business.exceptions.InvalidDenominatorException;

public interface Calculator {
	
	String SUM = "+";
	String SUBTRACTION = "-";
	String MULTIPLICATION = "*";
	String DIVISION = "/";
	
	Double sum(Double ... portions);
	
	Double sub (Double portion1, Double portion2);
	
	Double multiply (Double factor1, Double factor2);
	
	Double divide (Double numerator, Double denominator) throws InvalidDenominatorException;
}
