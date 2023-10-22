 package study.graph;

public class DisjointSet {
	int N=10;
	int[] parent = new int[N];
	
	void initialize() {
		for(int i=0;i<N; i++) {
			parent[i]=i;
		}
	}
	
	int find(int x) {
		if(parent[x]==x)
				return x;
		return find(parent[x]);
	}
	
	void union(int a,int b) {
		int x=find(a);
		int y=find(b);
		if(x==y)
			return ;
		parent[y]=x;
	}
}
