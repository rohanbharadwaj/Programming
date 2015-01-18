package sorting;

/*
 *  Inplace and Stable
 *  Worst Case O(n^2).
 */

public class BubbleSort extends Sort{
	@Override
	public void sort(int[] a) {
		int n = a.length;
		for(int k=1;k<=n-1;k++)
		{
		for(int i=0;i<=n-k-1;i++)
		{
			if(a[i]>a[i+1]) swap(a,i,i+1);  
		}
		}
		
	}
	
	private void swap(int[] a,int i,int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j]=temp;
	}

}
