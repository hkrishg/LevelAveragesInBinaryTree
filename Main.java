import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class Main {

  // Problem Statement #
  // Given a binary tree, populate an array to represent the averages of all of
  // its levels.

  private static List<Double> leverOrderTraversal(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if (root == null)
      return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      double levelSum = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {

        TreeNode currentNode = queue.poll();
        levelSum += currentNode.val;
        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.add(currentNode.left);
        if (currentNode.right != null)
          queue.add(currentNode.right);
      }
      res.add(levelSum / size);
    }
    return res;
  }


  // Problem 1: Find the largest value on each level of a binary tree.

  
  private static List<Integer> LargestValueEachLevel(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null)
      return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int maxvalue = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {

        TreeNode currentNode = queue.poll();
        maxvalue = Math.max(maxvalue, currentNode.val);
        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.add(currentNode.left);
        if (currentNode.right != null)
          queue.add(currentNode.right);
      }
      res.add(maxvalue);
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

    System.out.println(Main.leverOrderTraversal(root));
    System.out.println(Main.LargestValueEachLevel(root));

  }
}