package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class PopClass implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getSymbolStack().pop();
    }

    @Override
    public int getFunctionCode() {
        return 25;
    }
}
