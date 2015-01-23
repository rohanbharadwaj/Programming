package sorting;

public class KthLargest {

	private static int findKthLargest(int[] nums, int k) {
		if(k<1||k>nums.length)
		return -1;
		
		return findKthLargest(nums, 0,nums.length-1,k);
	}
	private static int findKthLargest(int[] a, int lo,int hi,int k){
		int pivot = a[hi]; // Right most is selected as pivot can be anything.
		int partitionIndex = lo; // This is the partition index.
		for (int i = lo; i <= hi - 1; i++) {
			if (a[i] <= pivot) { // Push all elements lesser than pivot to left of partitionIndex
				swap(a, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(a, partitionIndex, hi);
		if(partitionIndex+1==k)
			return a[partitionIndex];
		else if(k>partitionIndex+1)
			return findKthLargest(a, partitionIndex+1,hi,k);
		else
			return findKthLargest(a, lo,partitionIndex-1,k);
	}
	private static void swap(int a[], int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static void main(String[] args)
	{
		int[] nums = new int[20];
		java.util.Random myRandom = new java.util.Random();
		System.out.print("Numbers: ");
		for(int i=0; i<nums.length;i++)
		{
			nums[i] = myRandom.nextInt(100);//each number is random from 0-99
			System.out.print(nums[i]+",");
		}
		System.out.println();
		System.out.println("10th largest value is "+findKthLargest(nums, 10));
		System.out.print("After finding: ");
		for(int i=0; i<nums.length;i++)
		{
			System.out.print(nums[i]+",");
		}
		System.out.println();
		//notice the whole array is not sorted after we identified kth largest value!
	}
}
