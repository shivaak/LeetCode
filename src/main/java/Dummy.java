import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class Dummy {

    public static void main(String[] args) {
       // System.out.println(repeatLimitedString("aababab", 2));

        System.out.println(isToeplitzMatrix1(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));
    }

    public static boolean isToeplitzMatrix1(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;


        for(int i=0;i<rows-1;i++){
            for(int j=0;j<cols-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1]) return false;
            }
        }

        return true;

    }

    public static boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;


        for(int i=0;i<=cols-1;i++){
            int n=matrix[0][i];
            for(int j=1;j<=rows-1;j++){
                if(j+i>=cols) break;
                if(matrix[j][j+i]!=n) return false;
            }
        }

        for(int i=1;i<=rows-1;i++){
            int n=matrix[i][0];
            for(int j=1;j<=cols-1;j++){
                if(j+i>=rows) break;
                if(matrix[j+i][j]!=n) return false;
            }
        }

        return true;

    }




    public static String repeatLimitedString(String s, int repeatLimit) {

        Character[] sarr = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        StringBuilder result = new StringBuilder();
        Deque<Character> q = new ArrayDeque<>();

        Arrays.sort(sarr, (a, b) -> Character.compare(b,a));

        char prev = ' ';
        int rlc=0; //repeat limit count
        for(int i=0; i<=s.length()-1; i++){
            if(i>0) prev = result.charAt(result.length()-1);

            if(sarr[i]==prev) rlc++;
            else rlc=1;

            if(rlc>repeatLimit){
                q.offer(sarr[i]);
                continue;
            }

            result.append(sarr[i]);

            int t=repeatLimit;
            while(q.size()>0 && t>0){
                result.append(q.poll());
                t--;
            }

        }

        return result.toString();

    }
}
