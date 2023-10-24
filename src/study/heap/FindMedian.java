package study.heap;

import java.util.PriorityQueue;

public class FindMedian {
	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	public FindMedian() {
		maxHeap = new PriorityQueue<>((a,b)->b-a);
		minHeap = new PriorityQueue<>((a,b)->a-b);
	}

	public void insertNum(int num) {
		if(maxHeap.isEmpty() || maxHeap.peek()>num) {
			maxHeap.add(num);
		}else {
			minHeap.add(num);
		}
		if(maxHeap.size()>minHeap.size()+1) {
			minHeap.add(maxHeap.poll());
		}else if(maxHeap.size()<minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if(maxHeap.size()==minHeap.size()) {
			return maxHeap.poll()/2.0 + minHeap.poll()/2.0;
		}
		return maxHeap.poll();
	}
}
