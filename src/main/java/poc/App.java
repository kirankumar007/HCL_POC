package poc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	public static void main(String[] args) {
		
		
		BlockingQueue<Integer> randomNumberQueue  = new ArrayBlockingQueue<Integer>(1000);
		
		ArrayBlockingQueue<Integer> primeNumberQueue  = new ArrayBlockingQueue<Integer>(1000);
		
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		
		service.execute(new Randomizer(randomNumberQueue, primeNumberQueue));
		
		
		service.execute(new PrimeProcess(randomNumberQueue, primeNumberQueue));
		
	}

}
