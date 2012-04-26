import java.util.*;

public class TurtleSpy {
	public double maxDistance(String[] commands) {
		long forward = 0;
		long back = 0;
		List<Integer> turns = new ArrayList<Integer>();
		for (String com: commands) {
			String[] sp = com.split(" ");
			int val = Integer.parseInt(sp[1]);
			if (sp[0].equals("forward")) {
				forward += val;
			} else if (sp[0].equals("backward")) {
				back += val;
			} else if (sp[0].equals("right")) {
				turns.add(val);
			} else if (sp[0].equals("left")) {
				turns.add(-val);
			}
		}

		int degree = getProperDegree(turns);
		return Math.sqrt(forward * forward + back * back - 2 * forward * back * Math.cos((double)degree / 180 * Math.PI));
	}

	private int getProperDegree(List<Integer> turns) {
		if (turns.size() == 0) return 0;

		boolean[][] dp = new boolean[turns.size()][360];
		for (int i = 0; i < turns.size(); i++) {
			int degree = turns.get(i) + 1080;
			dp[i][degree % 360] = true;
			if (i != 0) {
				for (int d = 0; d < 360; d++) {
					if (dp[i - 1][d]) {
						dp[i][d] = true;
						dp[i][(d + degree) % 360] = true;
					}
				}
			}
		}
		int degree = 0;
		for (int i = 0; i < 360; i++) {
			if (dp[turns.size() - 1][i]) {
				degree = Math.max(degree, 180 - Math.abs(180 - i));
			}
		}
		return degree;
	}
}

