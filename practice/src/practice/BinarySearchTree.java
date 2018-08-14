package practice;

import java.util.Stack;

class tNode {
    int data;
    tNode l;
    tNode r;

    tNode(int data) {
        this.data = data;
        l = r = null;
    }

    tNode(int data, tNode l, tNode r) {
        this.data = data;
        this.l = l;
        this.r = r;
    }
}

public class BinarySearchTree {

    tNode root = null;
    Stack<tNode> fs = new Stack<tNode>();
    Stack<tNode> bs = new Stack<tNode>();
    tNode cur1, cur2;

    void initialize() {
        cur1 = cur2 = root;
    }

    void insert(int data) {
        tNode n = new tNode(data);
        tNode i = root, prev = root;
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

    void inOrder(tNode root) {
        if (root == null)
            return;
        if (root.l != null)
            inOrder(root.l);
        System.out.print(root.data + " --> ");
        if (root.r != null)
            inOrder(root.r);
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
        bst.initialize();
        int l = bst.inorder_next();
        int r = bst.rinorder_next();
        int n = 0;
        while (l < r) {
            System.out.println(l + " " + r);
            if (l + r == n) {
                System.out.println("sum found" + l + " " + r);
                break;
            } else if (n > l + r) {
                l = bst.inorder_next();
            } else {
                r = bst.rinorder_next();
            }
        }
        System.out.println();


        Class c = arr.getClass();
        String name = c.getName();
        System.out.println("=" + name);

    }
}
