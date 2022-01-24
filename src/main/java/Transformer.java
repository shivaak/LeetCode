public class Transformer {
    public static void main(String[] args) {
        System.out.println(solution("ACBDAC"));
    }

    public static String solution(String S) {
        while(canBeTransformed(S)){
            S = transform(S);
        }
        return S;
    }

    private static String transform(String s) {
        String transformableString[] = {"AB", "BA", "CD", "DC"};
        StringBuilder newString = new StringBuilder();
        int start=-1;
        for(String ts : transformableString){
            start=s.indexOf(ts);
            if(start!=-1){
                break;
            }
        }
        if(start!=-1){
            newString.append(s.substring(0,start));
            newString.append(s.substring(start+2));
            return newString.toString();
        } else{
            return s;
        }

    }

    private static boolean canBeTransformed(String s) {
        return s.contains("AB") || s.contains("BA") || s.contains("CD") || s.contains("DC");
    }
}
