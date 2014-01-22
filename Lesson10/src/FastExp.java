public class FastExp {
    static final int EXP_CACHE_SIZE = 100;
    static float exp_cache[] = new float[EXP_CACHE_SIZE];

    /**
     * Initializes a cache of exp() results for quantized values between 0 and 1.0.
     */
    void initExpCache() {
        for (int i = 0; i < EXP_CACHE_SIZE; i++) {
            exp_cache[i] = (float) Math.exp(-((float) i / (float) EXP_CACHE_SIZE));
        }
    }

    /**
     * Computes an approximation of the exp() function from a pre-computed cache, if possible.
     * Falls back to Math.exp() if the range if the cache is exceeded.
     *
     * @param a The input value to compute the exp() of.
     * @return A fast approximation of exp(a).
     */
    double fast_exp(double a) {
        int idx = (int) (-a * EXP_CACHE_SIZE);
        if (idx > 0 && idx < EXP_CACHE_SIZE) {
            return exp_cache[idx];
        } else {
            return Math.exp(a);
        }
    }
}
