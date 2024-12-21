package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;
import MiniJava.semantic.symbol.Symbol;

public class Fpid implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().pop();
        data.getAddressStack().pop();

        Symbol s = data.getSymbolTable().get(data.getSymbolStack().pop(), data.getSymbolStack().pop());
        varType t = varType.Int;
        switch (s.type) {
            case Bool:
                t = varType.Bool;
                break;
            case Int:
                t = varType.Int;
                break;
        }
        data.getAddressStack().push(new Address(s.address, t));
    }

    @Override
    public int getFunctionCode() {
        return 3;
    }
}
