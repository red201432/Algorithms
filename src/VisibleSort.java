import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Exchanger;

import com.sun.javafx.collections.SortableList;

public class VisibleSort {
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w)<0;
	}
	public  static void exch(Comparable[] a, int i,int j) {
		Comparable t=a[i];a[i]=a[j];a[j]=t;
	}
	
	public static void  QuickSort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	public static void  sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	public static int  partition(Comparable[] a,int lo,int hi) {
		int i=lo,j=hi+1;
		Comparable v=a[lo];
		while(true){
			while(less(a[++i], v)){
				if (i==hi) break;
			}
			while(less(v, a[--j])){
				if(j==lo) break;
			}
			if(i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		StdDraw.setPenColor(StdDraw.BLUE);
	    for (int m = 0; m < a.length; m++) {
            StdDraw.rectangle(180+m*3,i*20+(int)a[m]/20,0.3, (int)a[m]/20);
	       }
		return j;
	}
	
	public static void SelectionSort(Comparable[] a) {
		for(int i=0;i<a.length;i++){
			StdDraw.setPenColor(StdDraw.RED);
		    for (int m = 0; m < a.length; m++) {
	            StdDraw.rectangle(80+m*3,i*20+(int)a[m]/20,0.3, (int)a[m]/20);
		       }
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(less(a[j], a[min])) min=j;
			}
			exch(a, i, min);
			
		}
	}
	public  static void InsertionSort(Comparable[] a) {
		int N=a.length;
		 for (int m = 0; m < a.length; m++) {
	            StdDraw.rectangle(5+m*3,5+(int)a[m]/20,0.3, (int)a[m]/20);
		       }
		for(int i=1;i<N;i++){
			for(int j=i;j > 0 && less(a[j],a[j-1]);j--){
				exch(a, j, j-1);
			}
			StdDraw.setPenColor(StdDraw.BLUE);
		    for (int m = 0; m < a.length; m++) {
	            StdDraw.rectangle(5+m*3,i*20+(int)a[m]/20,0.3, (int)a[m]/20);
		       }
		}
//		for (int m = 0; m < a.length; m++) {
//            StdDraw.rectangle(5+m,10*(N-1),0.3, (int)a[m]/10);
//	       }
	}
	
	public static void main(String[] args) {
			StdDraw.setCanvasSize(600, 600);
			StdDraw.setXscale(0, 400);	        
	        StdDraw.setYscale(0, 400);
	        StdDraw.setPenRadius(.005);
	        
	        Comparable[] a={10,23,36,67,140,150,92,33,120,130,44,76,55,87,110,120,130,140,150};
//	        Point2D[] points = new Point2D[3];
//	        for (int i = 0; i < a.length; i++) {
//	            StdDraw.rectangle(5+i,0,0.3, 3+i);
//	        }
	       // QuickSort(a);
	        StdRandom.shuffle(a);
	        InsertionSort(a);
	        SelectionSort(a);
	        QuickSort(a);
	}
}
