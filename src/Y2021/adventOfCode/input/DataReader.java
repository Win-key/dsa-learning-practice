package Y2021.adventOfCode.input;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {
    private DataReader() {}

    public static List<String> readInput(String urlStr) throws Exception{
        return Files.readAllLines(Paths.get(DataReader.class.getResource("/2021"+urlStr).toURI()), StandardCharsets.UTF_8);
    }


}
