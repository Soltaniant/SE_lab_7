package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.semantic.symbol.SymbolType;

public class LastTypeBool implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        data.getSymbolTable().setLastType(SymbolType.Bool);
    }

    @Override
    public int getFunctionCode() {
        return 31;
    }
}
