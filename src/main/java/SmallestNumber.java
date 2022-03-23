import java.util.Arrays;

public class SmallestNumber {

    public static void main(String[] args) {
        System.out.println(smallestNumber(0));
    }


    public static long smallestNumber(long num) {
        if(num==0) return num;

        boolean isNeg = num < 0 ? true : false;
        if(isNeg){
            num*=-1;
        }
        int numLen = String.valueOf(num).length();
        numLen= num>=0 ? numLen : numLen-1;

        int[] arr=new int[numLen];
        int i=0; int numOfZeros = 0;
        while(num>0){
            int n =(int) (Math.abs(num) % 10);
            if(n==0){
                numOfZeros++;
            }else{
                arr[i]=n;
                i++;
            }
            num=num/10;

        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        StringBuilder output = new StringBuilder();
        if(isNeg){

            for(i=arr.length-1;i>=0;i--){
                if(arr[i]==0) continue;
                output.append(arr[i]);
            }

            for(int j=1;j<=numOfZeros;j++){
                output.append("0");
            }
        }else{

            for(i=0;i<=arr.length-1;i++){
                if(arr[i]==0) continue;
                output.append(arr[i]);

                if(output.length()==1){
                    for(int j=1;j<=numOfZeros;j++){
                        output.append("0");
                    }
                }

            }
        }




        long res = isNeg ? Long.valueOf(output.toString())*-1 : Long.valueOf(output.toString());
        return res;
    }
}
