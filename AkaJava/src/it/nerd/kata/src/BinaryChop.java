/*
 *finds the position of value in a sorted array of values.
 * in the first pass it determines whether the required value is 
 * in the top or the bottom half of the list of values
 * in the second pass in considers only this half 
 * again dividing it in to two
 * It stops when it finds the value it is looking for, 
 * or when it runs out of array to search
 */

package it.nerd.kata.src;


public class BinaryChop {
	
	public static int searchIt(int[] mySortedArr, int wanted){
		int half = mySortedArr.length % 2;
		if(wanted < mySortedArr[half]){
			for(int i=0; i<half; i++){
				if(mySortedArr[i] == wanted){
					return i;
				}
			}
		}
		else{
			for(int i = half; i < mySortedArr.length; i++){
				if(mySortedArr[i] == wanted){
					return i;
				}
			}
		}
		return 0;
	}
}
