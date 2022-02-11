package Aoc.Y2020.advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Day3TreesAndOpenP1 {

	public static void main(String[] args) throws Exception{
		
		String[] queries = {"1,1","3,1","5,1","7,1","1,2"};
		
		int result = 1;
		for (String query : queries) {
			String[] queryData = query.split(",");
			int count = part2(Integer.parseInt(queryData[0]), Integer.parseInt(queryData[1]));
			System.out.println("query : "+query + " : Count : "+ count);
			result *= count;
		}
		System.out.println("Result : " + result);
	}
	
	public static int part2(int right, int down) throws Exception{
		List<String> input = InputUtils.readInput("Day3TreesAndOpen.txt");
		
		int pos = 0, count = 0;
		for (int i = 0; i < input.size(); i+=down) {
			String line = input.get(i);
			if(line.charAt(pos%line.length()) == '#') {
				count++;
			}
			pos+=right;
		}
		return count;
	}
	
	public static void part1() throws Exception{

		try(FileReader fr = new FileReader("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day3TreesAndOpen.txt");
				BufferedReader bfr = new BufferedReader(fr)){
					String line = null;
					int pos = 0, count = 0;
					while((line = bfr.readLine()) != null) {
						if(pos != 0) {
							if(line.charAt(pos%line.length()) == '#') {
								count++;
							}
						}
						pos+=3;
					}
					System.out.println("Trees count :"+ count);
				}
	}

}
