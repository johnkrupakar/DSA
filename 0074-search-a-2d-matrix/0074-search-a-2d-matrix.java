class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Using binary search on every single row
        int n = matrix.length;
        int m = matrix[0].length;

        // Apply binary search in O(n*m)
        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // Get the x and y coordinates
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
