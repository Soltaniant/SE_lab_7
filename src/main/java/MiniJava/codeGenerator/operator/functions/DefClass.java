package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class DefClass implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().pop();
        data.getSymbolTable().addClass(data.getSymbolStack().peek());
    }

    @Override
    public int getFunctionCode() {
        return 23;
    }
}
