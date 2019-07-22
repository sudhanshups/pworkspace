package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TR3 {

    static class WGNode {
        int dest;
        int weight;

        WGNode() {
        }

        WGNode(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class WGraph {
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

        class node {
            int vertex;
            int key;
        }

        public void prims_mst(int max_t) {

            boolean[] mstset = new boolean[V];
            node[] e = new node[V];


            int[] parent = new int[V];

            for (int i = 0; i < V; i++)
                e[i] = new node();


            for (int i = 0; i < V; i++) {

                mstset[i] = false;

                e[i].key = Integer.MAX_VALUE;
                e[i].vertex = i;
                parent[i] = -1;
            }

            mstset[0] = true;


            e[0].key = 0;
            PriorityQueue<node> queue = new PriorityQueue<>(V, (u, v) -> u.key - v.key);

            for (int i = 0; i < V; i++) {
                queue.add(e[i]);
            }


            while (!queue.isEmpty()) {

                node node0 = queue.poll();
                mstset[node0.vertex] = true;

                for (WGNode wgNode : adj.get(node0.vertex)) {
                    if (mstset[wgNode.dest] == false) {
                        if (e[wgNode.dest].key > wgNode.weight) {
                            queue.remove(e[wgNode.dest]);
                            e[wgNode.dest].key = wgNode.weight;
                            queue.add(e[wgNode.dest]);
                            parent[wgNode.dest] = node0.vertex;
                        }
                    }
                }
            }


            for (int i = 1; i < V; i++) {
                System.out.println(parent[i] + " - " + i);
            }

        }
    }


    public static int findBestPath(int n, int m, int max_t, List<Integer> beauty, List<Integer> u, List<Integer> v, List<Integer> t) {
        WGraph graph = new WGraph(n);
        for(int i=0;i<n;i++){
            graph.addEdge(u.get(i), v.get(i), t.get(i));
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> beauty = new ArrayList<>(Arrays.asList(5, 10, 15, 20));
        ArrayList<Integer> source = new ArrayList<>(Arrays.asList(0, 1, 0));
        ArrayList<Integer> dest = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> time = new ArrayList<>(Arrays.asList(6,7,10));


        System.out.println(findBestPath(4, 3, 30, beauty, source, dest, time));


    }


}
