import java.io.*;
import java.math.*;
import java.util.*;

public class SmallA {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("out.txt");
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			String[] inputs = br.readLine().split(" ");
			boolean result = light(Integer.parseInt(inputs[0]), new BigInteger(inputs[1]));
			fw.write("Case #" + (i + 1) + ": " + (result ? "ON" : "OFF") + "\n");
		}

		fr.close();
		fw.close();
	}

	public static boolean light(int n, BigInteger k) {
		for (int i = 0; i < n; i++) {
			if (!k.testBit(i)) {
				return false;
			}
		}
		return true;
	}
}
