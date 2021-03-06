import java.util.HashSet;
import java.util.Set;

/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.*/

public class SingleNumber136 {
    public static void main(String[] args) {
        System.out.println(singleNumberConstantMem(new int[]{2,2,1,8,8}));
        int a = 6 ^ 5;
        System.out.println(a);

    }

    public static int singleNumberConstantMem(int[] nums) {
        int result = 0;
        for (int num : nums){
            result = result ^ num;
        }
        return result;
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<=nums.length-1;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }
}
