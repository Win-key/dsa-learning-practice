package Y2020.advent.of.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8BootCode {

	private static String[] codes = {"acc", "jmp", "nop"};
	
	private static List<String> swaps = Arrays.asList("jmp", "nop");
	
	public static void main(String[] args) throws Exception{

		List<Instruction> instructions = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day8BootCode.txt"))
											.stream()
											.map(line -> {
												String[] ar = line.split(" ");
												return new Instruction(ar[0], Integer.parseInt(ar[1]));
											})
											.collect(Collectors.toList());
		System.out.println(part1(instructions));
		System.out.println(part2(instructions));
	}
	
	private static Result part1(List<Instruction> instructions) throws Exception{
		int acc = 0;
		
		for (int i = 0; i < instructions.size();) {
			Instruction current = instructions.get(i);
			if(current.isTouched()) {
				instructions.forEach(ins->ins.setTouched(false));
				return new Result(acc, true, i);
			}
			
			current.setTouched(true);
			String code = current.getCode();
			if(code.equals("nop")) {
				i++;
			}else if(code.equals("acc")) {
				acc += current.getCount();
				i++;
			}else {
				/*
				 * int diff = (i + current.getCount())%instructions.size(); if(diff < 0) diff +=
				 * instructions.size();
				 */
				
				i += current.getCount();
			}
		}
		
		
		System.out.println(acc);

		return new Result(acc, false, 0);
		
	}
	
	private static Result part2(List<Instruction> instructions) throws Exception{
		int acc = 0;
		
		for (int i = 0; i < instructions.size(); i++) {
			Instruction instruction = instructions.get(i);
			if(swaps.contains(instruction.getCode())) {
				instruction.invertCode();
				Result part1 = part1(instructions);
				if(part1.isInfinite()) {
					instruction.invertCode();
				}else {
					return new Result(acc, false, i);
				}
			}
		}
		
		throw new Exception("Not found");
		
	}
	
}

class Instruction{
	private String code;
	private Integer count;
	private boolean touched = false;
	
	public Instruction(String code, Integer count) {
		super();
		this.code = code;
		this.count = count;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isTouched() {
		return touched;
	}

	public void setTouched(boolean touched) {
		this.touched = touched;
	}
	
	public void invertCode() {
		if(this.code.equals("nop")) {
			this.setCode("jmp");
		}else {
			this.setCode("nop");
		}
		this.touched = false;
	}

	@Override
	public String toString() {
		return "Instruction [code=" + code + ", count=" + count + ", touched=" + touched + "]";
	}
	
	
}
class Result{
	private int acc;
	private boolean isInfinite;
	private int index;
	
	public Result(int acc, boolean isInfinite, int index) {
		super();
		this.acc = acc;
		this.isInfinite = isInfinite;
		this.index= index; 
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public boolean isInfinite() {
		return isInfinite;
	}

	public void setInfinite(boolean isInfinite) {
		this.isInfinite = isInfinite;
	}

	@Override
	public String toString() {
		return "Result [acc=" + acc + ", isInfinite=" + isInfinite + ", index=" + index + "]";
	}

	
	
}
