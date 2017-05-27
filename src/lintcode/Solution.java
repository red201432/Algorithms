package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Solution {
	public static void main(String[] args) {
		int[]  numbers = {2, 7, 11, 15};
		int[] s={-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5};
		int ss=77;
		int target=9;
		int[] s30={-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5};
		System.out.println(threeSum(s));
	}
	
    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	
    	for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				for(int m=j+1;m<numbers.length;m++){
					if((numbers[i]+numbers[j]+numbers[m])==0){
						ArrayList<Integer> list=new ArrayList<Integer>();
						list.add(numbers[i]);
						list.add(numbers[j]);
						list.add(numbers[m]);
						Collections.sort(list);
						if(!CheckListIn(result, list)){
							result.add(list);
							for(int n=0;n<result.size()-1;n++){
					    		ArrayList<Integer> listI=result.get(n);
					    		ArrayList<Integer> list2=result.get(n+1);
					    		ArrayList<Integer> temp=new ArrayList<Integer>();
					    		if(listI.get(0)==list2.get(0)){
					    			if(listI.get(1)>list2.get(1)){
					    				temp=listI;
					    				result.set(n, list2);
					    				result.set(n+1, temp);
					    			}
					    			if(listI.get(1)==list2.get(1)){
					    				if(listI.get(2)>list2.get(2)){
					    					temp=listI;
					        				result.set(n, list2);
					        				result.set(n+1, temp);
					    				}
					    			}
					    		}
					    	}
						}
					}		
				}
			}
		}
    	Collections.sort(result,new Comparator<ArrayList<Integer>>() {
    		public int compare(ArrayList<Integer> o1,ArrayList<Integer> o2){
    			return o1.get(0).compareTo(o2.get(0));
    		}
		});
//    	for(int i=0;i<result.size()-1;i++){
//    		ArrayList<Integer> listI=result.get(i);
//    		ArrayList<Integer> list2=result.get(i+1);
//    		ArrayList<Integer> temp=new ArrayList<Integer>();
//    		if(listI.get(0)==list2.get(0)){
//    			if(listI.get(1)>list2.get(1)){
//    				temp=listI;
//    				result.set(i, list2);
//    				result.set(i+1, temp);
//    			}
//    			if(listI.get(1)==list2.get(1)){
//    				if(listI.get(2)>list2.get(2)){
//    					temp=listI;
//        				result.set(i+1, list2);
//        				result.set(i, temp);
//    				}
//    			}
//    		}
//    	}
    	
    	return result;
    }
    
    public  static <T> boolean CheckListIn(ArrayList<ArrayList<T>> arrayList,ArrayList<T> list) {
    	for (ArrayList<T> t :  arrayList) {
			if(t.containsAll(list))return true;
		}
    	return false;
	}
    
    
	
	public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result={0,0};
        	for(int i=0;i<numbers.length;i++){
        		for(int j=i+1;j<numbers.length;j++){
        			if(numbers[i]+numbers[j]==target){
        				result[0]=i+1;
        				result[1]=j+1;
        				return result;
        			}
        		}
        	}
        return null;
    }
	public static int threeSumClosest(int[] numbers, int target) {
	        // write your code here
	       int[] tag = { -1, -1, -1 };
	       int sum = 0;
	       // 如果给出的数组只有三个元素则返回此数组元素之和
			if(numbers.length<=3){
				for(int i=0;i<numbers.length;i++)
				sum+=numbers[i];
				return sum;
			}
			
		    int temp=0;
			int count = 0;
			int k=0;
			int result=0;
			// 设定合理的初始值
			int min=numbers[0]+numbers[1]+numbers[2];
			for(int i=0;i<numbers.length;i++){
				for(int j=i+1;j<numbers.length;j++){
					for(int m=j+1;m<numbers.length;m++){
						temp=numbers[i]+numbers[j]+numbers[m];
						if(Math.abs(temp-target)<Math.abs(min-target)){
							min=temp;
						}
					}
				}
			}
			return min;
//			while (count < 3) {
//				min=Math.abs(numbers[k]-target);
//				result=k;
//				for(int i=0;i<numbers.length;i++){
//					if(k==i) continue;
//					if(isIn(tag, i)) continue;
//					temp=Math.abs(numbers[i]-target);
//					if(min>temp){
//						result=i;
//						min=temp;
//					}							
//				}
//				if(result==k) k++;
//				tag[count]=result;
//				//System.out.println(tag[count]+"---");
//				count++;
//			}
//			
			
//			for (int j = 0; j < count; j++) {
//				sum += numbers[tag[j]];
//			}
//			return sum;
	    }
	    
	public static boolean isIn(int[] array,int num){
			for(int i=0;i<array.length;i++){
				if(num==array[i]) return true;
			}
			return false;
		}
}
