package com.programs.patterns.observer.demo;

import com.programs.patterns.observer.Subject;
import com.programs.patterns.observer.impl.BinaryObserver;
import com.programs.patterns.observer.impl.HexaObserver;
import com.programs.patterns.observer.impl.OctalObserver;

public class OberverPatternDemo {
	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}
}
