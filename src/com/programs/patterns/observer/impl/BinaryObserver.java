package com.programs.patterns.observer.impl;

import com.programs.patterns.observer.Observer;
import com.programs.patterns.observer.Subject;

public class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
	}

}
