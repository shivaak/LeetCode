import java.util.HashMap;
import java.util.Map;

public class CoinChange322 {

    private static Map<Integer, Integer> mem = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(coinChangeDP(new int[]{1,2,5}, 11));
    }
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if(mem.containsKey(amount)){
            return mem.get(amount);
        }

        int min = amount+1;
        for (int i = 0; i <= coins.length - 1; i++) {
            int coinsReqd  = coinChange(coins, amount - coins[i]);
            if(coinsReqd>=0) {
                min = Math.min(min, coinsReqd + 1);
            }
        }
        if(min>amount){
            min=-1;
        }
        mem.put(amount,  min);
        return  mem.get(amount);
    }

    public static int coinChangeDP(int[] coins, int amount){
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=dp.length-1;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=dp.length-1;i++){
           for(int j=0;j<=coins.length-1;j++){
               if(i - coins[j] >= 0){
                   dp[i]=Math.min(1+dp[i-coins[j]] , dp[i]);
               }
           }
        }
        return dp[amount];
    }
}
