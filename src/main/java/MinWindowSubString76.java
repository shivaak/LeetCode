public class MinWindowSubString76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    private static String minWindow(String str, String t) {
        int[] map = new int[128];
        int counter=t.length();
        for(char c : t.toCharArray()){
            map[c]++;
        }

        int start=0,end=0, minLen = Integer.MAX_VALUE, minStart=start;
        while(end<str.length()){
            final char c = str.charAt(end);
            if(map[c]>0){
                counter--;
            }
            map[c]--;
            end++;
            while(counter==0){
                if(minLen>end-start){
                    minLen=end-start;
                    minStart=start;
                }
                final char c2 = str.charAt(start);
                map[c2]++;
                if(map[c2]>0){
                    counter++;
                }
                start++;
            }
        }

        return minLen==Integer.MAX_VALUE ? "" : str.substring(minStart,minStart+minLen);

    }
}
