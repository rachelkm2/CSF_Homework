import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class CoinCounter {
    public static int CHANGE_NOT_POSSIBLE_FLAG = Integer.MAX_VALUE;
    private int[] denominations;

    private CoinCounter() {
        super();
    }

    /**
     * Creates a new instance with the desired coin denominations. All future calculations will use
     * these coin denominations.
     *
     * @param denominations Integer value coin denominations. They do not have to be sorted, but all must be > 0.
     *                      This is copied and stored locally.
     */
    public CoinCounter(int[] denominations) {
        this.denominations = Arrays.copyOf(denominations, denominations.length);
        Arrays.sort(this.denominations);
    }

    /**
     * Returns the number of coins required to make change for a given value.
     *
     * Memoized algorithm solution.
     *
     * @param totalSum The total value in coins that must be made change for.
     * @return The total number of coins that are needed to make change for totalSum.
     */
    public int numberOfCoinsRequired(int totalSum) {
        /*
            While our simpleNumberOfCoinsRequired works for most
            sane currency denominations, it does not work for all currencies.
            Consider a currency with the denominations 1, 5, 7 and 20.
            Our previous algorithm would say that 3 coins were needed to make
            change for 10, when in fact 2 is the actual solution (2 coins of value 5).

            We must take a different approach to solve for this. Instead of a 'greedy'
            algorithm, we will use memoization.

            Our algorithm must do the following:
                * For each possible value, from 1 to totalSum
                 * If that value is a coin denomination, it's required count is 1
                 * If not, examine that value minus all possible denominations
                    * e.g. If the value was 8, you would look at the number of coins
                      required for 8 - 7, 8 - 5 and 8 - 1.
                 * Take the smallest of those values, plus one
                 * Repeat
                * Return the calculated value for totalSum

            First assignment: Make testNumberOfCoinsRequired pass
            Second assignment: Make testWonderlandDenominations pass
            Third assignment: Make testTerribleDenominations pass
         */

        // Speed, O(m * n), m = totalSum, n = number of coins
        int[] numberOfCoinsRequiredAtValue = new int[totalSum + 1];

        for (int i = 1; i < numberOfCoinsRequiredAtValue.length; i++) {
            int minimumPreviousValue = CHANGE_NOT_POSSIBLE_FLAG;
            for (int coinValue : this.denominations) {
                if (coinValue == i) {
                    minimumPreviousValue = 1;
                    break;
                } else if (coinValue < totalSum && i - coinValue > 0) {
                    int value = numberOfCoinsRequiredAtValue[i - coinValue];
                    if (value != CHANGE_NOT_POSSIBLE_FLAG)
                        minimumPreviousValue = Math.min(minimumPreviousValue, value + 1);
                } else
                    break;
            }
            numberOfCoinsRequiredAtValue[i] = minimumPreviousValue;
        }

        return numberOfCoinsRequiredAtValue[totalSum];
    }

    int recursiveNumberOfCoinsRequired(int totalSum) {

        //Base cases :equal to 0 :equal to denominations :less than least possible denomination

        if (totalSum == 0){
            return 0;
        }

        if (totalSum < denominations[0]){
            return CHANGE_NOT_POSSIBLE_FLAG;
        }

        for(int i = 0; i <= (denominations.length - 1); i++){
            if (totalSum == denominations[i]){
                return 1;
            }
        }

        int lowestValue = 0;
        //recursive step :value - each currency :take the minimum of all
        for(int i = 0; i <= (denominations.length - 1); i++){
            int checkValue = recursiveNumberOfCoinsRequired(totalSum - denominations[i]);
            if (lowestValue == 0){
                lowestValue = checkValue;
            } else if (checkValue < lowestValue){
                lowestValue = checkValue;
            }
        }


        /*
        TODO: Create a recursive numberOfCoinsRequired method, making the unit tests pass.
         - The algorithm is:
           There are denominations and a desired amount, n.
           Get the number of coins required for n minus each denomination.
           The number of coins needed for n is equal to the least of those values, plus one.

         - What are your base cases?
         - What is your recursive step?
         */
        if (lowestValue == CHANGE_NOT_POSSIBLE_FLAG){
            return CHANGE_NOT_POSSIBLE_FLAG;
        }

        return lowestValue + 1;
    }
}
