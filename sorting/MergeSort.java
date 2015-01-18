package sorting;

/*
 * O(nlogn) in Worst Case!!!
 * Ideas :
 *  Divide And Conquer
 *  Recursive
 *  Stable Sort (Reletive order is same as original list)
 *  Not In-place (New arrays are created)
 *  	Space complexity is O(n)
 * 
 * 
 */
public class MergeSort extends Sort {
	@Override
	public void sort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	public static void mergeSort(int a[], int lo, int hi) {
		int mid;
		// Base condition to avoid infinite loop. When array is length 1 stop.
		if(lo<hi)
		{
		mid = (lo + hi) / 2;
		mergeSort(a, lo, mid); // recursive call
		mergeSort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
		}
	}

	public static void merge(int a[], int lo, int mid, int hi) {
		int i, j, k;
		int n1 = mid - lo + 1;
		int n2 = hi - mid;
		int L[] = new int[n1];
		int R[] = new int[n2]; // Extra Space O(n)
		for (i = 0; i < n1; i++)
			L[i] = a[lo + i];
		for (j = 0; j < n2; j++)
			R[j] = a[mid + 1 + j];
		i = j = 0;
		k = lo;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j])
				a[k++] = L[i++];
			else
				a[k++] = R[j++];

		}
		while (i < n1)
			a[k++] = L[i++];
		while (j < n2)
			a[k++] = R[j++];
	}

}
