// https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row = getRow (matrix, target);
        return bSearch(row, target);
    }
    
    private int[] getRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        while (low != high) {
            int midpoint = low + (high - low)/2;
            int[] row = matrix[midpoint];
            if (target >= row[0] && target <= row[row.length - 1]) return row;
            else if (target < row[0]) high = midpoint;
            else low = midpoint + 1;
        }
        
        return matrix[low];
    }
    
    private boolean bSearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low != high) {
            int midpoint = low + (high - low)/2;
            if (array[midpoint] == target) return true;
            else if (array[midpoint] > target) high = midpoint;
            else low = midpoint + 1;
        }
        
        return (array[low] == target);
    }
}
