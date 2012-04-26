import java.util.*;

public class ColorfulCards {
    public int[] theCards(int N, String colors) {
        boolean[] cards = toCards(colors);
        boolean[] primes = toPrimes(N);

        System.out.println(Arrays.toString(cards));
        System.out.println(Arrays.toString(primes));

        return null;
    }

    boolean[] toCards(String colors) {
        boolean[] cards = new boolean[colors.length()];
        for (int i = 0; i < colors.length(); i++) {
            cards[i] = colors.charAt(i) == 'R';
        }
        return cards;
    }

    boolean[] toPrimes(int N) {
        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        primes[1] = false;
        for (int i = 2; i <= N; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(new ColorfulCards().theCards(100, "RRBBRRBBRR"));
    }
}
