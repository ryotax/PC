public class CasketOfStar {
	public int maxEnergy(int[] weight) {
		int N = weight.length;
		int[][] dp = new int[N][N];

		for (int i = 2; i < N; i++) {
			for (int j = 0; i + j < N; j++) {
				for (int d = j + 1; d < j + i; d++) {
					dp[j][j + i] = Math.max(dp[j][j + i],
							weight[j] * weight[j + i] + dp[j][d] + dp[d][j + i]);
		// System.out.println(i + ":" + j + ":" + java.util.Arrays.deepToString(dp));
				}
			}
		}
		// System.out.println(java.util.Arrays.deepToString(dp));
		return dp[0][N - 1];
	}
}
