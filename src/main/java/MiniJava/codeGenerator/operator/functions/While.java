package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;

public class While implements Operator {
    
    @Override
    public void operate(CodeGeneratorData data) {
        data.getMemory().add3AddressCode(data.getAddressStack().pop().num, Operation.JPF, data.getAddressStack().pop(), new Address(data.getMemory().getCurrentCodeBlockAddress() + 1, varType.Address), null);
        data.getMemory().add3AddressCode(Operation.JP, data.getAddressStack().pop(), null, null);
    }

    @Override
    public int getFunctionCode() {
        return 15;
    }
}
