package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class DefField implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().pop();
        data.getSymbolTable().addField(data.getSymbolStack().pop(), data.getSymbolStack().peek());
    }

    @Override
    public int getFunctionCode() {
        return 27;
    }
}
