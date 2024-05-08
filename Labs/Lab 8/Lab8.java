public class Lab8 {
    public int coinChange(int[] coins, int amount) {
        int [] dpArray = new int[amount + 1];
        for (int i = 1; i < dpArray.length; i++){
            dpArray[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j < dpArray.length; j++){
                if (dpArray[j - coins[i]] != Integer.MAX_VALUE){
                    if (dpArray[j - coins[i]] < dpArray[j]){
                        dpArray[j] = dpArray[j - coins[i]] + 1;
                    }
                }
            }
        }
        if (dpArray[amount] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dpArray[amount];
        }
    }
}
