package strings;

public class Solution {
    public static void reverse(char[] a,int wordStartIndex,int wordMidIndex,int wordEndIndex)
    {
        
        for(;wordStartIndex<wordMidIndex;wordStartIndex++){
            char temp = a[wordStartIndex];
            a[wordStartIndex] = a[wordEndIndex-1];
            a[wordEndIndex-1] = temp;
            wordEndIndex--;
//            System.out.println("test1");
        }
    }
    public static String reverseWords(String s) {
    //if(s.trim().length()==0) return null;
    char[] array = s.toCharArray();
    int len = array.length;
    reverse(array,0,len/2,len);//reverse string    
//    System.out.println(array);
    int wordStrtIdx = 0;
    int wordMidIdx = 0;
    int prevWordLastIdx = 0;
    for(int sIdx = 0;sIdx<len;sIdx++){
        while(array[sIdx]!=' ')
        continue;
        wordStrtIdx = prevWordLastIdx;
        int wordEndIdx = sIdx;
        wordMidIdx = (wordStrtIdx+sIdx)/2;
        reverse(array,wordStrtIdx,wordMidIdx,wordEndIdx);
        prevWordLastIdx = sIdx+1;
                
    }    
    wordStrtIdx = prevWordLastIdx;
    wordMidIdx = (wordStrtIdx+array.length)/2;
    reverse(array,wordStrtIdx,wordMidIdx,array.length);
    
    return (new String(array));
    }
    
    public static void main(String[] args) {
		System.out.println(reverseWords("sky is blue"));
	}
}
