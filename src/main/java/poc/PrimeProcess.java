package poc;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class PrimeProcess implements Runnable {
	

	
	
	private Queue<Integer> randomNumberQueue;
	
	private Queue<Integer> primeQueue;
	
	public PrimeProcess(BlockingQueue<Integer> randomNumberQueue,Queue<Integer> primeQueue){
		this.randomNumberQueue = randomNumberQueue;
		this.primeQueue = primeQueue;
	}

	public void run() {

		while(true){
			
			try {
				
				Integer random = randomNumberQueue.poll();
				
				if(random != null){
					
					System.out.println("PrimeProcess: Prime app recieved number on RandomNumberQueue ...."+ random);
				
					//do prime check..
					if(isPrime(random)){
						if(primeQueue.offer(random)){
							System.out.println("PrimeProcess: Pushed prime to primeQueue...."+ random);	
						}else{
							System.out.println("PrimeProcess: Couldn't push prime to primeQueue...."+ random);	
						}	
					}
					
				}else{
					System.out.println("PrimeProcess: RandomNumberQueue is empty. Will retry after 2 secs "+ random);
					Thread.sleep(2000);
				}
				
			} catch (Exception e) {
			    System.out.println("PrimeProcess: Error polling the messages from randomNumberQueue..");
			    e.printStackTrace();
			}
	
		}
				

		
	}
	
	
	private boolean isPrime(int n){
		int m=n/2;  
		  for(int i=2;i<=m;i++){    
		   if(n%i==0){    
		    return false;   
		   }    
		  }    
		  return true;
		
	}
	
	
	

}
