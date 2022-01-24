public class MinimumSwaps2134 {

    public static void main(String[] args) {

        System.out.println(minSwaps(new int[]{0,1,1,1,0,0,1,1,0}));
    }

    public static int minSwaps(int[] nums) {

        int k = 0;
        for(int i=0;i<=nums.length-1;i++){
            if(nums[i]==1){
                k++;
            }
        }
        if(k==0){
            return 0;
        }

        int left=0;
        int numOfOnes=0;
        int minReqd=Integer.MAX_VALUE;
        int arrLength = nums.length;

        for(int right=0;left<=((arrLength-1)+k)-1;right++){
            int rIndex = right % arrLength;
            int lIndex = left % arrLength;

            if(nums[rIndex]==1){
                numOfOnes++;
            }


            if((right-left)+1==k){

                if(numOfOnes<=k){
                    minReqd = Math.min(minReqd, k - numOfOnes);
                }
                numOfOnes = nums[lIndex]==1 ? numOfOnes-1 : numOfOnes;
                left++;
            }
        }

        return minReqd;


    }
}
