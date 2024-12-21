package MiniJava;
import java.io.IOException;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.filereader.FileReader;
import MiniJava.parser.Parser;


public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            // start parsing
            parser.startParse(FileReader.readAsString("code"));
        } catch (IOException e) {
            ErrorHandler.printError(e.getMessage());
        }
    }
}
