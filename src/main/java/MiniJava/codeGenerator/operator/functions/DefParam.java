package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class DefParam implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().pop();
        String param = data.getSymbolStack().pop();
        String methodName = data.getSymbolStack().pop();
        String className = data.getSymbolStack().pop();

        data.getSymbolTable().addMethodParameter(className, methodName, param);

        data.getSymbolStack().push(className);
        data.getSymbolStack().push(methodName);
    }

    @Override
    public int getFunctionCode() {
        return 30;
    }
}
