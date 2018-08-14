package practice.specific;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class LevelOrderGraph {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        q.add(null);
        ArrayList<Integer> a = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t == null) {
                res.add(a);
//                a=new ArrayList<>();
                if (!q.isEmpty())
                    q.add(null);
            } else {
                a.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
        }

        return res;

    }

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static public int adjacent(ArrayList<Integer> x) {
        int n = x.size();
        int incl = x.get(0);

        // Not including first column's element
        int excl = 0, excl_new;

        for(int i =1; i<n; i++) {
            excl_new = Math.max(incl,excl);
            incl = x.get(i) + excl;
            excl = excl_new;
        }


        // Return maximum of excl and incl
        // As that will be the maximum sum
        return Math.max(excl, incl);

    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.add(A);

        while (!s.isEmpty()) {
            TreeNode x = s.pop();
            res.add(x.val);
            if (x.right != null) {
                s.push(x.right);
            }
            if (x.left != null) {
                s.push(x.left);
            }
        }

        return res;
    }


    public static void main(String... args) {
        System.out.println("DASCSDASD");

        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(60, 90, 60));

        System.out.println(adjacent(x));
    }

}
