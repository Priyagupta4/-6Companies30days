import java.util.*;

     public class shoppingoffer {
    
        private int encodeState(List<Integer> states) {
            int encoded = 0;
            for (int i = 0; i < states.size(); i++) {
                encoded |= states.get(i) << (4 * i);
            }
            return encoded;
        }
    
        public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<Integer, Integer> map) {
            int encodeState = encodeState(needs);
            if (map.containsKey(encodeState)) return map.get(encodeState); // use memoized result
    
            int result = 0;
            for (int i = 0; i < needs.size(); i++) {
                result += needs.get(i) * price.get(i);
            }
    
            for (List<Integer> offer : special) {
                boolean valid = true;
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++) {
                    if (needs.get(i) < offer.get(i)) {
                        valid = false;
                        break;
                    }
                    newNeeds.add(needs.get(i) - offer.get(i));
                }
                if (valid) {
                    result = Math.min(result, offer.get(price.size()) + helper(price, special, newNeeds, map));
                }
            }
    
            map.put(encodeState, result);
            return result;
        }
    
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            Map<Integer, Integer> map = new HashMap<>();
            return helper(price, special, needs, map);
        }
    
        public static void main(String[] args) {
            shoppingoffer solution = new shoppingoffer();
    
            List<Integer> price = Arrays.asList(2, 5);
            List<List<Integer>> special = Arrays.asList(
                Arrays.asList(3, 0, 5),
                Arrays.asList(1, 2, 10)
            );
            List<Integer> needs = Arrays.asList(3, 2);
    
            System.out.println("Minimum cost: " + solution.shoppingOffers(price, special, needs));
        }
    }
     

