import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,2,4,3}));
      //  System.out.println(lengthOfLISDynamic(new int[]{2,2,2,2,2}));
    }

    private static  Map<Integer, Integer> cache = new HashMap<>();

    public static int lengthOfLIS(int[] nums) {
        int max=0;
        for(int i=0;i<=nums.length-1;i++){
            max = Math.max(max, lengthOfLIS(nums, i));
        }
        return max;
    }

    public static int lengthOfLIS(int[] nums, int i) {
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        int max=0;
        for(int j=i+1;j<=nums.length-1;j++){
            if(nums[j]>nums[i]){
                max = Math.max(max, lengthOfLIS(nums,j));
            }
        }
        cache.put(i, 1+max);
        return 1 + max;
    }


    public static int lengthOfLISDynamic(int[] nums) {
        int arr[] = new int[nums.length];
        for(int i=0;i<=arr.length-1;i++){
            arr[i]=1;
        }
        int max = arr[0];
        for(int i=0;i<=nums.length-1;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    arr[i]=Math.max(1+arr[j],arr[i]);
                }
                max = Math.max(max, arr[i]);
            }
        }
        return max;
    }
}
