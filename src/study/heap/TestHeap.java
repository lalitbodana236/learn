package study.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TestHeap {

	void insert(int arr[] ,int n,int value) {
		n =n+1;
		arr[n]=value;
		int i = n ; 
		while(i>1) {
			int parent = i/2;
			if(arr[parent]< arr[i]) {
				swap(arr,parent,i);
				i=parent;
			}else {
				return;
			}
		}
	}

	private void swap(int[] arr, int parent, int i) {
		int temp = arr[parent];
		arr[parent] = arr[i];
		arr[i]=temp;	
	}

	void delete(int arr[],int n) {
		arr[1]=arr[n];

		n=n-1;
		int i=1;

		while(i<n) {
			int left = arr[2*i];
			int right =arr[2*i+1];
			int larger = left>right ? 2 * i : 2*i+1;

			if(arr[i]<arr[larger]) {
				swap(arr,i,larger);
				i=larger;
			}else {
				return;
			}
		}
	}
	
	void heapify(int a[],int n,int i) {
		int largest = i ;
		
		int l = 2*i;
		int r = 2*i+1;
		
		if(l<=n && a[l]>a[largest]) {
			largest=l;
		}
		if(r<=n && a[r]>a[largest]) {
			largest=r;
		}
		
		if(largest!=i) {
			swap(a,i,largest);
			heapify(a,n,largest);
		}
	}
	
	void build(int a[],int n){
		for(int i=n/2;i>0;i--) {
			heapify(a,n,i);
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(5);
		pq.add(15);
		pq.add(10);
		pq.add(1);
		pq.add(2);
		pq.add(16);
		//System.out.println(pq.size());
		//while(!pq.isEmpty()) {
			//System.out.println(pq.poll());
		//}
		
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(3);
		set.add(1);
		set.add(2);
		for(Integer i : set) {
			System.out.print(i+" ");
		}
		ArrayList<Integer> list = new ArrayList<>(set);
		System.out.println();
		for(Integer i : list) {
			System.out.print(i+" ");
		}
	
	}
	
	
}
