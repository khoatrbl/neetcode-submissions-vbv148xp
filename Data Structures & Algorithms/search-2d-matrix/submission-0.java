class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lowRow = 0;
        int highRow = matrix.length - 1;

        int potentialRow = 0;

        while (lowRow <= highRow) {
            int midRow = lowRow + (highRow - lowRow)/2;

            if (target >= matrix[midRow][0] &&
                target <= matrix[midRow][matrix[midRow].length - 1]) {
                    potentialRow = midRow;
                    break;
            }

            if (target < matrix[midRow][0]) {
                highRow = midRow - 1;
            } else {
                lowRow = midRow + 1;
            }
        }

        int low = 0;
        int high = matrix[potentialRow].length - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (target == matrix[potentialRow][mid]) {
                return true;
            }

            if (target < matrix[potentialRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
