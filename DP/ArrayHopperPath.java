package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayHopperPath {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> res = new ArrayList<Integer>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			String t = null;
			while ((t = br.readLine()) != null && t.length() != 0) {
				Integer e = Integer.parseInt(t);
				list.add(e);
			}
		} catch (IOException e) {

		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);
		s.close();
		int n = arr.length;
		int[] hop = new int[n];
		int[] prevIndex = new int[n];
		if (n == 0 || arr[0] == 0) {
			System.out.println("failure");
			System.exit(0);
		}
		Arrays.fill(hop, Integer.MAX_VALUE);
		hop[0] = 0;
		// DP Logic to choose the path with min hops.
		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {

				if (i <= j + arr[j] && hop[j] != Integer.MAX_VALUE) {
					hop[i] = Math.min(hop[i], hop[j] + 1);
					prevIndex[i] = j;
					break;
				}
			}
		}
		// Reconstructing the path.(It is in reverse order)
		int index = arr.length - 1;
		while (index > 0) {
			res.add(index);
			index = prevIndex[index];
		}
		res.add(0);
		for (int i = res.size() - 1; i >= 0; i--) {
			System.out.print(res.get(i) + ", ");
		}
		System.out.print("out");
	}
}
