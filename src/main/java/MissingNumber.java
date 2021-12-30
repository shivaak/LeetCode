import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {

        System.out.println(missingNumberBitWise(new int[] {0,1,3}));
    }

    public static int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = (nums.length * (nums.length+1))/2;
        return total-sum;
    }

    public static int missingNumberBitWise(int[] nums) {
        /*
         ^ -> xor
         a^a=0
         0^0=0
         a^0=a
         0^a=a
         a^b^b = a
         */

        int xor=0;
        for(int i=0;i<=nums.length-1;i++){
            xor = xor ^ (i+1) ^ nums[i];
        }
        return xor;
    }

}
