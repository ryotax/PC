import java.util.*; 

public class KindAndCruel { 
	public int crossTheField(String field, int K, int C) { 
		int len = field.length(); 
		boolean[] prev = new boolean[len];
		prev[0] = true; 

		for (int sec = 1; sec < 50 * 50 * 50; sec++) { 
			boolean[] curr = new boolean[len];
			curr[0] = true; 

			boolean enableK = sec % K != 0; 
			boolean enableC = sec % C == 0; 
			for (int p = 1; p < len; p++) { 
				char c = field.charAt(p);
				if (c == '.' || (c == 'K' && enableK) || (c == 'C' && enableC)) {
					curr[p] = prev[p] || prev[p - 1]; 
				}
			} 
			if (curr[len - 1]) { 
				return sec; 
			} 
			prev = curr;
		} 
		return -1; 
	} 
}
