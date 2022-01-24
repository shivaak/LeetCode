import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EscapeMaze {

    public static void main(String[] args) {

        /*
            0 0 0
            0 0 0
            0 0 0

         */
        int[][] maze = new int[][]{
                {1,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {0,1,1,1}
        };
        int row=1, col=1;
        Set<String> path = new LinkedHashSet<>();
        System.out.println(escapeMaze(maze, row, col,path));
        System.out.println(path);
    }

    private static boolean escapeMaze(int[][] maze, int row, int col, Set<String> path) {
        String currentCell = row+"-"+col;
        if((row<=0 || row>=maze.length-1) || (col<=0 || col>=maze[0].length-1)){
            path.add(currentCell);
            return true;
        }


        if(path.contains(currentCell)){
            return false;
        }
        path.add(currentCell);

        boolean canEscape=false;
        if(maze[row][col-1]==0){ //Left
            canEscape = canEscape || escapeMaze(maze,row, col-1, path);
        }
        if(maze[row][col+1]==0){ //Right
            canEscape = canEscape || escapeMaze(maze,row, col+1,path);
        }
        if(maze[row-1][col]==0){ //Up
            canEscape = canEscape || escapeMaze(maze,row-1, col,path);
        }
        if(maze[row+1][col]==0){ //Down
            canEscape = canEscape || escapeMaze(maze,row+1, col, path);
        }

        if(!canEscape){
            path.remove(currentCell);
        }


        return canEscape;
    }
}
