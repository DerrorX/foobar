public class Solution {

    // Function to count the number of salutes in the hallway
    public static int solution(String s) {
        // Variable to keep track of the total number of salutes
        int salutes = 0;
        // Variable to count the number of employees walking to the right
        int rightCount = 0;

        // Loop through each character in the hallway string
        for (char c : s.toCharArray()) {
            // If the character is '>', increment the rightCount
            if (c == '>') {
                rightCount++;
            }
            // If the character is '<', add 2 * rightCount to the total salutes
            else if (c == '<') {
                salutes += 2 * rightCount;
            }
        }

        // Return the total number of salutes
        return salutes;
    }

    // Main method for testing the solution with examples
    public static void main(String[] args) {
        // Example 1
        String hallwayString1 = ">----<";
        int result1 = solution(hallwayString1);
        System.out.println("Output for '" + hallwayString1 + "': " + result1);

        // Example 2
        String hallwayString2 = "<<>><";
        int result2 = solution(hallwayString2);
        System.out.println("Output for '" + hallwayString2 + "': " + result2);
    }
}