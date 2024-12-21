package MiniJava.codeGenerator.operator;

import MiniJava.codeGenerator.CodeGeneratorData;

public interface Operator {

        void operate(CodeGeneratorData data);
        int getFunctionCode();
}