package com.concurrancy.exxp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	 ExecutorService exe= Executors.newFixedThreadPool(2);
	Future<String> f01=exe.submit(new TaskMain("t1"));
	Future<String> f02=exe.submit(new TaskMain("t2"));
	Future<String> f03=exe.submit(new TaskMain("t3"));
	Future<String> f04=exe.submit(new TaskMain("t4"));
		
		System.out.println("getting future task "+f01.get());
		System.out.println("getting future task "+f02.get());
		System.out.println("getting future task "+f03.get());
		System.out.println("getting future task "+f04.get());
		
	System.out.println("Main Thread is called..");
	exe.shutdown();
}
}
class TaskMain implements Callable<String>{
	private String str;
	TaskMain(String str){
		this.str=str;
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("Task is created..."+Thread.currentThread().getName());
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return str +" is completed";
	}
	
}