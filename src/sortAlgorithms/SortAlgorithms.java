package sortAlgorithms;

/**
 * @author Aarti Nimhan
 * 
 *         This class contains types of sorting algorithms mentioned below that
 *         we need to analyze Insertion Sort Selection Sort Merge Sort Bubble
 *         Sort
 */

public class SortAlgorithms {

	/**
	 * @param inputNumbers
	 */
	public static void insertionSort(int[] inputNumbers) {
		for (int i = 1; i < inputNumbers.length; i++) { // The subarray to the left of i is considered sorted.
			int key = inputNumbers[i], j = i - 1;
			while (j >= 0 && inputNumbers[j] > key) { // If the key is smaller than an element the element is shifted to
														// the right
				inputNumbers[j + 1] = inputNumbers[j];
				j--;
			}
			inputNumbers[j + 1] = key; // The key is placed at its final position in sorted array.
		}
	}

	public static void selectionSort(int[] inputNumbers) {
		for (int i = 0; i < inputNumbers.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < inputNumbers.length; j++) { // Searching for the index of the smallest element in
																// the remaining list.
				if (inputNumbers[j] < inputNumbers[minIndex])
					minIndex = j;
			}
			int temp = inputNumbers[i]; // Temporary variable for swap.
			inputNumbers[i] = inputNumbers[minIndex];
			inputNumbers[minIndex] = temp;
		}
	}

	/**
	 * @param inputNumbers :- Input array
	 * @param startIndex
	 * @param endIndex
	 */

	public static void mergeSort(int[] inputNumbers, int startIndex, int endIndex) {
		int midIndex;
		if (startIndex < endIndex) {
			midIndex = (startIndex + endIndex) / 2; // Calculating the midIndex of the input array to be partitioned.
			mergeSort(inputNumbers, startIndex, midIndex); // Recursively breaking the input array at the middle to form
															// 2 smaller subarrays.
			mergeSort(inputNumbers, midIndex + 1, endIndex);
			merge(inputNumbers, startIndex, midIndex, endIndex); // Merging and sorting the 2 partitioned subarrays.
		}

	}

	public static void merge(int[] inputNumbers, int startIndex, int midIndex, int endIndex) {

		int sizeLeft = midIndex - startIndex + 1; // Calculating size of the left subarray to be merged
		int sizeRight = endIndex - midIndex; // Calculating size of the right subarray to be merged
		int tempLeft[] = new int[sizeLeft]; // Creating temporary arrays
		int tempRight[] = new int[sizeRight];
		for (int i = 0; i < sizeLeft; i++) // Copying data to temporary arrays
			tempLeft[i] = inputNumbers[startIndex + i];
		for (int i = 0; i < sizeRight; i++)
			tempRight[i] = inputNumbers[midIndex + 1 + i];
		int i = 0, j = 0, k = startIndex;
		while (i < sizeLeft && j < sizeRight) { // Copying the smaller of the two 1st elements of the subarrays into the
												// merged arrary. This loop continues till all the elements of either of
												// the subarrays is merged in.
			if (tempLeft[i] <= tempRight[j]) {
				inputNumbers[k] = tempLeft[i];
				i++;
			} else {
				inputNumbers[k] = tempRight[j];
				j++;
			}
			k++;
		}
		while (i < sizeLeft) { // Copy the remaining of the 1st subarray
			inputNumbers[k] = tempLeft[i];
			i++;
			k++;
		}
		while (j < sizeRight) { // Copy the remaining of the 2nd subarray
			inputNumbers[k] = tempRight[j];
			j++;
			k++;

		}
	}

	/**
	 * @param inputNumbers :- List of unsorted numbers.
	 */
	public static void bubbleSort(int[] inputNumbers) {
		for (int i = 0; i < inputNumbers.length - 1; i++) { // Compare each adjacent pair of elements and if it is
			// greater swap it.
			for (int j = 0; j < inputNumbers.length - i - 1; j++) { // This way after every iteration of the outer for
																	// loop
																	// the largest element bubbles up to the end of the
																	// list eventually sorting
																	// the list
				if (inputNumbers[j] > inputNumbers[j + 1]) {
					int temp = inputNumbers[j]; // Temporary variable for swap.
					inputNumbers[j] = inputNumbers[j + 1];
					inputNumbers[j + 1] = temp;
				}
			}
		}
	}
	
	/* Optimized Bubble sort*/
	
	    public static void bubbleSortOptimized(int[] inputNumbers) {
	        int i=0,k=0,temp=0;
	        int is_sorted=1;
	        for(k = 0;k < inputNumbers.length  -1; k++) {//n
	            is_sorted=1;
	            for(i=0;i < inputNumbers.length  - k - 1;i++) {//      best case loop will run for n-1 times best case complexity is n
	                        //      worst case (descending order) the loop will run for
	                if(inputNumbers[i] > inputNumbers[i+1] ) {// (n-1)+(n-2)+(n-3)...3+2+1 times = (n^2)/2-n/2 times
	                    temp=inputNumbers[i];            // worst case time complexity is n^2
	                    inputNumbers[i]=inputNumbers[i+1];    // avg case=(best case + worst case)/2 
	                    inputNumbers[i+1]=temp;          // (n^2+n)/2=n^2
	                    is_sorted=0;                // avg case time complexity is n^2
	                }
	            }
	            if(is_sorted==1) {
	                break;
	            }
	        }
	   }

	public static void main(String[] args) {

		int inputNumbers[] = { 34, 23, 1, 54, 12, 7, 55, 8, 98, 14 };

		System.out.print("\n-----------MERGE SORT---------\nUNSORTED LIST: ");
		printInputNumbers(inputNumbers);
		mergeSort(inputNumbers, 0, inputNumbers.length - 1);
		System.out.print("\nSORTED LIST: ");
		printInputNumbers(inputNumbers);

		int inputNumbers1[] = { 34, 23, 1, 54, 12, 7, 55, 8, 98, 14 };
		System.out.print("\n-----------BUBBLE SORT---------\nUNSORTED LIST: ");
		printInputNumbers(inputNumbers1);
		bubbleSort(inputNumbers1);
		System.out.print("\nSORTED LIST: ");
		printInputNumbers(inputNumbers1);

		int inputNumbers2[] = { 34, 23, 1, 54, 12, 7, 55, 8, 98, 14 };
		System.out.print("\n-----------SELECTION SORT---------\nUNSORTED LIST: ");
		printInputNumbers(inputNumbers2);
		selectionSort(inputNumbers2);
		System.out.print("\nSORTED LIST: ");
		printInputNumbers(inputNumbers2);

		int inputNumbers3[] = { 34, 23, 1, 54, 12, 7, 55, 8, 98, 14 };
		System.out.print("\n-----------INSERTION SORT---------\nUNSORTED LIST: ");
		printInputNumbers(inputNumbers3);
		insertionSort(inputNumbers3);
		System.out.print("\nSORTED LIST: ");
		printInputNumbers(inputNumbers3);

	}

	/**
	 * This method prints the a given list of numbers
	 * 
	 * @param inputNumbers
	 */
	public static void printInputNumbers(int[] inputNumbers) {
		System.out.println();
		for (int i = 0; i < inputNumbers.length; i++) {
			System.out.print(inputNumbers[i] + " ");
		}
	}

}
