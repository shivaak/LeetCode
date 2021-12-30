import java.util.HashMap;
import java.util.Map;

public class CoinChange322 {

    private static Map<Integer, Integer> mem = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
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
}
