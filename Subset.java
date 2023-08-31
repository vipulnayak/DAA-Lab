package sample;
import java.util.Scanner;

public class Subset {
	static int sol=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[]= new int[10];
		int n,d,i,sum=0;
		int x[]=new int[10];
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of elements");
		n=sc.nextInt();
		System.out.println("Enter the elements in increaing order");
		for(i=0;i<n;i++)
			set[i]=sc.nextInt()	;
		System.out.println("enter the value of d:");
		d=sc.nextInt();
		for(i=0;i<n;i++)
			sum=sum+set[i];
		System.out.println("sum"+sum);
		if(sum<d|| set[0]>d)
		{
			System.out.println("subset is not possible");
			System.exit(0);
		}
		subset(0,0,sum,x,set,d);
		if(sol==0)
			System.out.println("subset is not possible");
	}
	public static void subset(int cs,int k ,int r ,int x[],int set[], int d) {
		x[k]=1;
		if(cs+ set[k]==d) {
			sol++;
			System.out.println("\n subset "+sol+"is {");
			for(int i=0;i<=k;i++)
				if(x[i]==1) {
					System.out.println(set[i]+"");
				}
		}
		else if((cs +set[k]+set[k-1])<=d) 
			subset(cs+set[k],k+1,r-set[k],x,set,d);
		if((cs+r-set[k])>=d && (cs + set[k+1])<=d)
		{
			x[k]=0;
			subset(cs,k+1,r-set[k+1],x,set,d);
		}
		
	}

}
