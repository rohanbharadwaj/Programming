package dynamicprogramming;
// Time Complexity O(mn) 
public class LCSJava {
	String s1;//sequence 1
	String s2;//sequence 2
	static int[][] table;

	public LCSJava(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
		table = new int[s1.length() + 1][s2.length() + 1];

	}

	public int getLcsLen() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (i == 0 || j == 0)
					table[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					table[i][j] = 1 + table[i - 1][j - 1];
				else
					table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
			}
		}

		return table[s1.length()][s2.length()];

	}
	public String getLCS(){
		int index = table[s1.length()][s2.length()];
		char[] res = new char[index+1];
		res[index]='\0';
		int i = s1.length();
		int j = s2.length();
		while(i>0 & j>0){
			if(s1.charAt(i-1)==s2.charAt(j-1)){
				res[index-1]=s1.charAt(i-1);
				i--;j--;index--;
			}
			else if(table[i-1][j]>table[i][j-1])
				i--;
			else
				j--;
		}
		return new String(res);	
	}

	public static void main(String[] args) {
		LCSJava obj = new LCSJava("AGGTAB", "GTAB");
		int len = obj.getLcsLen();
		System.out.println(len);
		String res = obj.getLCS();
		System.out.println(res);
	}

}
