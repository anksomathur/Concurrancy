package com.concurrancy.exxp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PrintEvenOddUsingWaitNotify {
	public static void main(String[] args) {
		SharedNumber2 snum= new SharedNumber2();
		ExecutorService exeSer=Executors.newFixedThreadPool(2);
		exeSer.execute(new EvenThread1(snum));
		exeSer.execute(new OddThread1(snum));
		exeSer.shutdown();
	}
	}
	class SharedNumber2{
		boolean evenFlag=false;
		
		public  void printEven(int num) throws InterruptedException{
			synchronized (this) {
				while(!evenFlag){
					this.wait();
				}
				System.out.println("Print Even "+num);
				evenFlag=false;
				this.notifyAll();
			}
			
		} 
		public  void PrintOdd(int num) throws InterruptedException{
			synchronized (this) {
				while(evenFlag){
					this.wait();
				}
				System.out.println("Print Odd "+num);
				evenFlag=true;
				this.notifyAll();
			}
			
		}
	}
		  class EvenThread1 implements Runnable{
			private SharedNumber2 snum;
			public EvenThread1(SharedNumber2 snum) {
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
		 class OddThread1 implements Runnable{
			private SharedNumber2 snum;
			public OddThread1(SharedNumber2 snum) {
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
