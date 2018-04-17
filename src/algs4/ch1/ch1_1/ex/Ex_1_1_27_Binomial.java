package algs4.ch1.ch1_1.ex;

/**
 * 二项分布是n个独立的是/非试验中成功的次数的离散概率分布，其中每次试验的成功概率为p。
 * 这样的单次成功/失败试验又称为伯努利试验。
 * 实际上，当n=1时，二项分布就是伯努利分布，二项分布是显著性差异的二项试验的基础
 * Created by John Farrell on 2017/11/25.
 */
public class Ex_1_1_27_Binomial {

    /**
     * N次试验发生k次的概率：P(N,K)=（1-p）f(N-1,k)+p* f(N-1,K-1）。
     *
     * @param N
     * @param k
     * @param p
     * @return
     */
    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }

        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double betterBinomial(int N, int k, double p) {
        for (int i = 0; i <= k; i++) {

        }

        return 0.0;
    }
}
