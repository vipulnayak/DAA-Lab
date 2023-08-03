package sample;

import java.util.Scanner;

class ObjSort{
	int k,temp;
	void selection_sort(int arr1[]) {
//		Selection sort logic
		for(int i=0;i<arr1.length-1;i++) {
			k=i;
			for(int j=i+1;j<arr1.length;j++) {
				if(arr1[k]>arr1[j]) {
					k=j;
				}
			}
			temp=arr1[k];
			arr1[k]=arr1[i];
			arr1[i]=temp;
		}
	}
}

class StaticSort{
	static int k,temp;
	public static void selection_sort(int arr1[]) {
//		Selection sort logic
		for(int i=0;i<arr1.length-1;i++) {
			k=i;
			for(int j=i+1;j<arr1.length;j++) {
				if(arr1[k]>arr1[j]) {
					k=j;
				}
			}
			temp=arr1[k];
			arr1[k]=arr1[i];
			arr1[i]=temp;
		}
		
//		print the sorted array
		for(var arrItem: arr1) {
			System.out.println(arrItem);
		}
	}
}

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		
		int[] arr1 = new int[5];
		
//		initializing an array
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=sc.nextInt();
		}
		
//		static method
//		StaticSort.selection_sort(arr1);
		
//		object method
		long start = System.nanoTime();
		ObjSort obj1 = new ObjSort();
		obj1.selection_sort(arr1);
		long timeTaken = System.nanoTime()- start;
		
//		print the sorted array
		for(var arrItem: arr1) {
			System.out.println(arrItem);
		}
		
		
		System.out.println("Time Taken : "+timeTaken+" ns");

	}

}
