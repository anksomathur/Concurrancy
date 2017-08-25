package com.concurrancy.exxp;

import java.util.Queue;

public class Consumer implements Runnable {
	
	Queue<Integer> queue;
public Consumer(Queue<Integer> queue) {
	// TODO Auto-generated constructor stub
	this.queue=queue;
 }
@Override
public void run() {
	while(true){
		try {
			System.out.println("Consumeing element :"+consume());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

private int consume() throws InterruptedException{
	while(queue.isEmpty()){
	synchronized (queue) {
		System.out.println("Releasing Consumer lock....");
		queue.wait();
	  }
	}
	
	synchronized (queue) {
		System.out.println("Cosuming element...");
		queue.notifyAll();
		return (Integer) queue.poll();
	}
}

}
