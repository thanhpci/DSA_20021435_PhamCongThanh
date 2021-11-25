import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.List;


public class Solver {

    private final boolean isSolvable;
    private final int moves;

    private final List<Board> solution = new LinkedList<>();


    public Solver(Board initial){
        if (initial == null) throw new IllegalArgumentException();
        BoardSolver origBoard = new BoardSolver(initial);
        BoardSolver twinBoard = new BoardSolver(initial.twin());


        while ( !origBoard.isSolutionFound() && !twinBoard.isSolutionFound()){
            origBoard.performStep();
            twinBoard.performStep();
        }

        if (origBoard.isSolutionFound()){
            this.isSolvable = true;
            this.moves = origBoard.getSolutionSearNode().moves;
            createSolution(origBoard.solutionSearNode, this.solution);
        } else {
            this.isSolvable = false;
            this.moves = -1;
        }

    }


    public boolean isSolvable(){
        return this.isSolvable;
    }

    public int moves(){
        return this.moves;
    }

    public Iterable<Board> solution(){
        return this.solution != null ? solution : null;
    }


    private void createSolution(SearchNode searchNode, List<Board> acc){
        acc.add(0, searchNode.board);
        if (searchNode.predecessor != null){
            createSolution(searchNode.predecessor, acc);
        }

    }


    private static class BoardSolver {

        private final MinPQ<SearchNode> minPQ = new MinPQ<>();

        private boolean solutionFound = false;

        private SearchNode solutionSearNode;

        public BoardSolver(Board initial) {
            minPQ.insert(SearchNode.createSearchNode(initial, 0));
        }

        private void performStep(){
            if ( !minPQ.isEmpty() ){
                SearchNode searchNode  = minPQ.delMin();
                if ( searchNode.board.isGoal() ){
                    this.solutionFound = true;
                    this.solutionSearNode = searchNode;
                } else {
                    for (Board b : searchNode.board.neighbors()){
                        // don't enqueue a neighbor if its board is the same as the board of the predecessor search node
                        if ( !b.equals(searchNode.predecessor != null ? searchNode.predecessor.board : null) ){
                            minPQ.insert(SearchNode.createSearchNode(b, searchNode, searchNode.moves + 1));
                        }
                    }
                }
            }
        }

        private boolean isSolutionFound(){
            return this.solutionFound;
        }

        private SearchNode getSolutionSearNode(){
            return this.solutionSearNode;
        }
    }

    private static class SearchNode implements Comparable<SearchNode> {

        public final int moves;
        public final Board board;
        public final SearchNode predecessor;

        private SearchNode(Board board, SearchNode predecessor, int moves) {
            this.moves = moves;
            this.board = board;
            this.predecessor = predecessor;
        }

        public static SearchNode createSearchNode(Board board, int moves){
            return new SearchNode(board, null, moves);
        }

        public static SearchNode createSearchNode(Board board, SearchNode predecessor, int moves){
            return new SearchNode(board, predecessor, moves);
        }

        @Override
        public int compareTo(SearchNode other) {

            int myPriority = moves + board.manhattan();
            int otherPriority = other.moves + other.board.manhattan();
            if (myPriority > otherPriority) {
                return 1;
            } else if (myPriority < otherPriority) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args){
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
