import java.util.Arrays;

public class MaxEnvelopeFind {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }

        // Sort envelopes by width (w) in ascending order and height (h) in descending order
        Arrays.sort(envelopes, (a, b) -> {
            int w1 = a[0], h1 = a[1];
            int w2 = b[0], h2 = b[1];
            if (w1 == w2) {
                return h2 - h1; // Sort heights in descending order if widths are equal
            }
            return w1 - w2; // Sort widths in ascending order
        });

        // Use a DP array to find the longest increasing subsequence of heights
        int[] dp = new int[n];
        int length = 0;

        for (int i = 0; i < n; i++) {
            int h = envelopes[i][1]; // Extract height
            int index = Arrays.binarySearch(dp, 0, length, h);

            // If height is not found, binarySearch returns (-insertion_point - 1)
            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = h; // Place the height at the found or new position

            // If the height is placed at the end, increase the length of LIS
            if (index == length) {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        MaxEnvelopeFind solution = new MaxEnvelopeFind(); // Fixed the class instantiation

        // Example input
        int[][] envelopes = {
            {5, 4}, // w=5, h=4
            {6, 4}, // w=6, h=4
            {6, 7}, // w=6, h=7
            {2, 3}  // w=2, h=3
        };

        // Find the maximum number of envelopes
        int result = solution.maxEnvelopes(envelopes);

        // Output the result
        System.out.println("Maximum number of envelopes: " + result);
    }
}

// T.c =o(nlogn)  && S.C=o(n) ->bcoz 1dp array taken for space 
