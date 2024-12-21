package MiniJava.codeGenerator.operator.functions;

import MiniJava.codeGenerator.CodeGeneratorData;
import MiniJava.codeGenerator.operator.Operator;

public class Kpid implements Operator {

    @Override
    public void operate(CodeGeneratorData data) {
        data.getAddressStack().push(data.getSymbolTable().get(data.getToken().value));
    }

    @Override
    public int getFunctionCode() {
        return 4;
    }
}
