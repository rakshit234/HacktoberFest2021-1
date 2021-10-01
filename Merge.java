import java.util.*;

public class Merge {
	public static void mergeSort(int arr[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1];
		int M[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = arr[p + i];
		for (int j = 0; j < n2; j++)
			M[j] = arr[q + 1 + j];

		int i, j, k;
		i = 0;
		j = 0;
		k = p;

		while (i < n1 && j < n2) {
			if (L[i] <= M[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = M[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = M[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(int arr[], int l, int r) {

		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			mergeSort(arr, l, m, r);
		}
	}

	public static void main(String[] args) {
		for(int n=100; n<=1_00_000; n*=10) {
			int[] input = new int[n];
			for(int i=0; i<input.length; i++) {
				input[i] = input.length-i;
			}
			
			long startTime = System.currentTimeMillis();
			mergeSort(input, 0, input.length-1);
			long endTime = System.currentTimeMillis();
			System.out.println("Time for "+n+" inputs:"+ (endTime-startTime));
		}
		int n = 3_00_000;
		int[] input = new int[n];
		for(int i=0; i<input.length; i++) {
			input[i] = input.length-i;
		}
		long startTime = System.currentTimeMillis();
		mergeSort(input, 0, input.length-1);
		long endTime = System.currentTimeMillis();
		System.out.println("Time for "+n+" inputs:"+ (endTime-startTime));

	}

}
