package br.ufscar.dc.secomp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.ufscar.dc.secomp.business.Calculator;
import br.ufscar.dc.secomp.business.exceptions.InvalidDenominatorException;

@Configuration
@ComponentScan (basePackages = { "br.ufscar.dc.secomp.business.impl" })
public class App {

	private static Scanner scanner = new Scanner(System.in);
	private static ApplicationContext context;

	public static void main( String[] args ) throws InvalidDenominatorException {
		context = new AnnotationConfigApplicationContext(App.class);
		System.out.println("------------------------------------------------------------------");
		System.out.println("Hi, I'm the calculator. I can perform the following operations:");
		System.out.println("\r\n\t+ : Sum\r\n\t- : Subtraction\r\n\t* : Multiplication\r\n\t/ : Division");
		System.out.println("Now tell me: what operation do you want to run? ");
		String operation = scanner.next().trim();

		if (Calculator.SUM.equals(operation)) {
			executeSum();
		} else if (Calculator.SUBTRACTION.equals(operation)) {
			executeSubtration();
		} else if (Calculator.MULTIPLICATION.equals(operation)) {
			executeMultiplication();
		} else if (Calculator.DIVISION.equals(operation)) {
			executeDivision();
		} else {
			System.out.println("This operation is not supported.");
		}
	}

	private static void executeSum() {
		System.out.println("Alright, a sum ... tell me the first portion of it: ");
		Double portion1 = scanner.nextDouble();
		System.out.println("OK, got it ... now the second portion: ");
		Double portion2 = scanner.nextDouble();
		System.out.println(portion1 + " + " + portion2 + " = " + 
				context.getBean(Calculator.class).sum(portion1, portion2));
	}

	private static void executeSubtration() {
		System.out.println("Alright, a subtration ... tell me the first portion of it: ");
		Double portion1 = scanner.nextDouble();
		System.out.println("OK, got it ... now the second portion: ");
		Double portion2 = scanner.nextDouble();
		System.out.println(portion1 + " - " + portion2 + " = " + 
				context.getBean(Calculator.class).sub(portion1, portion2));
	}

	private static void executeMultiplication() {
		System.out.println("Alright, a multiplication ... tell me the first factor of it: ");
		Double portion1 = scanner.nextDouble();
		System.out.println("OK, got it ... now the second factor: ");
		Double portion2 = scanner.nextDouble();
		System.out.println(portion1 + " * " + portion2 + " = " + 
				context.getBean(Calculator.class).multiply(portion1, portion2));
	}

	private static void executeDivision() throws InvalidDenominatorException {
		System.out.println("Alright, a division ... tell me the numerator: ");
		Double numerator = scanner.nextDouble();
		System.out.println("OK, got it ... now the denominator (> 0): ");
		Double denominator = scanner.nextDouble();
		System.out.println(numerator + " / " + denominator + " = " + 
				context.getBean(Calculator.class).divide(numerator,  denominator));
	}	
}
