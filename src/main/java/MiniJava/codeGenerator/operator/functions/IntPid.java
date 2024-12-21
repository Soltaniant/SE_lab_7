package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.TypeAddress;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;

public class IntPid implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().push(new Address(Integer.parseInt(data.getToken().value), varType.Int, TypeAddress.Imidiate));
    }

    @Override
    public int getFunctionCode() {
        return 5;
    }
}
