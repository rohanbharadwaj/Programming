package arrays;

// Time O(N) space O(1)
public class MaxSubArraySum {
//Kadane Algorithm
	private static int maxSubArraySum(int[] array) {
		// TODO Auto-generated method stub
		int curSum = array[0];
		int maxSum = array[0];
		for(int i=1;i<array.length;i++)
		{
			curSum = array[i]>(array[i]+curSum)?array[i]:array[i]+curSum;
			maxSum = curSum>maxSum?curSum:maxSum;
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int array[] = {-1,1,2,-3,3,-1,2,-2};
		int sum = maxSubArraySum(array);
		System.out.println("Max sum : "+sum);
	}
	
}
