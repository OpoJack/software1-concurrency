package concurrency;

public class Worker implements Runnable{

	private int theArray[];
	private double time;
	private String name;

	public Worker(int[] theArray, String name) {
		super();
		this.theArray = theArray;
		this.name = name;
	}


	public String getName() {
		return name;
	}
	
	public double getTime() {
		return time;
	}


	public void setTime(double time) {
		this.time = time;
	}



	@Override
	public void run() {
		synchronized(this) {
			setTime(System.currentTimeMillis());
			//System.out.println("Starting calculation for " + this.getName());
			sum(theArray);
			//System.out.println("Calculation complete for " + this.getName());
			setTime(System.currentTimeMillis() - time);
			//System.out.println(this.getName() + " took " + time + " ms to calculate");
		  }    			
		}

	static int sum(int[] arr) 
    { 
        int sum = 0; // initialize sum 
        int i; 
       
        // Iterate through all elements and add them to sum 
        for (i = 0; i < arr.length; i++) 
           sum +=  arr[i]; 
       
        return sum; 
    } 
		
}
