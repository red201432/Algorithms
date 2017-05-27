package chapter21;

import java.util.Scanner;

public class MaxPQ<Key extends Comparable<Key>>{
	private  Key[] pq;
	private int N=0;
	
	public MaxPQ(int maxN) {
		// TODO Auto-generated constructor stub
		pq=(Key[])new Comparable[maxN+1];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int  size() {
		return N;
	}
	
	public  void insert(Key v) {
		pq[++N]=v; 
		swim(N);
	}
	
	public Key delMax() {
		Key max=pq[1];
		exch(1, N--);
		pq[N+1]=null;
		sink(1);
		return max;
	}
	
	private void exch(int i,int j) {
		Key t=pq[i];
		pq[i]=pq[j];
		pq[j]=t;
	}
	
	private boolean less(int i,int j) {
		return pq[i].compareTo(pq[j])<0;
	}
	
	private void swim(int k){//如果节点K大于 它的父节点则交换
		while(k>1 && less(k/2, k)){
			exch(k/2, k);
			k=k/2;
		}
	}
	/*
	 * 
	 */
	private void sink(int k) {
		while(2*k<=N){
			int j=2*k;
			if(j<N && less(j, j+1)) j++;
			if(!less(k,j)) break;
			exch(k, j);
			k=j;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("hello world!!");
		MaxPQ<String> maxPQ=new MaxPQ<String>(10);
		Scanner in =new Scanner(System.in);
		String s=in.nextLine();
		while (!s.equals("Q")) {
			maxPQ.insert(s);
			
		}
	}
	
}