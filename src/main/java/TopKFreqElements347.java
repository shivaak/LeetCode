import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqElements347 {
    public static void main(String[] args) {
        int res[] = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        for(int i=0;i<=res.length-1;i++){
            System.out.println(res[i]);
        }

    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<=nums.length-1; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->{
            return map.get(a) -  map.get(b);
        });
        for(int key: map.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        while(heap.size()>0){
            res[--k]=heap.poll();
        }
        return res;
    }
}
