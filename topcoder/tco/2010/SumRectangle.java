public class SumRectangle {
	public int getCorner(int[] leftColumn, int[] topRow) {
		int[] currentRow = topRow;
		int[] nextRow = new int[topRow.length];
		for (int r = 1; r < leftColumn.length; r++) {
			nextRow[0] = leftColumn[r];
			for (int c = 1; c < topRow.length; c++) {
				nextRow[c] = currentRow[c - 1] - nextRow[c - 1] - currentRow[c];
			}
			currentRow = nextRow;
			nextRow = new int[topRow.length];
		}
		return currentRow[currentRow.length - 1];
	}
}
