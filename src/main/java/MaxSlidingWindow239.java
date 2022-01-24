import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaxSlidingWindow239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int left=0;
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for(int right=0;right<=nums.length-1;right++){
            while(q.size()>0 && nums[q.getLast()]<nums[right]){
                q.removeLast();
            }
            q.add(right);



            if((right-left)+1>=k){
                result.add(nums[q.getFirst()]);
                left++;

                if(left>q.getFirst()){
                    q.removeFirst();
                }
            }

        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int arr[] = maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);

        for(int a : arr){
            System.out.print(a + " ");
        }

    }
}
