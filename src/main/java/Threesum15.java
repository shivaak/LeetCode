import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Threesum15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<=nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            List<List<Integer>> twoSumResult = twoSum(nums, i+1, -1*nums[i]);
            if(twoSumResult.size()>0){
                for(List<Integer> r : twoSumResult){
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.addAll(r);
                    result.add(subResult);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target){
        int l=start;
        int r=nums.length-1;

        List<List<Integer>> twoSumResult = new ArrayList<>();
        while(l<r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                twoSumResult.add(new ArrayList<Integer>(Arrays.asList(nums[l] , nums[r])));
                do{
                    r--;
                }while(nums[r]==nums[r+1] && l<r);
            }else if(sum < target){
                l++;
            }else if(sum > target){
                r--;
            }
        }

        return twoSumResult;


    }

}
