package com.serialization.exxp;

public class Person {
	private String name;
	 private int id;
	 private int age;
	 /*private String city;
	 public String getCity() {
	  return city;
	 }*/
	 // Constructor
	 Person(String name, int id, int age){
	   System.out.println("In Constructor with args");
	   this.name = name;
	   this.id = id;
	   this.age = age; 
	 }
	 // no-arg Constructor
	 Person(){
	   System.out.println("no-arg constructor");
	 }
	 
	 public String getName() {
	  return name;
	 }
	  
	 
	 public int getAge() {
	  return age;
	 }
	 public int getId() {
	  return id;
	 }
}
