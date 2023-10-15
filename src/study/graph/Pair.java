package study.graph;

public class Pair implements Comparable<Pair>{
	int wt;
	int v;

	public Pair(int wt, int v) {
		super();
		this.wt = wt;
		this.v = v;
	}

	@Override
	public int compareTo(Pair o) {
		return this.wt-o.wt;
	}
}