package com.algorithms.quickfind;

public class QuickFind {
	
	public int[] id;
	
	public QuickFind() {
		id = new int[10];
		for(int i = 0; i<10; i++)
			id[i]=i;
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p , int q) {
		int pid = id[p], qid = id[q];
		if(!connected(p, q))
			for(int i = 0; i<10; i++)
				if (id[i]==pid)	id[i]=qid;
	}
	
}
