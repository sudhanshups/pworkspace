package practice.specific;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GL {

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char x) {
            val = x;
            left = null;
            right = null;
        }

        static boolean shouldBeErased(TreeNode node) {
            if (node == null)
                return true;
            if (node.val == 'B' || node.val == 'I')
                return true;
            return false;
        }

        static List<TreeNode> getValidTrees(TreeNode root) {
            if (root == null)
                return new ArrayList<>();

            List<TreeNode> result = getValidTreeUtil(root, shouldBeErased(root));
            result.addAll(getValidTreeUtil(root.right, shouldBeErased(root)));

            if (shouldBeErased(root)) {
                return result;
            } else {
                result.add(root);
                return result;
            }

/*            if (root == null)
                return new ArrayList<>();

            return getValidTreeUtil(root, true);

 */

        }

        static List<TreeNode> getValidTreeUtil(TreeNode root, boolean parentCanBeRemoved) {

            List<TreeNode> result = new ArrayList<>();

            if (root == null)
                return result;

            result.addAll(getValidTreeUtil(root.left, shouldBeErased(root)));
            result.addAll(getValidTreeUtil(root.right, shouldBeErased(root)));

            if (shouldBeErased(root.left))
                root.left = null;

            if (shouldBeErased(root.right))
                root.right = null;

            if (parentCanBeRemoved && !shouldBeErased(root)) {
                result.add(root);
            }
            return result;
        }


        /*
     F
   /  \
[B]    G
/  \     \
A   D    [I]
/ \  /   /
  C  E  H

    shouldBeErased(B) -> true

A  F      D    H
 \  \    /
 c  G   E

     */
        public static void main(String[] args) throws IOException {

            TreeNode root = new TreeNode('F');
            root.left = new TreeNode('B');
            root.left.left = new TreeNode('A');
            root.left.left.right = new TreeNode('C');
            root.left.right = new TreeNode('D');
            root.left.right.left = new TreeNode('E');
            root.right = new TreeNode('G');
            root.right.right = new TreeNode('I');
            root.right.right.left = new TreeNode('H');

            List<TreeNode> result = getValidTrees(root);
            System.out.println(result);
        }
    }


    /*

        static List<TreeNode> getValidTrees(TreeNode root) {

            if (root == null)
                return new ArrayList<>();

            List<TreeNode> result = getValidTreeUtil(root, shouldBeErased(root));
            result.addAll(getValidTreeUtil(root.right, shouldBeErased(root)));

            if (shouldBeErased(root)) {
                return result;
            } else {
                result.add(root);
                return result;
            }
        }

        static List<TreeNode> getValidTreeUtil(TreeNode root, boolean parentCanBeRemoved) {

            List<TreeNode> result = new ArrayList<>();

            if (root == null)
                return result;

            result.add(getValidTreeUtil(root.left, shouldBeErased(root)));
            result.add(getValidTreeUtil(root.right, shouldBeErased(root)));

            if (shouldBeErased(root.left))
                root.left = null;

            if (shouldBeErased(root.right))
                root.right = null;

            if (parentCanBeRemoved && !shouldBeErased(root)) {
                result.add(root);
            }
            return result;
        }


        /*
     F
   /  \
[B]    G
/  \     \
A   D    [I]
/ \  /   /
  C  E  H

    shouldBeErased(B) -> true

A  F      D    H
    \    / \
    G   C   E


     */
}
