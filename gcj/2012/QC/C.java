import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C-large-practice.in"));
		br.readLine();
		String l;
		int i = 1;
		while((l = br.readLine()) != null) {
			String[] sa = l.split(" ");
			int n = count(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]));
			System.out.println("Case #" + i + ": " + n);
			i++;
		}
		br.close();
	}

	public static int count(int a, int b) {
		int ret = 0;
		for (int i = a; i < b; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int order = (int)Math.pow(10, Integer.toString(i).length());
			for (int j = 10; j <= b; j *= 10) {
				int recycled = (i % j) * (order / j) + (i / j);
				if (i < recycled && recycled <= b) {
					set.add(recycled);
				}
			}
			ret += set.size();
		}
		return ret;
	}
}
