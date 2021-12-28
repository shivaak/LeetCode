public class MaximumSubArray53 {

    public static void main(String[] args) {
        //System.out.println(maxSubArrayBrutForce(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSubArraySum=nums[0];

        for(int i=1;i<=nums.length-1;i++){
            nums[i]=Math.max(nums[i-1]+nums[i], nums[i]);
            if(maxSubArraySum<nums[i]){
                maxSubArraySum=nums[i];
            }
        }
        return maxSubArraySum;
    }


    public static int maxSubArrayBrutForce(int[] nums) {
        int len = nums.length;
        int maxSubArray= 0;
        int currentMax = nums[0];

        for(int i=0;i<len;i++){
            int count = nums[i];
            if(count > currentMax){
                currentMax = count;
                maxSubArray = 1;
            }
            for(int j=i+1;j<len;j++){
                count = count + nums[j];
                if(count > currentMax){
                    currentMax = count;
                    maxSubArray = (j-i)+1;
                }
            }
        }
        return  currentMax;
    }
}
