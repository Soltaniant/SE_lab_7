package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;

public class JPFSave implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        Address save = new Address(data.getMemory().saveMemory(), varType.Address);
        data.getMemory().add3AddressCode(data.getAddressStack().pop().num, Operation.JPF, data.getAddressStack().pop(), new Address(data.getMemory().getCurrentCodeBlockAddress(), varType.Address), null);
        data.getAddressStack().push(save);
    }

    @Override
    public int getFunctionCode() {
        return 16;
    }
}
