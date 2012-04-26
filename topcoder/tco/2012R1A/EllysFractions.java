import java.util.*;
public class EllysFractions {
	public long getCount(int N) {
		Set<Integer> primes = new HashSet<Integer>();
		long result = 0;

		for (int i = 2; i <= N; i++) {
			int n = i;
			for (int j = 2; j <= N; j++) {
				while (n % j == 0) {
					primes.add(j);
					n /= j;
				}
			}
			result += 1L << primes.size() - 1;
		}

		return result;
	}
}
