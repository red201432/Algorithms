package lintcode;

public class LongestCommonSubStr {
	public static void main(String[] args) {
		String A="www.lintcode.com code";
		String B="www.ninechapter.com code";
		int max=0;
		System.out.println(longestCommonSubstring(A, B,0,0,max));
	}
	public static int longestCommonSubstring(String A, String B,int s,int e,int max) {
		if(A.length() == 0 || B.length() == 0) return 0;
		if(s==A.length()-1 && e== B.length()-1) return max;
		int count=0;
		int NA=s;
		int NB=e;
		while(NA<A.length()-1&&NB<B.length()-1){
			if(A.charAt(NA)==B.charAt(NB)){
				NA++;
				NB++;
				//System.out.println(NA+"---->"+NB);
				count++;
				if(max<count) max=count;
				System.out.println(max);
				if(NB==B.length()-1) longestCommonSubstring(A, B, s++, 0, max);
				continue;
			}else {				
				longestCommonSubstring(A, B, s, e++, max);				
			}
		}
        return -1;
	}
	
	public static void  match() {
		
	}
	
}
