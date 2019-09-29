package practice.ibit;

import org.apache.commons.collections.CollectionUtils;

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

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.left.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

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
//        System.out.println(ibit.solve("cool_ice_wifi", new ArrayList<>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"))));
//        System.out.println(ibit.buildTree(new ArrayList<>(Arrays.asList(5,10,40,30,28)))); // Given an inorder traversal of a cartesian tree, construct the tree.
//        System.out.println(ibit.sortedArrayToBST(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
//        System.out.println(ibit.TreefromInPost(new ArrayList<>(Arrays.asList(2, 3, 4, 1, 5)), new ArrayList<>(Arrays.asList(3, 2, 5, 1, 4))));
//        System.out.println(ibit.TreefromInPre(new ArrayList<>(Arrays.asList(2, 3, 4, 1, 5)), new ArrayList<>(Arrays.asList(4, 2, 3, 1, 5))));
//        System.out.println(ibit.recoverTree(root));

        /*TreeLinkNode root1 = new TreeLinkNode(1);
        root1.left = new TreeLinkNode(2);
        root1.left.left = new TreeLinkNode(3);
        ibit.connect(root1);
        System.out.println(ibit.recoverTree(root));*/

//        System.out.println(ibit.prefix(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"))));

//        System.out.println(ibit.lca(root, 1, 2));
        /*TreeNode result = ibit.flatenBTToLinkList(root);
        System.out.println(result);*/
        ArrayList<Integer> height = new ArrayList<>(Arrays.asList(5, 3, 4, 6, 1, 2));
        ibit.arrange(height, new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 2)));
        System.out.println(height);


        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.left.right = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
/*
          4
    2          6
       3   5     7
*/
        //System.out.println("--"+ibit.isValidBST(root1));
        System.out.println(ibit.isValidBST(root));
    }

    public int isValidBST(TreeNode A) {
        return isValidBSTUtil(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBSTUtil(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val < min || root.val > max) {
            return false;
        }
        return isValidBSTUtil(root.left,min,root.val-1) && isValidBSTUtil(root.right,root.val+1,max);
    }

    // people heights
    public void arrange(ArrayList<Integer> A, ArrayList<Integer> B) {//height,frontcount

        Integer[] heights = A.toArray(new Integer[A.size()]);
        Integer[] frontCounts = B.toArray(new Integer[B.size()]);
        Person[] persons = new Person[heights.length];

        for (int i = 0; i < persons.length; i++)
            persons[i] = new Person(heights[i], frontCounts[i]);

        Arrays.sort(persons, (p1, p2) -> Integer.compare(p2.height, p1.height));

        Node root = new Node(persons[0]);

        for (int i = 1; i < persons.length; i++) {
            insert(root, persons[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(root, result);
    }


    private void insert(Node root, Person p) {
        insert(root, p, p.frontCount);
    }

    private void insert(Node root, Person p, int value) {
        if (value < root.value) { // should insert to the left
            if (root.left == null) {
                root.left = new Node(p);
            } else {
                insert(root.left, p, value);
            }
            root.value++; // Increase the current node value while descending left!
        } else { // insert to the right
            if (root.right == null) {
                root.right = new Node(p);
            } else {
                insert(root.right, p, value - root.value);
            }
        }
    }

    private void inOrder(Node root, ArrayList<Integer> result) {
        if (root == null)
            return;

        inOrder(root.left, result);
        result.add(root.person.height);
        inOrder(root.right, result);
    }

    static class Node {
        Node left, right;
        int value;
        public final Person person;

        public Node(Person person) {
            this.value = 1;
            this.person = person;
        }
    }

    static class Person {
        public final int height;
        public final int frontCount;

        Person(int height, int frontCount) {
            this.height = height;
            this.frontCount = frontCount;
        }
    }
    //===//

    public TreeNode flatenBTToLinkList(TreeNode A) {
        if (A == null) {
            return null;
        }
        flatenBTToLinkList(A.left);
        flatenBTToLinkList(A.right);
        if (A.left != null) {
            TreeNode leftLastNode = A.left;
            while (leftLastNode.right != null) {
                leftLastNode = leftLastNode.right;
            }
            TreeNode temp = A.right;
            A.right = A.left;
            leftLastNode.right = temp;
            A.left = null;
        }

        return A;
    }


    //lca in BST
    public int lca(TreeNode A, int B, int C) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        if (!findPath(A, path1, B) || !findPath(A, path2, C)) {
            return -1;
        }

        int i;
        for (i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }
        return path1.get(i - 1);

    }

    private boolean findPath(TreeNode A, List<Integer> path1, int data) {
        if (A == null) {
            return false;
        }
        path1.add(A.val);
        if (A.val == data) {
            return true;
        }
        if (A.left != null && findPath(A.left, path1, data)) {
            return true;
        }

        if (A.right != null && findPath(A.right, path1, data)) {
            return true;
        }
        path1.remove(path1.size() - 1);
        return false;
    }

    // shortest unique prefix
    public ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> result = new ArrayList<>();
        if (A == null) {
            return result;
        } else if (A.size() == 1) {
            result.add(new String(A.get(0).charAt(0) + ""));
            return result;
        }

        Map<String, Integer> hm = new HashMap<>();
        //A.stream().collect(Collectors.toMap(u->u,  i + 1));
        int k = 0;
        for (String s : A) {
            hm.put(s, k++);
            result.add(null);
        }

        A.sort(String::compareTo);

        int j = 0;
        while (j < Math.min(A.get(0).length(), A.get(1).length())) {
            if (A.get(0).charAt(j) == A.get(1).charAt(j))
                j++;
            else
                break;
        }

        result.set(hm.get(A.get(0)), A.get(0).substring(0, j + 1));

        /* Store the unique prefix of a[1] from its left neighbor */
        String temp_prefix = A.get(1).substring(0, j + 1);
        for (int i = 1; i < A.size() - 1; i++) {

            j = 0;
            while (j < Math.min(A.get(i).length(), A.get(i + 1).length())) {
                if (A.get(i).charAt(j) == A.get(i + 1).charAt(j))
                    j++;
                else
                    break;
            }
            String new_prefix = A.get(i).substring(0, j + 1);
            if (temp_prefix.length() > new_prefix.length())
                result.set(hm.get(A.get(i)), temp_prefix);
            else
                result.set(hm.get(A.get(i)), new_prefix);

            temp_prefix = A.get(i + 1).substring(0, j + 1);
        }

        j = 0;
        String sec_last = A.get(A.size() - 2);
        String last = A.get(A.size() - 1);

        while (j < Math.min(sec_last.length(), last.length())) {
            if (sec_last.charAt(j) == last.charAt(j))
                j++;
            else
                break;
        }

        result.set(hm.get(last), last.substring(0, j + 1));
        return result;

    }


    //==
    static class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        TreeLinkNode(int a) {
            val = a;
        }
    }

    //connect next right
    public void connect(TreeLinkNode root) {
        TreeLinkNode temp = null;
        if (root == null)
            return;
        root.next = null;

        while (root != null) {
            TreeLinkNode q = root;
            while (q != null) {
                if (q.left != null) {
                    if (q.right != null)
                        q.left.next = q.right;
                    else
                        q.left.next = getNextRightForChildOf(q);
                }

                if (q.right != null)
                    q.right.next = getNextRightForChildOf(q);
                q = q.next;
            }

            if (root.left != null)
                root = root.left;
            else if (root.right != null)
                root = root.right;
            else
                root = getNextRightForChildOf(root);
        }
    }

    TreeLinkNode getNextRightForChildOf(TreeLinkNode p) {
        TreeLinkNode temp = p.next;

        while (temp != null) {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.next;
        }
        return null;
    }
    //==//


    //===
    class RecoverTree {
        TreeNode prev, first, mid, last;
    }

    public ArrayList<Integer> recoverTree(TreeNode A) {// tree has 2 value swapped
        if (A == null) {
            return new ArrayList<>();
        }

        RecoverTree swNodes = new RecoverTree();
        recoverTreeWhere2ValueSwapped(A, swNodes);

        ArrayList<Integer> result = new ArrayList<>();
        if (swNodes.last == null) {
            result.add(swNodes.mid.val);
            result.add(swNodes.first.val);
        } else {
            result.add(swNodes.last.val);
            result.add(swNodes.first.val);
        }
        return result;
    }

    private void recoverTreeWhere2ValueSwapped(TreeNode root, RecoverTree swNodes) {
        if (root == null) {
            return;
        }
        recoverTreeWhere2ValueSwapped(root.left, swNodes);
        if (swNodes.prev != null && swNodes.prev.val > root.val) {
            if (swNodes.first == null) {
                swNodes.first = swNodes.prev;
                swNodes.mid = root;
            } else {
                swNodes.last = root;
            }
        }
        swNodes.prev = root;
        recoverTreeWhere2ValueSwapped(root.right, swNodes);
    }
    //===//


    class PIndex {
        int index;
    }

    public TreeNode TreefromInPre(final List<Integer> inOrder, final List<Integer> preOrder) {
        if (inOrder == null) {
            return null;
        }
        Map<Integer, Integer> dataToIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            dataToIndexMap.put(inOrder.get(i), i);
        }

        PIndex pIndex = new PIndex();
        pIndex.index = 0;

        TreeNode root = buildTreeFromInOrderAndPreOrder(0, inOrder.size() - 1, preOrder, pIndex, dataToIndexMap);
        return root;
    }

    private TreeNode buildTreeFromInOrderAndPreOrder(int start, int end, final List<Integer> preOrder, PIndex pIndex,
                                                     Map<Integer, Integer> dataToIndexMap) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder.get(pIndex.index));
        int nodeInorderIndex = dataToIndexMap.get(preOrder.get(pIndex.index));
        pIndex.index++;

        node.left = buildTreeFromInOrderAndPreOrder(start, nodeInorderIndex - 1, preOrder, pIndex, dataToIndexMap);
        node.right = buildTreeFromInOrderAndPreOrder(nodeInorderIndex + 1, end, preOrder, pIndex, dataToIndexMap);

        return node;
    }


    public TreeNode TreefromInPost(final List<Integer> inOrder, final List<Integer> postOrder) {
        if (inOrder == null) {
            return null;
        }
        Map<Integer, Integer> dataToIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            dataToIndexMap.put(inOrder.get(i), i);
        }

        PIndex pIndex = new PIndex();
        pIndex.index = postOrder.size() - 1;

        TreeNode root = buildTreeFromInOrderAndPostOrder(0, inOrder.size() - 1, postOrder, pIndex, dataToIndexMap);
        return root;
    }

    private TreeNode buildTreeFromInOrderAndPostOrder(int start, int end, final List<Integer> postOrder, PIndex pIndex,
                                                      Map<Integer, Integer> dataToIndexMap) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(postOrder.get(pIndex.index));
        int nodeInorderIndex = dataToIndexMap.get(postOrder.get(pIndex.index));
        pIndex.index--;

        node.right = buildTreeFromInOrderAndPostOrder(nodeInorderIndex + 1, end, postOrder, pIndex, dataToIndexMap);
        node.left = buildTreeFromInOrderAndPostOrder(start, nodeInorderIndex - 1, postOrder, pIndex, dataToIndexMap);
        return node;
    }


    //=====
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if (a == null) {
            return null;
        }
        TreeNode root = buildTreeFromSortedArray(a, 0, a.size() - 1);
        return root;
    }

    private TreeNode buildTreeFromSortedArray(final List<Integer> a, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = buildTreeFromSortedArray(a, start, mid - 1);
        node.right = buildTreeFromSortedArray(a, mid + 1, end);
        return node;
    }
    //=====//


    // Given an inorder traversal of a cartesian tree, construct the tree.
    public TreeNode buildTree(ArrayList<Integer> A) {
        if (CollectionUtils.isEmpty(A)) {
            return null;
        }
        TreeNode root = null;
        root = buildCartesianTree(A, 0, A.size() - 1);
        return root;
    }

    private TreeNode buildCartesianTree(ArrayList<Integer> inorder, int start, int end) {
        if (start > end)
            return null;

        int i = max(inorder, start, end);
        TreeNode node = new TreeNode(inorder.get(i));

        if (start == end)
            return node;

        node.left = buildCartesianTree(inorder, start, i - 1);
        node.right = buildCartesianTree(inorder, i + 1, end);
        return node;
    }

    private int max(ArrayList<Integer> inorder, int start, int end) {
        int i, max = inorder.get(start), maxind = start;
        for (i = start + 1; i <= end; i++) {
            if (inorder.get(i) > max) {
                max = inorder.get(i);
                maxind = i;
            }
        }
        return maxind;
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
            reviewOrders.add(new ReviewOrder(i, count));
        }
        reviewOrders.sort((u, v) -> {
            int goodness = -(u.count - v.count);
            if (goodness == 0) {
                return u.index - v.index;
            } else {
                return goodness;
            }
        });

        ArrayList<Integer> result = new ArrayList<>(reviewOrders.stream().map(u -> u.index).collect(Collectors.toList()));
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
