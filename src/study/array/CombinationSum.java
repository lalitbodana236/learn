package study.array;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		//combinationSum(candidates, 7);

		int[]  candidates1 = {2,3,5};
		int target = 8;
		combinationSum(candidates1, 8);



	}

	public static void combinationSum(int[] candidates, int target) {
		for(int i=0;i<candidates.length;i++) {
			int sum=candidates[i];
			
			for(int j=0;j<candidates.length;j++) {
				System.out.println(sum+" "+candidates[j]);
				if(sum==target) {
					System.out.println(sum);
					break;
				}
				sum=sum+candidates[j];

			}
		}
	}

}
