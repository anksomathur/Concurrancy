package com.enumtype.exp;

public class EnumMain {

	public static void main(String[] args) {
		System.out.println("Hi....");
		EnumLevel enmLbl=EnumLevel.HIGH;
		System.out.println(enmLbl.getLevel());
		System.out.println(EnumLevel.HIGH);
		 enmLbl=EnumLevel.LOW;
		System.out.println(enmLbl.getLevel());
		System.out.println(EnumLevel.LOW);

	}

}
