/**
 * Tester class for PuzzleComparison.java
 * @author Kyle Geddes, Laiba Khan
 */

 import java.util.ArrayList;
 import csis4463.*;

public class Runner {

    public static void main(String[] args){
        String[] algs = {"UCS" ,"AStarMisplaced", "AStarManhattan", "ID", "IDAStarMisplaced", "IDAStarManhattan"};
        for(int i = 2; i <= 12; i = i + 2){
            ArrayList<SlidingTilePuzzle> generatedList = PuzzleCompairson.generatePuzzles(3, 3, i, 100);
            for(int j = 0; j < algs.length; j++){
                System.out.println(PuzzleCompairson.runSimulations(generatedList, i, algs[j]));
            }
        }

        
    }
    
}
