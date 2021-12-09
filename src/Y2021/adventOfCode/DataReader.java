package Y2021.adventOfCode;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {
    private DataReader() {}

    public static List<String> readInput(String urlStr) throws Exception{
        List<String> out = new ArrayList<>();
        URL url = new URL(urlStr);
        try(Scanner s = new Scanner(url.openStream())){
            while(s.hasNextLine()) {
                out.add(s.nextLine());
            }
        }
        return out;
    }


}
