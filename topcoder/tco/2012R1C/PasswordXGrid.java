public class PasswordXGrid {
	int[][] grid;
	String[] horizontal;
	String[] vertical;
	public int minSum(String[] horizontal, String[] vertical) {
		int rows = horizontal.length;
		int cols = vertical[0].length();

		this.horizontal = horizontal;
		this.vertical = vertical;
		this.grid = new int[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				grid[r][c] = Math.max(horizontalCost(r, c), verticalCost(r, c));
			}
		}
		return grid[rows - 1][cols - 1];
	}

	private int horizontalCost(int r, int c) {
		if (c != 0) {
			return grid[r][c - 1] + (horizontal[r].charAt(c - 1) - '0');
		} else {
			return 0;
		}
	}

	private int verticalCost(int r, int c) {
		if (r != 0) {
			return grid[r - 1][c] + (vertical[r - 1].charAt(c) - '0');
		} else {
			return 0;
		}
	}
}
