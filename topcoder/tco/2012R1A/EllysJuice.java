import java.util.*;

public class EllysJuice {
	public String[] getWinners(String[] players) {
		if (players.length == 1) {
			return players;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String p : players) {
			Integer i = map.get(p);
			if (i == null) {
				map.put(p, 1);
			} else {
				map.put(p, i + 1);
			}
		}

		List<String> l = new ArrayList<String>();

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() > 1) {
				l.add(e.getKey());
			}
		}
		Collections.sort(l);

		return l.toArray(new String[0]);
	}
}
