package com.concurrancy.exxp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlcokingQueue {
public static void main(String[] args) {
	BlockingQueue<Integer> bcQueue = new ArrayBlockingQueue<>(10);
	ExecutorService exeSer= Executors.newFixedThreadPool(2);
	exeSer.execute(new ProducerBlockingQueue(bcQueue));
	exeSer.execute(new ConsumerBlockingQueue(bcQueue));
	exeSer.shutdown();
}
}
class ProducerBlockingQueue implements Runnable{
	BlockingQueue<Integer> bcQueue;
	public ProducerBlockingQueue(BlockingQueue<Integer> bcQueue) {
		this.bcQueue=bcQueue;
		}
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			try {
				System.out.println("Produce "+i+" " );
				 bcQueue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class ConsumerBlockingQueue implements Runnable{
	BlockingQueue<Integer> bcQueue;
	public ConsumerBlockingQueue(BlockingQueue<Integer> bcQueue) {
		this.bcQueue=bcQueue;
	}
	@Override
	public void run() {
		while(!bcQueue.isEmpty()){
			try {
				System.out.println("Consumed "+bcQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	}
}