package concurrency;

import java.util.Random;

/*
 * Implement a parallel array sum, and compare performance with single thread sum. 


Make an array of 200 million random numbers between 1 and 10. 
Compute the sum in parallel using multiple threads. 
Then compute the sum with only one thread, and display the sum and times for both cases.
 * 
 */
/* Name: Jack Oporto
 * Class: CEN 3024C
 * Professor Dhrgam Al Kafaf
 * Assignment: Concurrency
 * Date completed: October 30, 2020
 * 
 * Summary:
 * This program demonstrates the use of multithreading
 */

public class Main {

public static void main(String[] args) throws InterruptedException {

	//random number object
	Random random = new Random();
	
	//randomizes the array of 3 million numbers sized 1-1000
	System.out.println("Getting random numbers...");
	int[] single = random.ints(250000000, 1, 1000).toArray();

	//s = single , m = multithreaded
	Worker s1 = new Worker(single, "s1");
	
	//Re-declares random values after they're assigned to each array
	int[] multi = random.ints(75000000, 1, 1000).toArray();
	Worker m1 = new Worker(multi, "m1");
	multi = random.ints(75000000, 1, 1000).toArray();
	Worker m2 = new Worker(multi, "m2");
	multi = random.ints(75000000, 1, 1000).toArray();
	Worker m3 = new Worker(multi, "m3");
	System.out.println("Random numbers initialized!\n\n");
	
	

	//basic intro text
	welcome();
	
	//Threads begin, s1 does all calculations solo, m1-3 divide the numbers equally.
	new Thread (s1).start();
	new Thread (m1).start();
	new Thread (m2).start();
	new Thread (m3).start();
	
	Thread.sleep(300);
	System.out.println("Single-threaded calculation performed in: " + s1.getTime() + " ms.");
	System.out.println("Multi-threaded calculation performed in: " + 
			((m1.getTime() + m2.getTime() + m3.getTime())/3) + " ms.");

}


public static void welcome() throws InterruptedException {
	System.out.println("This program will test the efficiency of single vs multithreaded operation.");
	System.out.println("A single thread will calculate the sum of 250 million random numbers");
	System.out.println("Three threads will calculate the sum, 75 million at a time.");
	Thread.sleep(2000);
	System.out.println("\n\nCalculating now...");
}
}