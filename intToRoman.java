package testLeet;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 *
 */
public class intToRoman {
	public static void main(String[] args) {
		intToRoman ir = new intToRoman();
		System.out.println(ir.intToRoman1(3879));
		System.out.println(ir.intToRoman2(3879));
		System.out.println(ir.intToRoman3(3879));
	}
	public String intToRoman1(int num) {
		String result = "";
		while(num > 0) {
			if(num>=1000) {
				num-=1000;
				result+="M";
			}else if(num>=900) {
				num-=900;
				result+="CM";
			}else if(num>=500) {
				num-=500;
				result+="D";
			}else if(num>=400) {
				num-=400;
				result+="CD";
			}else if(num>=100) {
				num-=100;
				result+="C";
			}else if(num>=90) {
				num-=90;
				result+="XC";
			}else if(num>=50) {
				num-=50;
				result+="L";
			}else if(num>=40) {
				num-=40;
				result+="XL";
			}else if(num>=10) {
				num-=10;
				result+="X";
			}else if(num>=9) {
				num-=9;
				result+="IX";
			}else if(num>=5) {
				num-=5;
				result+="V";
			}else if(num>=4) {
				num-=4;
				result+="IV";
			}else if(num>=1) {
				num-=1;
				result+="I";
			}
		}
		return result;
	}
	public String intToRoman2(int num) {
		String result = "";
		int n = 0;
		while(num > 0) {
			if(num>=1000) {
				n = num/1000;
				num-=n*1000;
				for(int j = n;n>0;n--) {
					result+="M";
				}
			}else if(num>=900) {
				num-=900;
				result+="CM";
			}else if(num>=500) {
				num-=500;
				result+="D";
			}else if(num>=400) {
				num-=400;
				result+="CD";
			}else if(num>=100) {
				n = num/100;
				num-=n*100;
				for(int j = n;n>0;n--) {
					result+="C";
				}
			}else if(num>=90) {
				num-=90;
				result+="XC";
			}else if(num>=50) {
				num-=50;
				result+="L";
			}else if(num>=40) {
				num-=40;
				result+="XL";
			}else if(num>=10) {
				n = num/10;
				num-=n*10;
				for(int j = n;n>0;n--) {
					result+="X";
				}
			}else if(num>=9) {
				num-=9;
				result+="IX";
			}else if(num>=5) {
				num-=5;
				result+="V";
			}else if(num>=4) {
				num-=4;
				result+="IV";
			}else if(num>=1) {
				for(int j = num;num>0;num--) {
					result+="I";
				}
			}
		}
		return result;
	}
	int[] nIntArray= new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	String[] nStrArray = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	int i = 0;
	public String intToRoman3(int num) {
		StringBuffer sb = new StringBuffer();
//		String result = "";
		int n = 0;
		while (num > 0) {
			n = num / nIntArray[i];
//			if (n > 0) {
				num -= n * nIntArray[i];
				while (n > 0) {
//					result += nStrArray[i];
					sb.append(nStrArray[i]);
					n--;
				}
//			}
			i++;
		}
//		return result;
		return sb.toString();
	}
}
