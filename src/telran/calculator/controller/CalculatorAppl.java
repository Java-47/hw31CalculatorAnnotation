package telran.calculator.controller;

import telran.calculator.infra.Calculator;
import telran.utils.service.CalculatorRunner;

public class CalculatorAppl {
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		CalculatorRunner.runInfo(calc.getClass(), args);
		
		try {		
			double res = Calculator.calculate(args[0], args[1], args[2]);
			System.out.println(" = " + res);
			
		} catch (Exception e) {
			System.out.println("Wrong operation");
		}
	}

}
