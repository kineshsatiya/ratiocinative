package com.ratiocinative.solutions.dp;

public class CuttingRod {

    /**
     * Get the max revenue that can be obtained by the cutting a rod of size n.
     * The run time of this method is exponential 2^(n-1)
     *
     * @param n
     *            size of the rod
     * @param p
     *            array of prices
     * @return
     */
    public int cutRod(int n, int[] p) {
        if (n <= 0) {
            return 0;
        }

        int maxRevenue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int revenue = p[i-1] + cutRod(n - i, p);
            if (maxRevenue < revenue) {
                maxRevenue = revenue;
            }
        }
        return maxRevenue;
    }

    public static void main(String[] args) {
        CuttingRod cuttingRod = new CuttingRod();
        int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
        System.out.println(cuttingRod.cutRod(10, prices));
    }
}
