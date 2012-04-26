import java.util.*;

public class FoxListeningToMusic {
	public double[] getProbabilities(int[] length, int T) {
		int len = length.length;
		double[][] dp = new double[T + 1][length.length];

		for (int i = 0; i < len; i++) {
			int targetIndex = Math.min(T, length[i]);
			dp[targetIndex][i] = (double)1 / len;
		}

		for (int t = 0; t <= T; t++) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					int targetIndex = Math.min(T, t + length[j]);
					dp[targetIndex][j] += dp[t][i] / len;
				}
			}
			System.out.println(Arrays.deepToString(dp));
		}

		return dp[T];
	}
}
