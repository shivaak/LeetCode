import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    private static Map<Integer, Integer> mem = new HashMap<>();
    public static int climbStairsMem(int n) {
        if(n==0){
            return 1;
        }
        if(mem.containsKey(n)){
            return mem.get(n);
        }
        int result  = 0;
        if(n-1>=0){
            result = result + climbStairsMem(n-1);
        }
        if(n-2>=0){
            result = result + climbStairsMem(n-2);
        }
        mem.put(n, result);
        return result;

    }

    public static  int climbStairsTab(int n){
        int arr[] = new int[n+1];
        arr[0]=0;
        for(int i=1;i<=n;i++){
            if(i==1){ arr[i]=1; continue; }
            if(i==2){ arr[i]=2; continue; }
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(climbStairsMem(n));
        System.out.println(climbStairsTab(n));
    }
}
