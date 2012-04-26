import static java.lang.Math.abs;
public class RandomColoringDiv2 {
	public int getCount(int maxR, int maxG, int maxB, int startR, int startG, int startB, int d1, int d2) {
		int result = 0;
		for (int r = 0; r < maxR; r++) {
			for (int g = 0; g < maxG; g++) {
				for (int b = 0; b < maxB; b++) {
					if ((abs(r - startR) >= d1 || abs(g - startG) >= d1 || abs(b - startB) >= d1) &&
						(abs(r - startR) <= d2 && abs(g - startG) <= d2 && abs(b - startB) <= d2)) {
						result++;
					}
				}
			}
		}
		return result;
	}
}
