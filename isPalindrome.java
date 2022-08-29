package testLeet;

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 */
public class isPalindrome {
	public static void main(String[] args) {
		isPalindrome iP = new isPalindrome();
		System.out.println(iP.isPalindrome1(1234554321));
		System.out.println(iP.isPalindrome2(12344321));
		System.out.println(iP.isPalindrome3(1234321));
	}
	private boolean isPalindrome1(int x) {
		String strX = String.valueOf(x);
		StringBuffer sb = new StringBuffer();
		String reX = sb.append(strX).reverse().toString();
		return strX.equals(reX);
	}
	private boolean isPalindrome2(int x) {
		if(x<0)return false;
		
		int numberOfDigits = 0;
		int temp = x;
		while (temp > 0) {
			temp = temp/10;
			numberOfDigits++;
		}
		for(int i = 0 ;i<numberOfDigits/2 ; i++) {
			int normal = 0;
			int reserse = 0;
			temp = x;
			for(int j = 0; j <= i;j++) {
				normal = temp %10;
				temp /= 10;
			}
			temp = x;
			for(int j = 0; j<numberOfDigits-i;j++) {
				reserse = temp %10;
				temp /= 10;
			}
			if(normal!=reserse)return false;
		}
		
		return true;
	}
	private boolean isPalindrome3(int x) {
		if(x<0)return false;
		int temp = x;
		int reverse = 0;
		
		while(true) {
			reverse = reverse*10+temp%10;
			temp /=10;
			if(temp==0)break;
		}
		if(x!=reverse)return false;
		return true;
	}
}
