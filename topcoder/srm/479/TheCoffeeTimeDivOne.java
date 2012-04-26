public class TheCoffeeTimeDivOne {
    public long find(int n, int[] tea) {
        boolean[] isTea = new boolean[n + 1];
        for (int i : tea) {
            isTea[i] = true;
        }

        int nTea = 0;
        int nCoffee = 0;
        long result = 0;
        for (int i = n; i > 0; i--) {
            if (isTea[i]) {
                if (nTea == 0) {
                    result += 2 * i + 47;
                    nTea = 6;
                } else {
                    nTea--;
                }
            } else {
                if (nCoffee == 0) {
                    result += 2 * i + 47;
                    nCoffee = 6;
                } else {
                    nCoffee--;
                }
            }
        }
        return result + n * 4;
    }
}
