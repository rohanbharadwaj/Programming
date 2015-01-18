package sorting;

/*
 * Time complexity
 * 	Avg - O(nlogn)
 * 	Worst - O(n^2)
 * Recursive 
 * Divide and Conquer
 * In-place
 */
public class QuickSort extends Sort {
	@Override
	public void sort(int[] a) {

		sort(a, 0, a.length - 1);
	}

	private static void swap(int a[], int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	private static void sort(int[] a, int lo, int hi) {
		//sort(array,start_index,end_index)
		int p;
		if (lo < hi) {
			p = partition(a, lo, hi);
			sort(a, lo, p - 1);
			sort(a, p + 1, hi);
		}
	}

	// Logic to pick the pivot and rearranged.
	// Such that all elements before pivot are less than
	// pivot and all elements after pivot are greater than
	// pivot.
	private static int partition(int[] a, int lo, int hi) {
		int pivot = a[hi]; // Right most is selected as pivot can be anything.
		int partitionIndex = lo; // This is the partition index.
		for (int i = lo; i <= hi - 1; i++) {
			if (a[i] <= pivot) { // Push all elements lesser than pivot to left of partitionIndex
				swap(a, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(a, partitionIndex, hi);
		return partitionIndex; //Return partition index
	}

}
