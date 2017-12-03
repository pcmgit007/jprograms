package com.programs.patterns.observer;

public abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
