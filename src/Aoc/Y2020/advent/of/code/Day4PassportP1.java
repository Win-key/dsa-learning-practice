package Aoc.Y2020.advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Day4PassportP1 {

	public static List<String> eclAr = Arrays.asList("amb","blu","brn","gry","grn","hzl","oth");
	public static void main(String[] args) throws Exception {
		
//		part1();
		part2();
	}
	
	public static void part1() throws Exception{
		try(FileReader fr = new FileReader("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day4PassportInputs.txt");
				BufferedReader bfr = new BufferedReader(fr)){
					String line = null;
					Map<String, String> map = new HashMap<>();
					int count = 0;
					while(true) {
						line = bfr.readLine();
						if(line == null || "".equals(line)) {
							
							if(		   map.containsKey("byr") && map.containsKey("iyr") 
									&& map.containsKey("eyr") && map.containsKey("hgt") 
									&& map.containsKey("hcl") && map.containsKey("ecl") 
									&& map.containsKey("pid") ) {
								count++;
							}
							if(line == null)
								break;
							map = new HashMap<>();
							continue;
						}
						line = line.trim();
						String[] split = line.split(" ");
						for (String keyValue : split) {
							map.put(keyValue.split(":")[0].trim(), keyValue.split(":")[1].trim());
						}
						
					}
					
					System.out.println("Total valid passwords: "+ count);
				}
	}
	
	public static void part2() throws Exception{
		
		try(FileReader fr = new FileReader("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day4PassportInputs.txt");
				BufferedReader bfr = new BufferedReader(fr)){
					String line = null;
					Map<String, String> map = new HashMap<>();
					int count = 0;
					while(true) {
						line = bfr.readLine();
						if(line == null || "".equals(line)) {
							
							if(validation(map)) {
								count++;
							}
							if(line == null)
								break;
							map = new HashMap<>();
							continue;
						}
						line = line.trim();
						String[] split = line.split(" ");
						for (String keyValue : split) {
							map.put(keyValue.split(":")[0].trim(), keyValue.split(":")[1].trim());
						}
						
					}
						
						System.out.println("Total valid passwords: "+ count);
					}
					
				}
	
	public static boolean validation(Map<String, String> map) {
		if(!(map.containsKey("byr") && map.containsKey("iyr") 
				&& map.containsKey("eyr") && map.containsKey("hgt") 
				&& map.containsKey("hcl") && map.containsKey("ecl") 
				&& map.containsKey("pid") ))
			return false;

		Integer byr = Integer.parseInt(map.get("byr"));
		if(byr < 1920 || byr > 2002)
			return false;
		Integer iyr = Integer.parseInt(map.get("iyr"));
		if(iyr < 2010 || iyr > 2020)
			return false;
		Integer eyr = Integer.parseInt(map.get("eyr"));
		if(eyr < 2020 || eyr > 2030)
			return false;
		String hgt = map.get("hgt");
		if(hgt.endsWith("cm") || hgt.endsWith("in")) {
			if(hgt.endsWith("cm")) {
				Integer cm = Integer.parseInt(hgt.substring(0, hgt.indexOf("cm")));
				if(cm < 150 || cm > 193)
					return false;
			}else {
				Integer in = Integer.parseInt(hgt.substring(0, hgt.indexOf("in")));
				if(in < 59 || in > 76)
					return false;
			}
		}else
			return false;
		
		String hcl = map.get("hcl");
		if(!Pattern.matches("^#[0-9a-f]{6}", hcl))
			return false;
		
		String ecl = map.get("ecl");
		if(!eclAr.contains(ecl))
			return false;
		
		String pid = map.get("pid");
		if(!Pattern.matches("[0-9]{9}", pid))
			return false;
		
		return true;
			
	}

}
