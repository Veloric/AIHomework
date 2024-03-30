/**
 * Class to help read input from the Suduoku puzzle files.
 * @author Kyle Geddes, Laiba Khan
 */

 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;

public class SudokuReader {
    
    public static Sudoku readBoard(String fileName){
        int[][] board = new int[9][9];
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            int rowNum = 0;
            int linesToRead = 0;
            
            while(reader.hasNextLine() && linesToRead < 9){
                int[] row = new int[9];
                for(int i = 0; i < row.length; i++){
                    row[i] = reader.nextInt();
                }
                board[rowNum] = row;
                rowNum++;
                linesToRead++;
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found, try again!");
        }
        Sudoku gameBoard = new Sudoku(board);
        return gameBoard;
    }

}
