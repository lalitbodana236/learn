package study.pod;

public class PoorPigs {

	public static void main(String[] args) {
		int buckets = 4, minutesToDie = 15, minutesToTest = 15;
		System.out.println(poorPigs(buckets,minutesToDie,minutesToTest));

	}
	
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
   int tests = minutesToTest / minutesToDie + 1;
   

   int bucketsToCheck = 1;
   while (bucketsToCheck < buckets) {
       bucketsToCheck *= tests;
       System.out.println(tests+" " +bucketsToCheck);
       pigs++;
   }

   return pigs;
   }

}
