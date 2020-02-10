package com.concurrancy.exxp;

import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PrintEvenOddUsingSemaphore {
public static void main(String[] args) {
	SharedNumber snum= new SharedNumber();
	ExecutorService exeSer=Executors.newFixedThreadPool(2);
	exeSer.execute(new EvenThread(snum));
	exeSer.execute(new OddThread(snum));
	exeSer.shutdown();
	
}
}
class SharedNumber{
	
	Semaphore sOd= new Semaphore(0);//All acquire will be block until you do a release
	Semaphore sEvn= new Semaphore(1);//For semOne the first acquire() calls will succeed and the rest will block until the first one releases.
	/**
	 * 
	 * @param num
	 * @throws InterruptedException
	 */
	public void printEven(int num) throws InterruptedException{
		sOd.acquire();// if you shuffle the statement sod=>sEvn & sEvn=>sod & will do same in print odd method then print odd will call first
		System.out.println("Print Even "+num);
		sEvn.release();
	} 
	public void PrintOdd(int num) throws InterruptedException{
		sEvn.acquire();
		System.out.println("Print Odd "+num);
		sOd.release();
	}
}
	  class EvenThread implements Runnable{
		private SharedNumber snum;
		public EvenThread(SharedNumber snum) {
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
	 class OddThread implements Runnable{
		private SharedNumber snum;
		public OddThread(SharedNumber snum) {
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
