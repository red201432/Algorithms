package chapter1;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xpath.internal.operations.And;

import chapter14.StopWatch;

/*
 * 环形队列采用数组实现
 * 设置一个插入指针，一个删除指针
 * 当插入指针=N-1且删除指针=0 或者 插入指针+1=删除指针，此时队列满
 * 否则当插入指针=N-1时，插入指针=0，继续插入
 */
public class RingBuffer<T> {
	private int N=10;//数组长度
	private int insetPoint=0;
	private int deletePoint=0;
	private T[] a=(T[])new Object[N];
	public RingBuffer() {
		// TODO Auto-generated constructor stub
	}
	public  boolean isFull() {
		if(insetPoint==deletePoint&&a[insetPoint]!=null)
			return true;
		return false;
	}
	public boolean isEmpty() {
		if((insetPoint==deletePoint)&&a[insetPoint]==null)
			return true;
		return false;
	}
	
	public void insert(T item) {
		if(!isFull()){
			a[insetPoint]=item;
			insetPoint++;
			if(insetPoint==N)
				insetPoint=0;
		}else {
			System.out.println("Full");
		}
	}
	
	public T delete() {
		if(!isEmpty()){
			T item=a[deletePoint];
			a[deletePoint]=null;
			deletePoint++;
			if((deletePoint==N)&&!isEmpty())
				deletePoint=0;
			return item;
		}else {
			System.out.println("Empty");
		}
		return null;
	}
	
	public void display() {
		for(int i=0;i<N;i++){
			if(a[i]!=null)
				System.out.println(i+"--->"+a[i]);
		}
	}
	public static void  main(String[] args) {
		System.out.println("RingBuffer");
		RingBuffer<Integer> ringBuffer=new RingBuffer<Integer>();
		StopWatch sw=new StopWatch();
		for(int i=0;i<1000000;i++){
		ringBuffer.insert(0);
		ringBuffer.delete();
		ringBuffer.insert(1);
		ringBuffer.delete();
		ringBuffer.insert(2);
		ringBuffer.delete();
		ringBuffer.insert(3);
		ringBuffer.delete();
		ringBuffer.insert(4);
		ringBuffer.delete();
		ringBuffer.insert(5);
		ringBuffer.delete();
		ringBuffer.insert(6);
		ringBuffer.delete();
		ringBuffer.insert(7);
		ringBuffer.delete();
		ringBuffer.insert(8);
		ringBuffer.delete();
		ringBuffer.insert(9);
		ringBuffer.delete();
		
		ringBuffer.display();
		}
		System.out.println(sw.elapsedTime());
	}
}
