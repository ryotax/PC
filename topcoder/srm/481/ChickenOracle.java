public class ChickenOracle {
    public String theTruth(int n, int eggCount, int lieCount, int liarCount) {
        boolean factEgg = false;

        // nXY means nOracleAnswer
        // factEgg
        int x = n - eggCount - liarCount + lieCount;
        if (x % 2 == 0) {
            int nChiChi = x / 2;
            int nChiEgg = lieCount - nChiChi;
            int nEggEgg = n - liarCount - nChiChi;
            int nEggChi = liarCount - nChiEgg;
            if (nChiChi >= 0 && nChiEgg >= 0 && nEggEgg >= 0 && nEggChi >= 0) {
                factEgg = true;
            }
        }

        boolean factChi = false;
        x = 2 * n - eggCount - liarCount - lieCount;
        if (x % 2 == 0) {
            int nChiChi = x / 2;
            int nChiEgg = n - lieCount - nChiChi;
            int nEggEgg = lieCount - (liarCount - nChiEgg);
            int nEggChi = liarCount - nChiEgg;
            if (nChiChi >= 0 && nChiEgg >= 0 && nEggEgg >= 0 && nEggChi >= 0) {
                factChi = true;
            }
        }

        if (factEgg) {
            if (factChi) {
                return "Ambiguous";
            } else {
                return "The egg";
            }
        } else {
            if (factChi) {
                return "The chicken";
            } else {
                return "The oracle is a lie";
            }
        }
    }
}
