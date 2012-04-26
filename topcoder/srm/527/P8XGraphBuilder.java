import java.util.*;

public class P8XGraphBuilder {
	public int solve(int[] scores) {
		int n = 1 + scores.length;
		int[] best = new int[2 * n - 1];
		Arrays.fill(best, -1);
		best[0] = 0;
		for (int v = 0; v < n; ++v) {
			int[] nbest = new int[2 * n - 1];
			Arrays.fill(nbest, -1);
			for (int cur = 1; cur < n; ++cur)
				for (int prev = 0; prev + cur < nbest.length; ++prev)
					if (best[prev] >= 0)
						nbest[prev + cur] = Math.max(nbest[prev + cur], best[prev] + scores[cur - 1]);
System.out.println(Arrays.toString(nbest));
			best = nbest;
		}
		return best[2 * n - 2];
	}

	public static void main(String[] args) {
		System.out.println(new P8XGraphBuilder().solve(new int[]{1, 3, 2}));
	}
}
