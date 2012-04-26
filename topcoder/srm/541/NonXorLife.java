import java.util.*;

public class NonXorLife {
	public int countAliveCells(String[] field, int K) {
		BitSet[] plane = new BitSet[3000 + 50];
		for (int i = 0; i < plane.length; i++) {
			plane[i] = new BitSet(3000 + 50);
		}

		for (int y = 0; y < field.length; y++) {
			for ( int x = 0; x < field[0].length(); x++) {
				if (field[y].charAt(x) == 'o') {
					int xx = 1500 + x;
					int yy = 1500 + y;
					for (int cy = yy - K; cy <= yy + K; cy++) {
						int width = K - Math.abs(cy - yy);
						plane[cy].set(xx - width, xx + width + 1);
					}
				}
			}
		}

		int result = 0;
		for (BitSet bs: plane) {
			if (bs.cardinality() != 0) {
				System.out.println(bs.cardinality());
			}
			result += bs.cardinality();
		}
		return result;
	}
}
