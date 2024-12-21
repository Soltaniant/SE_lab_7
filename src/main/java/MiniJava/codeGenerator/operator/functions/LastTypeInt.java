package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.semantic.symbol.SymbolType;

public class LastTypeInt implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getSymbolTable().setLastType(SymbolType.Int);
    }

    @Override
    public int getFunctionCode() {
        return 32;
    }
}
