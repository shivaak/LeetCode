import java.util.Arrays;
import java.util.HashSet;

public class MicrosoftCodility1 {
    private int noOfFragments=0;
    private HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        MicrosoftCodility1 obj = new MicrosoftCodility1();
        System.out.println(obj.solution("zzzX", "zzzX"));
        System.out.println(obj.solution("dBacaAA", "caBdaaA"));
        System.out.println(obj.solution("ZZXYOz", "OOYXZZ"));
        System.out.println(obj.solution("abc", "ABC"));
        System.out.println(obj.solution("A", "A"));
    }

    public int solution(String A, String B){
        this.noOfFragments=0;
        this.set.clear();
        helper(A, B, 0, A.length());
        return noOfFragments;
    }

    public void helper (String A, String B, int start, int end){
        if(start<end && !set.contains(formIndexString(start, end))){
            boolean isMatch = sortAndCompare(A.substring(start, end), B.substring(start, end));
            if(isMatch){
                set.add(formIndexString(start, end));
                noOfFragments++;
            }
            helper(A, B, start+1, end);
            helper(A, B, start, end-1);
            helper(A, B, start+1, end-1);
        }
    }

    private String formIndexString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(start).append(end);
        return sb.toString();
    }

    public boolean sortAndCompare(String s1, String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return String.valueOf(arr1).equals(String.valueOf(arr2));
    }
}
