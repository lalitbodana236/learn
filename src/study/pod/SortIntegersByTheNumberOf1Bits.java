package study.pod;

public class SortIntegersByTheNumberOf1Bits {

	public static void main(String[] args) {
		int number = 0; // Replace this with the integer you want to convert to binary
		String binaryString = toBinary(number);
		System.out.println(countOne(2));
		
		System.out.println("Binary representation of " + number + " is: " + binaryString);
		int[]arr = {0,1,2,3,4,5,6,7,8};

		// int[] ans = sortByBits(arr);
	        System.out.println("Sorted array based on set bits count:");
	     //   for (int a : ans) {
	      //      System.out.print(a + " ");
	      //  }
	}

	 public static int[] sortByBits(int[] arr) {
	        for (int i = 0; i < arr.length - 1; i++) {
	            for (int j = 0; j < arr.length - i - 1; j++) {
	                if (countOne(arr[j]) > countOne(arr[j + 1])) {
	                    // Swap arr[j] and arr[j+1]
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                } else if (countOne(arr[j]) == countOne(arr[j + 1]) && arr[j] > arr[j + 1]) {
	                    // If set bit count is the same, compare the values
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	        return arr;
	    }

	    static int countOne(int num) {
	        int count = 0;
	        while (num > 0) {
	        	System.out.println();
	            count += num & 1;
	            num = num >> 1;
	        }
	        return count;
	    }
	
	static int countOne(String binaryString ) {
		int count=0;
		for(char c : binaryString.toCharArray()) {
			if(c=='1') {
				count++;
			}
		}
		return count;
	}


	public static String toBinary(int number) {
		if (number == 0) {
			return "0";
		}

		StringBuilder binary = new StringBuilder();
		while (number > 0) {
			int bit = number & 1;
			binary.insert(0, bit);
			number= number>> 1;
		}

		return binary.toString();
	}

}
