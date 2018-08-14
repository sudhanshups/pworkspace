package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair implements Comparable<Pair> {
	List<Integer> list;
	int index;

	public Pair(List<Integer> list, int index) {
		this.list = list;
		this.index = index;
	}

	@Override
	public int compareTo(Pair o) {
		if (list.get(index) > o.list.get(o.index)) {
			return 1;
		} else if (list.get(index) < o.list.get(o.index)) {
			return -1;
		}
		return 0;
	}
}

public class MergeKList {

	public static void main(String args[]) throws Exception {
		List<List<Integer>> l = new ArrayList<>();
		/*
		 * List<Integer> x = new ArrayList<>(); x.add(1); l.add(x);
		 */
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(1, 10, 11, 20));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(1, 5, 9, 13));
		List<Integer> l5 = new ArrayList<>(Arrays.asList(1, 6, 11, 17));

		l.add(l1);
		l.add(l4);
		l.add(l3);
		l.add(l2);
		l.add(l5);

		Queue<Pair> pqueue = new PriorityQueue<Pair>();
		Pair p1 = new Pair(l.get(0),0);
		Pair p2 = new Pair(l.get(1),0);
		Pair p3 = new Pair(l.get(2),0);
		Pair p4 = new Pair(l.get(3),0);
		Pair p5 = new Pair(l.get(4),0);
		pqueue.add(p1);
		pqueue.add(p2);
		pqueue.add(p3);
		pqueue.add(p4);
		pqueue.add(p5);
		
		while(!pqueue.isEmpty()){
			Pair p = pqueue.poll();
			System.out.println(p.list.get(p.index));
			p.index++;
			if(p.index < p.list.size()){
				//Pair pn = new Pair (p.list, p.index);
				pqueue.add(p);
			}
		}
	}
}
