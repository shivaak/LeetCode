public class Leetcode6027 {

    public static void main(String[] args) {
        System.out.println(countHillValley(new int[]{2,4,1,1,1,1}));

    }


    public static int countHillValley(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length-1;i++) {
            int prev = i-1;
            int next = i+1;

            if(nums[prev]==nums[i])continue;

            while(nums[i]==nums[next]){
                next++;

                if(next==nums.length) break;
            }

             if(next==nums.length) break;


            if(nums[prev]>nums[i] && nums[next]>nums[i])
                count++;
            if(nums[prev]<nums[i] && nums[next]<nums[i])
                count++;

        }
        return count;
    }
}
