public class SubStrHash {
    public static void main(String[] args) {
        System.out.println(subStrHash("leetcode", 7, 20, 2 , 0));
    }

    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int start=0, end=0;
        int len = s.length();

        //current hash value
        int currHash = 0;
        while(end<len){
            final char c = s.charAt(end);
            currHash = currHash + calculateCurrentHash(c, power, modulo, end-start);

            if(currHash==hashValue){
                return s.substring(start, end-1);
            }

            while(currHash>hashValue){
                currHash = currHash - calculateCurrentHash(c, power, modulo, start);
                start++;
            }
            end++;
        }

        return "";
    }

    public static int calculateCurrentHash(char c, int power, int modulo, int pos){
        int t= (c-'a')+1;
        int pow = (int) Math.pow(Double.valueOf(power), Double.valueOf(pos)) % modulo;
        return t * pow;
    }
}
