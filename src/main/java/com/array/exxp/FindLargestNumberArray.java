package com.array.exxp;

public class FindLargestNumberArray {

	public static void main(String[] args) {
		int[] intArr= {25,51,64,85,9,10,75,65,82,45,61,35};
		int maxNumber=intArr[0];
		int minNumber=intArr[0];
		int secondlargest=maxNumber;
		for(int i=0;i<intArr.length;i++){
			if(maxNumber<intArr[i]){
				secondlargest=maxNumber;
				maxNumber=intArr[i];
			}else if(secondlargest<intArr[i]){
				secondlargest=intArr[i];
			}
			if(minNumber>intArr[i]){
				minNumber=intArr[i];
			} 
		}
		System.out.println("min Number :"+minNumber +" max number :"+maxNumber+" Second largest number: "+secondlargest);

	}

}
