package com.programs.ds.queues;

public class MyQueue {
	private int capacity;
	int queueArr[];
	int front = 0;
	int rear = -1;
	int currentSize = 0;

	public MyQueue(int queueSize) {
		this.capacity = queueSize;
		queueArr = new int[this.capacity];
	}

	public void enqueue(int item) {
		if (isQueueFull()) {
			System.out.println("Overflow..!! Unable to add element.." + item);
		} else {
			rear++;
			if (rear == capacity - 1) {
				rear = 0;
			}
			queueArr[rear] = item;
			currentSize++;
			System.out.println("Element: " + item + " is pushed to Queue..!!");
		}
	}

	public void dequeue() {
		if (isQueueEmpty()) {
			System.out.println("Underflow..!! Unable to remove element from Queue..!!");
		} else {
			front++;
			if (front == capacity - 1) {
				System.out.println("Pop operation done..!! Removed:: " + queueArr[front - 1]);
				front = 0;
			} else {
				System.out.println("Pop operation done..!! Removed::" + queueArr[front - 1]);
			}
			currentSize--;
		}
	}

	public boolean isQueueFull() {
		boolean status = false;
		if (currentSize == capacity) {
			status = true;
		}
		return status;
	}

	public boolean isQueueEmpty() {
		boolean status = false;
		if (currentSize == 0) {
			status = true;
		}
		return status;
	}

	public static void main(String a[]) {

		MyQueue queue = new MyQueue(4);
		queue.enqueue(4);
		queue.dequeue();
		queue.enqueue(56);
		queue.enqueue(2);
		queue.enqueue(67);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(24);
		queue.dequeue();
		queue.enqueue(98);
		queue.enqueue(45);
		queue.enqueue(23);
		queue.enqueue(435);
	}
}