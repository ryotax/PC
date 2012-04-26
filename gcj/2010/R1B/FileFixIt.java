import java.io.*;
import java.math.*;
import java.util.*;

public class FileFixIt {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("out.txt");
		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			String[] inputs = br.readLine().split(" ");
			int nExist = Integer.parseInt(inputs[0]);
			Set<String> exists = new HashSet<String>();
			for (int j = 0; j < nExist; j++) {
				exists.add(br.readLine());
			}

			int nCreate = Integer.parseInt(inputs[1]);
			List<String> creates = new ArrayList<String>();
			for (int j = 0; j < nCreate; j++) {
				creates.add(br.readLine());
			}

			int result = fileFixIt(exists, creates);
			fw.write("Case #" + (i + 1) + ": " + result + "\n");
		}

		fr.close();
		fw.close();
	}

	public static int fileFixIt(Set<String> existSet, List<String> createList) {
		int result = 0;
		for (String dir : createList) {
			int index = dir.length();

			while (true) {
				if (existSet.contains(dir)) {
					break;
				} else {
					// System.out.println(dir);
					result++;
					existSet.add(dir);
				}

				index = dir.lastIndexOf('/', index);
				if (index <= 0) {
					break;
				}

				String parent = dir.substring(0, index);
				dir = parent;
			}
		}
		return result;
	}
}
