package Mmn14;

import java.util.HashSet;
import java.util.Scanner;

public class Matala14 {
	private static final int MAX_NUM = 100;
	
	/* The following methods return the amount of distinct numbers in an array*/
	
	
	// Original Algorithm
	static int comp1 = 0;
	static int ass1 = 0;
	static int copy1 = 0;
	public static int method1(int a[])
	{
		comp1 = 0; ass1 = 0; copy1 = 0;
		int U_size = 1;
		int j; int i;
		for ( i = 1; i < a.length; i++ ) 
		{
			boolean U = true;
			ass1++;
			for ( j = 0; j < U_size; j++ ) 
			{
				comp1++;
				if ( a[j] == a[i] )
				{
					U = false;
					break;
				}
			}
			if (U)
			{
				a[U_size]=a[i];
				U_size = U_size+1; 
				ass1++;
			}
			
		}
		System.out.println("The Original Algorithm performs: ");
		System.out.println("Compares: " + comp1);
		System.out.println("Assignments: " + ass1);
		System.out.println("Copies: " + copy1);
		System.out.print("Total distinct numbers: ");
		return U_size;
	}
	// O(n2^2)
	
	
	// Insertion Sort
	static int comp2 = 0;
	static long ass2 = 0;
	static int copy2 = 0;
	public static int method2(int arr[]) {
		comp2 = 0; ass2 = 0; copy2 = 0;
		insertionSort(arr);
		int count = 1;
		for ( int i = 1; i <arr.length; i++ )
		{
			comp2++;
			if ( arr[i] != arr[i-1] ) count++;
		}
		System.out.println("The 2nd Algorithm performs: ");
		System.out.println("Compares: " + comp2);
		System.out.println("Assignments: " + ass2);
		System.out.println("Copies: " + copy2);
		System.out.print("Total distinct numbers: ");
		return count;
	}
	// O(n^2)
	
	
	
	// Merge-Sort ( optimum comparison-bases sorting method )
	static int comp3 = 0;
	static int ass3 = 0;
	static int copy3 = 0;
	public static int method3(int[] arr) {
		comp3 = 0; ass3 = 0; copy3 = 0;
		mergeSort(arr,0,arr.length);
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			comp3++;
			if(arr[i] != arr[i-1]) count++;
		}
		System.out.println("The 3rd Algorithm performs: ");
		System.out.println("Compares: " + comp3);
		System.out.println("Assignments: " + ass3);
		System.out.println("Copies: " + copy3);
		System.out.print("Total distinct numbers: ");
		return count;
	}
	// O(nlogn)
	
	
	
	// C array in Counting Sort
	static int copy4 = 0;
	public static int method4(int[] arr) {
		copy4 = 0;
		int[] c = new int[MAX_NUM];
		for (int i = 0; i < arr.length; i++) {
			copy4++;
			c[arr[i]-1]++;
		}
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			if(c[i] != 0) count++;
		}
		System.out.println("The 4th Algorithm performs: ");
		System.out.println("Compares: " + 0);
		System.out.println("Assignments: " + 0);
		System.out.println("Copies: " + copy4);
		System.out.print("Total distinct numbers: ");
		return count;
	}
	// O(n)
	
	
	
	// Hash Table ( HashSet )
	static int comp5 = 0;
	static int copy5 = 0;
	public static int method5(int[] arr) {
		comp5 = 0; copy5 = 0;
		HashSet<Integer> h = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			comp5++;
			if(!h.contains(arr[i])) {
				count++;
				copy5++;
				h.add(arr[i]);
			}
		}
		System.out.println("The 5th Algorithm performs: ");
		System.out.println("Compares: " + comp5);
		System.out.println("Assignments: " + 0);
		System.out.println("Copies: " + copy5);
		System.out.print("Total distinct numbers: ");
		return count;
	}
	// Average time O(n)
	
	
	
	// Binary Search Tree
	static int comp6 = 0;
	static int copy6 = 0;
	public static int method6(int[] arr) {
		comp6 = 0; copy6 = 0;
		BST b = new BST();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(!b.contains(arr[i])) {
				count++;
				copy6++;
				b.add(arr[i]);
			}
		}
		System.out.println("The 6th Algorithm performs: ");
		System.out.println("Compares: " + comp6);
		System.out.println("Assignments: " + 0);
		System.out.println("Copies: " + copy6);
		System.out.print("Total distinct numbers: ");
		return count;
	}
	// O(n)
	
	
	
	// RedBlack Tree
	static int comp7 = 0;
	static int copy7 = 0;
	public static int method7(int[] arr) {
		comp7 = 0; copy7 = 0;
		RBT b = new RBT();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(!b.contains(arr[i])) {
				count++;
				copy7++;
				b.add(arr[i]);
			}
		}
		System.out.println("The 7th Algorithm performs: ");
		System.out.println("Compares: " + comp7);
		System.out.println("Assignments: " + 0);
		System.out.println("Copies: " + copy7);
		System.out.print("Total distinct numbers: ");
		return count;
	}
	// O(logn)
	
	
	
	// "Helpers"
	private static void insertionSort(int arr[]) {  
		int n = arr.length;  
		for (int j = 1; j < n; j++) { 
			ass2++;
			int key = arr[j];  
			int i = j-1;
			while ( (i > -1) && ( arr [i] > key ) ) {
				ass2++;
				arr [i+1] = arr [i];  
				i--;  
			}
			ass2++;
			arr[i+1] = key;  
		}  
	}  
	// O(n^2)
	
	private static void mergeSort(int[] arr, int low, int high) {
		if(high-low < 2) return;
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid, high);
		int[] temp = new int[high - low];
		int a = low, b = mid, c = 0;
		while(a < mid && b < high) {
			comp3++; copy3++;
			if(arr[a] < arr[b]) temp[c++] = arr[a++];
			else temp[c++] = arr[b++];
		}
		while(a < mid) {
			copy3++;
			temp[c++] = arr[a++];
		}
		while(b < high) {
			copy3++;
			temp[c++] = arr[b++];
		}
		for (int i = 0; i < temp.length; i++) {
			ass3++;
			arr[i+low] = temp[i];
		}
	}
	// O(nlogn)
	
	// print the array
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}
	
	
	
	// main program
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("N = ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*MAX_NUM + 1);
		}
		System.out.println("The array is: ");
		printArray(arr);
		System.out.println();
		//int[] arr = {7,9,1,2,9,1,10,20,2,2,2,4,12,34,5,6,8,1,1,1,1,1,1,2,3};
		System.out.println("For N = "+n+":");
		System.out.println("---------------------------------");
		System.out.println(method1(arr));
		System.out.println("---------------------------------");
		System.out.println(method2(arr));
		System.out.println("---------------------------------");
		System.out.println(method3(arr));
		System.out.println("---------------------------------");
		System.out.println(method4(arr));
		System.out.println("---------------------------------");
		System.out.println(method5(arr));
		System.out.println("---------------------------------");
		System.out.println(method6(arr));
		System.out.println("---------------------------------");
		System.out.println(method7(arr));
		System.out.println("---------------------------------");
		
		sc.close();
	}
}
