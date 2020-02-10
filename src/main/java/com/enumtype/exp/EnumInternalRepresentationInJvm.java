package com.enumtype.exp;





 enum BeerType{                  //==> class BeerType{
	RC,TCH,DESI;				//==>	public static final BeerType RC= new BeerType();
								//==>	public static final BeerType TECH= new BeerType();
								//==>	public static final BeerType RC= new BeerType();
								//==>	public static final BeerType DESI= new BeerType();
}

public class EnumInternalRepresentationInJvm {
public static void main(String[] args) {
	BeerType b= BeerType.RC;
	System.out.println("Beer Type: "+b);	
}
}
