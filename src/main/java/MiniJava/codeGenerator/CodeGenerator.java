package MiniJava.codeGenerator;

import MiniJava.Log.Log;
import MiniJava.codeGenerator.operator.OperatorRegistry;
import MiniJava.scanner.token.Token;

public class CodeGenerator {

    private final CodeGeneratorData generatorData = new CodeGeneratorData();

    public void semanticFunction(int func, Token next) {
        generatorData.setToken(next);
        Log.print("code generator : " + func);
        if (func == 0)
            return;
        OperatorRegistry.getOperator(func).operate(generatorData);
    }

    public void printMemory() {
        generatorData.getMemory().pintCodeBlock();
    }
}
