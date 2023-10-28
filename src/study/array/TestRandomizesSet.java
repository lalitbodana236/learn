package study.array;

public class TestRandomizesSet {

	public static void main(String[] args) {
		RandomizedSet s = new RandomizedSet();

		System.out.println(s.insert(1));
		System.out.println("2 "+s.remove(2));
		System.out.println("2 "+s.insert(2));
		System.out.println(s.getRandom());
	//	System.out.println(	s.remove(1));
		System.out.println(s.insert(2));
		System.out.println(s.getRandom());
		System.out.println(s.insert(3));
		System.out.println(s.getRandom());
		System.out.println(s.remove(1));

	}

}
