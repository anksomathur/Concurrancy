package com.concurrancy.exxp;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTestWithThread {
PrintingNumber numberObj= new PrintingNumber();
FutureTask<Boolean> ftk=new FutureTask<>(new PrintingJobThread(numberObj));
Thread thread= new Thread(ftk);
}

class PrintingNumber {
public PrintingNumber() {
}	
	public void printNumber(int i){
		System.out.println("Printing number :"+i);
	}
}
class PrintingJobThread implements Callable<Boolean>{
	PrintingNumber numberObj;
	public PrintingJobThread(PrintingNumber number) {
		this.numberObj=number;
	}
	@Override
	public Boolean call() throws Exception {
		for (int i = 0; i <= 10; i++) {
			numberObj.printNumber(i);
		}

		return true;

	}	
}