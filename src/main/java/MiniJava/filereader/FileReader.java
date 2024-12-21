package MiniJava.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    private final static String baseResourcesDirectory = "src/main/resources/";

    public static List<String> readLines(String relativePath) throws IOException {
        Path path = Paths.get(baseResourcesDirectory + relativePath);
        return Files.readAllLines(path);
    }

    public static String readAsString(String relativePath) throws IOException {
        Path path = Paths.get(baseResourcesDirectory + relativePath);
        return Files.readString(path);
    }

}
