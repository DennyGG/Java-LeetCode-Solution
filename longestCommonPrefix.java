package testLeet;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 */
public class longestCommonPrefix {
	public static void main(String[] args) {
		longestCommonPrefix lcp = new longestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		
		System.out.println(lcp.longestCommonPrefix1(strs));
		System.out.println(lcp.longestCommonPrefix2(strs));
	}
    public String longestCommonPrefix1(String[] strs) {
        int strsLength = strs.length;
        String firstWord = strs[0];
        int firstLength = firstWord.length();
        String result = "";
        for(int i =0;i<firstLength;i++) {
        	String temp = firstWord.substring(0, i+1) ;
        	for(int j = 0 ;j <strsLength;j++) {
        		if(strs[j].indexOf(temp)!=0) {
        			return result;
        		}
        	}
        	result = temp;
        }
    	return result;
    }
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";    
            return longestCommonPrefix3(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix3(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix3(strs, l , mid);
            String lcpRight =  longestCommonPrefix3(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
       }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());       
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
