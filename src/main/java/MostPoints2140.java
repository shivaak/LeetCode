public class MostPoints2140 {

    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]{{3,2}}));
    }
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long max=0;
        for(int i=0;i<=n-1;i++){
            long pt = questions[i][0];
            max = Math.max(max, pt+mostPoints(questions,i));
        }
        return max;
    }

    public static long mostPoints(int[][] questions, int i) {
        int bp = questions[i][1];
        int n = questions.length;

        if(i+bp>=n){
            return 0;
        }

        long max=0;
        for(int j=i+bp+1;j<=n-1;j++){
            long pt=questions[j][0] + mostPoints(questions, j);
            max=Math.max(max, pt);
        }

        return max;
    }
}
