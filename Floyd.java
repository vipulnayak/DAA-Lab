package sample;
import java.util.Scanner;

public class Floyd {
	int min (int i,int j) {
		if(i<j)
			return i;
		else
			return j;
	}
	
	void result(int [][]w,int n ) {
		int i,j,k;
		for(k=1;k<=n;k++)
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					w[i][j]=min(w[i][j], w[i][k]+w[k][j]);
		System.out.println("the shortest path will be");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.println(w[i][j]+ "");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		int a[][]=new int[10][10];
		System.out.println("Enter the number of vertices");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("enter the wighted graph");
		for ( i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		Floyd f= new Floyd();
		f.result(a,n);
	}
}
