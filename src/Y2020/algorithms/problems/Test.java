package Y2020.algorithms.problems;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 1000; i < 9999; i++) {
			if(Integer.toString(i*4).equals(new StringBuffer(Integer.toString(i)).reverse().toString())) {
				System.out.println(i);
			}
		}
		
	}

}
