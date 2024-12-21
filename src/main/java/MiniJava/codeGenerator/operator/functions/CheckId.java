package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;

public class CheckId implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        data.getSymbolStack().pop();
        if (data.getAddressStack().peek().varType == varType.Non) {
            //TODO : error
        }
    }

    @Override
    public int getFunctionCode() {
        return 1;
    }
}
