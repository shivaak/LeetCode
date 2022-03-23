public class WordSearch {

    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(new WordSearch().exist(board, "ABCCED"));
        System.out.println(new WordSearch().exist(board, "SEE"));
        System.out.println(new WordSearch().exist(board, "ABCB"));
        System.out.println(new WordSearch().exist(board, "FCED"));
    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board, i, j, word, 0, visited)){
                    printVisited(visited);
                    return true;
                }
            }
        }
        return false;
    }

    private void printVisited(boolean[][] visited) {
        for(int i=0;i<visited.length;i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j]? 1 + " " : 0 + " ");
            }
            System.out.println();
        }
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] visited) {

        if(index==word.length()) return true;

        if((row<0) || (col<0) || (row>=board.length) || (col>=board[0].length)) return false;
        if(board[row][col]!=word.charAt(index)) return false;
        if(visited[row][col]) return false;

        visited[row][col]=true;
        boolean res =  dfs(board, row, col+1, word, index+1, visited) || dfs(board, row+1, col, word, index+1,visited)
        || dfs(board, row, col-1, word, index+1, visited) || dfs(board, row-1, col, word, index+1,visited);

        if(res==false) visited[row][col]=false;
        return res;
    }
}
