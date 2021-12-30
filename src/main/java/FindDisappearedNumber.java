import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumber {

    public static void main(String[] args) {
     //   System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDisappearedNumbersConstantMem(new int[]{4,3,2,7,8,2,3,1}));
    }

    private static List<Integer> findDisappearedNumbersConstantMem(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0;i<=nums.length-1;i++){
            int abs = Math.abs(nums[i]);
            if(nums[abs-1] >0) {
                nums[abs - 1] = nums[abs - 1] * -1;
            }
        }

        for(int i=0;i<=nums.length-1;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }

        return result;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] newArr = new int[nums.length+1];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=nums.length-1;i++){
            newArr[nums[i]]=1;
        }
        for(int i=1;i<=newArr.length-1;i++){
            if(newArr[i]!=1){
                result.add(i);
            }
        }
        return result;
    }
}
