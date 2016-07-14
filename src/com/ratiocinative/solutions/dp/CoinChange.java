package com.ratiocinative.solutions.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new HashMap<>());
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount == 0) {
            return 0;
        }

        if (map.containsKey(amount)) {
            return map.get(amount);
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int rem = amount - coins[i];
                if (rem >= 0) {
                    int change = coinChange(coins, rem, map);
                    if (change >= 0) {
                        change = change + 1;
                        if (change < min) {
                            min = change;
                        }
                    }

                }
            }
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            map.put(amount, min);
            return min;
        }
    }
}

