import java.util.Arrays;
import java.util.concurrent.Exchanger;

public class VisibleSort {
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w)<0;
	}
	public  static void exch(Comparable[] a, int i,int j) {
		Comparable t=a[i];a[i]=a[j];a[j]=t;
	}
	public  static void InsertionSort(Comparable[] a) {
		int N=a.length;
		 for (int m = 0; m < a.length; m++) {
	            StdDraw.rectangle(5+m*3,(int)a[m]/10,0.3, (int)a[m]/10);
		       }
		for(int i=1;i<N;i++){
			for(int j=i;j > 0 && less(a[j],a[j-1]);j--){
				exch(a, j, j-1);
			}
			StdDraw.setPenColor(StdDraw.BLUE);
		       for (int m = 0; m < a.length; m++) {
	            StdDraw.rectangle(5+m*3,i*20+(int)a[m]/10,0.3, (int)a[m]/10);
		       }
		}
//		for (int m = 0; m < a.length; m++) {
//            StdDraw.rectangle(5+m,10*(N-1),0.3, (int)a[m]/10);
//	       }
	}
	
	public static void main(String[] args) {
			StdDraw.setCanvasSize(600, 600);
	        StdDraw.setXscale(0, 150);
	        StdDraw.setYscale(0, 150);
	        StdDraw.setPenRadius(.005);
	        Comparable[] a={10,23,36,67,92,44,76};
//	        Point2D[] points = new Point2D[3];
//	        for (int i = 0; i < a.length; i++) {
//	            StdDraw.rectangle(5+i,0,0.3, 3+i);
//	        }
	        InsertionSort(a);
	}
}
