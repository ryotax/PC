public class SRMCodingPhase {
	int[] points;
	int[] skills;
	public int countScore(int[] points, int[] skills, int luck) {
		this.points = points;
		this.skills = skills;
		int point = 0;
		for (int i = 0; i < 8; i++) {
			point = Math.max(point, calcScore(luck, i));
		}
		return point;
	}

	int[] MULTI = new int[]{2, 4, 8};

	private int calcScore(int luck, int target) {
		int point = 0;
		int remainTime = 75;

		for (int i = 2; i >= 0; i--) {
			if (((target >> i) & 1) == 1) {
				if (remainTime - skills[i] + luck >= 0) {
					int time = Math.max(skills[i] - luck, 1);
					point += points[i] - MULTI[i] * time;
					remainTime -= time;
					luck -= skills[i] - time;
				} else {
					return 0;
				}
			}
		}

		return point;
	}
}
