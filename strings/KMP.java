package strings;

/*
 * Time complexity is O(m+n) when compared to the brute force algorithm O(mn)
 * This algorithm takes at most 2n comparisions
 */
public class KMP {

	public static int[] buildTable(char[] pattern) {
		int i = 0, j = -1;
		int plen = pattern.length;
		int[] table = new int[plen + 1];
		table[i] = j;
		while (i < plen) {
			while (j >= 0 && pattern[i] != pattern[j]) {
				j = table[j];
			}
			i++;
			j++;
			table[i] = j;
		}

		return table;
	}

	public static int search(char[] text, char[] pattern) {
		int i = 0, j = 0;
		int plen = pattern.length;
		int tlen = text.length;
		int[] table = buildTable(pattern);
		while (i < tlen) {
			while (j >= 0 && text[i] != pattern[j]) {
				j = table[j];
			}
			i++;
			j++;
			if (j == plen) {
				//System.out.println("Found pattern at :" + (i - plen));
				return i-plen;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int res = search("abksfbvksdvb".toCharArray(),"yhh".toCharArray());
		if(res>=0)
		{
			System.out.println("is substring "+"starting index "+res);
		}
		else if(res==-1){
			System.out.println("no match");
		}
	}

}
