public class KingXMagicSpells {
	int n;
	int[] spellOne;
	int[] spellTwo;
	public double expectedNumber(int[] ducks, int[] spellOne, int[] spellTwo, int K) {
		n = ducks.length;
		this.spellOne = spellOne;
		this.spellTwo = spellTwo;

		double result = 0;
		for (int i = 0; i < 31; i++) {
			double[] p = new double[n];
			for (int d = 0; d < n; d++) {
				p[d] = ((ducks[d] >> i) & 1);
			}
			for (int k = 0; k < K; k++) {
				p = calc(p, i);
			}
			result += p[0] * (1 << i);
		}
		return result;
	}

	private double[] calc(double[] p, int pos) {
		double[] np = new double[n];
		for (int i = 0; i < n; i++) {
			int bit = (spellOne[i] >> pos) & 1;
			np[i] += ((bit == 0) ? p[i] : 1 - p[i]) / 2;
			np[spellTwo[i]] += p[i] / 2;
		}
		return np;
	}
}
