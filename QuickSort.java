package sample;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	
	public static int partition(int a[],int low,int high) {
		int p,i,j,temp;
		p=a[low];
		i=low;
		j=high;
		while(i<j) {
			while(a[i]<=p && i<high)
				i++;
			while(a[j]>p)
				j--;
			if(i<j) {
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
			temp=p;
			p=a[j];
			a[j]=temp;
			return j;
	}
	
	public static void quickSort(int a[],int low,int high) {
		if(low<high) {
			int s =partition(a,low,high);
			quickSort(a,low,s-1);
			quickSort(a,s+1,high);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		Random r = new Random();
		int size = sc.nextInt();
		int a[] = new int[size];
		int count=0;
		
//		declare an array
		for(int i=0; i<size; i++) {
			a[i]= r.nextInt(100);
			count++;
			System.out.print(a[i]+","+count+" ");
		}
		
		long start = System.currentTimeMillis();
		
//		logic
		quickSort(a,0,size-1);
		
		long totTime = System.currentTimeMillis()-start;
		
		System.out.println("\nThe time taken is: "+ totTime);
		
//		Sorted array
		System.out.println("\nThe sorted array is : ");
		for(int i=0; i<size; i++) {
			System.out.print(a[i]+" ");
		}
		sc.close();
	}

}
