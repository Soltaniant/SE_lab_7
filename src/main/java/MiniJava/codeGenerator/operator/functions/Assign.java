package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.errorHandler.ErrorHandler;

public class Assign implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        Address s1 = data.getAddressStack().pop();
        Address s2 = data.getAddressStack().pop();

        if (s1.varType != s2.varType) {
            ErrorHandler.printError("The type of operands in assign is different ");
        }

        data.getMemory().add3AddressCode(Operation.ASSIGN, s1, s2, null);
    }

    @Override
    public int getFunctionCode() {
        return 9;
    }
}
