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
        MemoryFacade memory = data.getMemory();
        Address temp = new Address(memory.getTemp(), t);
        memory.updateTempIndex();
        data.getAddressStack().push(temp);
        memory.add3AddressCode(data.getAddressStack().pop().num, Operation.ASSIGN, new Address(temp.num, varType.Address, TypeAddress.Imidiate), new Address(data.getSymbolTable().getMethodReturnAddress(className, methodName), varType.Address), null);
        memory.add3AddressCode(data.getAddressStack().pop().num, Operation.ASSIGN, new Address(memory.getCurrentCodeBlockAddress() + 2, varType.Address, TypeAddress.Imidiate), new Address(data.getSymbolTable().getMethodCallerAddress(className, methodName), varType.Address), null);
        memory.add3AddressCode(data.getAddressStack().pop().num, Operation.JP, new Address(data.getSymbolTable().getMethodAddress(className, methodName), varType.Address), null, null);

    }

    @Override
    public int getFunctionCode() {
        return 7;
    }
}
