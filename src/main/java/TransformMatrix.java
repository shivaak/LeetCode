
public class TransformMatrix {

    /*

        1. Any live cell with fewer than two live neighbors dies, as if caused by under population.
        2. Any live cell with two or three live neighbors lives on to the next generation.
        3. Any live cell with more than three live neighbors dies, as if by overpopulation.
        4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

      0 0 0 0        0 0 0 0
      0 1 1 0   ==>  0 1 1 0
      0 0 1 0        0 0 0 1
      0 1 0 1        0 0 1 0

        Initially live, now dead 2
        Initially dead, now alive 3
     */

    public static void main(String[] args) {
        /*int[][] matrix={
                {0,0,0,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,1,0,1}
        };*/
        int[][] matrix={
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };
        int count=0;
        while(!isAllDied(matrix)){
            transformMatrix(matrix);
            count++;
        }
        System.out.println("No of transformations : " + count);
    }

    public static boolean isAllDied(int[][] matrix){
        int noc = matrix[0].length;
        int nor = matrix.length;
        for(int i=0;i<nor;i++) {
            for (int j = 0; j < noc; j++) {
                if(matrix[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void transformMatrix(int[][] matrix) {
        int noc = matrix[0].length;
        int nor = matrix.length;
        for(int i=0;i<nor;i++){
            for(int j=0;j<noc;j++){
                int noOfLiveNeighbours = countNoOfLiveNeighbours(matrix, i,j);
                if(matrix[i][j]==1 && (noOfLiveNeighbours<2 || noOfLiveNeighbours>3)){
                    matrix[i][j]=2;
                }
                if(matrix[i][j]==0 && noOfLiveNeighbours==3){
                    matrix[i][j]=3;
                }
            }
        }

        for(int i=0;i<nor;i++) {
            for (int j=0;j<noc;j++) {
                if(matrix[i][j]==2){
                    matrix[i][j]=0;
                }
                if(matrix[i][j]==3){
                    matrix[i][j]=1;
                }
                System.out.print(matrix[i][j]  + " ");
            }
            System.out.println();
        }
        System.out.println("------------------");
        System.out.println();
    }

    private static int countNoOfLiveNeighbours(int[][] matrix, int i, int j) {
        int[][] dir ={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        int noc = matrix[0].length;
        int nor = matrix.length;

        int noOfLiveNodes = 0;
        for(int d=0;d<dir.length;d++){
            if(checkIfDirectionIsValid(dir[d], i, j, noc, nor)){
                int row=i+dir[d][0];
                int col=j+dir[d][1];
                if(matrix[row][col]==1 || matrix[row][col]==2){
                    noOfLiveNodes++;
                }
            }
        }
        return noOfLiveNodes;
    }

    private static boolean checkIfDirectionIsValid(int[] dir, int r, int c, int noc, int nor) {
        if(r+dir[0] >= 0 && r+dir[0] < nor &&  c+dir[1] >= 0 && c+dir[1]<noc){
            return true;
        }
        return false;
    }
}
