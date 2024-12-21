package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class DefMethod implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().pop();
        String methodName = data.getSymbolStack().pop();
        String className = data.getSymbolStack().pop();

        data.getSymbolTable().addMethod(className, methodName, data.getMemory().getCurrentCodeBlockAddress());

        data.getSymbolStack().push(className);
        data.getSymbolStack().push(methodName);
    }

    @Override
    public int getFunctionCode() {
        return 24;
    }
}
