package lintcode;

public class LongestCommonPrefix {
	public static void main(String[] args){
		String[] strs={"abc","abcd","","ab","ac"};
		System.out.println(longestCommonPrefix(strs));
	}
	public static String longestCommonPrefix(String[] strs) {
		String commonStr="";
		if(strs.length == 0 || hasEmptyStr(strs)) return "";
		if(strs.length==1) return strs[0];
			int count=0;
			while(true){			
				if (isAllMatch(strs, strs[0], count)) {
					commonStr+=strs[0].charAt(count);
					count++;
					if(count == minLength(strs)) return commonStr;
				}else {
					return commonStr;
				}
			}
	}
	
	public  static boolean isAllMatch(String[] strs,String s,int index) {
		for (String string : strs) {
			if(string.charAt(index) != s.charAt(index)){
				return false;
			}
		}
		return true;
	}
	
	public  static int minLength(String[] strs) {
		if(strs.length == 0) return 0;
		int minLength=strs[0].length();
		for (String string : strs) {
			if(string.length()<minLength){
				minLength=string.length();
			}
		}
		return minLength;
	}
	
	public  static boolean hasEmptyStr(String[] strs) {
		for (String string : strs) {
			if(string.length() == 0)
				return true;
		}
		return false;
	}
}
