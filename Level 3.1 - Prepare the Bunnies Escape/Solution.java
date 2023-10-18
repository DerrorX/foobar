import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Method to find the shortest path
    public static int solution(int[][] map) {
        // Get the height and width of the map
        int height = map.length;
        int width = map[0].length;

        // Define possible moves (up, down, left, right)
        int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // Create a queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        // Add the starting position to the queue (x, y, wallsRemoved, pathLength)
        queue.offer(new int[]{0, 0, 0, 1});

        // Create a 3D array to track visited positions and walls removed
        boolean[][][] visited = new boolean[width][height][2];
        // Mark the starting position as visited
        visited[0][0][0] = true;

        // Perform BFS
        while (!queue.isEmpty()) {
            // Get the current position and parameters
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int wallsRemoved = current[2];
            int pathLength = current[3];

            // Check possible moves
            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    // Calculate walls removed for the new position
                    int newWallsRemoved = wallsRemoved + map[newY][newX];

                    // Check if the move is valid and the position has not been visited
                    if (newWallsRemoved <= 1 && !visited[newX][newY][newWallsRemoved]) {
                        // Check if the destination is reached
                        if (newX == width - 1 && newY == height - 1) {
                            return pathLength + 1;
                        }

                        // Add the new position to the queue
                        queue.offer(new int[]{newX, newY, newWallsRemoved, pathLength + 1});
                        // Mark the new position as visited
                        visited[newX][newY][newWallsRemoved] = true;
                    }
                }
            }
        }

        // No solution found
        return -1;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // Example 1
        int[][] map1 = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        };
        System.out.println("Input: Solution.solution(map1)\nOutput: " + solution(map1));

        // Example 2
        int[][] map2 = {
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println("Input: Solution.solution(map2)\nOutput: " + solution(map2));
    }
}
