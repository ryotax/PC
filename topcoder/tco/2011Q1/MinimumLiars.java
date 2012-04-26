import java.util.*;

public class MinimumLiars {
	public int getMinimum(int[] claim) {
		int len = claim.length;
		Arrays.sort(claim);

		if (claim[len - 1] == 0) {
			return 0;
		}

		if (claim[0] > len) {
			return len;
		}

		for (int nLier = 1; nLier < len; nLier++) {
			if (claim[len - nLier - 1] > nLier) {
				continue;
			}
			if (claim[len - nLier] <= nLier) {
				continue;
			}
			return nLier;
		}
		return -1;
	}
}
