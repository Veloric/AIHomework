/**
 * Class to contain relevant Sudoku puzzles
 * @author Kyle Geddes, Laiba Khan
 */

public class Sudoku {
    private int[][] board;


    public Sudoku(int[][] board){
        this.board = board;
    }

    public int[][] getBoard(){
        return this.board;
    }

    public String printSudokuPuzzle(){
        String outpuString = "";
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                outpuString = outpuString + board[i][j] + " ";
            }
            outpuString = outpuString + "\n";
            if((i + 1) % (int)Math.sqrt(board.length) == 0){
                outpuString = outpuString + " ";
            }
        }

        return outpuString;
    }

}
