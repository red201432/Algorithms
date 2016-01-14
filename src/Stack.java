import java.util.Iterator;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class Stack<Item> implements Iterable<Item> {
	private class Node{
		Node next;
		Item item;
	}
	
	private Node first;	//栈顶
	private int N;		//元素数量
	
	public boolean isEmpty() {
		return first==null;
	}
	public int size() {
		return N;
	}
	public  void push(Item item) {
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	
	public Item pop() {
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}
	//返回最近添加的元素而不删除
	public  Item peek() {
		Item item=first.item;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current=first;
		public boolean hasNext() {
			return current!=null;
		}
		public  void remove() {
			
		}
		
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item=current.item;
			current=current.next;
			return item;
		}
	}
}
