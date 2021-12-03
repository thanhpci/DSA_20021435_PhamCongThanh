package week12;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedCellsInAGrid {
    class Cell {
        public int r, c;
        public Cell(int i, int j) {
            r = i;
            c = j;
        }
    }

    public class Solution {

        static int[][] grid;
        static boolean[][] visited;
        static int N, M;


        static int count_connected(int row, int col) {
            if (row < 0 || col < 0 || row >= N || col >= M) return 0;

            if (visited[row][col] == true) return 0;
            else visited[row][col] = true;

            if (grid[row][col] == 0) return 0;

            int cnt = 1;
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i == row && j == col) continue;
                    cnt += count_connected(i, j);
                }
            }
            return cnt;
        }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner = new Scanner(System.in);
            N = scanner.nextInt();
            M = scanner.nextInt();
            grid = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    grid[i][j] = scanner.nextInt();
                    visited[i][j] = false;
                }
            }
            int max = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (grid[i][j] == 0 || visited[i][j]) continue;
                    int cnt = count_connected(i, j);
                    if (max < cnt) max = cnt;
                }
            }
            System.out.println(max);
        }
    }
}
