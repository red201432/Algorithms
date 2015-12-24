import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item> {
	private  int  N=0;//记录元素个数
	private Item[] a=(Item[])new Object[1];//栈元素
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	public  void resize(int max) {
		Item[] temp=(Item[]) new Object[max];
		for(int j=0;j<N;j++)
			temp[j]=a[j];
		
		a=temp;
	}
	
	public void push(Item item) {
		if(N==a.length) resize(a.length*2);
		a[N++]=item;
	}
	
	public Item pop() {
		Item item=a[--N];
		a[N]=null;
		if(N>0&&N==a.length/4) resize(a.length/2);
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	private  class ReverseArrayIterator implements Iterator<Item> {
		public  int i=N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}
		
	}
	
}
