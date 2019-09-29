package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InterviewbitGraph {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

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
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitGraph ibit = new InterviewbitGraph();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(5);
/*
        6
    5       4
4        9      5
*/
        //System.out.println(ibit.SmallestSequenceWithGivenPrimes(3, 11, 7, 50));
        //System.out.println(ibit.LevelOrder(root));

//        System.out.println(ibit.ValidPath(2, 3, 1, 1, new ArrayList<>(Arrays.asList(2)), new ArrayList<>(Arrays.asList(3))));//No
//        System.out.println(ibit.ValidPath(8, 10, 2, 2, new ArrayList<>(Arrays.asList(3, 4)),new ArrayList<>(Arrays.asList(3, 4))));//yes
//        System.out.println(ibit.ValidPath(61, 88, 2, 9, new ArrayList<>(Arrays.asList(3, 55)),new ArrayList<>(Arrays.asList(18, 83)))); ///NO
        //System.out.println(ibit.ValidPath(35, 26, 6, 8, new ArrayList<>(Arrays.asList(11,15,16,25,28,33)),new ArrayList<>(Arrays.asList(2,17,24,19,3,7))));//NO
        //System.out.println(ibit.SmallestMultipleWith0And1(55));

/*        ArrayList<ArrayList<Integer>> pathCost = new ArrayList<>();
        int[][] pathCostMatrix = new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {4, 5, 6}, {5, 1, 2}, {2, 4, 3}, {2, 5, 5}, {1, 3, 2}};
        for (int[] a : pathCostMatrix) {
            ArrayList<Integer> path = new ArrayList<>();
            for (int a1 : a) {
                path.add(a1);
            }
            pathCost.add(path);
        }
        System.out.println(ibit.CommutableIslands(5, pathCost));*/

/*        ArrayList<String> grid = new ArrayList<>(Arrays.asList("OOOXOOO", "OOXXOXO", "OXOOOXO"));
        System.out.println(ibit.BlackShapes(grid));*/

       /* ArrayList<ArrayList<Character>> grid = new ArrayList<>(4);
        String[] arr = new String[]{"XXXX", "XOOX", "XXOX", "XOXX"};
        for (String s : arr) {
            ArrayList<Character> a = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                a.add(s.charAt(i));
            }
            grid.add(a);
        }

        System.out.println(grid);
        ibit.CaptureRegionsonBoard(grid);
        System.out.println(grid);*/

        System.out.println(ibit.SteppingNumbers(10, 20));

    }

    ArrayList<Integer> SteppingNumbers(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> s = new TreeSet<>();
        for (int i = 0; i <= 9; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int steppingNo = queue.poll();
            if (steppingNo >= n && steppingNo <= m) {
                s.add(steppingNo);
            }
            if (steppingNo == 0 || steppingNo > m) {
                continue;
            }

            int lastDigit = steppingNo % 10;
            int a = steppingNo * 10 + lastDigit + 1;
            int b = steppingNo * 10 + lastDigit - 1;
            if (lastDigit == 0)
                queue.add(a);
            else if (lastDigit == 9)
                queue.add(b);
            else {
                queue.add(a);
                queue.add(b);
            }
        }

        return new ArrayList<>(s);
    }

    void CaptureRegionsonBoard(ArrayList<ArrayList<Character>> grid) {
        /*
         A = [ [X, X, X, X],
          [X, O, O, X],
          [X, X, O, X],
          [X, O, X, X] ]
          after A = [ [X, X, X, X],
          [X, X, X, X],
          [X, X, X, X],
          [X, O, X, X] ]
         */
        if (grid == null || grid.size() < 2 || grid.get(0).size() < 2) {
            return;
        }

        int row = grid.size();
        int col = grid.get(0).size();

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid.get(i).get(j) == 'O')
                    grid.get(i).set(j, '-');

        for (int i = 0; i < row; i++) {
            if (i == 0 || i == row - 1) {
                for (int j = 0; j < col; j++)
                    if (grid.get(i).get(j) == '-')
                        uncaptureRegions(i, j, row, col, grid);
            } else {
                if (grid.get(i).get(0) == '-')
                    uncaptureRegions(i, 0, row, col, grid);
                if (grid.get(i).get(col - 1) == '-')
                    uncaptureRegions(i, col - 1, row, col, grid);
            }
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid.get(i).get(j) == '-')
                    grid.get(i).set(j, 'X');

    }

    private void uncaptureRegions(int r, int c, int row, int col, ArrayList<ArrayList<Character>> grid) {
        if (r < 0 || r == row || c < 0 || c == col || grid.get(r).get(c) != '-') {
            return;
        }
        grid.get(r).set(c, 'O');
        uncaptureRegions(r + 1, c, row, col, grid);
        uncaptureRegions(r - 1, c, row, col, grid);
        uncaptureRegions(r, c + 1, row, col, grid);
        uncaptureRegions(r, c - 1, row, col, grid);
    }

    int BlackShapes(ArrayList<String> grid) {
        if (grid == null || grid.size() == 0) {
            return 0;
        }
        int row = grid.size();
        int col = grid.get(0).length();
        boolean[][] visited = new boolean[grid.size()][grid.get(0).length()];
        int blacks = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid.get(i).charAt(j) == 'X' && !visited[i][j]) {
                    blacks++;
                    visitConnectedComponent(i, j, visited, grid);
                }
            }
        }
        return blacks;
    }

    private void visitConnectedComponent(int r, int c, boolean[][] visited, ArrayList<String> grid) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;

        int[] adjX = new int[]{-1, 1, 0, 0};
        int[] adjY = new int[]{0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int x = r + adjX[i];
            int y = c + adjY[i];
            if (canVisit(visited, x, y) && grid.get(x).charAt(y) == 'X') {
                visitConnectedComponent(x, y, visited, grid);
            }
        }
    }


    int CommutableIslands(int V, ArrayList<ArrayList<Integer>> pathCost) {
        WGraph wGraph = new WGraph(V);
        for (ArrayList<Integer> a : pathCost) {
            wGraph.addEdge(a.get(0) - 1, a.get(1) - 1, a.get(2));
        }
        class Node {
            int vertex;
            int key;//edge weight
        }
        boolean[] mstset = new boolean[V];
        Node[] e = new Node[V];

        for (int i = 0; i < V; i++)
            e[i] = new Node();

        for (int i = 0; i < V; i++) {
            mstset[i] = false;
            e[i].key = Integer.MAX_VALUE;
            e[i].vertex = i;
        }
        mstset[0] = true;
        e[0].key = 0;

        // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
        TreeSet<Node> queue = new TreeSet<>((u, v) -> {
            if (u.key - v.key != 0) {
                return u.key - v.key;
            } else
                return u.vertex - v.vertex;
        });

        for (int i = 0; i < V; i++) {
            queue.add(e[i]);
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            Node node0 = queue.pollFirst();
            mstset[node0.vertex] = true;
            sum += node0.key;

            for (WGNode wgNode : wGraph.adj.get(node0.vertex)) {
                if (!mstset[wgNode.dest] && e[wgNode.dest].key > wgNode.weight) {
                    queue.remove(e[wgNode.dest]);
                    e[wgNode.dest].key = wgNode.weight;
                    queue.add(e[wgNode.dest]);
//                    parent[wgNode.dest] = node0.vertex;
                }
            }
        }
        return sum;
    }

    String SmallestMultipleWith0And1(int n) {
        if (n == 0) {
            return "0";
        }

        int[] parent = new int[n];
        int[] step = new int[n];

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(1 % n);
        //parent[1%n]=0;

        int currentRemainder = 0;
        while (!bfsQueue.isEmpty()) {
            Integer remainder = bfsQueue.poll();
            currentRemainder = remainder % n;

            if (currentRemainder == 0) {
                break;
            }
            currentRemainder = (currentRemainder * 10) % n;
            if (parent[currentRemainder] == 0) {
                bfsQueue.add(currentRemainder);
                parent[currentRemainder] = remainder;
                step[currentRemainder] = 0;
            }
            currentRemainder = (currentRemainder + 1) % n;
            if (parent[currentRemainder] == 0) {
                bfsQueue.add(currentRemainder);
                parent[currentRemainder] = remainder;
                step[currentRemainder] = 1;
            }
        }

        StringBuilder s = new StringBuilder();
        while (parent[currentRemainder] != 0) {
            s.append(step[currentRemainder]);
            currentRemainder = parent[currentRemainder];
            if (currentRemainder == 1)
                break;
        }
        s.append(1);
        return s.reverse().toString();
    }

    String ValidPath(int x, int y, int n, int radius, ArrayList<Integer> circleX, ArrayList<Integer> circleY) {
        boolean[][] grid = new boolean[x + 1][y + 1];
        //boolean[][] visited = new boolean[x + 1][y + 1];
        for (int i = 0; i < n; i++) {
            markNotVisitableCoordinate(circleX.get(i), circleY.get(i), radius, grid);
        }
        if (grid[0][0])
            return "NO";

        class Point {
            int x;
            int y;

            Point(int a, int b) {
                x = a;
                y = b;
            }
        }

        int[] adjacent = new int[]{-1, 0, 1};

        Queue<Point> bfsqueue = new LinkedList<>();
        bfsqueue.add(new Point(0, 0));

        while (!bfsqueue.isEmpty()) {
            Point current = bfsqueue.poll();
            if (x == current.x && y == current.y) {
                return "YES";
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (canVisit(grid, current.x + adjacent[i], current.y + adjacent[j])) {
                        bfsqueue.add(new Point(current.x + adjacent[i], current.y + adjacent[j]));
                        grid[current.x + adjacent[i]][current.y + adjacent[j]] = true;
                    }
                }
            }
        }

        return "NO";
    }

    private boolean canVisit(boolean[][] grid, int x, int y) {
        int l = grid.length;
        int h = grid[0].length;
        if (x < 0 || x >= l || y < 0 || y >= h || grid[x][y]) {
            return false;
        }
        return true;
    }

    private void markNotVisitableCoordinate(int x, int y, int r, boolean[][] grid) {
        int xl = grid.length;
        int yl = grid[0].length;
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (((i - x) * (i - x) + (j - y) * (j - y)) <= r * r) {
                    grid[i][j] = true;
                }
            }
        }
    }

    private void printGrid(boolean[][] grid) {
        System.out.print("    ");
        for (int i = 0; i < grid[0].length; i++) {
            System.out.print(i % 10 + "-");
        }
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            System.out.print(i + "-> ");
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] == true ? "1-" : "0-");
            }
            System.out.println();
        }
    }

    ArrayList<ArrayList<Integer>> LevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);
        while (!queue.isEmpty()) {
            ArrayList<Integer> res = new ArrayList<>();
            TreeNode first = queue.poll();
            while (first != null) {
                res.add(first.val);
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
                first = queue.poll();
            }
            result.add(res);
            if (!queue.isEmpty())
                queue.add(null);
        }
        return result;
    }

    public ArrayList<Integer> SmallestSequenceWithGivenPrimes(int A, int B, int C, int D) {
        TreeSet<Integer> visited = new TreeSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (D == 0)
            return result;
        visited.add(A);
        visited.add(B);
        visited.add(C);
        while (D != 0) {
            int curr = visited.first();
            visited.remove(curr);
            result.add(curr);

            int mulA = A * curr;
            int mulB = B * curr;
            int mulC = C * curr;
            visited.add(mulA);
            visited.add(mulB);
            visited.add(mulC);
            D--;
        }
        return result;
    }

}
