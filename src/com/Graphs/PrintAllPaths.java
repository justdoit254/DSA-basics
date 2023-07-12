package com.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintAllPaths {

    static class Edge {
        int vtx;
        int nbr;
        int wt;

        public Edge(int vtx, int nbr, int wt) {
            this.vtx = vtx;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtx = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtx];
        for (int i = 0; i < vtx; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtx];
        printAllPaths(graph, src, dest, visited, src+"");
    }

    private static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src==dest) {
            System.out.println(psf);
            return;
        }
        if (visited[src]) {
            return ;
        } else visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
               printAllPaths(graph, e.nbr, dest, visited, psf+e.nbr);
               visited[e.nbr] = false;
            }
        }
//        visited[src] = false;
    }
}
