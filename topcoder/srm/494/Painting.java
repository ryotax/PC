import java.util.*;
public class Painting { 
	boolean[][] orig;

	public int largestBrush(String[] picture) { 
		int rows = picture.length; 
		int cols = picture[0].length(); 
		int max = Math.min(rows, cols); 

		orig = new boolean[rows][cols];
		for (int r = 0; r < rows; r++) { 
			for (int c = 0; c < cols; c++) { 
				orig[r][c] = picture[r].charAt(c) == 'B';
			}
		}

		for (int s = max; s > 1; s--) {
			boolean[][] work = new boolean[rows][cols];
			for (int r = 0; r <= rows - s; r++) { 
				for (int c = 0; c <= cols - s; c++) { 
					paintIfPossible(s, r, c, work);
				}
			}
			if (Arrays.deepEquals(orig, work)) {
				return s;
			}
		}
		return 1;
	}

	void paintIfPossible(int s, int rs, int cs, boolean[][] work) {
		for (int r = rs; r < rs + s; r++) { 
			for (int c = cs; c < cs + s; c++) { 
				if (!orig[r][c]) {
					return;
				}
			}
		}

		for (int r = rs; r < rs + s; r++) { 
			for (int c = cs; c < cs + s; c++) { 
				work[r][c] = true;
			}
		}
	}
}
