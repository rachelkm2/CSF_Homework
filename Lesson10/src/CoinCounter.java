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
     * Greedy algorithm solution.
     *
     * @param totalSum The total value in coins that must be made change for.
     * @return The total number of coins that are needed to make change for totalSum.
     */
    public int simpleNumberOfCoinsRequired(int totalSum) {
        /*
            To calculate the number of coins required to give change in
            most sane coin denominations, a simple 'greedy' algorithm
            is sufficient.

            Imagine you need to give change for 42 cents in America.
            First you would take a quarter; you'll  need 17 more cents for change.
            Second you take a dime; you'll need 7 more cents for change.
            Third you take a nickle; you'll need 2 more cents for change.
            Fourth you take a penny; you'll need 1 more cent for change.
            Fifth you take another penny; you're all done making change, and you needed 5 coins.

            For most currency denominations, we can generalize the rule for giving change:
                * When giving change, always take the largest value coin that's less than the
                change you need to give (e.g. if you need 42, take a quarter. If you have 8, take a nickle).
                * Subtract that amount from the total amount of change you need to give.
                * Repeat.

            Assignment: Implement this algorithm below and make testSimpleNumberOfCoinsRequired pass.
         */

        throw new NotImplementedException();
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
            Our previous algorithm would say that 4 coins were needed to make
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

        throw new NotImplementedException();
    }
}
