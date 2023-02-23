package telran.utils.service;

import java.lang.reflect.Method;
import telran.calculator.annotation.CheckArgs;
import telran.calculator.annotation.OperationAn;

public class CalculatorRunner {
	private static final String PACKAGE = "telran.calculator.model.";

	public static void runInfo() {

	}

	public static void runInfo(Class<?> clazz, String[] args) {

		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			// handle @CheckArgs
			if (method.isAnnotationPresent(CheckArgs.class)) {
				if (args.length != 3) {
					System.out.println("Wrong number of arguments");
					return;
				}
				if (args[2].equals("Divine") && args[1].equals("0")) {
					System.out.println("Error Divine by zero");
					return;
				}
			}

		}
		//handle @OperationAn
		String operation = "";
		try {
			Class<?> clazzOperations = Class.forName(PACKAGE + args[2]);
			if (clazzOperations.isAnnotationPresent(OperationAn.class)) {
			operation = clazzOperations.getAnnotation(OperationAn.class).operationInfo();
			}
			else {
				operation = clazzOperations.getSimpleName();
			}

			clazzOperations.getAnnotations();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		displayInfo(args, operation);
	}

	private static void displayInfo(String[] args, String operation) {
		System.out.print(args[0] + " " + operation + " " + args[1]);
	}

}
