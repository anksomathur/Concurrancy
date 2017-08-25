package com.concurrancy.exxp;

import java.util.Queue;

public class Producer implements Runnable 
{
	Queue<Integer> queue;
	int n;
	Producer(Queue<Integer> queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		while(n<10){
			try {
				produce(n);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			n++;
		} 
		
	}
	private void produce(int i) throws InterruptedException{
		while(queue.size()==1){
			synchronized (queue) {
				System.out.println("Releasing Producing lock...");
				queue.wait();
				
			}
		}
		synchronized (queue) {
			queue.notifyAll();
			System.out.println("Producing Element.."+i);
			queue.add(i);
		}
	}

}
