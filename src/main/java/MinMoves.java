import java.util.HashMap;
import java.util.Map;

public class MinMoves {

    public static void main(String[] args) {
                System.out.println(minMoves(656101987,1));
       // System.out.println(minMoves(19 ,2));
    }
    public static int minMoves(int target, int maxDoubles){
        if(target==1){
            return 0;
        }

        if(maxDoubles==0){
            return target-1;
        }
        int resultBy1=0, resultByDouble=0;
        if(maxDoubles>0 && target%2==0){
            maxDoubles=maxDoubles-1;
            target=target/2;
            resultByDouble = 1+minMoves(target, maxDoubles);
        }else{
            target--;
            resultBy1 = 1+minMoves(target, maxDoubles);
        }

        return resultByDouble+resultBy1;

    }

}
