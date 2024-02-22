package com.nykaa.tradeScheme.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSAndBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList<Integer> dfs = dfsOfGraph(5, adj);
        for (int i = 0; i < dfs.size(); i++) {
            System.out.print(dfs.get(i) + " ");
        }

        ArrayList<Integer> bfs = bfsOfGraph(5, adj);
        for (int i = 0; i < bfs.size(); i++) {
            System.out.print(bfs.get(i) + " ");
        }
    }

    private static ArrayList<Integer> dfsOfGraph(int size, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[size + 1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
}
