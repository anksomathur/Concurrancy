package com.exception.exxp;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.management.openmbean.InvalidOpenTypeException;

public class ThrowsDema {
public static void main(String[] args) {
	try {
		display();
	} catch (IOException e) {
      System.out.println("Exception occured in main method");
		e.printStackTrace();
	}
}

private static void display() throws FileNotFoundException{
	
	//throw new NullPointerException();// No need to declare throws keyword for unchecked exception
	try{
	throw new FileNotFoundException();
	}catch(FileNotFoundException exception){
		System.out.println("Exception occured in display method");
		throw exception;
	}
}
}
