package com.enumtype.exp;

enum Beer{                  //==> class BeerType{
	RC,TCH,DESI;				//==>	public static final BeerType RC= new BeerType();
								//==>	public static final BeerType TECH= new BeerType();
								//==>	public static final BeerType RC= new BeerType();
								//==>	public static final BeerType DESI= new BeerType();
	Beer(){
		System.out.println("Calling Constructor "); // It will call at the time of loading class
	}
}



public class EnumConstructor {
	
	public static void main(String[] args) {
		Beer b = Beer.RC;
		System.out.println(" Enum Value :"+b);
	}

}
