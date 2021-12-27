import java.util.HashMap;
import java.util.Map;

public class MinStepForOne {

    private static Map<Integer,Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        int n=10000;
        //System.out.println(getMinStepsMemo(n));
        System.out.println(getMinStepsTab(n));
    }

    public static int getMinStepsTab(int n){
        int[] arr = new int[n+1];
        arr[1]=0;

        for(int i=1;i<=n;i++){
            assignValue(arr, i+1, i, n);
            assignValue(arr, i*2, i, n);
            assignValue(arr, i*3, i, n);
        }
        return arr[n];
    }

    private static void assignValue(int[] arr, int ptr, int i,int n) {
        if(ptr<=n){
            if(arr[ptr]==0){
                arr[ptr] = arr[i] +1;
            }else{
                arr[ptr] = Math.min(arr[ptr],arr[i] +1 );
            }
        }
    }
    public static int getMinStepsMemo(int n){
        if(n==1){
            return 0;
        }
        if(cache.containsKey(n)){
           return cache.get(n);
        }
        int divideBy3 = n%3==0 ? getMinStepsMemo(n/3) : Integer.MAX_VALUE;
        int divideBy2 = n%2==0 ? getMinStepsMemo(n/2) : Integer.MAX_VALUE;
        int minusOne = getMinStepsMemo(n-1);

        int result = Math.min(minusOne , Math.min(divideBy2, divideBy3)) + 1;
        cache.put(n,result);
        return result;
   }
}
