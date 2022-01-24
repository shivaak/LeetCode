
// Smallest sub array with sum >= k

public class SmallestSubArray {

    public static int smallestSubArray(int[] nums, int k){
        int currentWindowSum=0;
        int left=0;
        int minSubArrayLength = Integer.MAX_VALUE;
        for(int right=0;right<=nums.length-1;right++){
            currentWindowSum = currentWindowSum + nums[right];
            while(currentWindowSum>=k){
                minSubArrayLength = Math.min(minSubArrayLength, (right-left)+1);
                currentWindowSum = currentWindowSum - nums[left];
                left++;
            }
        }

        return minSubArrayLength;
    }

    public static void main(String[] args) {
        int result = smallestSubArray(new int[]{4,2,2,7}, 1);
        System.out.println(result);
    }
}
