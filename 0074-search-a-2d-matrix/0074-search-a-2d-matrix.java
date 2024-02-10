class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Using binary search on every single row
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            // Check if the target is in this row
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
