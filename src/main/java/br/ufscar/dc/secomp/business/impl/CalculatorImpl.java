package br.ufscar.dc.secomp.business.impl;

import org.springframework.stereotype.Component;

import br.ufscar.dc.secomp.business.Calculator;
import br.ufscar.dc.secomp.business.exceptions.InvalidDenominatorException;

/**
 * Implementação padrão de uma calculadora simples. 
 */
@Component
public class CalculatorImpl implements Calculator {

	public Double sum(Double... portions) {
		Double sum = 0.0;
		for (Double portion : portions) {
			sum += portion;
		}
		return sum;
	}

	public Double sub(Double portion1, Double portion2) {
		return portion1 - portion2;
	}

	public Double multiply(Double factor1, Double factor2) {
		return factor1 * factor2;
	}

	public Double divide(Double numerator, Double denominator) throws InvalidDenominatorException {
		if (denominator == 0.0) {
			throw new InvalidDenominatorException("O denominador de uma divisão não pode ser 0");
		}
		return numerator / denominator;
	}
}
