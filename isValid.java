package testLeet;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 */
public class isValid {
	public static void main(String[] args) {
		isValid iv = new isValid();
//		System.out.println(iv.isValid1("()[{}]"));
//		System.out.println(iv.isValid1("([)]"));//false
//		System.out.println(iv.isValid1("([]{)}"));//false
		System.out.println(iv.isValid1("(){}}{"));//false
	}

	public boolean isValid1(String s) {
        if (s == null) return true;

        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for(int i = 0 ; i<charArray.length;i++) {
        	char c = charArray[i];
        	if(c=='('||c=='['||c=='{') {
        		stack.push(c);
        	}else {
        		if(stack.isEmpty())return false;
        		char pop = stack.pop();
        		if(c==')'&&pop!='(')return false;
        		else if(c==']'&&pop!='[')return false;
        		else if(c=='}'&&pop!='{')return false;
        	}
        }

        return stack.isEmpty();
    }
}
