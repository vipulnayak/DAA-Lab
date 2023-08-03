import java.util.Random;
import java.util.Scanner;

public class MinMax {

    public static int a[];
    public static int min=0,max=0;

    public static void minMax(int i, int j) {
        if (i == j) {
            min = max = a[i];
        } 
        else if (i + 1 == j) {
            if (a[i] < a[j]) {
                min = a[i];
                max = a[j];
            } else {
                min = a[j];
                max = a[i];
            }
        } else {
            int mid = (i + j) / 2;
            minMax(i, mid);
            int min1 = min, max1 = max;
            minMax(mid + 1, j);
            if (min1 < min) {
                min = min1;
            } else if (max1 > max) {
                max = max1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int size = sc.nextInt();
        a = new int[size];

        // input array values
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(10);
            System.out.println(a[i]);
        }

        // logic to find min and max value using divide and conquer method
        minMax(0, size-1);

        // print the smallest and largest values
        System.out.println("Min : "+min+", Max : "+max);

        // closing scanner obj
        sc.close();
    }
}
