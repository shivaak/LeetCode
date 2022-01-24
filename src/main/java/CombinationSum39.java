import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target==0){
            return result;
        }

        List<Integer> subList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates,target, 0, subList);
        return result;
    }

    public static void combinationSum(int[] candidates, int target, int start, List<Integer> subList) {

        if(target==0){
            result.add(new ArrayList<>(subList));
        }else if(target<0){
            return;
        }

        for(int i=start;i<=candidates.length-1;i++){
            if(candidates[i]>target){
                break;
            }

            subList.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], i, subList);
            subList.remove(subList.size()-1);
        }
    }
}
