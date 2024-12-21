package MiniJava.codeGenerator;

import MiniJava.semantic.symbol.SymbolTable;
import lombok.Getter;

import java.util.Stack;

@Getter
public class CodeGeneratorData {

    private final Memory memory = new Memory();
    private final Stack<Address> ss = new Stack<Address>();
    private final Stack<String> symbolStack = new Stack<>();
    private final Stack<String> callStack = new Stack<>();
    private final SymbolTable symbolTable;

    public CodeGeneratorData() {
        symbolTable = new SymbolTable(memory);
    }
}
