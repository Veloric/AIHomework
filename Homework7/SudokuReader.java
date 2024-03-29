/**
 * Class to help read input from the Suduoku puzzle files.
 * @author Kyle Geddes, Laiba Khan
 */

 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;

public class SudokuReader {
    
    public static Sudoku readBoard(String fileName){
        int[][] board = new int[8][8];
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            int rowNum = 0;
            while(reader.hasNextLine()){
                int[] row = new int[8];
                for(int i = 0; i < row.length; i++){
                    row[i] = reader.nextInt();
                }
                board[rowNum] = row;
                rowNum++;
            }
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found, try again!");
        }
        Sudoku gameBoard = new Sudoku(board);
        return gameBoard;
    }

}
