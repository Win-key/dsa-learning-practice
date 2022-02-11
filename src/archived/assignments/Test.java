package archived.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class Test {

	private static Callable<Integer> callable = ()-> {
		String data = "I'm in callable.";
		String[] keys = "asbsc||qerej".split("\\|\\|");
		
		System.out.println(Arrays.toString(keys));
		System.out.println();
		return data.length();
	};
	
	public static void main(String[] args) throws Exception {
		
		List<String> split = attrSplit("identifier[system.value[a.b=123]=123456].code");
		System.out.println(split.toString());
		
	}
	
	public static List<String> attrSplit(String input){
		List<String> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		char[] chars = input.toCharArray();
		int count = 0;
		
		for (int i = 0; i < chars.length; i++) {
			
			switch (chars[i]) {
			case '.':
				if(count == 0) {
					list.add(sb.toString());
					sb = new StringBuffer();
				}else {
					sb.append(chars[i]);
				}
				break;
			case '[':
				count++;
				sb.append(chars[i]);
				break;
			case ']':
				count--;
				sb.append(chars[i]);
				break;
			default:
				sb.append(chars[i]);
				break;
			}
		}
		if(sb.length() > 0) {
			list.add(sb.toString());
		}
		return list;
		
	}

}

