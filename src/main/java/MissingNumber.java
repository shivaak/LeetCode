import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {1,2,3}));
    }

    public static int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = (nums.length * (nums.length+1))/2;
        return total-sum;
    }

}
