package archived.algorithms.problems;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AliceAndNotebooks {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Map<Integer, List<Requirement>> readInputs = readInputs();
		readInputs.forEach((key, req)->{
			try {
				req.sort((req1, req2)->{
					if(req1.getRi()> req2.getRi()) {
						return 1;
					}else
						return -1;
				});
				System.out.println(req);
				processReq(key, req);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	private static int processReq(Integer testCase, List<Requirement> requirements) throws Exception {
		int w = 0;
		boolean outerFlag = false;
		int max = getMax(requirements);
		int[] arr = new int[max+1];
		int total = 0 ; double ans = 0;
		for (Requirement req : requirements) {
			total += req.getZi();
			ans = Math.max(ans, Math.ceil((float)total/req.getRi()));
		}
		
		System.out.println(ans);
		
		
		/*
		 * while (!outerFlag) { boolean innerflag = false; Arrays.fill(arr, ++w); for
		 * (Requirement req : requirements) { if(innerflag) break; int zi = req.getZi();
		 * for (int i = 1; i <= req.getRi(); i++) { if(zi == 0) break; int a = arr[i];
		 * if(a <= 0) continue; int diff = a -zi; if(diff >= 0) { arr[i] = diff; zi = 0;
		 * }else { arr[i] = 0; zi = Math.abs(diff); } } innerflag = zi > 0; }
		 * if(!innerflag) outerFlag = true; }
		 * 
		 * System.out.println(w);
		 */
		return w;
	}
	
	private static int getMax(List<Requirement> requirements) {
		int maxDep = Integer.MIN_VALUE;
		for (Requirement requirement : requirements) {
			maxDep = maxDep < requirement.getRi() ? requirement.getRi() : maxDep;
		}
		return maxDep;
	}
	
	public static Map<Integer, List<Requirement>> readInputs() throws Exception{

		int testCase = 0;
		Map<Integer, List<Requirement>> testCases = new HashMap<>();
		List<String> lines = Files
				.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\problemInputs\\AliceAndNotebooks.txt"));
		
		for (int i = 1; i < lines.size(); i++) {
			if(lines.get(i).split(" ").length == 1) {
					testCase++;					
			}else {
				List<Requirement> list = testCases.get(testCase);
				if(Objects.isNull(list)) {
					list = new ArrayList<>();
					testCases.put(testCase, list);
				}
				int[] data = Arrays.asList(lines.get(i).split(" ")).stream().mapToInt(Integer::parseInt).toArray();
//				System.out.println(lines.get(i));
				list.add(new Requirement(data[0],data[1],data[2]));
			}
		}
		return testCases;
	}
	
}

class Requirement{
	private int Li;
	private int Ri;
	private int Zi;
		
	public Requirement() {
		super();
	}
	
	
	public Requirement(int li, int ri, int zi) {
		super();
		Li = li;
		Ri = ri;
		Zi = zi;
	}

	public int getLi() {
		return Li;
	}
	public void setLi(int li) {
		Li = li;
	}
	public int getRi() {
		return Ri;
	}
	public void setRi(int ri) {
		Ri = ri;
	}
	public int getZi() {
		return Zi;
	}
	public void setZi(int zi) {Zi = zi;}


	@Override
	public String toString() {
		return Li + " " + Ri + " " + Zi + " \n";
	}
	
}