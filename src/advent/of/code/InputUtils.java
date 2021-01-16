package advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {
	
	public static List<String> readInput(String inputFile) throws Exception{
		List<String> out = new ArrayList<>();
		try(FileReader fr = new FileReader("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\"+inputFile);
		BufferedReader bfr = new BufferedReader(fr)){
			String line = null;
			while((line = bfr.readLine()) != null) {
				out.add(line);
			}
		}
		return out;
	}
	public static List<String> readInputData(String inputFile) throws Exception{
		List<String> out = new ArrayList<>();
		try(FileReader fr = new FileReader(inputFile);
		BufferedReader bfr = new BufferedReader(fr)){
			String line = null;
			while((line = bfr.readLine()) != null) {
				out.add(line);
			}
		}
		return out;
	}
}
