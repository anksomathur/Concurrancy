package com.concurrancy.exxp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintEvenOddUsingCondition {
	public static void main(String[] args) {
		SharedResource snum= new SharedResource();
		ExecutorService exeSer=Executors.newFixedThreadPool(2);
		exeSer.execute(new PrintEvenThread(snum));
		exeSer.execute(new PrintOddThread(snum));
		exeSer.shutdown();
	}
	}
	class SharedResource{
		boolean evenFlag=false;
		Lock lock= new ReentrantLock();
		Condition printoddNumber=lock.newCondition();
		Condition printEvenNumber=lock.newCondition();
		public  void printEven(int num) throws InterruptedException{
			lock.lock();
			try {
				while(!evenFlag){
					printEvenNumber.await();;
				}
				System.out.println("Print Even "+num);
				evenFlag=false;
				printoddNumber.signalAll();
		}finally {
			lock.unlock();
			}
			
		}  	
		public  void PrintOdd(int num) throws InterruptedException{
			lock.lock();
			try {
				while(evenFlag){
					printoddNumber.await();
				}
				System.out.println("Print Odd "+num);
				evenFlag=true;
				printEvenNumber.signalAll();
			}finally {
				lock.unlock();
			}
			
		}
	}
		  class PrintEvenThread implements Runnable{
			private SharedResource snum;
			public PrintEvenThread(SharedResource snum) {
				this.snum=snum;
	     	}
			@Override
			public void run() {
				for(int i=2;i<10;i=i+2){
					try {
						snum.printEven(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
		 class PrintOddThread implements Runnable{
			private SharedResource snum;
			public PrintOddThread(SharedResource snum) {
				this.snum=snum;
	     	}
			@Override
			public void run() {
				for(int i=1;i<10;i=i+2){
					try {
						snum.PrintOdd(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
 }
