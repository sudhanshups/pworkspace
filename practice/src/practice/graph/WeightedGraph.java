package practice.graph;

import java.util.*;

class WGNode {
    int dest;
    int weight;

    WGNode() {
    }

    WGNode(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class WGraph {
    int V;
    List<List<WGNode>> adj;

    WGraph(int vertex) {
        this.V = vertex;
        adj = new ArrayList<>(vertex);

        for (int i = 0; i < vertex; i++)
            adj.add(new LinkedList<>());
    }

    public void addEdge(int u, int v, int weight) {
        WGNode wgNode1 = new WGNode(v, weight);
        adj.get(u).add(wgNode1);
        WGNode wgNode2 = new WGNode(u, weight);
        adj.get(v).add(wgNode2);
    }

    public void print() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + "=> ");
            for (WGNode v : adj.get(i)) {
                System.out.print(v.dest + "-> ");
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

            for (WGNode v : adj.get(node)) {
                if (!visited[v.dest]) {
                    visited[v.dest] = true;
                    queue.add(v.dest);
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
        List<WGNode> children = adj.get(i);
        for (WGNode j : children) {
            dfsUtil(j.dest, visited);
        }
    }

    public void dfs(int source) {
        boolean visited[] = new boolean[V];
        dfsUtil(source, visited);
    }

    class node {
        int vertex;
        int key;
    }

    public void prims_mst() {
        // Whether a vertex is in PriorityQueue or not
        boolean[] mstset = new boolean[V];
        node[] e = new node[V];

        // Stores the parents of a vertex
        int[] parent = new int[V];

        for (int i = 0; i < V; i++)
            e[i] = new node();

        for (int i = 0; i < V; i++) {
            // Initialize to false
            mstset[i] = false;
            // Initialize key values to infinity
            e[i].key = Integer.MAX_VALUE;
            e[i].vertex = i;
            parent[i] = -1;
        }
        // Include the source vertex in mstset
        mstset[0] = true;

        // Set key value to 0  so that it is extracted first out of PriorityQueue
        e[0].key = 0;

        // PriorityQueue
        PriorityQueue<node> queue = new PriorityQueue<>(V, (u, v) -> u.key - v.key);

        for (int i = 0; i < V; i++) {
            queue.add(e[i]);
        }

        // Loops until the PriorityQueue is not empty
        while (!queue.isEmpty()) {
            // Extracts a node with min key value
            node node0 = queue.poll();

            // Include that node into mstset
            mstset[node0.vertex] = true;

            // For all adjacent vertex of the extracted vertex V
            for (WGNode wgNode : adj.get(node0.vertex)) {
                // If V is not in PriorityQueue
                if (mstset[wgNode.dest] == false) {
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if (e[wgNode.dest].key > wgNode.weight) {
                        queue.remove(e[wgNode.dest]);
                        e[wgNode.dest].key = wgNode.weight;
                        queue.add(e[wgNode.dest]);
                        parent[wgNode.dest] = node0.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }


        List<Integer> a = Collections.synchronizedList(new ArrayList<>());

        HashMap<Integer,Integer> az = new HashMap<>();
        az.put(1,1);
        Collections.synchronizedSet(new HashSet<>());
        Collections.synchronizedMap(new HashMap< >());

    }

}

public class WeightedGraph {


    public static void main(String[] args) {
        int V = 9;

        WGraph graph = new WGraph(V);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);


        graph.print();

        System.out.println("\n=== bfs === from 0");
        graph.bfs(0);
        System.out.println();
        graph.prims_mst();

    }
}
