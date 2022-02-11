package Aoc.Y2020.advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;

public class Day5SeatNumber {
	
	
	
	public static void main(String[] args) throws Exception {
		getHighestSeatNumber();
	}
	
	public static void getHighestSeatNumber() throws Exception{
		TreeSet<Integer> seatIds = new TreeSet<>();
		try(FileReader fr = new FileReader("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day5SeatNumber.txt");
				BufferedReader bfr = new BufferedReader(fr)){
			String line = null;
			int highestSeatID = -1;
			
			while ((line = bfr.readLine())!=null) {
				int start = 0, end = 127;
				for(int i=0;i<7;i++) {
					if(line.charAt(i) == 'F') {
						end = (start+end)/2;
					}else {
						start = (start+end)/2 + 1;
					}
				}
				int row = start;
				start = 0; end = 7;
				for(int i=7;i<line.length();i++) {
					if(line.charAt(i) == 'L') {
						end = (start+end)/2;
					}else {
						start = (start+end)/2 + 1;
					}
				}
				int column = start, seatId = ((row * 8)+ column);
				if( seatId > highestSeatID) {
					highestSeatID = seatId;
				}
				seatIds.add(seatId);
			}
			System.out.println(seatIds);
		}
		
		Integer[] seatArray = seatIds.toArray(new Integer[seatIds.size()]);
		for (int i = 0; i < seatArray.length-1; i++) {
			if(seatArray[i]+1 != seatArray[i+1]) {
				System.out.println("seatArray[i] "+ seatArray[i] +" missing :"+ (seatArray[i]+1));
			}
		}
		
	}
}
