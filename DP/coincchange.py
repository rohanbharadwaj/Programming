"""
Coin Change Problem 
Refrence : http://www.algorithmist.com/index.php/Coin_Change

Number of ways of making changes for a particular amount of cents, n, using a given set of denominations, can be solved using DP
"""

S = [1,5,10,25,50]

def change_recursive( n, m ):
    if n == 0:   #no money, exactly one way to solve the problem 
        return 1  # by choosing no coin change, or, more precisely, to choose coin change of 0
    if n < 0:
        return 0   # no solution -- negative sum of money
    if m < 0 and n >= 1: #m < 0 for zero indexed programming languages
        return 0          #no solution -- we have money, but no change available
 
    return count( n, m - 1 ) + count( n - S[m], m )


def change_recursive_memo( n, m ):
	"""
	Memoized version of coin change.

	Time complexity is O(mn)
	"""
    table[n][m] 




def main():
   print count(6,4);

if __name__=='__main__':
	main()      