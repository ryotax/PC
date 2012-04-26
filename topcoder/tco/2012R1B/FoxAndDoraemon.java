import java.util.*;
public class FoxAndDoraemon {
	public int minTime(int[] workCost, int splitCost) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i : workCost) {
			q.add(i);
		}

		while (q.size() > 1) {
			q.add(Math.max(q.poll(), q.poll()) + splitCost);
		}
		return q.poll();
	}
}
