/**
 * Tester class for PuzzleComparison.java
 * @author Kyle Geddes, Laiba Khan
 */

 import java.util.ArrayList;
 import csis4463.*;

public class Runner {

    public static void main(String[] args){
        String[] algs = {"UCS" ,"AStarMisplaced", "AStarManhattan", "ID", "IDAStarMisplaced", "IDAStarManhattan"};
        for(int i = 0; i < algs.length; i++){
            System.out.println("Simulating: " + algs[i]);
            for(int ii = 2; ii <= 12; ii = ii + 2){
                ArrayList<SlidingTilePuzzle> generatedList = PuzzleComparison.generatePuzzles(3, 3, ii, 100);
                System.out.println(PuzzleComparison.runSimulations(generatedList, ii, algs[i]));
            }
            System.out.println();
        }

        
    }
    
}
