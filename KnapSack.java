package sample;
import java.util.*;

public class KnapSack {
	
	public static void sort(int n,double[] r,int[] p,int[] w) {
		double temp_r;
		int temp_p;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(r[i]<r[j]) {
//					swap r
					temp_r=r[j];
					r[j]=r[i];
					r[i]=temp_r;
					
//					swap p
					temp_p=p[j];
					p[j]=p[i];
					p[i]=temp_p;
					
//					swap w
					temp_p=w[j];
					w[j]=w[i];
					w[i]=temp_p;
				}
			}
		}
	}
	
	public static void k(int n,int[] w,int[] p,int m) {
		 double x[] = new double[n];
		 double profit= 0;
		 int i=0;
		 
		 for(i=0;i<n;i++) {
			 x[i]=0;
			 if(w[i]>m) break;
			 x[i]=1;
			 profit=profit+ p[i];
			 m=m-w[i];
		 }
		 if(i<n) {
			 x[i]=(float)m/w[i];
			 profit = profit + (x[i]*p[i]);
		 }
		 System.out.println("\nSelected items are");
		 for(i=0;i<n;i++) {
			 System.out.println(x[i]);
		 }
		 System.out.println("profit "+profit);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=7;
		int m=15;
		int p[] = {10,5,15,7,6,18,3};
		int w[] = {2,3,5,7,1,4,1};
		System.out.println("Number of elements");
//		int n = sc.nextInt();
		System.out.println("Max value");
//		int m = sc.nextInt();
//		int p[] = new int[n];
//		int w[] = new int[n];
		double r[] = new double[n];
		
		for(int i = 0;i<n;i++) {
//			p[i]=sc.nextInt();
//			w[i]=sc.nextInt();
			r[i]=(double)p[i]/(double)w[i];
		}
		
//		sorting r array
		sort(n,r,p,w);
		
//		displaying the value
		System.out.println("The profits are");
		for(int i = 0;i<n;i++) {
			System.out.println(p[i]);
		}
		System.out.println("the weights are");
		for(int i = 0;i<n;i++) {
			System.out.println(w[i]);
		}
		System.out.println("the ratio are");
		for(int i = 0;i<n;i++) {
			System.out.println(r[i]);
		}
		
		
//		call k function
		k(n,w,p,m);
		
		

		sc.close();
	}

}
