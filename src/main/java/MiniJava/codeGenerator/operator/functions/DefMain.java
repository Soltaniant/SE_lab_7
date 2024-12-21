package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;

public class DefMain implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getMemory().add3AddressCode(data.getAddressStack().pop().num, Operation.JP, new Address(data.getMemory().getCurrentCodeBlockAddress(), varType.Address), null, null);
        String methodName = "main";
        String className = data.getSymbolStack().pop();

        data.getSymbolTable().addMethod(className, methodName, data.getMemory().getCurrentCodeBlockAddress());

        data.getSymbolStack().push(className);
        data.getSymbolStack().push(methodName);
    }

    @Override
    public int getFunctionCode() {
        return 33;
    }
}
