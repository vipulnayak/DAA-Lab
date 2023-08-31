package sample;
import java.util.Scanner;

public class Knapsack_d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v[][]=new int[20][20];
		Knapsack_d ks=new Knapsack_d();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of items");
		int n=sc.nextInt();
		int[] p = new int[20];
		int[] w = new int[20];
		System.out.println("enter the weights of items");
		for(int i=0;i<n;i++) {
			w[i]=sc.nextInt();
		}
		System.out.println("enter the profits of items");
		for(int i=0;i<n;i++) {
			p[i]=sc.nextInt();
		}
		System.out.println("enter the knapsack capacity");
		int m=sc.nextInt();
		System.out.println("item /weight/ profit ");
		for(int i=1;i<=n;i++) {
			System.out.println(i+'\t'+w[i]+'\t'+p[i]);
		}
		ks.k(m,n,w,p,v);
		System.out.println("Contents of Knapsack are");
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				System.out.println(v[i][j]+"");
			}
			System.out.println();
			
		}
		
	}

}
