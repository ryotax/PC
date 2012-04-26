import java.util.*;

public class OneRegister {
    public String getProgram(int s, int t) {
        if (s == t) {
            return "";
        }
        if (t == 1) {
            return "/";
        }

        Map<Long, String> map = new LinkedHashMap<Long, String>();
        map.put((long)s, "");
        while (!map.isEmpty()) {
            Map<Long, String> nextmap = new LinkedHashMap<Long, String>();

            for (Map.Entry<Long, String> entry : map.entrySet()) {
                long v = entry.getKey();

                if (v != 1) {
                    long multi = v * v;
                    String ope = entry.getValue() + "*";
                    if (multi == t) {
                        return ope;
                    } else {
                        if (multi < t) {
                            nextmap.put(multi, ope);
                        }
                    }
                }

                long add = v + v;
                String ope = entry.getValue() + "+";
                if (add == t) {
                    return ope;
                } else {
                    if (add < t && !nextmap.containsKey(add)) {
                        nextmap.put(add, ope);
                    }
                }

                if (entry.getValue().equals("")) {
                    nextmap.put(1L, "/");
                }
            }


            map = nextmap;
        }
        return ":-(";
    }

    public static void main(String[] args) {
        System.out.println(new OneRegister().getProgram(7, 9));
    }

}

