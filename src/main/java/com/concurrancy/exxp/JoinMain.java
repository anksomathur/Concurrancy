package com.concurrancy.exxp;

public class JoinMain {
private static class Join implements Runnable{
	Thread predecessor;
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"   Started.");
		if(predecessor!=null){
			try{
				predecessor.join();
				System.out.println();
			}catch(InterruptedException exception){
				exception.getStackTrace();
			}
			
			
		}
		System.out.println(Thread.currentThread().getName()+"   Finished.");
		
	}
	
	public void setPredecessor(Thread predecessor) {
		this.predecessor = predecessor;
	}
	
  }

	public static void main(String[] args) {
		Join j1=new Join();
		Join j2=new Join();
		Join j3=new Join();
		Join j4=new Join();
		
		
		Thread t1= new Thread(j1);
		Thread t2= new Thread(j2);
		Thread t3= new Thread(j3);
		Thread t4= new Thread(j4);
		
		j2.setPredecessor(t1);
		j3.setPredecessor(t2);
		j4.setPredecessor(t3);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
