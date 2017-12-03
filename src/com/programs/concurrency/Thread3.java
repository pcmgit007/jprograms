package com.programs.concurrency;

public class Thread3 extends Thread {
	ThreadSequence threadSequence;

	Thread3(ThreadSequence threadSequence) {
		this.threadSequence = threadSequence;
	}

	@Override
	public void run() {
		try {
			synchronized (threadSequence) {
				for(int i=0; i<10; i++) {
					/*if(threadSequence.status!=3)
						threadSequence.wait();*/
					while (threadSequence.status != 3){
						threadSequence.wait();
					}
					System.out.println("Thread 3");
					threadSequence.status = 1;
					threadSequence.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 3: " + e.getMessage());
		}
	}
}
