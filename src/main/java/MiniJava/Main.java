package MiniJava;
import java.io.IOException;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.filereader.FileReader;
import MiniJava.parser.Parser;
import MiniJava.parser.ParserFacade;


public class Main {
    public static void main(String[] args) {
        ParserFacade parser = new ParserFacade();
        try {
            // start parsing
            parser.startParse(FileReader.readAsString("code"));
        } catch (IOException e) {
            ErrorHandler.printError(e.getMessage());
        }
    }
}
