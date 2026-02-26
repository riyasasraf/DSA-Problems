package Otheres;
// There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

// The operation of drinking a full water bottle turns it into an empty bottle.

// Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

// Example 1:

// Input: numBottles = 9, numExchange = 3
// Output: 13
// Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
// Number of water bottles you can drink: 9 + 3 + 1 = 13.
// Example 2:

// Input: numBottles = 15, numExchange = 4
// Output: 19
// Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
// Number of water bottles you can drink: 15 + 3 + 1 = 19.

//solution
// Start with numBottles → drink all of them → they become empty.

// While empty >= numExchange:

// Exchange empty / numExchange bottles.

// Add them to total.

// Update empty = exchanged + (empty % numExchange).

// Stop when you can’t exchange anymore.

public class WaterBottles {
  public static void main(String[] args) {
    numWaterBottles(12, 4);
  }

  public static int numWaterBottles(int numBottles, int numExchange) {

    int empty = numBottles;
    int total = empty;

    while (empty >= numExchange) {

      int remining = empty / numExchange;

      total += remining;
      empty = remining + (empty % numExchange);

    }
    return total;

  }

}
