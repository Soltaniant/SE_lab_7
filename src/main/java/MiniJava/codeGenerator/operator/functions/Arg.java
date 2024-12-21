package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.Address;
import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.Operation;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.codeGenerator.varType;
import MiniJava.errorHandler.ErrorHandler;
import MiniJava.semantic.symbol.Symbol;

public class Arg implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        String methodName = data.getCallStack().pop();
        try {
            Symbol s = data.getSymbolTable().getNextParam(data.getCallStack().peek(), methodName);
            varType t = varType.Int;
            switch (s.type) {
                case Bool:
                    t = varType.Bool;
                    break;
                case Int:
                    t = varType.Int;
                    break;
            }
            Address param = data.getAddressStack().pop();
            if (param.varType != t) {
                ErrorHandler.printError("The argument type isn't match");
            }
            data.getMemory().add3AddressCode(Operation.ASSIGN, param, new Address(s.address, t), null);

        } catch (IndexOutOfBoundsException e) {
            ErrorHandler.printError("Too many arguments pass for method");
        }
        data.getCallStack().push(methodName);
    }

    @Override
    public int getFunctionCode() {
        return 8;
    }
}
