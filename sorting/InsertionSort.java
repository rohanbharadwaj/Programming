package sorting;

/*More efficient than Bubble and Selection.
 * Left and Right parts 
 * Select from left and insert the card in correct place in right.
 * At any point of time left - unsorted and right - sorted.
 * initially sorted is empty.
 * 
 * initially A[0] is in sorted part. Store A[1] in a temp place
 * and move all elements greater than A[1] shift to right. When
 * all shifting is done then put the temp value at that position.
 * 
 * Inplace
 * 
 * When already sorted -> Best case -> O(n)
 * Worst case ->  Reerse sorted input --> O(n^2)
 * Average case -->O(n^2)
 * 
 * Number of comparisions and shifts is less than selection 
 * and bubble sort.
 * 
 */
public class InsertionSort extends Sort{
	@Override
	public void sort(int[] a) {
		int n = a.length;
		// Take element 1 to n-1 index and place in correct position
		for(int i=1;i<=n-1;i++)
		{
			int value = a[i]; // Store in temp place.
			int hole = i;
			while(hole>0 && a[hole-1]>value){
				a[hole]=a[hole-1];
				hole--;
			}
			a[hole]=value;
		}
		
	}

}
