package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;

public class Label implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().push(new Address(data.getMemory().getCurrentCodeBlockAddress(), varType.Address));
    }

    @Override
    public int getFunctionCode() {
        return 13;
    }
}
