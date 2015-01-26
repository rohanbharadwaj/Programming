package strings;

public class ReverseWords {
	public static char[] reverseWords() {
		// reverse the string
		char[] arr = "sky is blue".toCharArray();
		reverse(arr, 0, arr.length / 2, arr.length);

		// reverse words of a string
		int wordStartIdx = 0;
		int wordMidIdx = 0;
		int prevWordLastIdx = 0; // keep track where the next word will begin

		// outer loop to track spaces
		for (int sentenceIdx = 0; sentenceIdx < arr.length; sentenceIdx++) {
			if (arr[sentenceIdx] != ' ')
				continue;

			wordStartIdx = prevWordLastIdx;
			int wordLastIdx = sentenceIdx;
			wordMidIdx = (sentenceIdx + wordStartIdx) / 2;
			// reverse each word in a string
			reverse(arr, wordStartIdx, wordMidIdx, wordLastIdx);
			prevWordLastIdx = sentenceIdx + 1;
		}

		// reverse last word
		wordStartIdx = prevWordLastIdx;
		wordMidIdx = (arr.length + wordStartIdx) / 2;
		reverse(arr, wordStartIdx, wordMidIdx, arr.length);

		return arr;
	}

	private static void reverse(char[] arr, int wordStartIdx, int wordMidIdx,
			int wordLastIdx) {
		for (; wordStartIdx < wordMidIdx; wordStartIdx++) {
			// swap first letter with the last letter in the
			char tmp = arr[wordStartIdx];
			arr[wordStartIdx] = arr[wordLastIdx - 1];
			arr[wordLastIdx - 1] = tmp;
			wordLastIdx--;
		}
	}

	public static void main(String[] args) {
		System.out.println(new String(reverseWords()));
	}

}