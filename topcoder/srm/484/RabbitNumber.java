public class RabbitNumber {
	public int theCount(int low, int high) {
		return Integer.parseInt("" + high, 3) - Integer.parseInt("" + low, 3);
	}

	private String prevTernary(int n) {
		String s = Integer.toString(n);
		StringBuilder result = new StringBuilder();
		boolean over = false;

		for (char c : s.toCharArray()) {
			if (c > '2' || over) {
				result.append('2');
				over = true;
			} else {
				result.append(c);
			}
		}

		return result.toString();
	}

	private String nextTernary(int n) {
		String s = Integer.toString(n);
		StringBuilder result = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c > '2') {
				result.append('0');
				for (int i = 0; i < result.length()) {
					char cc = result.charAt(result.length() - i);
					if (cc == '2') {
						result.setCharAt(result.length() - i, '0');
					} else {
						result.setCharAt(result.length() - i, cc + (char)1);
						break;
					}
				}
				over = true;
			} else {
				result.append(c);
			}
		}

		return result.toString();
	}
}
