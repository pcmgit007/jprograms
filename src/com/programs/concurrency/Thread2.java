package com.programs.concurrency;

public class Thread2 extends Thread {
	ThreadSequence threadSequence;

	Thread2(ThreadSequence threadSequence) {
		this.threadSequence = threadSequence;
	}

	@Override
	public void run() {
		try {
			synchronized (threadSequence) {
				for(int i=0; i<10; i++) {
					/*if(threadSequence.status!=2)
						threadSequence.wait();*/
					while (threadSequence.status != 2){
						threadSequence.wait();
					}
					System.out.println("Thread 2");
					threadSequence.status = 3;
					threadSequence.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 2: " + e.getMessage());
		}
	}
}
