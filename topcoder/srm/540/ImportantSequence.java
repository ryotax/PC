public class ImportantSequence {
	public int getCount(int[] B, String operators) {
		if (operators.indexOf('+') < 0) {
			return -1;
		}

		long aMax = (long)Integer.MAX_VALUE * 100;
		long aMin = 1;

		for (int i = 0; i < B.length; i++) {
			int b = B[i];
			boolean plus = operators.charAt(i) == '+';

			long aMaxTemp, aMinTemp;
			if (plus) {
				aMaxTemp = b - aMin;
				aMinTemp = Math.max(b - aMax, 1);
			} else {
				aMaxTemp = aMax - b;
				aMinTemp = Math.max(aMin - b, 1);
			}
			aMax = aMaxTemp;
			aMin = aMinTemp;

			if (aMax <= 0) {
				return 0;
			}
		}

		return (int)(aMax - aMin + 1);
	}
}
