import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MicrosoftCodility2 {

    public static void main(String[] args) {
    //   System.out.println(solution(new String[]{"039","4","14", "32","", "34", "7"}));
      //  System.out.println(solution(new String[]{"5421","245","1452", "0345","53", "354"}));
       System.out.println(solution(new String[]{"801234567","180234567","0", "189234567","891234567", "98","9"}));
    }

    public static  int solution(String[] E) {
        int[] days = new int[10];
        Map<Integer, List<Integer>> prefMap = new HashMap<>();

        int eid=0;
        for(String pref : E){
            char[] prefArr = pref.toCharArray();
            for(int i=0;i<prefArr.length;i++){
                final int c = prefArr[i] - '0';
                days[c]++;
                prefMap.putIfAbsent(c, new ArrayList<>());
                prefMap.get(c).add(eid);
            }
            eid++;
        }

        System.out.println(Arrays.toString(days));
        System.out.println(prefMap);

        int max=Integer.MIN_VALUE;
        for(Integer lkey : prefMap.keySet()){
            for(Integer rkey : prefMap.keySet()){
                if(lkey==rkey){
                    continue;
                }
                Set<Integer> mergedSet = new HashSet<>();
                mergedSet.addAll(prefMap.get(lkey));
                mergedSet.addAll(prefMap.get(rkey));
                max = Math.max(max,mergedSet.size());
            }
        }
        return max;
    }
}
