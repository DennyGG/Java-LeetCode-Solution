package testLeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 *
 */
public class romanToInt {
	
	public static void main(String[] args) {
		romanToInt tt = new romanToInt();
		System.out.println(tt.romanToInt1("MDCXCV"));
		System.out.println(tt.romanToInt2("MDCXCV"));
		System.out.println(tt.romanToInt3("MCMXCIV"));
	}
    public int romanToInt1(String s) {
    	List<Integer> array = new ArrayList<>();
    	int sInt = 1;
    	int sum = 0;
    	for(int i = 0;i<s.length();i++) {
    		String sString = s.charAt(i)+"";
    		System.out.println("sString:"+sString);
    		if("M".equals(sString)) {
    			sInt = 1000;
    		}else if("D".equals(sString)) {
    			sInt = 500;
    		}else if("C".equals(sString)) {
    			sInt = 100;
    		}else if("L".equals(sString)) {
    			sInt = 50;
    		}else if("X".equals(sString)) {
    			sInt = 10;
    		}else if("V".equals(sString)) {
    			sInt = 5;
    		}else {
    			sInt = 1;
    		}
    		array.add(sInt);
    	}
    	System.out.println(array);
    	if(array.size()>1) {
    		for(int j=0;j<array.size()-1;j++) {
    			int leftInt = array.get(j);
    			int rightInt = array.get(j+1);
    			
    			if(leftInt<rightInt) {
    				sum = sum +rightInt-leftInt;
    				j++;
    			}else {
    				sum += leftInt;
    			}
    			if(j==array.size()-2) {
    				int finalInt = array.get(j+1);
    				sum += finalInt;
    			}
    		}
    	}else {
    		sum = array.get(0);
    	}
        return sum;
    }
    public int romanToInt2(String s) {
    	Map<String,Integer> map = new HashMap<>();
    	map.put("I", 1);
    	map.put("V", 5);
    	map.put("X", 10);
    	map.put("L", 50);
    	map.put("C", 100);
    	map.put("D", 500);
    	map.put("M", 1000);
    	List<String> array = Arrays.asList(s.split(""));
    	int sum = 0;
    	System.out.println(array);
    	if(array.size()>1) {
    		for(int j=0;j<array.size()-1;j++) {
    			int leftInt = map.get(array.get(j));
    			int rightInt = map.get(array.get(j+1));
    			
    			if(leftInt<rightInt) {
    				sum = sum +rightInt-leftInt;
    				j++;
    			}else {
    				sum += leftInt;
    			}
    			if(j==array.size()-2) {
    				int finalInt = map.get(array.get(j+1));
    				sum += finalInt;
    			}
    		}
    	}else {
    		sum = map.get(array.get(0));
    	}
    	return sum;
    }
    public int romanToInt3(String s) {
    	int sInt = 1;
    	int sum = 0;
    	int tempLeft = 0;
    	for(int i = 0;i<s.length();i++) {
    		String sString = s.charAt(i)+"";
    		System.out.println("sString:"+sString);
    		if("M".equals(sString)) {
    			sInt = 1000;
    		}else if("D".equals(sString)) {
    			sInt = 500;
    		}else if("C".equals(sString)) {
    			sInt = 100;
    		}else if("L".equals(sString)) {
    			sInt = 50;
    		}else if("X".equals(sString)) {
    			sInt = 10;
    		}else if("V".equals(sString)) {
    			sInt = 5;
    		}else {
    			sInt = 1;
    		}
    		
    		if(s.length()==1) {
    			return sInt;
    		}
    		if(i==0) {
    			tempLeft = sInt;
    			continue;
    		}else {
    			if(tempLeft<sInt) {
    				sum -= tempLeft ;
    			}else {
    				sum += tempLeft; 
    			}
    			if(i==s.length()-1) {
    				sum += sInt;
    			}
    			tempLeft = sInt;
    		}
    	}
    	return sum;
    }
}
