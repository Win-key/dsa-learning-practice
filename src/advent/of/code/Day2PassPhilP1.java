package advent.of.code;

import java.util.List;
import java.util.Objects;

public class Day2PassPhilP1 {

	public static void main(String[] args) throws Exception{
		List<String> arr = InputUtils.readInput("Day2PassPhilP1.txt");
		int validInputs = 0;
		for (String query : arr) {
			int start, end;
			String[] queryData = query.split(" ");
			start = Integer.parseInt(queryData[0].split("-")[0]);
			end = Integer.parseInt(queryData[0].split("-")[1]);
			
			if (checkPasswordPart2(start, end, queryData[1], queryData[2]))
				validInputs++;
		}
		
		System.out.println("Valid number of inputs : " + validInputs);
	}
	
	public static boolean checkPassword(int start, int end, String target, String data) {
		
		int count = 0;
		for(String charStr : data.split("")) {
			if(target.startsWith(charStr)) {
				count++;
			}
		}
		
		return count >= start && count <= end;
	}
	
	public static boolean checkPasswordPart2(int start, int end, String target, String data) {
		String[] dataAr = data.split("");
		try {
			if(target.startsWith(dataAr[start-1]) && target.startsWith(dataAr[end-1])) {
				return false;
			}else if(!target.startsWith(dataAr[start-1]) && !target.startsWith(dataAr[end-1])) {
				return false;
			}
			return true;
		}catch (IndexOutOfBoundsException e) {
			return false;
		}
		
	}
	
}
