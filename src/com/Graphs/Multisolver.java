package com.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Multisolver {
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

    public static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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
        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtx];
        multisolver(graph, src, dest, visited, src + "", 0, criteria, k);

        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
    }


    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    private static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wt, int criteria, int k) {
        if (src == dest) {
            if (wt < spathwt) {
                spathwt = wt;
                spath = psf;
            }
            if (wt > lpathwt) {
                lpathwt = wt;
                lpath = psf;
            }
            if (wt > criteria && wt < cpathwt) {
                cpathwt = wt;
                cpath = psf;
            }
            if (wt < criteria && wt > fpathwt) {
                fpathwt = wt;
                fpath = psf;
            }
            if (pq.size() < k) {
                pq.add(new Pair(wt, psf));
            } else {
                if (wt > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wt, psf));
                }
            }
            return;
        }
        if (visited[src]) {
            return;
        } else visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                multisolver(graph, e.nbr, dest, visited, psf + e.nbr, wt + e.wt, criteria, k);
                visited[e.nbr] = false;
            }
        }
//        visited[src] = false;
    }
}
