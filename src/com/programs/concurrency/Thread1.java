package com.programs.concurrency;

public class Thread1 extends Thread {
	ThreadSequence threadSequence;

	Thread1(ThreadSequence threadSequence) {
		this.threadSequence = threadSequence;
	}

	@Override
	public void run() {
		try {
			synchronized (threadSequence) {
				for(int i=0; i<10; i++) {
					/*if(threadSequence.status!=1)
						threadSequence.wait();*/
					while (threadSequence.status != 1){
						threadSequence.wait();
					}
					System.out.println("Thread 1");
					threadSequence.status = 2;
					threadSequence.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1: " + e.getMessage());
		}
	}
}
