import java.util.PriorityQueue;

public class KthLargetNumber215 {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minQ = new PriorityQueue<>();


        for(int i=0;i<=nums.length-1;i++){
            minQ.add(nums[i]);

            if(minQ.size()>k){
                minQ.poll();
            }
        }
        return minQ.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{7,4,6,9},3));
    }
}
