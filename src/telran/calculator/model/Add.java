package telran.calculator.model;

import telran.calculator.annotation.OperationAn;
import telran.calculator.infra.Operation;

@OperationAn(operationInfo = "+")
public class Add implements Operation {

	@Override
	public double action(double a, double b) {
		return a + b;
	}
	
}
