package com.concurrancy.exxp;

public class PauseThread {
public static void main(String[] args) {
	Runnable r1=new CuurentThread("runner thread");
	Thread t1= new Thread(r1);
	t1.start();
	try {
		Thread.sleep(100l);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	t1.interrupt();
	System.out.println("    End    ");
}
}
class CuurentThread implements Runnable{
	private String threadName;
	
	
	CuurentThread(String thName){
		this.threadName=thName;
	}
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			
			System.out.println("Current Thread "+threadName+" is running....");
		}
		
	}
	
}
