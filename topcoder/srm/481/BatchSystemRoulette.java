import java.util.*;

public class BatchSystemRoulette {
    public double[] expectedFinishTimes(int[] duration, String[] user) {
        int n = duration.length;
        Map<String, Long> map = new HashMap<String, Long>();
        for (int i = 0; i < n; i++) {
            Long total = map.get(user[i]);
            if (total == null) {
                map.put(user[i], (long)duration[i]);
            } else {
                map.put(user[i], total + duration[i]);
            }
        }

        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            long self = map.get(user[i]);
            for (int j = 0; j < n; j++) {
                long opp = map.get(user[j]);
                if (i == j) {
                    result[i] += duration[j];
                } else if (self > opp) {
                    result[i] += duration[j];
                } else if (self == opp) {
                    result[i] += (double)duration[j] / 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BatchSystemRoulette().expectedFinishTimes(
            new int[] {3, 2, 4, 1},
            new String[] {"Gil Grissom", "Sarah Sidle", "Warrick Brown", "Catherine Willows"})));
    }
}
