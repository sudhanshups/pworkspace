package practice;


public class TreeRightPointer {

    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;

        }
    }

    static void connect(Node root) {
        if (root != null)
            connectUtil(root.left, root.right);
    }

    static Node getNextRight(Node node) {
        if (node == null)
            return node;
        if (node.left != null)
            return node.left;
        else
            return node.right;
    }

    static void connectUtil(Node l, Node r) {
        if (l == null && r == null)
            return;
        if (r != null)
            connectUtil(r.left, r.right);
        if (l != null) {
            l.nextRight = r;
            if (l.right == null && r != null) {
                connectUtil(l.left, getNextRight(r));
            } else if (r != null) {
                connectUtil(l.right, r.left);
            }
            connectUtil(l.left, l.right);
        }
    }


    public static void main(String args[]) {

/*        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(1);
        root.right.right = new Node(2);*/

        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);

        // preorder(root);
        connect(root);
        preorder(root);

    }

    static void preorder(Node root) {
        if (root == null)
            return;

        if (root.nextRight != null)
            System.out.println(root.data + " -> " + root.nextRight.data);
        else
            System.out.println(root.data + " -> " + root.nextRight);
        preorder(root.left);
        preorder(root.right);
    }
}