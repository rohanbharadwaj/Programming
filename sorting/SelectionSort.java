package sorting;
/*
 * Simplest Sorting Algorithm
 * Left part - Right Part
 * Select smallest from left and put it in right.
 * At any point right is unsorted left is sorted.
 * 
 * Solution1
 * Auxilary Array (Not in place{takes constant memory})
 * Take new array and put smallest in it and seected is 
 * replaced by MAX_VALUE so that it is not considered in next pass.
 * 
 * Solution2(Inplace)
 * Find min and swap it with 0th index. Next min from 1st min and
 * swap it with index 1.
 * 
 * Time : O(n^2)
 * 
 */

public class SelectionSort extends Sort{
	private void swap(int[] a,int i,int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j]=temp;
	}
	@Override	
	public void sort(int[] a) {
	int n = a.length;
	for(int i=0;i<=n-2;i++) // Last element is at correct position , we need n-2 passes
	{
		int iMin = i;
		for(int j=i+1;j<=n-1;j++)
		{
			if(a[j]<a[iMin])
				iMin = j; // update index of min element
		}
		swap(a, i, iMin);
		
		
	}

}
}
