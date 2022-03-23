import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSubSequence2099 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-1,-2,3,4}, 3)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(n->n[0]));

        for(int i=0;i<nums.length;i++){
            q.offer(new int[]{nums[i], i});
            if(q.size()>k){
                q.remove();
            }
        }

        return q.stream().sorted(Comparator.comparingInt(n->n[1])).mapToInt(n->n[0]).toArray();

    }
}
