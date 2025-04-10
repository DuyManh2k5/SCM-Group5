package hoan_vi;
import java.util.*;

public class hoanvisonguyen {
	static boolean next(int a[]) {
		int i = a.length-2;
		while(i>=0 && a[i]>=a[i+1]) i--;
		if(i<0) return false;
		int j = a.length-1;
		while(a[j]<=a[i]) j--;
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
		for(i++ , j=a.length-1 ; i<j ; i++ , j--) {
			t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner o = new Scanner(System.in);
		System.out.println("Nhap so nguyen duong n vao : ");
		int n = o.nextInt();
		if(n<0) System.out.println("Vui long nhap so duong!");
		else {
			int [] a = new int[n];
			for(int i=0;i<n;i++) a[i] = i+1;
			do {
				for(int x : a) System.out.print(x + " ");
				System.out.println();
			}while(next(a));
		}
	}
}
