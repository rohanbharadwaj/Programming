package dynamicprogramming;

/*
 * http://stackoverflow.com/questions/24755059/leetcode-unique-binary-search-trees-calculation
 */
public class UniqueBST {

	public static int getUnique(int n) { // Bottom up solution :- Dynamic
											// Programming
		int[] table = new int[n + 1];
		table[0] = 1; // Base condition tree with no nodes 1=null
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < i; j++)
				table[i] += table[j] * table[i - j - 1];
		return table[n]; //the index n has the number of unique trees for n elements.
	}

	public static void main(String[] args) {
		System.out.println(getUnique(3));

	}
}
