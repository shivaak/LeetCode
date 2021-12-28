public class HouseRobber {

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println("------------");
        System.out.println(robUsingArray(new int[]{4,3,56}));
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


    public static int robUsingArray(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int[] newArr = new int[nums.length];
        newArr[0] = nums[0];
        newArr[1] = Math.max(nums[0],nums[1]);
        int max = newArr[1];
        for(int i=2;i<=newArr.length-1;i++){
            newArr[i]= Math.max(nums[i]+newArr[i-2], newArr[i-1]);
            if( newArr[i] > max){
                max= newArr[i];
            }
        }
        return max;

    }
    
}
