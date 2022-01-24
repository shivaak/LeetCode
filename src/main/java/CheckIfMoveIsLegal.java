public class CheckIfMoveIsLegal {

    public static void main(String[] args) {
        char board[][]={
                {'.','.','.','.','.','.','.','.'},
                {'.','B','.','.','W','.','.','.'},
                {'.','.','W','.','.','.','.','.'},
                {'.','.','.','W','B','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','B','W','.','.'},
                {'.','.','.','.','.','.','W','.'},
                {'.','.','.','.','.','.','.','B'}};

        System.out.println(checkMove(board, 4,4,'W'));
    }

    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        boolean isGoodLine = checkMove(board,rMove, cMove+1, color, 'R',1) ||
                checkMove(board,rMove+1, cMove, color, 'D',1) ||
                checkMove(board,rMove, cMove-1, color, 'L',1) ||
                checkMove(board,rMove-1, cMove, color, 'U',1) ||
                checkMove(board,rMove-1, cMove-1, color, 'W',1) ||
                checkMove(board,rMove-1, cMove+1, color, 'X',1) ||
                checkMove(board,rMove+1, cMove-1, color, 'Y',1) ||
                checkMove(board,rMove+1, cMove+1, color, 'Z',1);

        return isGoodLine;
    }

    public static boolean checkMove(char[][] board, int rMove, int cMove, char color, char dir, int noOfMoves) {

        if(rMove<0 || rMove>=8 || cMove<0 || cMove>=8){
            return false;
        }

        if(board[rMove][cMove]=='.'){
            return false;
        }

        if(noOfMoves==1 && board[rMove][cMove]==color){
            return false;
        }

        if(noOfMoves>1 && board[rMove][cMove]==color){
            return true;
        }



        switch(dir){
            case 'R':
                return checkMove(board,rMove, cMove+1, color, 'R',noOfMoves+1);
            case 'D':
                return checkMove(board,rMove+1, cMove, color, 'D',noOfMoves+1);
            case 'L':
                return checkMove(board,rMove, cMove-1, color, 'L',noOfMoves+1);
            case 'U':
                return checkMove(board,rMove-1, cMove, color, 'U',noOfMoves+1);
            case 'W':
                return checkMove(board,rMove-1, cMove-1, color, 'W',noOfMoves+1);
            case 'X':
                return checkMove(board,rMove-1, cMove+1, color, 'X',noOfMoves+1);
            case 'Y':
                return checkMove(board,rMove+1, cMove-1, color, 'Y',noOfMoves+1);
            case 'Z':
                return checkMove(board,rMove+1, cMove+1, color, 'Z',noOfMoves+1);
        }

        return false;
    }
}
