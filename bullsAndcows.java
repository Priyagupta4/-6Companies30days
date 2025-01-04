
import java.util.HashMap;
public class bullsAndcows {
    
     public String getHint(String secret, String guess) {
        // Initialize the variables
        int cows = 0;
        int bulls = 0;

        // HashMap used to store unmatched characters of secret and guess
        HashMap<Character, Integer> s = new HashMap<>();
        HashMap<Character, Integer> g = new HashMap<>();

        // Traverse through the characters of the strings
        for (int i = 0; i < secret.length(); i++) {
            char schr = secret.charAt(i);
            char gchr = guess.charAt(i);

            // Check if each character matches directly
            if (schr == gchr) {
                bulls++;
            } else {
                // Add the characters to HashMaps with counts
                s.put(schr, s.getOrDefault(schr, 0) + 1);
                g.put(gchr, g.getOrDefault(gchr, 0) + 1);
            }
        }

        // Calculate the number of cows
        for (char ch : s.keySet()) {
            if (g.containsKey(ch)) {
                // Take the minimum count of a character between secret and guess
                cows += Math.min(s.get(ch), g.get(ch));
            }
        }

        // Return the result in the required format
        return bulls + "A" + cows + "B";
    }

    // Main method to test the code
    public static void main(String[] args) {
        bullsAndcows solution = new bullsAndcows();

        // Example input
        String secret = "1807"; // The secret number
        String guess = "7810";  // The guess

        // Get the hint
        String result = solution.getHint(secret, guess);

        // Output the result
        System.out.println("Hint: " + result); // Output should be "1A3B"
    }
}


