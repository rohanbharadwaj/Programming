#Finds a largest increasing subsequence in O(n^2) time
def LiS(array):
  n=len(array)
  #q[i] contains the max length of sub seq. ending at array[i]
  #p[i] contains predecessor of the sub seq. ending at array[i] 
  q=[0]*n
  p=[-1]*n
 
  for i in range(n):
    maxLen=0
    for j in range(i):
      if array[i]>array[j] :
        if q[j]>maxLen :
          maxLen=q[j]
          p[i]=j
 
    q[i]=maxLen+1
 
  # print "text"  
  idx=q.index(max(q))
  print idx
  print "p :",p
  print "q :",q
  seq=[]
  while(idx!=-1):
    seq=[array[idx]]+seq
    print seq
    idx=p[idx]
    print idx
 
  return seq
 
def main():
  a = [4,2,6,1,9,0,11,7,12];
  print "\nInput Array : \n",a
  print LiS(a)
 
 
if __name__=='__main__':
  main()