package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.*;
import MiniJava.codeGenerator.operator.Operator;
import MiniJava.errorHandler.ErrorHandler;

public class Call implements Operator {
    @Override
    public void operate(CodeGeneratorData data) {
        String methodName = data.getCallStack().pop();
        String className = data.getCallStack().pop();
        try {
            data.getSymbolTable().getNextParam(className, methodName);
            ErrorHandler.printError("The few argument pass for method");
        } catch (IndexOutOfBoundsException e) {
        }
        varType t = varType.Int;
        switch (data.getSymbolTable().getMethodReturnType(className, methodName)) {
            case Int:
                t = varType.Int;
                break;
            case Bool:
                t = varType.Bool;
                break;
        }
        Address temp = new Address(data.getMemory().getTemp(), t);
        data.getAddressStack().push(temp);
        data.getMemory().add3AddressCode(Operation.ASSIGN, new Address(temp.num, varType.Address, TypeAddress.Imidiate), new Address(data.getSymbolTable().getMethodReturnAddress(className, methodName), varType.Address), null);
        data.getMemory().add3AddressCode(Operation.ASSIGN, new Address(data.getMemory().getCurrentCodeBlockAddress() + 2, varType.Address, TypeAddress.Imidiate), new Address(data.getSymbolTable().getMethodCallerAddress(className, methodName), varType.Address), null);
        data.getMemory().add3AddressCode(Operation.JP, new Address(data.getSymbolTable().getMethodAddress(className, methodName), varType.Address), null, null);

    }

    @Override
    public int getFunctionCode() {
        return 7;
    }
}
