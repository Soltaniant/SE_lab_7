package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class StartCall implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {

        data.getAddressStack().pop();
        data.getAddressStack().pop();
        String methodName = data.getSymbolStack().pop();
        String className = data.getSymbolStack().pop();
        data.getSymbolTable().startCall(className, methodName);
        data.getCallStack().push(className);
        data.getCallStack().push(methodName);

    }

    @Override
    public int getFunctionCode() {
        return 6;
    }
}
