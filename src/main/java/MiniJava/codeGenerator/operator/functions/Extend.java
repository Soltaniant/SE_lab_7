package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class Extend implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().pop();
        data.getSymbolTable().setSuperClass(data.getSymbolStack().pop(), data.getSymbolStack().peek());
    }

    @Override
    public int getFunctionCode() {
        return 26;
    }
}
