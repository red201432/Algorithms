import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private class Node{
		Item item;
		Node next;
	}
	private Node first;
	private Node last;
	private  int N; 
	public boolean isEmpty() {
		return first==null;
	}
	public  int  size() {
		return N;
	}
	public  void enqueue(Item item) {
		Node oldfirst=last;
		last=new Node();
		last.item=item;
		last.next=null;
		oldfirst.next=last;
		if(isEmpty()) first=last;
		else {
			 oldfirst.next=last;
		}
		N++;
	}
	
	public  Item dequeue() {
		Item item=first.item;
		first=first.next;
		if(isEmpty()) last=null;
		N--;
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
