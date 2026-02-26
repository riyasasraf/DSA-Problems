import java.util.Arrays;

public class CoinsChange {
    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins, (b, a) -> {
        // });
        int count = 0;
        int i = 0;

        while (amount > 0 && i < coins.length) {
            if (coins[i] <= amount) {
                amount -= coins[i];
                count++;
            } else {
                i++;
            }
        }
        if (amount > 0 || amount < 0) {
            return -1;
        }
        return count;

    }

}
