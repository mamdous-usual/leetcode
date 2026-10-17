/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    // Serializes a binary tree to a single string representation using preorder traversal with null markers
    public String serialize(TreeNode root) {
        StringBuilder serializedTree = new StringBuilder();
        serializeHelper(root, serializedTree);
        return serializedTree.toString();
    }

    // Recursive helper method for tree serialization using preorder traversal with null nodes as "N"
    private void serializeHelper(TreeNode root, StringBuilder serializedTree) {
        // Base case: if current node is null, append null marker and return
        if (root == null) {
            serializedTree.append("N,");
            return;
        }

        // Process current node: append its value followed by comma separator
        serializedTree.append(root.val).append(",");

        // Recursively serialize left subtree (preorder: left before right)
        serializeHelper(root.left, serializedTree);

        // Recursively serialize right subtree
        serializeHelper(root.right, serializedTree);
    }


    private int index; // Tracks current position in the serialized data array

    // Deserializes a string back into a binary tree using preorder reconstruction
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        index = 0; // Reset index for each deserialization
        return deserializeHelper(nodes);
    }

    // Recursive helper method that rebuilds the tree from preorder traversal array
    private TreeNode deserializeHelper(String[] nodes) {
        // Base case: if current element is null marker, increment index and return null
        if (nodes[index].equals("N")) {
            index++;
            return null;
        }

        // Parse current node value and create new TreeNode
        int nodeValue = Integer.parseInt(nodes[index]);
        TreeNode node = new TreeNode(nodeValue);
        index++;

        // Recursively build left subtree (preorder: left before right)
        node.left = deserializeHelper(nodes);

        // Recursively build right subtree
        node.right = deserializeHelper(nodes);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));