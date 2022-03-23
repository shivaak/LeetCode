import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramicPairs {

    public static void main(String[] args) {
        //Expected output: [[1,4], [2,3]]
        List<List<String>> anagramicPair = findAnagramicPairs(new String[]{"zip"});
        System.out.println(anagramicPair);
    }

    private static List<List<String>> findAnagramicPairs(String[] strings) {

        Map<String, List<String>> pairMap = new HashMap<>();
        for(String str : strings){
            char[] c = str.toCharArray();
            char[] freqKey = new char[26];
            for(int i=0;i<=c.length-1;i++){
                freqKey[c[i]-'a']++;
            }
            String keyStr = String.valueOf(freqKey);
            pairMap.putIfAbsent(keyStr, new ArrayList<>());
            pairMap.get(keyStr).add(str);
        }
        return pairMap.values().stream().filter(l-> l.size()>1).collect(Collectors.toList());
    }
}
