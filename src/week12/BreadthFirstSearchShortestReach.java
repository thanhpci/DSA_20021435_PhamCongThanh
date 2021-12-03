package week12;

import java.io.*;
import java.util.*;

public class BreadthFirstSearchShortestReach {
    public static class Graph{
        public int N = 0;
        public boolean  matrix[][];

        public Graph(Scanner s){
            N = s.nextInt();
            int e = s.nextInt();
            matrix = new boolean [N][N];
            for(int i=0;i <e; i++){
                int a = s.nextInt()-1;
                int b = s.nextInt()-1;
                matrix[a][b] = true;
                matrix[b][a] = true;
            }
        }

        public int[] getDistanceToEdges(int s){
            boolean visited[] = new boolean[N];

            int resp[] = new int[N];
            Arrays.fill(resp, 0, N, Integer.MAX_VALUE);
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(s-1);
            resp[s-1] = 0;
            visited[s-1]=true;
            while(!q.isEmpty()){
                int node = q.poll();
                for (int i = 0;i < N;i++){
                    if(matrix[node][i] == true){
                        resp[i] = Math.min(resp[i], resp[node]+1);
                        if(visited[i]==false){
                            visited[i]= true;
                            q.add(i);
                        }
                    }
                }
            }
            return resp;
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for(int i=0; i< Q;i++){
            BreadthFirstSearchShortestReach.Graph g = new BreadthFirstSearchShortestReach.Graph(scanner);
            for(int d: g.getDistanceToEdges(scanner.nextInt())){
                if (d!=0){
                    System.out.print(""+((d==Integer.MAX_VALUE)?-1: d*6)+" " );
                }
            };
            System.out.println("");
        }
    }
}