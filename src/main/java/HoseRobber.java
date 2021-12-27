public class HoseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);
        for(int i=2;i<=nums.length-1;i++){
            if(first+nums[i]>second){
                int temp = second;
                second=first+nums[i];
                first = temp;
            }else{
                first=second;
            }
        }
        return second;
    }
}
