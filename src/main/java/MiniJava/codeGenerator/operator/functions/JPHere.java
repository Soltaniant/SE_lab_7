package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;

public class JPHere implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getMemory().add3AddressCode(data.getAddressStack().pop().num, Operation.JP, new Address(data.getMemory().getCurrentCodeBlockAddress(), varType.Address), null, null);
    }

    @Override
    public int getFunctionCode() {
        return 17;
    }
}
