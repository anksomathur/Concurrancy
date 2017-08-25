package com.concurrancy.exxp;

public class StringThreadSafety {
	
 static class StringThread implements Runnable{
private String s;
	StringThread(String str){
	this.s=str;
	}
	public void run() {
	for(int i=0;i<5;i++){
		s=s+"abc"+Thread.currentThread().getName();
		System.out.println("Thread class "+s);
	}
	}

}
 
 public static void main(String[] args) {
	 String str="abc";
	Thread t1= new Thread(new StringThread(str));
	t1.start();
	Thread t2= new Thread(new StringThread(str));
	t2.start();
}

}
