package practice.ibit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class InterviewbitTree {

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        InterviewbitTree ibit = new InterviewbitTree();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
//        root.right = new TreeNode(4);
        //root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(5);

/*
        6
    5       4
4        9      5
*/

//        System.out.println(ibit.verticalOrderTraversal(root));
//        System.out.println(ibit.inorderTraversal(root));
//        System.out.println(ibit.postOrderTraversal(root));
//        System.out.println(ibit.preorderTraversal(root));
//        System.out.println(ibit.zigzagLevelOrder(root));
//        System.out.println(ibit.hasPathSum(root, 22));
//        System.out.println(ibit.pathSum(root, 15));
//        System.out.println(ibit.maxDepth(root));
//        System.out.println(ibit.minDepth(root));
//        System.out.println(ibit.sumNumbers(root));
//        System.out.println(ibit.isSameTree(root,root));
//        System.out.println(ibit.isSymmetric(root));
//        System.out.println(ibit.isBalanced(root));
//        System.out.println(ibit.invertTree(root));//mirror
//        System.out.println(ibit.kthsmallest(root, 3));
        System.out.println(ibit.solve("cool_ice_wifi", new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
    }


    //hotel Reviews https://www.interviewbit.com/problems/hotel-reviews/
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        class ReviewOrder {
            int index;
            int count;

            ReviewOrder(int a, int b) {
                index = a;
                count = b;
            }
        }
        Set<String> goodWords = new HashSet<>(Arrays.asList(A.split("_")));
        List<ReviewOrder> reviewOrders = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int count = 0;
            for (String word : B.get(i).split("_")) {
                if (goodWords.contains(word))
                    count++;
            }
            reviewOrders.add(new ReviewOrder(i,count));
        }
        reviewOrders.sort((u,v)-> {
            int goodness = -(u.count-v.count);
            if(goodness == 0){
                return u.index-v.index;
            }else {
                return goodness;
            }
        });

        ArrayList<Integer> result = new ArrayList<>(reviewOrders.stream().map(u->u.index).collect(Collectors.toList()));
        return result;
    }

    public int kthsmallest(TreeNode A, int B) {
        int k = 0;
        TreeNode current = A;
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode top = stack.pop();
                k++;
                if (k == B) {
                    return top.val;
                }
                current = top.right;
            }
        }
        return 1;
    }


    public TreeNode invertTree(TreeNode A) {//mirror
        if (A == null) {
            return A;
        }
        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);
        A.left = right;
        A.right = left;
        return A;
    }


    //==========
    class Height {
        int height;

        Height(int h) {
            height = h;
        }
    }

    public int isBalanced(TreeNode A) {
        if (isBalancedTree(A, new Height(0))) {
            return 1;
        }
        return 0;
    }

    private boolean isBalancedTree(TreeNode A, Height height) {
        if (A == null) {
            return true;
        }
        Height lh = new Height(0);
        boolean lb = isBalancedTree(A.left, lh);

        Height rh = new Height(0);
        boolean rb = isBalancedTree(A.right, rh);

        height.height = Math.max(lh.height, rh.height) + 1;

        return lb && rb && Math.abs(lh.height - rh.height) < 2;
    }

    int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
//==========

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isSymmetricTree(A.left, A.right);
    }

    private int isSymmetricTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        } else if ((A == null && B != null) || (A != null && B == null)) {
            return 0;
        } else if (A.val != B.val) {
            return 0;
        }

        int lfound = isSymmetricTree(A.left, B.right);
        int rfound = isSymmetricTree(A.right, B.left);
        if (lfound == 0 || rfound == 0) {
            return 0;
        }
        return 1;
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        } else if ((A == null && B != null) || (A != null && B == null)) {
            return 0;
        }

        if (A.val != B.val) {
            return 0;
        }
        int lfound = isSameTree(A.left, B.left);
        int rfound = isSameTree(A.right, B.right);
        if (lfound == 0 || rfound == 0) {
            return 0;
        }
        return 1;
    }

    public int sumNumbers(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) {
            return 0;
        }
        getAllNodeData(A, new ArrayList<>(), result);
        int mod = 1003;
        int totalSum = 0;
        for (ArrayList<Integer> list : result) {
            int mul = 1;
            int num = 0;
            for (Integer i : list) {
                num = num * 10 + i;
                num = num % mod;
            }
            totalSum = (totalSum + num) % mod;
        }
        return totalSum;
    }

    private void getAllNodeData(TreeNode A, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (A == null)
            return;
        ArrayList<Integer> currentPath = new ArrayList<>(path);
        currentPath.add(A.val);
        if (A.left == null && A.right == null) {
            result.add(currentPath);
            return;
        }
        getAllNodeData(A.left, currentPath, result);
        getAllNodeData(A.right, currentPath, result);
    }

    public int minDepth(TreeNode A) {
        if (A == null)
            return 0;

        if (A.left == null && A.right == null)
            return 1;

        int lh = 0;
        boolean lf = false;
        if (A.left != null) {
            lf = true;
            lh = minDepth(A.left);
        }

        int rh = 0;
        boolean rf = false;
        if (A.right != null) {
            rf = true;
            rh = minDepth(A.right);
        }

        if (lf && rf) {
            return 1 + Math.min(lh, rh);
        } else if (lf) {
            return 1 + lh;
        } else {
            return 1 + rh;
        }
    }

    public int maxDepth(TreeNode A) {
        if (A == null)
            return 0;
        return 1 + Math.max(maxDepth(A.left), maxDepth(A.right));
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) {
            return result;
        }
        getValidPathSum(A, B, new ArrayList<>(), result);
        return result;
    }

    private void getValidPathSum(TreeNode A, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (A == null)
            return;
        ArrayList<Integer> currentPath = new ArrayList<>(path);
        currentPath.add(A.val);
        if (A.left == null && A.right == null && A.val == sum) {
            result.add(currentPath);
            return;
        }

        if (A.left != null) {
            getValidPathSum(A.left, sum - A.val, currentPath, result);
        }
        if (A.right != null) {
            getValidPathSum(A.right, sum - A.val, currentPath, result);
        }
        return;
    }

    public int hasPathSum(TreeNode A, int B) {
        if (A == null)
            return 0;
        if (A.left == null && A.right == null && A.val == B) {
            return 1;
        }
        int lf = 0;
        int rf = 0;
        if (A.left != null) {
            lf = hasPathSum(A.left, B - A.val);
        }
        if (A.right != null) {
            rf = hasPathSum(A.right, B - A.val);
        }
        if (lf == 1 || rf == 1) {
            return 1;
        }
        return 0;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        //todo can be done by stack easily no need to reverse again and again
        boolean leftToRight = true;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) {
            return result;
        }
        List<TreeNode> left2Right = new LinkedList<>();
        List<TreeNode> right2Left = new LinkedList<>();
        left2Right.add(A);
        while (!left2Right.isEmpty() || !right2Left.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (leftToRight) {
                Collections.reverse(left2Right);
                for (TreeNode treeNode : left2Right) {
                    temp.add(treeNode.val);
                    if (treeNode.left != null)
                        right2Left.add(treeNode.left);
                    if (treeNode.right != null)
                        right2Left.add(treeNode.right);
                }
                left2Right.clear();
            } else {
                Collections.reverse(right2Left);
                for (TreeNode treeNode : right2Left) {
                    temp.add(treeNode.val);
                    if (treeNode.right != null)
                        left2Right.add(treeNode.right);
                    if (treeNode.left != null)
                        left2Right.add(treeNode.left);
                }
                right2Left.clear();
            }
            leftToRight = !leftToRight;
            result.add(temp);
        }
        return result;
    }


    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }

        return result;
    }

    public ArrayList<Integer> postOrderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(A);
        while (!stack1.empty()) {
            TreeNode top = stack1.pop();
            stack2.push(top);
            if (top.left != null)
                stack1.push(top.left);
            if (top.right != null)
                stack1.push(top.right);
        }
        while (!stack2.empty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode current = A;
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode top = stack.pop();
                result.add(top.val);
                current = top.right;
            }
        }
        return result;
    }

    class TreeNodeWithDistance {
        TreeNode treeNode;
        int distance;

        TreeNodeWithDistance(TreeNode A, int d) {
            treeNode = A;
            distance = d;
        }

    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        if (A == null) {
            return new ArrayList<>();
        }
        Map<Integer, ArrayList<Integer>> verticalNodesWithDistance = new TreeMap<>();

        Queue<TreeNodeWithDistance> treeNodeWithDistances = new LinkedList<>();
        treeNodeWithDistances.add(new TreeNodeWithDistance(A, 0));

        while (!treeNodeWithDistances.isEmpty()) {
            TreeNodeWithDistance qElement = treeNodeWithDistances.poll();

            if (!verticalNodesWithDistance.containsKey(qElement.distance)) {
                verticalNodesWithDistance.put(qElement.distance, new ArrayList<>());
            }
            verticalNodesWithDistance.get(qElement.distance).add(qElement.treeNode.val);
            if (qElement.treeNode.left != null)
                treeNodeWithDistances.add(new TreeNodeWithDistance(qElement.treeNode.left, qElement.distance - 1));
            if (qElement.treeNode.right != null)
                treeNodeWithDistances.add(new TreeNodeWithDistance(qElement.treeNode.right, qElement.distance + 1));
        }

        return new ArrayList<>(verticalNodesWithDistance.values());
    }

}
