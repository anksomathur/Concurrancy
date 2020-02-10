package com.concurrancy.exxp;

import java.util.concurrent.CountDownLatch;

public class InterruptedThread {
public static void main(String[] args) throws InterruptedException {
	Thread t1= new Thread(new PrintingMessageThread());
	t1.start();
	Thread.sleep(200);
	t1.interrupt();
	System.out.println(" Main printing Child thread has been finished...");
}
}
class PrintingMessageThread implements Runnable{
	@Override
	public void run() {
		while(!Thread.interrupted()){
		
		System.out.println(Thread.currentThread().getName()+" printing Message...");
		}
	}
}