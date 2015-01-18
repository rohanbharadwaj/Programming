package DP;

//DP solution for MinCoins problem
//Given a number and denominations, returns minimum number of coins required to make a change
//Works for non US currency as well
import java.util.*;
public class MinCoins {

public static int NumberOfCoins(int sum, int[] denominations) {
    int[] a = new int[sum + 1]; // Base condition is trivial so we need a extra nth term which contains solution.
    Arrays.fill(a, Integer.MAX_VALUE);  // Initalize the array with Infinity.
    a[0]=0; 
    for (int i = 0; i <= sum; i++) {
      for (int j = denominations.length - 1; j >= 0; j--) { // Processs denominations in non increasing order.
        if (denominations[j] <= i) {
          a[i] = Math.min(1 + a[i - denominations[j]], a[i]);
        }
      }
    }
    return a[sum];
  }

  public static void printArray(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + "  ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] denominations = new int[] {1,2,5,8,10};
    int sum = 24;  
    
    System.out.println(NumberOfCoins(sum, denominations)); //returns 3 instead of 10,10,2,2
  
}
}