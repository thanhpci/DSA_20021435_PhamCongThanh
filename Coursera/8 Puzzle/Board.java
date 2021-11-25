import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private final int[][] blocks;
    private final int hamming;
    private final int manhattan;

    public Board(int[][] blocks){
        this.blocks = new int[blocks.length][];
        for (int i = 0; i < blocks.length; i++){
            this.blocks[i] = new int[blocks[i].length];
            for (int j = 0; j < blocks[i].length; j++){
                this.blocks[i][j] = blocks[i][j];
            }
        }
        this.hamming = numOfBlocksInWrongPosition();
        this.manhattan = computeManhattan();
    }

    public int dimension(){
        return this.blocks.length;
    }

    public int hamming(){
        return this.hamming;
    }

    public int manhattan(){
        return this.manhattan;
    }

    public boolean isGoal(){
        return this.hamming == 0;
    }

    public Board twin() {
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension() - 1; j++) {
                if (this.blocks[i][j] != 0 && this.blocks[i][j + 1] != 0) {
                    return createTwin(i, j, i, j + 1);
                }
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (other instanceof Board){
            Board otherBoard = (Board)other;
            if (otherBoard.dimension() == dimension()){
                for (int i = 0; i < dimension(); i++){
                    for (int j = 0; j < dimension(); j++){
                        if (this.blocks[i][j] != otherBoard.blocks[i][j]){
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }


    public Iterable<Board> neighbors(){

        List<Board> neighbors = new LinkedList<>();
        boolean zeroFound = false;
        for (int i = 0; i < dimension() && !zeroFound; i++){
            for (int j = 0; j < dimension() && !zeroFound; j++){
                if (this.blocks[i][j] == 0){
                    zeroFound = true;
                    //Up
                    if (isLegalPosition(i - 1, j)){
                        neighbors.add(createTwin(i, j, i - 1, j));
                    }
                    //Left
                    if (isLegalPosition(i, j - 1)){
                        neighbors.add(createTwin(i, j, i, j - 1));
                    }
                    //Down
                    if (isLegalPosition(i + 1, j)){
                        neighbors.add(createTwin(i, j, i + 1, j));
                    }
                    // Right
                    if (isLegalPosition(i, j + 1)){
                        neighbors.add(createTwin(i, j, i, j + 1));
                    }
                }
            }
        }

        return neighbors;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(dimension()).append('\n');
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                sb.append(this.blocks[i][j]).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private int numOfBlocksInWrongPosition(){
        int counter = 0;
        int goalNum = 1;
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                int value = this.blocks[i][j];
                if (value != 0 && value != goalNum) counter++;
                goalNum++;
            }
        }
        return counter;
    }

    private int computeManhattan(){
        int distanceCounter = 0;
        for (int i = 0; i < dimension(); i++){
            for (int j = 0; j < dimension(); j++){
                if (this.blocks[i][j] == 0) continue;
                int targetX = (this.blocks[i][j] - 1) / dimension();
                int targetY = (this.blocks[i][j] - 1) % dimension();
                distanceCounter += countMoves(targetX, targetY, i, j);
            }
        }
        return distanceCounter;
    }


    private int countMoves(int targetX, int targetY, int currentX, int currentY){
        return Math.abs(targetX - currentX) + Math.abs(targetY - currentY);
    }

    private boolean isLegalPosition(int i, int j){
        return i > -1 && i < dimension() && j > -1 && j < dimension();
    }

    private Board createTwin(int x0, int y0, int x1, int y1){

        int[][] b = new int[dimension()][];
        for (int i = 0; i < dimension(); i++){
            b[i] = new int[dimension()];
            for (int j = 0; j < dimension(); j++){
                b[i][j] = this.blocks[i][j];
            }
        }
        int tmp = b[x0][y0];
        b[x0][y0] = b[x1][y1];
        b[x1][y1] = tmp;

        return new Board(b);
    }

    
}
