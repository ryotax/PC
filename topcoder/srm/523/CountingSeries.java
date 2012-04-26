public class CountingSeries {
	public long countThem(long a, long b, long c, long d, long upperBound) {
		long nArith = upperBound >= a ? ((upperBound - a) / b) + 1 : 0;

		long geom = c;
		long nGeom = 0;
		 while (geom <= upperBound && geom >= 0) {
			nGeom += unique(geom, a, b);
			if (d == 1) {
				break;
			}
			geom *= d;
		}
		return nArith + nGeom;
	}

	private long unique(long target, long a, long b) {
		if (target < a) {
			return 1;
		} else {
			return (target - a) % b == 0 ? 0 : 1;
		}
	}
}
