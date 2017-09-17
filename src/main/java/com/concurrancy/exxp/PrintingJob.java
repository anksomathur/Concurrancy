package com.concurrancy.exxp;

public class PrintingJob implements Runnable {
	private PrinterQueue pqueue;
	PrintingJob(PrinterQueue pqueue){
		this.pqueue=pqueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
		pqueue.printjob();
	}

}
