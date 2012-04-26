public class FractionInDifferentBases {
	public long getNumberOfGoodBases(long P, long Q, long A, long B) {
		long n = reduce(Q / gcd(Math.max(P, Q), Math.min(P, Q)));
		return (B - A + 1) - ((B / n) - ((A - 1) / n));
	}

	private long gcd(long p, long q) {
		return q == 0 ? p : gcd(q, p % q);
	}

	private long reduce(long q) {
		long result = 1;
		long last = (long)Math.sqrt(q);
		for (int i = 2; i <= last; i++) {
			boolean first = true;
			while (q % i == 0) {
				if (first) {
					result *= i;
					first = false;
				}
				q /= i;
			}
		}

		return result * q;
	}
}
