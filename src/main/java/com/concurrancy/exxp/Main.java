package com.concurrancy.exxp;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
public static void main(String[] args) {
	Queue<Integer> queue= new LinkedList<>();
	Thread t1= new Thread(new Producer(queue));
	t1.start();
	Thread t2= new Thread(new Consumer(queue));
	t2.start();
}
}
