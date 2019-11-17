package practice.ibit;

import java.util.Stack;

class Node {
    char c;
    Node left, right;

    Node(char v) {
        this.c = v;
    }

    @Override
    public String toString() {
        return "Node{" +
                "" + c +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class TernaryExpressionToBinaryTree {

    public static void main(String[] args) {
    Integer i = null;
        if(i==0){
            System.out.println("hwe");
        }
        test("a?b:c");
        test("a?b?c:d:e");
        test("a?b?c?d:e:f:g");
        test("a?b:c?d:e");
        test("a?b:c?d:e?f:e");
        test("a?b?c?d:e:f?g:h:i?j:k");
    }

    private static void test(String test) {
        System.out.println("\n\ntest 1: ->" + test + "\n");
        TernaryExpressionToBinaryTreeSolution solution = new TernaryExpressionToBinaryTreeSolution();

        System.out.println("\nRecursive:");
        Node root = solution.ternaryToBinaryTreeRecursive(test);

        print(root);

        System.out.println("\nIterative:");
        Node rootIterative = solution.ternaryToBinaryTreeIterative(test);

        print(rootIterative);

    }


    private static void print(Node root) {
        if (null == root)
            return;

        System.out.print(root.c + " ");

        if (root.left != null) {
            System.out.print("? ");
            print(root.left);
        }
        if (root.right != null) {
            System.out.print(": ");
            print(root.right);
        }
    }
}


class TernaryExpressionToBinaryTreeSolution {

    public Node ternaryToBinaryTreeRecursive(String s) {

        if (null == s || s.isEmpty())
            return null;

        return ternaryToBinaryTreeRecursive(s, 0, s.length() - 1);

    }

    private Node ternaryToBinaryTreeRecursive(String s, int start, int end) {

        //expression is complete
        if (start >= s.length())
            return null;

        Node root = new Node(s.charAt(start));
        start++;
        if (start < s.length() && s.charAt(start) == '?') {
            //find the complemented :
            int colonIndex = 0;
            int colonCount = 0;
            for (int i = start + 1; i < s.length(); i++) {
                if (s.charAt(i) == '?') {
                    colonCount--;
                } else if (s.charAt(i) == ':') {
                    colonCount++;
                }
                if (colonCount == 1) {
                    colonIndex = i;
                    break;
                }
            }

            root.left = ternaryToBinaryTreeRecursive(s, start + 1, colonIndex - 1);
            root.right = ternaryToBinaryTreeRecursive(s, colonIndex + 1, end);
        }
        return root;
    }


    public Node ternaryToBinaryTreeIterative(String s) {

        if (null == s || s.isEmpty())
            return null;

        Stack<Node> stack = new Stack<>();

        Node root = new Node(s.charAt(0));
        stack.push(root);

        for (int i = 1; i < s.length(); i += 2) {
            Node node = new Node(s.charAt(i + 1));

            char c = s.charAt(i);
            if (c == '?') {
                stack.peek().left = node;

            } else if (c == ':') {
                stack.pop();

                //pop all the root whose right sub-tree already been created
                while (stack.peek().right != null)
                    stack.pop();

                stack.peek().right = node;

            }
            stack.push(node);

        }
        return root;

    }
}
