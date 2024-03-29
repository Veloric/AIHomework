/**
 * Sudoku Solver using 
 * 
 * @author Kyle Geddes, Laiba Khan
 */


public class Solver {

    public static boolean checkSafe(int[][] gameBoard, int row, int col, int num){
        boolean safe = true;


        for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[row][i] == num){
                safe = false;
                return safe;
            }
        }
        for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[i][col] == num){
                safe = false;
                return safe;
            }
        }
        int sqrt = (int)Math.sqrt(gameBoard.length);
        int matrixRowStart = row - row % sqrt;
        int matrixColStart = col - col % sqrt;

        for(int i = matrixRowStart; i < matrixRowStart + sqrt; i++){
            for(int j = matrixColStart; j < matrixColStart + sqrt; j++){
                if(gameBoard[i][j] == num){
                    safe = false;
                    return safe;
                }
            }
        }
        
        return safe;
    }

    public static boolean solveSudoku(Sudoku game, int num){
        boolean solved = false;
        int row = -1;
        int col = -1;
        int[][] gameBoard = game.getBoard();
        boolean empty = true;

        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(gameBoard[i][j] == 0){
                    row = i;
                    col = j;
                    empty = false;
                    break;
                }
            }
            if(!empty){
                break;
            }
        }
        if(empty == true){
            solved = true;
        }

        for(int i = 1; i <= num; i++){
            if(checkSafe(gameBoard, row, col, i)){
                gameBoard[row][col] = i;
                if(solveSudoku(game, num)){
                    solved = true;
                    return solved;
                } else {
                    gameBoard[row][col] = 0;
                }
            }
        }

        return solved;
    }

    public static void main(String[] args){
        Sudoku game = SudokuReader.readBoard("./sudokus/s05a.txt");
        if(solveSudoku(game, game.getBoard().length)){
            System.out.println(game.printSudokuPuzzle());
        } else {
            System.out.println("No Solution Found");
        }
    }
    
}
