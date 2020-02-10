package com.enumtype.exp;

public enum EnumLevel {
	HIGH(3),NORMAL(2),LOW(1);
	
	private  int level;
	EnumLevel(int level){
		this.level=level;
	}
	public  int getLevel(){
		return level;
	}
	

}
