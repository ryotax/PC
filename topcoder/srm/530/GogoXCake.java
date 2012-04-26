import java.util.*;

public class GogoXCake {
	boolean[][] cake;
	boolean[][] goal;
	String[] cutter;
	public String solve(String[] sCake, String[] cutter) {
		int rows = sCake.length;
		int cols = sCake[0].length();
		cake = new boolean[rows][cols];
		goal = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				goal[i][j] = sCake[i].charAt(j) != 'X';
			}
		}
		this.cutter = cutter;

		for (int i = 0; i < rows - cRows + 1; i++) {
			for (int j = 0; j < cols - cCols + 1; j++) {
				cut(i, j);
			}
		}
		return Arrays.deepEquals(goal, cake) ? "YES" : "NO";
	}

	private void cut(int i, int j) {
		for (int ii = 0; ii < cRows; ii++) {
			for (int jj = 0; jj < cCols; jj++) {
				if ((!goal[i + ii][j + jj] && cutter[ii].charAt(jj) == 'X') ||
						(cake[i + ii][j + jj] && cutter[ii].charAt(jj) == 'X')) {
					return;
				}
			}
		}

		for (int ii = 0; ii < cRows; ii++) {
			for (int jj = 0; jj < cCols; jj++) {
				cake[i + ii][j + jj] |= cutter[ii].charAt(jj) == 'X';
			}
		}
	}
}
