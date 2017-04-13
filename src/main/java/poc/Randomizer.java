package poc;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Randomizer implements Runnable{

	
	private BlockingQueue<Integer> randomNumberQueue;
	
	private Queue<Integer> primeQueue;
	
	Random rand = new Random();

	
	public Randomizer(BlockingQueue<Integer> randomNumberQueue,Queue<Integer> primeQueue){
		this.randomNumberQueue = randomNumberQueue;
		this.primeQueue = primeQueue;
	}
	
	
	public void run() {
		
		boolean insertError = false;
		
		Integer  random  = null;
		
		Integer prime  = null;
		
		while(true){
			
			try {
				random = (insertError ? random : rand.nextInt(Integer.MAX_VALUE));
				insertError = ! randomNumberQueue.offer(random);
				if(!insertError)
				 System.out.println("RandomNumberProcess: Inserted random number to RandomNumberQueue...."+ random);
			} catch (Exception e) {
			    System.out.println("RandomNumberProcess:Error adding.."+ random);
			    insertError = true;
			}
	
			
			try {
				prime = primeQueue.poll();
				if(prime != null){
					System.out.println("RandomNumberProcess:Prime recieved from the PrimeNumberQueue...."+ prime);
				}
			} catch (Exception e) {
			    System.out.println("RandomNumberProcess: Error retrieving .."+ prime);
			}
			
		}
				
	}

}
