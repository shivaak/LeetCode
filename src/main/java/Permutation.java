public class Permutation {

    public static void main(String[] args) {
        String s="ABC";
        permute(s,0);
    }

    private static void permute(String s, int l) {
        if(l==s.length()){
            System.out.println(s);
            return;
        }

        for(int i=l;i<=s.length()-1;i++){
            s = swap(s, l,i);
            permute(s,l+1);
        }
    }

    private static String swap(String s, int a, int b) {
        char ch[] = s.toCharArray();
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
        return new String(ch);
    }


}
