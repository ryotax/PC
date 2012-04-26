public class RowAndCoins {
	public String getWinner(String cells) {
		String[] ca = cells.split("((?<=A)(?=B)|(?<=B)(?=A))");
		if (ca[0].charAt(0) == 'B' && ca[ca.length - 1].charAt(0) == 'B') {
			return "Bob";
		} else {
			return "Alice";
		}
	}
}
