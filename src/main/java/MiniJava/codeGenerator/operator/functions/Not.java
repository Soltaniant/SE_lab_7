package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.*;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.errorHandler.ErrorHandler;

public class Not implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        MemoryFacade memory = data.getMemory();
        Address temp = new Address(memory.getTemp(), varType.Bool);
        memory.updateTempIndex();
        Address s2 = data.getAddressStack().pop();
        Address s1 = data.getAddressStack().pop();
        if (s1.varType != varType.Bool) {
            ErrorHandler.printError("In not operator the operand must be boolean");
        }
        memory.add3AddressCode(Operation.NOT, s1, s2, temp);
        data.getAddressStack().push(temp);
    }

    @Override
    public int getFunctionCode() {
        return 22;
    }
}
