import java.util.*;
public class Shopping {
	public int minNumber(int X, int[] values) {
		Arrays.sort(values);
		if (values[0] != 1) {
			return -1;
		}

		int sum = 0;
		int nCoins = 0;
		for (int coinIndex = 0; sum < X; nCoins++){
			sum += values[coinIndex];
			while (overNext(coinIndex + 1, values, sum)) {
				coinIndex++;
			}
		}
		return nCoins;
	}

	private boolean overNext(int coinIndex, int[] values, int sum) {
		return coinIndex < values.length && sum + 1 >= values[coinIndex];
	}
}
