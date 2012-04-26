import java.util.*;

public class LockersDivOne {
    public int lastOpened(int N) {
        BitSet lockers = new BitSet(N);
        lockers.set(0, N);

        int last = 0;
        int count = 0;
        int nLoop = 1;
        while (true) {
            int index = 0;

             nLoop++;
             for (int i = lockers.nextSetBit(0); i >= 0; ) {
                 lockers.set(i, false);
                 last = i;
                 count++;
                 for (int n = 0; n < nLoop; n++) {
                     i = lockers.nextSetBit(i + 1);
                     if (i < 0) {
                         break;
                     }
                 }
             }

             if (count == N) {
                 break;
             }
        }
        return last + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LockersDivOne().lastOpened(2000000));
    }
}
