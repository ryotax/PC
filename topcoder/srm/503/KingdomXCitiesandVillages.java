import java.util.*;
public class KingdomXCitiesandVillages {
	public double determineLength(int[] cx, int[] cy, int[] vx, int[] vy) {
		int nc = cx.length;
		int nv = vx.length;

		double result = 0;
		for (int v = 0; v < nv; v++) {
			double vc = Double.MAX_VALUE;
			for (int c = 0; c < nc; c++) {
				vc = Math.min(vc, len(vx[v], vy[v], cx[c], cy[c]));
			}

			List<Double> vvList = new ArrayList<Double>();
			for (int v2 = 0; v2 < nv; v2++) {
				if (v == v2) {
					continue;
				}
				vvList.add(Math.min(vc, len(vx[v], vy[v], vx[v2], vy[v2])));
			}

			Collections.sort(vvList);
			double remain = 1;
			for (int i = 0; i < vvList.size(); i++) {
				double vv = vvList.get(i);
				double p = remain / (2 + i);
				remain -= p;
				result += p * vv;
			}
			result += vc * remain;
		}

		return result;
	}

	private double len(long x1, long y1, long x2, long y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public static void main(String[] args) {
		System.out.println(new KingdomXCitiesandVillages().determineLength(
			new int[] {1,2,3},
			new int[] {4,4,4},
			new int[] {4,5,6},
			new int[] {4,4,4}
					));
	}
}
