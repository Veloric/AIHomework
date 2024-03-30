/**
 * Sudoku Solver using 
 * 
 * @author Kyle Geddes, Laiba Khan
 */


public class Solver {

    public static boolean checkSafe(int[][] gameBoard, int row, int col, int num){
        return !DuplicInRow(gameBoard, row, num)
        && !DuplicInColumn(gameBoard, col, num)
        && !DuplicInSubmatrix(gameBoard, row - row % 3, col - col % 3, num);
    }

    private static boolean DuplicInRow(int[][] gameBoard, int row, int num){
        for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[row][i] == num){
                return true;
            }
        }    
        return false;    
    }

    private static boolean DuplicInColumn(int[][] gameBoard, int col, int num){
        for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[i][col] == num){
                return true;
            }
        }     
        return false;   
    }

    private static boolean DuplicInSubmatrix(int[][] gameBoard, int row, int col, int num){
        int sqrt = (int)Math.sqrt(gameBoard.length);
        int matrixRowStart = row - row % sqrt;
        int matrixColStart = col - col % sqrt;

            for(int i = matrixRowStart; i < matrixRowStart + sqrt; i++){
                for(int j = matrixColStart; j < matrixColStart + sqrt; j++){
                    if(gameBoard[i][j] == num){
                        return true;
                    }
                }
            }
            
            return false;
    }        
    private static int[] findEmptyCells(int[][] gameBoard){
        for(int row = 0; row < gameBoard.length; row++){
            for(int col = 0; col < gameBoard.length; col++){
                if(gameBoard[row][col] == 0){
                    return new int[]{row, col};
                } 
            }
        }

        return null;
    }     
    
    public static boolean solveSudoku(Sudoku game, int num){
        int[] emptyCells = findEmptyCells(game.getBoard());

        if (emptyCells == null) {
            return true; //If there are no emptyCells, then the sudoku is solved.
        }

        int row = emptyCells[0];
        int col = emptyCells[1];

        for(int i = 1; i <= num; i++){
            if(checkSafe(game.getBoard(), row, col, i)) {
                game.getBoard()[row][col] = i;

                if (solveSudoku(game, num)) {
                    return true; 
                }

            game.getBoard()[row][col] = 0;
            }
        }
        return false;
    }       

    public static void main(String[] args){
        Sudoku game = SudokuReader.readBoard("./sudokus/s05c.txt");

            if(solveSudoku(game, game.getBoard().length)){
                System.out.println(game.printSudokuPuzzle());
            } else {
                System.out.println("No Solution Found");
            }
    }
    
}
