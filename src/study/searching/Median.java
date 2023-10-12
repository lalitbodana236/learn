package study.searching;

public class Median {

	public static void main(String[] args) {
		int[] sortedArray = {1, 3, 4, 7, 8};
		double median = calculateMedian(sortedArray);
		System.out.println("Median: " + median);
		
		int[] sortedArray1 = {1,2};
		double median1 = calculateMedian(sortedArray1);
		System.out.println("Median: " + median1);
		
		int[] sortedArray2 = {3,4};
		double median2 = calculateMedian(sortedArray2);
		System.out.println("Median: " + median2);
		System.out.println("Median: final" + (median2+median1)/2);


	}
	
	public static double calculateMedian(int[] sortedArray) {
	    int n = sortedArray.length;
	    
	    if (n % 2 == 1) {
	        // If there is an odd number of elements, return the middle element.
	        return (double) sortedArray[n / 2];
	    } else {
	        // If there is an even number of elements, return the average of the two middle elements.
	        int middle1 = sortedArray[(n - 1) / 2];
	        int middle2 = sortedArray[n / 2];
	        return (double) (middle1 + middle2) / 2.0;
	    }
	}

}
