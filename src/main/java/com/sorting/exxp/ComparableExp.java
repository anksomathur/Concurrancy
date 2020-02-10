package com.sorting.exxp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableExp {
	public static void main(String[] args) {
  List<Person> list= new ArrayList();
   list.add(new Person("ankit","M",20));
   list.add(new Person("mathur","M",19));
   list.add(new Person("kajol","M",21));
   list.add(new Person("reena","M",25));
   list.add(new Person("priya","M",15)); list.add(new Person("shalu","M",10));
   
   list.add(new Person("kanika","M",30));
   list.add(new Person("deepika","M",16));
   list.add(new Person("ram","M",27));
   Collections.sort(list);
   list.stream().forEach(System.out::println);
   Collections.sort(list,new ageSorter());
   System.out.println("Sorting with age.......");
   list.stream().forEach(System.out::println);
	}
}

class Person implements Comparable<Person>{

	private String name;
	private String gender;
	private int age;
	
	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
}
class ageSorter implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		
		return o1.getAge()-o2.getAge();
	}
	
}