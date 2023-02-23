package telran.calculator.infra;

import telran.calculator.annotation.CheckArgs;

public class Calculator {



	private static final String PACKAGE = "telran.calculator.model.";
	
	public Calculator() {
	}
	@CheckArgs
	public static double calculate(String operand1, String operand2, String oper) {
		try {
			double a = Double.parseDouble(operand1);
			double b = Double.parseDouble(operand2);
			Class<?> clazz = Class.forName(PACKAGE + oper);
			Operation calc = (Operation) clazz.getDeclaredConstructor().newInstance();
			double res = calc.action(a, b);
			return res;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
