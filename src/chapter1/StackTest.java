package chapter1;

import java.util.Scanner;
import java.util.Stack;

public class StackTest {
	
	public static void  main(String[] args) {
		Stack<Integer> integers=new Stack<Integer>();
		int N=50;
		while(N>0){
			integers.push(N%2);
			N=N/2;
		}
		for(int d:integers)System.out.println(d);
		Stack<String> stack=new Stack<String>();
		Scanner in =new Scanner(System.in);
		String s=in.nextLine();
//		while(true){
//			if(s.equals("q")){
//				break;
//			}
//			stack.push(s);
//			s=in.nextLine();
//		}
//		
//		while (!stack.isEmpty()) {
//			String type = (String) stack.pop();
//			System.out.println(type.toString());
//		}
//		System.out.println(stack.size());
//		
//		s=in.nextLine();
		String[] ss=s.split("");
		stack.push(ss[0]);
		for(int i=1;i<ss.length;i++){
			System.out.println(ss[i]);
			if(stack.size()==0) stack.push(ss[i]);
			else{
			if(stack.peek().equals("[")&&ss[i].equals("]")){
				stack.pop();
			} else if(stack.peek().equals("(")&&ss[i].equals(")")){
				stack.pop();
			}else if(stack.peek().equals("{")&&ss[i].equals("}")){
				stack.pop();
			}
			else {
				stack.push(ss[i]);
			}
			}
		}
		if(stack.size()==0){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
	}
}
