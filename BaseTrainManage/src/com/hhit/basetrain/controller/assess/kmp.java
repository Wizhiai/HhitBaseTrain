/**
 * 
 */
package com.hhit.basetrain.controller.assess;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 *@author hulijie
 * @date 2016-5-29t下午10:29:05
 * TODO
 */
public class kmp {
	
	
	static	public int[] getNext(String b)  
	{  
	    int len=b.length();  
	    int j=0;  
	          
	    int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始  
	    next[0]=next[1]=0;  
	          
	    for(int i=1;i<len;i++)//i表示字符串的下标，从0开始  
	    {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置  
	        while(j>0&&b.charAt(i)!=b.charAt(j))j=next[j];  
	        if(b.charAt(i)==b.charAt(j))j++;  
	        next[i+1]=j;  
	    }  
	          
	    return next;  
	}  
	
static	public  String[] search(String original, String find, int next[]) {  
	    int j = 0;  
	    int a[][] = new int[100][];
	    String[] rArr = new String[100];
	    int ar = 0;
	    for (int i = 0; i < original.length(); i++) {  
	        while (j > 0 && original.charAt(i) != find.charAt(j))  
	            j = next[j];  
	        if (original.charAt(i) == find.charAt(j))  
	            j++;  
	        if (j == find.length()) {  
	            System.out.println("find at position " + (i - j+1));  
	            System.out.println(original.subSequence(i - j + 1, i + 1));  
	            if ((i-j)>0) {
	            	switch (i-j) {
	            	case 0:{
	            		a[ar] = new int[]{i-j+1,i+1};
	            		ar++;
	            		  System.out.println(original.subSequence(i - j + 1, i + 1)); 
	            		  
	            		break;}
					case 1:{
						a[ar] = new int[]{i-j,i+1};
	            		ar++;
						  System.out.println(original.subSequence(i - j , i + 1));
						break;}
					case 2:{
						a[ar] = new int[]{i-j-1,i+1};
	            		ar++;
						  System.out.println(original.subSequence(i - j -1, i + 1));
						break;}
					case 3:{
						a[ar] = new int[]{i-j-2,i+1};
	            		ar++;
						  System.out.println(original.subSequence(i - j -2, i + 1));
						break;}
//					case 4:{
//						a[ar] = new int[]{i-j-3,i+1};
//	            		ar++;
//						  System.out.println(original.subSequence(i - j -3, i + 1));
//						break;}
					
					default:{
						a[ar] = new int[]{i-j-2,i+1};
	            		ar++;
						 
						break;}
					}
	            	  
				}
	            j = next[j];  
	        }  
	    }  			
	
		int rArri = 0;
	    for (int i = 0; i < a.length; i++) {

	    if (a[i]!=null) {
	    	
	    	rArr[rArri] = original.substring(a[i][0], a[i][1]);
	    	rArri++;

	    	
		}
	    }
	    String []arr = {rArr[0],find,"1"};
		return arr;
	  
	}  




static	public  String[] searchDegree(String []original, String find, int next[]) {  
    int j = 0;  
	int rArri = 0;
    int a[][] = new int[100][];
    String[] rArr = new String[100];
    int ar = 0;
    for (int i = 0; i < original[0].length(); i++) {  
        while (j > 0 && original[0].charAt(i) != find.charAt(j))  
            j = next[j];  
        if (original[0].charAt(i) == find.charAt(j))  
            j++;  
        if (j == find.length()) {  
          
            a[ar] = new int[]{i-j+1,i+1};
    		ar++;
    		rArr[rArri] = original[0].substring(i - j+1);
        	rArri++;
            j = next[j];  
        }  
    }  			
	if (ar==0) {
		rArr[0] = original[1];
	}
	  String []arr = {rArr[0],"1"};
 
	return arr;
  
}  


static	public  boolean isContain(String original, String find, int next[]) {  
    int j = 0;  
    boolean b = false;
	
    for (int i = 0; i < original.length(); i++) {  
        while (j > 0 && original.charAt(i) != find.charAt(j))  
            j = next[j];  
        if (original.charAt(i) == find.charAt(j))  
            j++;  
        if (j == find.length()) {  
            
            j = next[j];  
            b = true;
        }  
    }  			
	

 
	return b;
  
}  







static	public  String[] pipei(int[][] a,String orignal) {
	String[] arrStrings = {"s","s"};
	for (int i = 0; i < a.length; i++) {
//		ws
	}
	return arrStrings; 
}
}
