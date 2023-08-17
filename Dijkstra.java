package sample;
import java.util.*;
import java.io.*;

public class Dijkstra {
	int[] p= new int[10];
	int[] d= new int[10];
	int[] visited= new int[10];
	
	public void dijk(int[][] a,int s,int n) {
		int u=-1,v,i,j,min;
		for(v=0;v<n;v++) {
			d[v]=99;
			p[v]=-1;
		}
		d[s]=0;
		for(i=0;i<n;i++) {
			min=99;
			for(j=0;j<n;j++){
				if(visited[j]==0 && d[j]<min) {
					min=d[j];
					u=j;
				}
			}
			visited[u]=1;
			for(v=0;v<n;v++) {
				if(visited[v]==0 && (d[u]+a[u][v]<d[v])) {
					d[v]=d[u]+a[u][v];
					p[v]=u;
				}
			}
		}
	}
	
	void path(int v,int s) {
		if(p[v]!=-1) {
			path(p[v],s);
		}
		if(v!=s) {
			System.out.print("->"+v+" ");
		}
	}
	
	void display(int s,int n) {
		int i;
		for(i=0;i<n;i++) {
			if(i!=s) {
				System.out.println(s+" ");
				path(i,s);
				System.out.println("="+d[i]+" ");
				System.out.println();
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[][] = new int[10][10];
		int i,j,n,s;
		System.out.println("Enter the number of vertices");
		n=sc.nextInt();
		System.out.println("Weighted matrix");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		System.out.println("Enter the start vertex");
		s=sc.nextInt();
		Dijkstra tr = new Dijkstra();
		tr.dijk(a,s,n);
		System.out.println("The shortest path between source "+s+" to remaining vertices are ");
		tr.display(s, n);
		
		
		sc.close();

	}

}