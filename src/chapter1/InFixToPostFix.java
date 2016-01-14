package chapter1;

import java.util.Scanner;
import java.util.Stack;

import sun.security.provider.certpath.ssl.SSLServerCertStore;

public class InFixToPostFix {
	
	public static boolean isOperator(String s) {
		if(s.equals("*")||s.equals("/")||s.equals("+")||s.equals("-"))
			return true;
		return false;
	}
	
	public static boolean isBigThan(String s,Stack<String> stack) {
		if((s.equals("*")||s.equals("/"))&&(stack.peek().equals("+")||stack.peek().equals("-")))
			return true;
		return false;
	}
	//将前序表达式转化为后序表达式
	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		Scanner in =new Scanner(System.in);
		String s=in.nextLine();
		String[] ss=s.split("");
		for(int i=0;i<ss.length;i++){
			if(!isOperator(ss[i])&&!ss[i].equals("(")&&!ss[i].equals(")")){
				System.out.print(ss[i]);//如果是数字 直接输出
			}else if(ss[i].equals("(")){//如果是（ 压栈
				stack.push(ss[i]);
			}else if(ss[i].equals(")")) {//如果是 ） 则 将 （ 之后的 操作符 出栈
				while(!stack.isEmpty()&&!stack.peek().equals("(")){
					String pop=stack.pop();
					System.out.print(pop);
				}
				stack.pop();
			}
			else {//如果是操作符
				if(stack.isEmpty()){//如果栈为空
					stack.push(ss[i]);
				}else if (stack.peek().equals("(")) {//如果已经有一个（ ，则压栈
					stack.push(ss[i]);
				}else if (!isBigThan(ss[i], stack)) {//如果比栈顶的元素优先级低，则先将栈顶的元素输出，再压栈					System.out.print(stack.pop());
					stack.push(ss[i]);
				}else {
					do{
						stack.push(ss[i]);
						}
					//当栈不为空且栈顶的元素不为 （ 且 将要入栈的运算符优先级大于栈顶元素的优先级
					while(!(stack.isEmpty()||stack.peek().equals(("("))||!isBigThan(ss[i], stack)));
				}
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
}
