def lcs_len(x, y): #recursive not efficient
    """This function returns length of longest common sequence of x and y."""

    if len(x) == 0 or len(y) == 0:
        return 0
 
    xx = x[:-1]   # xx = sequence x without its last element    
    yy = y[:-1]
 
    if x[-1] == y[-1]:  # if last elements of x and y are equal
        return lcs_len(xx, yy) + 1
    else:
        return max(lcs_len(xx, y), lcs_len(x, yy))

# Time Complexity is O(mn)
def lcs(x, y): # DP solution with Memoization
    n = len(x)
    m = len(y)
    table = dict()  # a hashtable, but we'll use it as a 2D array here
 
    for i in range(n+1):     # i=0,1,...,n
        for j in range(m+1):  # j=0,1,...,m
            if i == 0 or j == 0:
                table[i, j] = 0
            elif x[i-1] == y[j-1]:
                table[i, j] = table[i-1, j-1] + 1
            else:
                table[i, j] = max(table[i-1, j], table[i, j-1])
 		
    # Now, table[n, m] is the length of LCS of x and y.
 
    # Let's go one step further and reconstruct
    # the actual sequence from DP table:
    def recon(i, j):
        if i == 0 or j == 0:
            return []
        elif x[i-1] == y[j-1]:
            return recon(i-1, j-1) + [x[i-1]]
        elif table[i-1, j] > table[i, j-1]: #index out of bounds bug here: what if the first elements in the sequences aren't equal
            return recon(i-1, j)
        else:
            return recon(i, j-1)
 
    return recon(n, m)        

def main():
	x = "AGCAT"
	y = "GAC"
	print "x : ",x
	print "y : ",y
	l = lcs_len(x,y)
	print "Longest Common SubSequence length : ",l
	print "LCS : ",lcs(x, y)



if __name__=='__main__':
	main()
