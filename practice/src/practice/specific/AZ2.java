package practice.specific;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

public class AZ2 {

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

    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(1, 2))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(2, 3))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(3, 4))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(4, 5))));
        a.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(6, 3))));

        List<Integer> res = criticalRouters(6, 5, a);
        System.out.println(res);
    }


    static public ArrayList<String> topNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors,
                                                    int numReviews, List<String> reviews) {

        Set<String> comps = new HashSet<>(competitors);

        Map<String, Integer> map = comps.stream().map(s -> s.toLowerCase())
                .map(s -> s.replaceAll(" ", "#"))
                .collect(Collectors.toMap(s -> s, v -> 0));
        List<String> reviewsNew = new ArrayList<>();

        for (String s : reviews) {
            for (String cc : comps) {
                s = s.replaceAll(cc, cc.replaceAll(" ", "#"));
            }
            reviewsNew.add(s);
        }

        for (String review : reviewsNew) {

            review = review.toLowerCase();
            review = review.replaceAll(";", " ");
            review = review.replaceAll(",", " ");
            String c[] = review.split(" ");
            HashSet<String> compNamesInReview = new HashSet<>();
            for (String cc : c) {
                if (map.containsKey(cc)) {
                    if (!compNamesInReview.contains(cc)) {
                        map.put(cc, map.get(cc) + 1);
                    }
                    compNamesInReview.add(cc);
                }
            }
            //review = review.replaceAll(".", " ");
        }

        Comparator<Map.Entry<String, Integer>> byCount = (e1, e2) -> {
            if (e2.getValue() == e1.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue() - e1.getValue();
        };
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(byCount);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < topNCompetitors; i++) {
            Map.Entry<String, Integer> e = pq.remove();
            if (e.getValue() == 0) break;
            ans.add(e.getKey().replaceAll("#", " "));
        }

        //System.out.println(map);
        return ans;
    }

}


