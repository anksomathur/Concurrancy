package com.concurrancy.exxp;

public class RunClassWithoutStartThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread "+Thread.currentThread().getName());
		for(int i=0;i<5;i++){
			System.out.println("Printing Thread:"+Thread.currentThread().getName()+" Number "+i);
		}
	}
public static void main(String[] args) {
	RunClassWithoutStartThread obj= new RunClassWithoutStartThread();
	Thread t1= new Thread(obj);
	Thread t2= new Thread(obj);
	t1.run();
	t2.run();
}
}
