package practice.graph;

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

    // check if an undirected graph has cycle started from vertex u
    // hasCycle(adjList, 0, visited, -1)
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);

            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
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
        //path.add(s);
        printPathUtil(s, d, visited, path);
    }

    private void printPathUtil(int s, int d, boolean[] visited, List<Integer> path) {
        visited[s] = true;
        path.add(s);
        if (s == d) {
            System.out.println("Path Found " + path);
        } else {
            List<Integer> neighbours = adj.get(s);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    //path.add(neighbour);
                    printPathUtil(neighbour, d, visited, path);
                    //path.remove(neighbour);
                }
            }
        }
        visited[s] = false;
        path.remove(s);
        return;
    }

    //Delete Edge to minimize subtree sum difference
    // Method returns minimum subtree sum difference
    // not working , check gfg/delete-edge-minimize-subtree-sum-difference/
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

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        List<Integer> neighbours = adj.get(v);
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour])
                topologicalSortUtil(neighbour, visited, stack);
        }
        stack.push(v);
    }

    // check for all-topological-sorts-of-a-directed-acyclic-graph/
    // another simpler way- use queue starting from 0 degree vertex,
    // reduce in-degree of neighbour, save in topological array keep repeating
    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (!stack.empty())
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

        //find articulation point in an undirected graph
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(1, 2))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(2, 3))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(3, 4))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(4, 5))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(6, 3))));

        List<Integer> res = criticalRouters(6, 5, a);
        System.out.println(res);

    }


    /*
     * An articulation point is a vertex whose removal and it's edges will leave the graph in two disconnected component
     *
     * A O(V+E) algorithm to find all Articulation Points (APs)
     * In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
     * 1) u is root of DFS tree and it has at least two child subtree and these two child subtree should be disjoint.
     * 2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
     *
     * To check if there is a backEdge for each vertex we maintain 1. discovery time
     *  2. lowest discovery number reachable from any vertex by taking one back edge(i.e other than parent edge)
     *  2. in other word : we also maintain the lowest discovery time it has encountered in its subtree(consider the discovery time even if child is visited)
     *
     * No backedge to ancestor of u in subtree of u if:
     * lowest discovery time subtree has encountered >= discovery time of u
     *
     * Update the lowest discovery time of u
     *
     * Biconnectivity: An articulation vertex (or cut vertex) is a vertex whose removal increases the number of connected components.
     * A graph is biconnected if it has no articulation vertices. It uses depth-first search to find the bridges and articulation vertices.
     * It takes time proportional to V + E in the worst case.
     *
     */
    static List<Integer> criticalRouters(int numRouters, int numLinks,
                                         ArrayList<ArrayList<Integer>> links) {
        HashMap<Integer, Integer> nodeToRMap = new HashMap<>();
        HashMap<Integer, Integer> rToNodeMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> nodeLinks = new ArrayList<>();

        int node = 0;
        for (int i = 0; i < links.size(); i++) {

            if (!rToNodeMap.containsKey(links.get(i).get(0))) {
                nodeToRMap.put(node, links.get(i).get(0));
                rToNodeMap.put(links.get(i).get(0), node);
                node++;
            }

            if (!rToNodeMap.containsKey(links.get(i).get(1))) {
                nodeToRMap.put(node, links.get(i).get(1));
                rToNodeMap.put(links.get(i).get(1), node);
                node++;
            }
            ArrayList<Integer> link = new ArrayList<>();

            link.add(rToNodeMap.get(links.get(i).get(0)));
            link.add(rToNodeMap.get(links.get(i).get(1)));
            nodeLinks.add(link);
        }


        Graph2 g = new Graph2(numRouters);

        for (int i = 0; i < nodeLinks.size(); i++) {
            g.addEdge(nodeLinks.get(i).get(0), nodeLinks.get(i).get(1));
        }

        boolean visit[] = new boolean[numRouters];
        int parent[] = new int[numRouters];

        //lowest discovery number reachable from any vertex by taking one back edge
        int low[] = new int[numRouters];

        int discoveryTime[] = new int[numRouters];
        boolean aPoint[] = new boolean[numRouters];
        Time t = new Time();

        for (int i = 0; i < numRouters; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < numRouters; i++) {
            if (!visit[i]) {
                findArticulationPoint(i, visit, parent, low, discoveryTime, aPoint, g, t);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numRouters; i++) {
            if (aPoint[i]) {
                res.add(nodeToRMap.get(i));
            }
        }
        return res;
    }

    static void findArticulationPoint(int u, boolean[] visit, int[] parent, int[] low, int[] discoveryTime,
                                      boolean[] aPoint, Graph2 g, Time t) {
        int disconnectedComponent = 0;
        visit[u] = true;
        t.time++;
        discoveryTime[u] = low[u] = t.time;

        for (Integer v : g.adj.get(u)) {

            if (!visit[v]) {
                disconnectedComponent++;
                parent[v] = u;
                findArticulationPoint(v, visit, parent, low, discoveryTime, aPoint, g, t);

                if (parent[u] == -1 && disconnectedComponent > 1) {
                    aPoint[u] = true;
                }

                if (parent[u] != -1 && discoveryTime[u] <= low[v]) {
                    aPoint[u] = true;
                }
                low[u] = Math.min(low[u], low[v]);

            } else if (parent[u] != v) {
                low[u] = Math.min(discoveryTime[v], low[u]);
            }
        }
    }

}

class Graph2 {
    int v;
    List<List<Integer>> adj;

    Graph2(int v) {
        this.v = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

class Time {
    int time = 0;
}

