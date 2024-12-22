package MiniJava.parser;


public class ParserFacade {
    private Parser parser;

    public ParserFacade() {
        this.parser = new Parser();
    }
    public void startParse(String input) {
        parser.startParse(input);
    }

}
