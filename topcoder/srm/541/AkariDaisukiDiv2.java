public class AkariDaisukiDiv2 {
	public int countTuples(String S) {
		int len = S.length();
		int result = 0;
		for (int start = 1; start < len - 3; start++) {
			for (int xLen = 1; start + xLen < len; xLen++) {
				int secondStart = start + xLen + 1;
				String x = S.substring(start, start + xLen);
				while ((secondStart = S.indexOf(x, secondStart) + 1) > 0 && secondStart + xLen <= len) {
// System.out.println(x + ":" + start + ":" + xLen + ":" + secondStart);
					result++;
				}
			}
		}
		return result;
	}
}
