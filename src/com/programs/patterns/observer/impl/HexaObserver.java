package com.programs.patterns.observer.impl;

import com.programs.patterns.observer.Observer;
import com.programs.patterns.observer.Subject;

public class HexaObserver extends Observer {

	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ) ); 
	}

}
