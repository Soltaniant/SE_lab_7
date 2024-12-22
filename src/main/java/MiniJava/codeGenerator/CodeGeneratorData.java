package MiniJava.codeGenerator;

import MiniJava.scanner.token.Token;
import MiniJava.semantic.symbol.SymbolTable;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Getter
public class CodeGeneratorData {

    private final MemoryFacade memory = new MemoryFacade();
    private final Stack<Address> addressStack = new Stack<>();
    private final Stack<String> symbolStack = new Stack<>();
    private final Stack<String> callStack = new Stack<>();
    private final SymbolTable symbolTable;

    @Setter
    private Token token;

    public CodeGeneratorData() {
        symbolTable = new SymbolTable(memory);
    }
}
