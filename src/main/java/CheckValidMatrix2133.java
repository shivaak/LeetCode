import java.util.HashSet;
import java.util.Set;

public class CheckValidMatrix2133 {

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int r = 1; r < n; ++r) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int c = 0; c < n; ++c) {
                row.add(matrix[r][c]);
                col.add(matrix[c][r]);
            }
            if (row.size() < n || col.size() < n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckValidMatrix2133().checkValid(new int[][]{{1,2,3},{3,1,2},{2,3,1}}));
    }
}
