package binarysearch;
/*
 * This Program is used to search for a key in a sorted array which is 
 * rotated. It works fine even if there are duplicates.
 */
public class RotatedArray {
	public static int search(int[] arr, int key, int low, int high) {

		int mid = (low + high) / 2;

		if (arr[mid] == key)
			return mid;
		while (low <= high) {
			// if the left half is sorted.
			if (arr[low] < arr[mid]) {

				// if key is in the left half
				if (arr[low] <= key && key <= arr[mid])
					// search the left half
					return search(arr, key, low, mid - 1);
				else
					// search the right half
					return search(arr, key, mid + 1, high);
			}

			// if the right half is sorted.
			else if (arr[mid] < arr[low]) {
				// if the key is in the right half.
				if (arr[mid] <= key && arr[high] >= key)
					return search(arr, key, mid + 1, high);
				else
					return search(arr, key, low, mid - 1);
			}

			else if (arr[mid] == arr[low]) {

				if (arr[mid] != arr[high])
					// Then elements in left half must be identical.
					// Because if not, then it's impossible to have either
					// arr[mid] < arr[high] or arr[mid] > arr[high]
					// Then we only need to search the right half.
					return search(arr, key, mid + 1, high);
				else {
					// arr[low] = arr[mid] = arr[high], we have to search both
					// halves.
					int result = search(arr, key, low, mid - 1);
					if (result == -1)
						return search(arr, key, mid + 1, high);
					else
						return result;
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int[] arr = { 2, 2, 2, 2, 2, 3, 1 };
		int high = arr.length;
		int res = search(arr, 2, 0, high - 1);
		System.out.println(res);
	}
}