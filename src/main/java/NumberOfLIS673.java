import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NumberOfLIS673 {

    public static void main(String[] args) {
        //NOT WORKING
        System.out.println(findNumberOfLIS(new int[]{1,2,4,3}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        for(int i=0;i<=arr.length-1;i++){
            arr[i]=1;
        }

        int counter[] = new int[nums.length];
        for(int i=0;i<=counter.length-1;i++){
            counter[i]=1;
        }

        int max=0;
        for(int i=0;i<=nums.length-1;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    arr[i]= Math.max(1+arr[j],arr[i]);
                }
                max = Math.max(max,arr[i]);
            }
            counter[max] +=1;
        }
        System.out.println(max);
        return counter[max];
    }


}
