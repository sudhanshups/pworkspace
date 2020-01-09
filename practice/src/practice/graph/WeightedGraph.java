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


    public void prims_mst() {
        class Node {
            int vertex;
            int edgeWeight;//edge weight
        }
        // Whether a vertex is in Set or not
        boolean[] mstset = new boolean[V];
        Node[] e = new Node[V];

        // Stores the parents of a vertex
        int[] parent = new int[V];


        for (int i = 0; i < V; i++) {
            mstset[i] = false;// Initialize to false
            e[i] = new Node();
            e[i].edgeWeight = Integer.MAX_VALUE; // Initialize key values to infinity
            e[i].vertex = i;
            parent[i] = -1;
        }
        // Include the source vertex in mstset
        mstset[0] = true;
        // Set key value to 0  so that it is extracted first out of PriorityQueue
        e[0].edgeWeight = 0;

        TreeSet<Node> queue = new TreeSet<>((u, v) -> {
            if (u.edgeWeight - v.edgeWeight != 0) {
                return u.edgeWeight - v.edgeWeight;
            } else
                return u.vertex - v.vertex;
        });

        for (int i = 0; i < V; i++) {
            queue.add(e[i]);
        }

        // Loops until the PriorityQueue is not empty
        while (!queue.isEmpty()) {
            // Extracts a node with min key value
            Node node0 = queue.pollFirst();

            // Include that node into mstset
            mstset[node0.vertex] = true;

            // For all adjacent vertex of the extracted vertex V
            for (WGNode wgNode : adj.get(node0.vertex)) {
                // If V is not already included
                if (mstset[wgNode.dest] == false) {
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if (e[wgNode.dest].edgeWeight > wgNode.weight) {
                        queue.remove(e[wgNode.dest]);
                        e[wgNode.dest].edgeWeight = wgNode.weight;
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

    }

    /**
     * O( (E+V)*logV) using Adjacency list and priority Queue
     * O(logV) – to extract each vertex from queue. So for V vertices – O(VlogV)
     * O(logV) – each time new pair object with new key value of a vertex and will be done
     * for at most once for each edge. So for total E edge – O(ElogV)
     * So over all complexity: O(VlogV) + O(ElogV) = O((E+V)logV) = O(ElogV)
     */
    public void dijkstraGetMinDistances(int src) {

        //shortest path tree
        boolean[] SPT = new boolean[V];
        Set<Integer> settled = new HashSet<>();

        //distance used to store the distance of vertex from a source
        int[] distance = new int[V];

        //Initialize all the distance to infinity
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //Initialize priority queue override the comparator to do the sorting based keys
        // Add source node to the priority queue // weight is as distance from source
        PriorityQueue<WGNode> pq = new PriorityQueue<>(V, (u, v) -> u.weight - v.weight);
        pq.add(new WGNode(src, 0));

        // Distance to the source is 0
        distance[src] = 0;
        while (settled.size() != V) {
            // remove the minimum distance node from the priority queue
            int u = pq.remove().dest;
            // adding the node whose distance is finalized
            settled.add(u);

            // All the neighbors of v
            for (int i = 0; i < adj.get(u).size(); i++) {
                WGNode v = adj.get(u).get(i);

                // If current node hasn't already been processed
                if (!settled.contains(v.dest)) {
                    int newDistance = distance[u] + v.weight;

                    // If new distance is cheaper in cost
                    if (newDistance < distance[v.dest]) {
                        distance[v.dest] = newDistance;
                    }
                    // Add the current node to the queue
                    pq.add(new WGNode(v.dest, distance[v.dest]));
                }
            }
        }

        System.out.println("The shorted path from node :");
        for (int i = 0; i < V; i++) {
            System.out.println(src + " to " + i + " is " + distance[i]);
        }

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
        System.out.println(" === ");

        System.out.println(" ===prims mst ");
        graph.prims_mst();

        System.out.println(" ===Dijkstra ");
        graph.dijkstraGetMinDistances(1);

    }
}
