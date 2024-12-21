package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;
import MiniJava.errorHandler.ErrorHandler;

public class Add implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        Address temp = new Address(data.getMemory().getTemp(), varType.Int);
        Address s2 = data.getAddressStack().pop();
        Address s1 = data.getAddressStack().pop();

        if (s1.varType != varType.Int || s2.varType != varType.Int) {
            ErrorHandler.printError("In add two operands must be integer");
        }
        data.getMemory().add3AddressCode(Operation.ADD, s1, s2, temp);
        data.getAddressStack().push(temp);
    }

    @Override
    public int getFunctionCode() {
        return 10;
    }
}
