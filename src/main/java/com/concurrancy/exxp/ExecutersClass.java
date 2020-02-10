package com.concurrancy.exxp;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutersClass {
public static void main(String[] args) {
	ExecutorService executor= Executors.newFixedThreadPool(2);
	executor.execute(new Task());
	executor.execute(new Task());
	executor.execute(new Task());
}
}
class Task implements Runnable{

	@Override
	public void run() {
System.out.println("Task is created...successfully"+Thread.currentThread().getName());
try {
	Thread.sleep(500l);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
};
	}
	
}