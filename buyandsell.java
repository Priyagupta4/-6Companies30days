class buyandsell {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // If k >= n/2, it's the unlimited transaction problem
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // DP array
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int maxPrev = -prices[0]; // Max value of dp[t-1][j] - prices[j]
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxPrev); // No transaction vs Sell on day i
                maxPrev = Math.max(maxPrev, dp[t - 1][i] - prices[i]);  // Update maxPrev for the next day
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        // Example input
        int k = 2; // Maximum number of transactions
        int[] prices = {3, 2, 6, 5, 0, 3}; // Stock prices for each day

        // Calculate maximum profit
        int result = maxProfit(k, prices);

        // Print the result
        System.out.println("Maximum profit: " + result);
    }
}

//tc o(k.n) and sc = o(n)