package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class DefVar implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().pop();

        String var = data.getSymbolStack().pop();
        String methodName = data.getSymbolStack().pop();
        String className = data.getSymbolStack().pop();

        data.getSymbolTable().addMethodLocalVariable(className, methodName, var);

        data.getSymbolStack().push(className);
        data.getSymbolStack().push(methodName);
    }

    @Override
    public int getFunctionCode() {
        return 28;
    }
}
