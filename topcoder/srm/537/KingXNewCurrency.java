import java.util.*;

public class KingXNewCurrency {
	public int howMany(int A, int B, int X) {
		Set<Integer> sa = divisors(A, X);
		Set<Integer> sb = divisors(B, X);

		if (sa == null) {
			if (sb == null) {
				return -1;
			} else {
				return sb.size();
			}
		} else {
			if (sb == null) {
				return sa.size();
			} else {
				return intersect(sa, sb);
			}
		}
	}

	private <T> int intersect(Set<T> s1, Set<T> s2) {
		int count = 0;
		for (T t: s1) {
			if (s2.contains(t)) {
				count++;
			}
		}
		return count;
	}

	private Set<Integer> divisors(int old, int X) {
		if (old % X == 0) {
			return null;
		}

		Set<Integer> s = new HashSet<Integer>();
		for (int i = old; i >= 0; i -= X) {
			s.addAll(divisors(i));
		}
		return s;
	}


	private Set<Integer> divisors(int n) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				s.add(i);
			}
		}
		return s;
	}
}
