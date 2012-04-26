import java.util.*;

public class NoRepeatPlaylist {
	int N, M, P;
	int MOD = 1000000007;
	long[][] memo;

	public int numPlaylists(int N, int M, int P) {
		this.N = N;
		this.M = M;
		this.P = P;
		memo = new long[P + 1][N + 1];
		for (long[] ia: memo) {
			Arrays.fill(ia, -1);
		}
		return (int)countPlaylists(0, 0);
	}

	long countPlaylists(int p, int nPlayed) {
		if (p == P)
			return nPlayed == N ? 1 : 0;

		if (memo[p][nPlayed] != -1) return memo[p][nPlayed];

		long result = 0;
		if (nPlayed < N)
			result += countPlaylists(p + 1, nPlayed + 1) * (N - nPlayed);

		if (nPlayed > M)
			result += countPlaylists(p + 1, nPlayed) * (nPlayed - M); 

		memo[p][nPlayed] = result % MOD;
		return memo[p][nPlayed];
	}
}
