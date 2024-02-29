/**
 * Compares statistics of different types of algorithms on the 8-puzzle.
 * GitHub Repo: https://github.com/Veloric/AIHomework
 * @author Kyle Geddes, Laiba Khan
 */

 import java.util.ArrayList;
 import csis4463.*;

public class PuzzleCompairson {

    /**
     * Generates a random amount of specified puzzles
     * @param n - Rows
     * @param m - Columns
     * @param optimalSolution - The solution required
     * @param amt - How many to generate
     * @return - An Arraylist containing all generated puzzles with proper solutions.
     */
    public static ArrayList<SlidingTilePuzzle> generatePuzzles(int n, int m, int optimalSolution, int amt){
        ArrayList<SlidingTilePuzzle> generatedPuzzles = new ArrayList<SlidingTilePuzzle>();
        for (int i = 0; i < amt; i++){
            SlidingTilePuzzle generated = new SlidingTilePuzzle(n, m, optimalSolution);
            generatedPuzzles.add(generated);
        }
        return generatedPuzzles;
    }

    public static String runSimulations(ArrayList<SlidingTilePuzzle> puzzles, int optimalSolution, String alg){
        String returnString = "L: " + optimalSolution + " ";
        int expandedStates = 0;
        long generatedStates = 0;
        int maxMemory = 0;
        PuzzleSolution solution;
        for(int i = 0; i < puzzles.size(); i++){
            SlidingTilePuzzle currentPuzzle = puzzles.get(i);
            switch (alg) {
                case "AStarMisplaced":
                    solution = SlidingTilePuzzleSolver.AStarSearchMisplacedTiles(currentPuzzle);
                    break;
                case "AStarManhattan":
                    solution = SlidingTilePuzzleSolver.AStarSearchManhattanDistance(currentPuzzle);
                    break;
                case "ID":
                    solution = SlidingTilePuzzleSolver.iterativeDeepening(currentPuzzle);
                    break;
                case "IDAStarMisplaced":
                    solution = SlidingTilePuzzleSolver.idaStarMisplacedTiles(currentPuzzle);
                    break;
                case "IDAStarManhattan":
                    solution = SlidingTilePuzzleSolver.idaStarManhattanDistance(currentPuzzle);
                    break;
                default:
                    solution = SlidingTilePuzzleSolver.uniformCostSearch(currentPuzzle);
                    break;
            }
            expandedStates = expandedStates + solution.getNumberOfStatesExpanded();
            generatedStates = generatedStates + solution.getNumGenerated();
            maxMemory = maxMemory + solution.getNumberOfStatesInMemory();
        }
        returnString = returnString + "Average expanded states: " + (double) expandedStates / (double) puzzles.size() + " Average generated states: " + generatedStates / (long) puzzles.size() + " Average states in memory: " + (double) maxMemory / (double) puzzles.size();
        return returnString;
    }
    
}
