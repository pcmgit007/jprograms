package com.programs.patterns.observer.impl;

import com.programs.patterns.observer.Observer;
import com.programs.patterns.observer.Subject;

public class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
	}

}
