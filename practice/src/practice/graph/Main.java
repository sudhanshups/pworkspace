package practice.graph;

import java.lang.reflect.Array;
import java.util.*;

class Graph {
    int V;
    List<List<Integer>> adj;

    Graph(int vertex) {
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

    public int motherVertex() {
        boolean[] visited = new boolean[V];
        int mother = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
                mother = i;
            }
        }

        visited = new boolean[V];
        dfsUtil(mother, visited);
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                return -1;
        }
        return mother;

    }

    private boolean isCycle(int i, boolean visited[], boolean recStack[]) {
        if (recStack[i])
            return true;
        if (visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;

        List<Integer> children = adj.get(i);
        for (int j : children) {
            if (isCycle(j, visited, recStack)) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }

    public boolean detectCycle() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCycle(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    void printLevel(int source) {
        boolean[] visited = new boolean[V];
        int[] level = new int[V];
        Arrays.fill(level, Integer.MAX_VALUE);

        level[source] = 0;
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            List<Integer> neighbours = adj.get(x);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    level[neighbour] = level[x] + 1;
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + " is " + level[i] + " away from " + source);
        }
    }

    void printAllPath(int s, int d) {
        boolean[] visited = new boolean[V];
        List<Integer> path = new ArrayList<>();
        path.add(s);
        printPathUtil(s, d, visited, path);
    }

    private void printPathUtil(int s, int d, boolean[] visited, List<Integer> path) {
        visited[s] = true;
        if (s == d) {
            System.out.println("Path Found " + path);
        } else {
            List<Integer> neighbours = adj.get(s);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    path.add(neighbour);
                    printPathUtil(neighbour, d, visited, path);
                    path.remove(neighbour);
                }
            }

        }
        visited[s] = false;
        return;
    }

    //Delete Edge to minimize subtree sum difference
    // Method returns minimum subtree sum difference
    // not working gfg/delete-edge-minimize-subtree-sum-difference/
    int getMinSubtreeSumDifference(int vertexWeight[]) {
        int totalWeight = 0;
        for (int i = 0; i < V; i++) {
            totalWeight += vertexWeight[i];
        }
        int res = dfsWeight(0, -1, vertexWeight, totalWeight, 0);

        return res;
    }

    int dfsWeight(int source, int parent, int[] vertexWeight, int totalWeight, int currentVertexWeight) {

        int sum = vertexWeight[source];
        int res = Math.abs(totalWeight - 2 * sum);

        List<Integer> neighbours = adj.get(source);
        for (Integer neighbour : neighbours) {
            if (neighbour != parent) {
                int res1 = dfsWeight(neighbour, source, vertexWeight, totalWeight, currentVertexWeight);
                sum += vertexWeight[neighbour];
                if (res > res1)
                    res = res1;
            }
        }
        vertexWeight[source] = sum;

        return res;
    }

    void topologicalSortUtil(int v, boolean visited[], Stack stack) {
        visited[v] = true;

        List<Integer> neighbours = adj.get(v);
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour])
                topologicalSortUtil(neighbour, visited, stack);
        }
        stack.push(new Integer(v));
    }

    // check for all-topological-sorts-of-a-directed-acyclic-graph/
    //another simpler way- use queue starting from 0 degree verted, reduce indegree of neighbour, save in topological array keep repeating
    void topologicalSort() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }
}

public class Main {

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
