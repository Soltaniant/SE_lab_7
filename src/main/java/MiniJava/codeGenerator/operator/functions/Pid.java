package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;
import MiniJava.semantic.symbol.Symbol;

public class Pid implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {

        if (data.getSymbolStack().size() > 1) {
            String methodName = data.getSymbolStack().pop();
            String className = data.getSymbolStack().pop();
            try {

                Symbol s = data.getSymbolTable().get(className, methodName, data.getToken().value);
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


            } catch (Exception e) {
                data.getAddressStack().push(new Address(0, varType.Non));
            }
            data.getSymbolStack().push(className);
            data.getSymbolStack().push(methodName);
        } else {
            data.getAddressStack().push(new Address(0, varType.Non));
        }
        data.getSymbolStack().push(data.getToken().value);
    }

    @Override
    public int getFunctionCode() {
        return 2;
    }
}
