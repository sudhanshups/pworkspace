package practice;


public class TreeRightPointer {

    static class TreeLinkNode {
        int data;
        TreeLinkNode left, right, next;

        TreeLinkNode(int item) {
            data = item;
            left = right = next = null;

        }
    }

    public static  void connect(TreeLinkNode root) {
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

    static TreeLinkNode  getNextRightForChildOf(TreeLinkNode p) {
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




    public static void main(String args[]) {
// can be done using level order traversal

/*        TreeLinkNode root = new TreeLinkNode(10);
        root.left = new TreeLinkNode(3);
        root.right = new TreeLinkNode(5);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(1);
        root.right.right = new TreeLinkNode(2);*/

        TreeLinkNode root = new TreeLinkNode(3);
        root.left = new TreeLinkNode(1);
        root.right = new TreeLinkNode(2);

        // preorder(root);
        connect(root);
        preorder(root);

    }


    static void preorder(TreeLinkNode root) {
        if (root == null)
            return;

        if (root.next != null)
            System.out.println(root.data + " -> " + root.next.data);
        else
            System.out.println(root.data + " -> " + root.next);
        preorder(root.left);
        preorder(root.right);
    }
}