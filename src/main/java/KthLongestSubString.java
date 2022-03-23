import java.util.PriorityQueue;

//Find kth longest substring with the same characters in the string “aaaaaabbbbccc”; For k = 2 answer is “bbbb”
public class KthLongestSubString {

    public static void main(String[] args) {
        System.out.println(findKthLongestSubString("aabbbcccc", 3));
    }

    private static String findKthLongestSubString(String str , int k) {

        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b)-> {
            return a.length() - b.length();
        });

        int[] map = new int[128];

        int start=0,end=0;
        while(end<=str.length()-1){
            final char c = str.charAt(end);

            if(start!=end && map[c]==0){
                map[str.charAt(start)]=0;
                minHeap.add(str.substring(start, end));
                if(minHeap.size()>k) minHeap.poll();
                start=end;
            }

            map[c]++;
            end++;
        }
        minHeap.add(str.substring(start, end));
        if(minHeap.size()>k) minHeap.poll();
        return minHeap.peek();
    }
}
