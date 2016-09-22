package br.ufscar.dc.secomp.business.exceptions;

/**
 * Representa problemas relacionados ao uso de um valor impróprio como 
 * denominador, em uma operação de divisão. 
 */
public class InvalidDenominatorException extends Exception {

	private static final long serialVersionUID = 1285912095323031190L;

	public InvalidDenominatorException(String message) {
		super(message);
	}
}
