package com.programs.concurrency;

//https://stackoverflow.com/questions/12989397/running-3-threads-in-sequence-java
public class ThreadSequence {
	volatile int status = 1;
	public static void main(String args[]) {
		ThreadSequence ts = new ThreadSequence();
		
		Thread1 t1 = new Thread1(ts);
		Thread2 t2 = new Thread2(ts);
		Thread3 t3 = new Thread3(ts);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
