package dynamicprogramming;

// Time Complexity O(n^2)
public class LIS {

	private void printLIS(int[] array) {
		int len = array.length;
		String[] paths = new String[len];
		int[] sizes = new int[len];
		for(int i=0;i<array.length;i++)
		{
			paths[i]=array[i]+" ";
			sizes[i]=1;
		}
		int maxLen = 1;
		for(int i=1;i<len;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(array[i]>array[j]&&sizes[i]<sizes[j]+1)
				{
					sizes[i]=sizes[j]+1;
					paths[i]=paths[j]+array[i]+" ";
					
					if(maxLen<sizes[i])
						maxLen = sizes[i];
					
				}
			}
		}
		for(int i=0;i<array.length;i++)
		{
			if(sizes[i]==maxLen){
				System.out.println("LIS "+paths[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,6,4,5,1,3};
		LIS o = new LIS();
		o.printLIS(array);
	}
	
}
