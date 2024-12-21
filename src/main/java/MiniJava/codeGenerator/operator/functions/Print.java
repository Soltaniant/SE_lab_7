package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;

public class Print implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getMemory().add3AddressCode(Operation.PRINT, data.getAddressStack().pop(), null, null);
    }

    @Override
    public int getFunctionCode() {
        return 18;
    }
}
