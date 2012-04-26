import java.util.*;
public class WhatsThisChord {
	private static String[] NOTES = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	private static int[] MAJOR = new int[] {0, 4, 7};
	private static int[] MINOR = new int[] {0, 3, 7};
	private static int[] INIT = new int[] {4, 9, 2, 7, 11, 4};
	public String classify(int[] chord) {
		List<Integer> l = play(chord);
		System.out.println(l);
		if (l.size() != 3) {
			return "";
		}

		for (int i = 0; i < 3; i++) {
			if (((l.get(i) + MAJOR[1]) % 12 == l.get((i + 1) % 3)) &&
				((l.get(i) + MAJOR[2]) % 12 == l.get((i + 2) % 3))) {
				return NOTES[l.get(i)] + " Major";
			}
			if (((l.get(i) + MINOR[1]) % 12 == l.get((i + 1) % 3)) &&
				((l.get(i) + MINOR[2]) % 12 == l.get((i + 2) % 3))) {
				return NOTES[l.get(i)] + " Minor";
			}
		}
		return "";
	}

	private List<Integer> play(int[] chord) {
		Set s = new HashSet<Integer>();
		for (int i = 0; i < chord.length; i++) {
			if (chord[i] == -1) {
				continue;
			}

			s.add((INIT[i] + chord[i]) % 12);
		}
		List<Integer> l = new ArrayList(s);
		Collections.sort(l);
		return l;
	}
}
