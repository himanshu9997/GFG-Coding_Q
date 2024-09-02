//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution
{
    
    private static final int[] dirX = {0, 0, -1, 1};
    private static final int[] dirY = {-1, 1, 0, 0};

    // Function to return the minimum cost to reach the bottom-right cell from the top-left cell
    public int minimumCostPath(int[][] grid)
    {
        int n = grid.length;
        int[][] dist = new int[n][n];
        
        // Initialize the distance array with maximum values
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority queue to store cells to be processed (cost, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Start from the top-left corner (0,0) with its cost
        pq.offer(new int[]{grid[0][0], 0, 0});
        dist[0][0] = grid[0][0];

        // Process the priority queue until it's empty
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], x = current[1], y = current[2];

            // If we reach the bottom-right corner, return the cost
            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                // Check if the new position is within bounds
                if (newX >= 0 && newY >= 0 && newX < n && newY < n) {
                    int newCost = cost + grid[newX][newY];
                    // If the new path has a lower cost, update the distance and add it to the queue
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.offer(new int[]{newCost, newX, newY});
                    }
                }
            }
        }

        // Return the cost to reach the bottom-right cell
        return dist[n-1][n-1];
    }
}
