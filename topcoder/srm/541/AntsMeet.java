import java.util.*;

public class AntsMeet {
	public int countAnts(int[] x, int[] y, String direction) {
		Set<Ant> set = new HashSet<Ant>();
		for (int i = 0; i < x.length; i++) {
			set.add(new Ant(x[i], y[i], direction.charAt(i)));
		}

		for (int t = 0; t <= 4000; t++) {
			Map<Integer, List<Ant>> check = new HashMap<Integer, List<Ant>>();
			for (Ant a: set) {
				a.move();
				int key = a.x * 10000 + a.y;
				List l = check.get(key);
				if (l == null) {
					l = new ArrayList<Ant>();
					check.put(key, l);
				}
				l.add(a);
			}

			for (List<Ant> l: check.values()) {
				if (l.size() != 1) {
					for (Ant a: l) {
						set.remove(a);
					}
				}
			}
		}
		return set.size();
	}

	private static class Ant {
		public int x;
		public int y;
		int diffX;
		int diffY;

		public Ant(int x, int y, char d) {
			this.x = 2 * x;
			this.y = 2 * y;
			switch (d) {
				case 'E':
					diffX = 1;
					break;
				case 'W':
					diffX = -1;
					break;
				case 'N':
					diffY = 1;
					break;
				case 'S':
					diffY = -1;
					break;
			}
		}

		public void move() {
			x += diffX;
			y += diffY;
		}
	}
}
