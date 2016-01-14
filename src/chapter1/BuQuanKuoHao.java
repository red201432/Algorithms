package chapter1;

import java.util.Scanner;
import java.util.Stack;

public class BuQuanKuoHao {
	public  static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		String[] ss=s.split("[/*\\+\\-]");
		for(Object o:ss) System.out.println(o.toString());
		for(int i=0;i<ss.length;i++){
			String temp;
			if(ss[i].equals(")")){
				String val2=stack.pop();
				String op=stack.pop();
				String val1=stack.pop();
				temp="("+val2+op+val1+")";
				stack.push(temp);
			}else {
				stack.push(ss[i]);
			}
		}
		while(!stack.isEmpty()){
		System.out.print(stack.pop());
		}
		in.close();
	}
}
