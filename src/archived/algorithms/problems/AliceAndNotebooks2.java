package archived.algorithms.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AliceAndNotebooks2 {

	public static void main(String[] args) throws Exception {
		Map<Integer, List<Requirement>> readInputs = AliceAndNotebooks.readInputs();
		
		readInputs.forEach((key, value)->{
			build(4, value);
		});
	}
	
	private static void processRequirements(List<Requirement> requirements) {
		
		
	}
	
	private static boolean update(int[] tree, int node, int start, int end, int idx, int val){
	    if(start == end){
	        tree[node] += val;
	    }else{
	        int mid = (start + end) / 2;
	        if(start <= idx && idx <= mid){
	            update(tree,2*node, start, mid, idx, val);
	        }else{
	            update(tree,2*node+1, mid+1, end, idx, val);
	        }
	        tree[node] = tree[2*node] + tree[2*node+1];
	    }
	    
	    return true;
	}
	
	
	private static int getMaxRi(List<Requirement> requirements) {
		AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
		requirements.forEach(req->{
			if(req.getRi() > max.get()) {
				max.set(req.getRi());
			}
		});
		
		return max.get()+1;
	}
	
	public static int[] build(int W, List<Requirement> requirements){
		int length = getMaxRi(requirements);
		int[] tree = new int[2*length-1];
		build(tree , W, 1, 1, length-1);// ignore index = 0
		System.out.println(Arrays.toString(tree));
		
		return tree;
	}
	
	public static void build(int[] tree, int W, int node, int start, int end){
	    if(start == end){
	        tree[node] = W;
	    }else{
	        int mid = (start + end) / 2;
	        build(tree, W, 2*node, start, mid);
	        build(tree, W, 2*node+1, mid+1, end);
	        tree[node] = tree[2*node] + tree[2*node+1];
	    }
	}
	
}
