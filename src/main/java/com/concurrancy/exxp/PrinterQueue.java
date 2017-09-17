package com.concurrancy.exxp;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterQueue {

	private final Lock lock= new ReentrantLock();

	
	public void printjob(){
	lock.lock();
	 Long duration = (long) (Math.random() * 10000);
     System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds :: Time - " + new Date());
	 try {
		Thread.sleep(duration);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally
     {
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
        lock.unlock();
     }
	 
	 
   }
}
