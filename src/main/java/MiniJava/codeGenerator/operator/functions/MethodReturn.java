package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.*;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.errorHandler.ErrorHandler;
import MiniJava.semantic.symbol.SymbolType;

public class MethodReturn implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        String methodName = data.getSymbolStack().pop();
        Address s = data.getAddressStack().pop();
        SymbolType t = data.getSymbolTable().getMethodReturnType(data.getSymbolStack().peek(), methodName);
        varType temp = varType.Int;
        switch (t) {
            case Int:
                break;
            case Bool:
                temp = varType.Bool;
        }
        if (s.varType != temp) {
            ErrorHandler.printError("The type of method and return address was not match");
        }
        data.getMemory().add3AddressCode(data.getAddressStack().pop().num, Operation.ASSIGN, s, new Address(data.getSymbolTable().getMethodReturnAddress(data.getSymbolStack().peek(), methodName), varType.Address, TypeAddress.Indirect), null);
        data.getMemory().add3AddressCode(data.getAddressStack().pop().num, Operation.JP, new Address(data.getSymbolTable().getMethodCallerAddress(data.getSymbolStack().peek(), methodName), varType.Address), null, null);
    }

    @Override
    public int getFunctionCode() {
        return 29;
    }
}
