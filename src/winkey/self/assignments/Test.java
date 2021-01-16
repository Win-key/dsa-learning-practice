package winkey.self.assignments;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

	private static Callable<Integer> callable = ()-> {
		String data = "I'm in callable.";
		System.out.println();
		return data.length();
	};
	
	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> callFuture = executor.submit(callable);
		Integer integer = callFuture.get();
		
	}
}

