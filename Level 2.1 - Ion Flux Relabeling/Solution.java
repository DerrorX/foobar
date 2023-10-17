public class Solution {

    // The solution method takes the tree height and an array of node indices,
    // and returns an array of parent indices for each given node index.
    public static int[] solution(int treeHeight, int[] nodeIndices) {
        // Create an array for the results with the same length as the nodeIndices array.
        int[] results = new int[nodeIndices.length];
        // For each node index, calculate its parent index and store it in the results array.
        for (int i = 0; i < nodeIndices.length; i++) {
            results[i] = getParentIndex(treeHeight, nodeIndices[i]);
        }
        // Return the array with the results.
        return results;
    }

    // The getParentIndex method calculates the parent index for a given node index in a tree with a specified height.
    public static int getParentIndex(int treeHeight, int nodeIndex) {
        // Calculate the maximum index in the tree.
        int maxIndex = (int) Math.pow(2, treeHeight) - 1;
        // If the given node index is greater than the maximum index in the tree, return -1.
        if (maxIndex < nodeIndex) {
            return -1;
        } else {
            int offset = 0;
            boolean continueSearch = true;
            int currentSubtreeSize = maxIndex;
            int result = -1; // Default result value (if no parent is found).

            // Loop for searching the parent in the tree.
            while (continueSearch) {
                if (currentSubtreeSize == 0) {
                    continueSearch = false;
                }

                // Right shift is equivalent to dividing the subtree size by 2 and discarding the remainder.
                currentSubtreeSize = currentSubtreeSize >> 1;

                // Predict the index of the left child.
                int leftNode = offset + currentSubtreeSize;

                // Predict the index of the right child.
                int rightNode = leftNode + currentSubtreeSize;

                // Calculate the index of the current node.
                int currentNode = rightNode + 1;

                // If either child matches the given index, store the index of the current node as the result.
                if (leftNode == nodeIndex || rightNode == nodeIndex) {
                    result = currentNode;
                    continueSearch = false;
                }

                // Move the current left child to the offset if the given index is greater than the left child.
                // This effectively searches the right subtree.
                if (nodeIndex > leftNode) {
                    offset = leftNode;
                }
            }

            // Return the index of the parent (or -1 if not found).
            return result;
        }
    }

    // The main method is used to test the solution on sample data.
    public static void main(String[] args) {
        int treeHeight1 = 3;
        int[] nodeIndices1 = {7, 3, 5, 1};
        int[] results1 = solution(treeHeight1, nodeIndices1);
        printResults(results1);

        int treeHeight2 = 5;
        int[] nodeIndices2 = {19, 14, 28};
        int[] results2 = solution(treeHeight2, nodeIndices2);
        printResults(results2);
    }

    // Helper method for printing the results.
    private static void printResults(int[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i]);
            if (i < results.length - 1) {
                System.out.print(", ");
            }
        }
        // Print a new line after finishing the output for better readability.
        System.out.println();
    }
}
