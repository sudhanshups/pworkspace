package practice.graph;

import java.util.*;

class WGraph {
    int V;
    List<List<Integer>> adj;

    WGraph(int vertex) {
        this.V = vertex;
        adj = new ArrayList<>(vertex);

        for (int i = 0; i < vertex; i++)
            adj.add(new LinkedList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void print() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + "=> ");
            for (Integer v : adj.get(i)) {
                System.out.print(v + "-> ");
            }
            System.out.println();
        }
    }

    public void bfs(int source) {
        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        //visited first , later expanded
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " -> ");

            for (Integer v : adj.get(node)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    private void dfsUtil(int i, boolean visited[]) {
        if (visited[i])
            return;

        //visited & expanded at the same time
        visited[i] = true;
        System.out.print(i + " -> ");
        List<Integer> children = adj.get(i);
        for (int j : children) {
            dfsUtil(j, visited);
        }
    }

    public void dfs(int source) {
        boolean visited[] = new boolean[V];
        dfsUtil(source, visited);
    }


}

public class WeightedGraph {







    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        g.print();

        System.out.println("\n=== bfs === from 0");
        g.bfs(0);
        System.out.println();

        /*Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 0);
        System.out.println(g.detectCycle());*/

        System.out.println("\n === dfs == from 0");
        g.dfs(0);

        System.out.println("\n\nfinding mother vertex");
        System.out.println(g.motherVertex() + " vertex ");

        System.out.println("\nprint all node distance from " + 1);
        g.printLevel(1);

        System.out.println("\nprint all path from 2 - 3");
        g.printAllPath(2, 3);

        System.out.println("\n Delete Edge to minimize subtree sum difference ");
        g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(2, 5);
        g.addEdge(5, 2);
        g.addEdge(3, 6);
        g.addEdge(6, 3);
        int[] vertexWeight = {4, 2, 1, 6, 3, 5, 2};
        // not working
        System.out.println(g.getMinSubtreeSumDifference(vertexWeight));

        //topological_sort
        g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();

    }
}
