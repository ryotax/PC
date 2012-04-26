import java.util.*;

public class KingSort {
	public String[] getSortedList(String[] kings) {
		Arrays.sort(kings, new KingComparator());
		return kings;
	}

	class KingComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			String[] ss1 = s1.split(" ");
			String[] ss2 = s2.split(" ");

			if (!ss1[0].equals(ss2[0])) {
				return ss1[0].compareTo(ss2[0]);
			}

			return parse(ss1[1]) - parse(ss2[1]);
		}

		public int parse(String s) {
			if (s.equals("L")) {
				return 50;
			} else if (s.startsWith("XL")) {
				return 40 + parse(s.substring(2));
			} else if (s.startsWith("XXX")) {
				return 30 + parse(s.substring(3));
			} else if (s.startsWith("XX")) {
				return 20 + parse(s.substring(2));
			} else if (s.startsWith("X")) {
				return 10 + parse(s.substring(1));
			} else if (s.equals("IX")) {
				return 9;
			} else if (s.equals("VIII")) {
				return 8;
			} else if (s.equals("VII")) {
				return 7;
			} else if (s.equals("VI")) {
				return 6;
			} else if (s.equals("V")) {
				return 5;
			} else if (s.equals("IV")) {
				return 4;
			} else if (s.equals("III")) {
				return 3;
			} else if (s.equals("II")) {
				return 2;
			} else if (s.equals("I")) {
				return 1;
			} else {
				return 0;
			}
		}

		public boolean equals(Object o) {
			return o == this;
		}
	}
}
