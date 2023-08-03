import java.util.*;

public class MSort {
	
	public static void merge(int a[],int low,int mid,int high) {
		int i=low,j=mid+1,k = low;
		int n1 = mid-low+1,n2 = high-mid;
		int[] leftArray = new int[n1]; 
		int[] rightArray = new int[n2]; 
		
		for(int p=0; p<n1;p++) {
			leftArray[p] = a[i];
			i++;
		}
		for(int p=0; p<n2;p++) {
			rightArray[p] = a[j];
			j++;
		}
		i=0;
		j=0;
		
		while(i<n1 && j<n2) {
			if(leftArray[i]<rightArray[j]) {
				a[k]=leftArray[i];
				i++;;k++;
			} else if(leftArray[i]>rightArray[j]) {
				a[k]=rightArray[j];
				j++;;k++;
			}
		}
		while(i<n1) {
			a[k]=leftArray[i];
			k++;i++;
		}
		while(j<n2) {
			a[k]=rightArray[j];
			j++;;k++;
		}
	}
	
	public static void mergeSort(int a[],int low,int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int size = sc.nextInt();
		
		int[] a = new int[size];
		for(int i = 0; i<size; i++) {
			a[i]=sc.nextInt();
		}
		
		mergeSort(a,0,size-1);
		
//		print the sorted array
		System.out.println("The sorted array is : ");
		for(int i = 0; i<size; i++) {
			System.out.println(a[i]);
		}
	}
	
}
