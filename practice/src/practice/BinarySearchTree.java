package practice;

import java.util.*;


public class BinarySearchTree {
    class Node {
        int data;
        Node l;
        Node r;

        Node(int data) {
            this.data = data;
            l = r = null;
        }

        Node(int data, Node l, Node r) {
            this.data = data;
            this.l = l;
            this.r = r;
        }
    }

    Node root = null;
    Stack<Node> fs = new Stack<>();
    Stack<Node> bs = new Stack<>();
    Node cur1, cur2;

    void initialize() {
        cur1 = cur2 = root;
    }

    void insert(int data) {
        Node n = new Node(data);
        Node i = root, prev = root;
        while (i != null) {
            prev = i;
            if (n.data <= i.data)
                i = i.l;
            else
                i = i.r;
        }
        if (prev == null) {
            root = n;
        } else {
            if (n.data <= prev.data)
                prev.l = n;
            else
                prev.r = n;
        }
    }

    // using stack
    int inorder_next() {
        int d = 0;
        while (!fs.empty() || cur1 != null) {
            if (cur1 != null) {
                fs.push(cur1);
                cur1 = cur1.l;
            } else {
                cur1 = fs.peek();
                fs.pop();
                d = cur1.data;
                cur1 = cur1.r;
                break;
            }
        }
        return d;
    }

    int rinorder_next() {
        int d = 0;
        while (!bs.empty() || cur2 != null) {
            if (cur2 != null) {
                bs.push(cur2);
                cur2 = cur2.r;
            } else {
                cur2 = bs.peek();
                bs.pop();
                d = cur2.data;
                cur2 = cur2.l;
                break;
            }
        }
        return d;
    }

    // using recursion
    void inOrder() {
        inOrder(root);
    }

    void findSumExist(int n) {
        initialize();
        int l = inorder_next();
        int r = rinorder_next();
        while (l < r) {
            System.out.println(l + " " + r);
            if (l + r == n) {
                System.out.println("sum found" + l + " " + r);
                break;
            } else if (n > l + r) {
                l = inorder_next();
            } else {
                r = rinorder_next();
            }
        }
    }

    void inOrder(Node root) {
        if (root == null)
            return;
        if (root.l != null)
            inOrder(root.l);
        System.out.print(root.data + " --> ");
        if (root.r != null)
            inOrder(root.r);
    }

    int lCABSearchTree(int a, int b) {
        if (root == null)
            return 0;
        Node temp = root;
        while (true) {
            if (temp.data > a && temp.data > b) {
                temp = temp.l;
            } else if (temp.data < a && temp.data < b) {
                temp = temp.r;
            } else {
                break;
            }
        }
        return temp.data;
    }

    private void printkdistanceDownNodes(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
        } else {
            printkdistanceDownNodes(root.l, k - 1);
            printkdistanceDownNodes(root.r, k - 1);
        }
    }

    int printkdistanceNode(Node root, int target, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == target) {
            printkdistanceDownNodes(root, k);
            return 0;
        }
        int dt = printkdistanceNode(root.l, target, k);
        if (dt != -1) {
            if (dt + 1 == k) {
                System.out.print(root.data + " ");
            } else {
                printkdistanceDownNodes(root.r, k - dt - 2);
            }
            return dt + 1;
        }

        dt = printkdistanceNode(root.r, target, k);
        if (dt != -1) {
            if (dt + 1 == k) {
                System.out.print(root.data + " ");
            } else {
                printkdistanceDownNodes(root.l, k - dt - 2);
            }
            return dt + 1;
        }

        return -1;
    }


    class Index {
        int i;
    }

    private void replaceNodeInorder(Node root, List<Integer> nodes, Index index) {
        if (root == null)
            return;
        if (root.l != null) {
            replaceNodeInorder(root.l, nodes, index);
        }
        root.data = nodes.get(index.i);
        index.i++;
        if (root.r != null) {
            replaceNodeInorder(root.r, nodes, index);
        }
    }

    Node binaryTreeToBinarySearchTree(Node root) {
        List<Integer> values = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            values.add(temp.data);
            if (temp.l != null) queue.add(temp.l);
            if (temp.r != null) queue.add(temp.r);
        }

        // do inorder and set
        Collections.sort(values);
        Index index = new Index();
        index.i = 0;
        replaceNodeInorder(root, values, index);

        return null;
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        int in;
        int arr[] = {5, 1, 8, 7, 3, 2, 4, 6};
        // { 29, 19, 11, 1, 22, 55, 53, 50, 95, 75 };
        for (int i = 0; i < arr.length; i++) {
            // in = (int) (Math.random() * 10000);
            in = arr[i];
            bst.insert(in);
        }
        System.out.println();
        bst.inOrder();
        bst.findSumExist(8);
        System.out.println();

        //Common ancester
        bst = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.inOrder();
        System.out.println();
        System.out.println("" +
                "      /5\\\n" +
                " 1\\        /8\n" +
                "  /3\\    /7\n" +
                " 2   4   6");

        System.out.println("Binary Search Tree Lowest Common ancestor of 2 ,4 is " + bst.lCABSearchTree(2, 4));

        // System.out.println("Binary Tree Lowest Common ancestor of 2 ,4 is " + bst.lCABTree(2, 4));
        System.out.println("2 distance nodes ");
        bst.printkdistanceNode(bst.root, 1, 2);


        System.out.println("===== binary tree to binary search tree ===");
        System.out.println("          10\n" +
                "         /  \\\n" +
                "        2    7\n" +
                "       / \\\n" +
                "      8   4");
        bst = new BinarySearchTree();
        bst.root = bst.new Node(10);
        bst.root.l = bst.new Node(2);
        bst.root.r = bst.new Node(7);
        bst.root.l.l = bst.new Node(8);
        bst.root.l.r = bst.new Node(4);
        System.out.println("Old inorder");
        bst.inOrder(bst.root);
        bst.binaryTreeToBinarySearchTree(bst.root);
        System.out.println("new inorder");
        bst.inOrder(bst.root);
    }
}
