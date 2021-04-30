package Y2020.ds;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Day6QandA {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>(5);
		IntStream.range(0, 11).forEach(list::add);
		Iterator<Integer> iterator = list.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			count++;
			Integer inte = iterator.next();
			if(inte%2 == 0)
				iterator.remove();
			
		}
		System.out.println(list.toString()+" "+count);
//		v2();
	}
	
	
	public static void v2() throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day6QandA.txt"));
		
		int totalQuestion = 0;
		List<String> questions = new ArrayList<>();
		boolean isFirst = true;
		for (int i = 0; i < lines.size(); i++) {
			if("".equals(lines.get(i))) {
				totalQuestion += questions.size();
//				System.out.println(questions.toString() + totalQuestion);
				isFirst = true;
				questions = new ArrayList<>();
				continue;
			}
			if(isFirst) {
				isFirst = false;
				questions.addAll(Arrays.asList(lines.get(i).split("")));
			}else
				questions.retainAll(Arrays.asList(lines.get(i).split("")));	
			if(i == lines.size()-1) {
				totalQuestion += questions.size();
//				System.out.println(questions.toString() + totalQuestion);
			}
			
		}
		System.out.println(totalQuestion);
	}
	
	public static void v1() throws Exception {
		List<String> lines = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day6QandA.txt"));
		int totalQuestion = 0;
		Set<String> questions = new HashSet<>();
		for (int i = 0; i < lines.size(); i++) {
			if("".equals(lines.get(i))) {
				totalQuestion += questions.size();
				questions = new HashSet<>();
				continue;
			}
			questions.addAll(Arrays.asList(lines.get(i).split("")));
			if(i == lines.size()-1) {
				totalQuestion += questions.size();
			}
		}
		System.out.println(totalQuestion);
	}

}
