package practice.specific;

import java.io.IOException;
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
}

public class Exp1 {

    public static List<Integer> order(int employeesNodes, List<Integer> employeesFrom, List<Integer> employeesTo, int host) {
        Graph graph = new Graph(employeesNodes);
        for (int i = 0; i < employeesFrom.size(); i++) {
            graph.addEdge(employeesFrom.get(i) - 1, employeesTo.get(i) - 1);
            graph.addEdge(employeesTo.get(i) - 1, employeesFrom.get(i) - 1);
        }
        boolean visited[] = new boolean[employeesNodes];

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(host - 1);
        queue.add(null);
        visited[host - 1] = true;


        Set<Integer> res = new TreeSet<>();
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (node == null) {
                result.addAll(res);
                res = new TreeSet<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                } else {
                    break;
                }
            } else {
                if (node + 1 != host)
                    res.add(node + 1);
                //System.out.print(node + " -> ");

                for (Integer v : graph.adj.get(node)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }

        return result;
    }

    public static long maxSum2(List<Long> arr, long threshold) {
        Long[] a = arr.stream().toArray(Long[]::new);
        return isSubSetSum(a, threshold);
    }

    private static long isSubSetSum(Long a[], long k) {
        int n = a.length;
        HashMap<Long, HashSet<Integer>> sumPossibleMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            HashSet<Integer> indexes = sumPossibleMap.getOrDefault(0l, new HashSet<>());
            indexes.add(i);
            sumPossibleMap.put(0l, indexes);
        }

        //System.out.println(sumPossibleMap);
        for (long i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {

                if (a[j - 1] > i) {
                    HashSet<Integer> indexes = sumPossibleMap.getOrDefault(i, new HashSet<>());
                    if (indexes.contains(j - 1)) {
                        indexes.add(j);
                    }
                    sumPossibleMap.put(i, indexes);
                } else {
                    HashSet<Integer> indexes = sumPossibleMap.getOrDefault(i, new HashSet<>());
                    HashSet<Integer> indexesOther = sumPossibleMap.getOrDefault(i - a[j - 1], new HashSet<>());

                    if (indexes.contains(j - 1) || indexesOther.contains(j - 1)) {
                        indexes.add(j);
                    }
                    sumPossibleMap.put(i, indexes);
                }
            }
        }
        long answer = 0;
        for (long sum = k; sum >= 0; sum--) {
            if (sumPossibleMap.getOrDefault(sum, new HashSet<>()).size() > 0) return sum;
        }
        return answer;
    }


    public static long maxSum(List<Long> arr, long threshold) {
        return sumBacktracking(arr,arr.size()-1,threshold,0);
    }

    private static long sumBacktracking(List<Long> arr, int n, long threshold, long sum) {
        if (n < 0)
            return sum;
        long included = 0;
        if (sum + arr.get(n) <= threshold) {
            included = sumBacktracking(arr, n - 1, threshold, sum + arr.get(n));
        }
        long excluded = sumBacktracking(arr, n - 1, threshold, sum);
        long maxReach = sum;
        if (included <= threshold && included >= sum) {
            maxReach = included;
        }
        if (maxReach <= excluded && excluded <= threshold && maxReach >= sum) {
            maxReach = excluded;
        }
        return maxReach;
    }

    public static void main(String[] args) throws IOException {
/*
        List<Integer> employeesFrom = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 1));
        List<Integer> employeesTo = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 5));
*/
        List<Integer> employeesFrom = new ArrayList<>(Arrays.asList(1));
        List<Integer> employeesTo = new ArrayList<>(Arrays.asList(2));
//        System.out.println(order(3, employeesFrom, employeesTo, 2));

        boolean[] ar = new boolean[10000000];
        List<Long> arr = new ArrayList<>(Arrays.asList(1l, 3l, 5l));//,4l,5l,6l,7l,8l));
        System.out.println(maxSum(arr, 2));
    }


}
