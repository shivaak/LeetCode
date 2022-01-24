public class DivideStringToGroup {

    public static void main(String[] args) {
        String arr[]=divideString("", 3, 'x');
        for(String s : arr){
            System.out.println(s);
        }

    }

        public static String[] divideString(String s, int k, char fill) {
            int noOfGroups = findNoOfgroups(s,k);
            String[] res = new String[noOfGroups];

            int g=0,i=0;
            for(;g<=noOfGroups-1;i=i+k,g++){
                if(i+k>s.length()){
                    int noOfExtraChars = s.length()%k;
                    res[g] = s.substring(i,i+noOfExtraChars);
                    for(int j=noOfExtraChars;j<k;j++){
                        res[g]+=fill;
                    }
                    break;
                }
                res[g] = s.substring(i,i+k);
            }

            return res;
        }

        private static int findNoOfgroups(String s, int k){
            int len = s.length();
            int noOfGroups = len/k;
            if(len%k>0){
                noOfGroups++;
            }
            return noOfGroups;
        }



}
