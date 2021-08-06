// https://leetcode.com/problems/bomb-enemy/

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        int[][] intGrid = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') intGrid[i][j] = -1;
            }
        }
        
        // scan horizontally
        for (int i = 0; i < grid.length; i++) {
            int start = 0;
            int eCount = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') eCount++;
                if (grid[i][j] == 'W' || j == grid[0].length - 1) {
                    // if found a wall or end of row, add the enemies counted to each value in the grid
                    // Note - while this is a for loop within a for loop, it is still O(n)
                    // because of the bounds, each index will only be read twice each (four times total)
                    for (int k = start; k <= j; k++) {
                        if (intGrid[i][k] != -1) {
                            intGrid[i][k] += eCount;
                            max = Math.max(max, intGrid[i][k]);
                        }
                    }
                    eCount = 0;
                    start = j;
                }
            }
        }
        
        // scan vertically
        for (int j = 0; j < grid[0].length; j++) {
            int start = 0;
            int eCount = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 'E') eCount++;
                if (grid[i][j] == 'W' || i == grid.length - 1) {
                    for (int k = start; k <= i; k++) {
                        if (intGrid[k][j] != -1) {
                            intGrid[k][j] += eCount;
                            max = Math.max(max, intGrid[k][j]);
                        }
                    }
                    eCount = 0;
                    start = i;
                }
            }
        }
        
        return max;
    }
}
