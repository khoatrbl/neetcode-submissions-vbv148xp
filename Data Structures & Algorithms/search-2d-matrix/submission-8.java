class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;

        int potentialRow = 0;
        while (l <= r) {
            int midIndex = l + (r - l)/2;
            
            if (target >= matrix[midIndex][0] && target <= matrix[midIndex][matrix[midIndex].length - 1]) {
                potentialRow = midIndex;
                break;
            }

            if (target < matrix[midIndex][0]) {
                r = midIndex - 1;
            } 
            
            if (target > matrix[midIndex][matrix[midIndex].length - 1]) {
                l = midIndex + 1;
            } 

            
        }

        l = 0;
        r = matrix[potentialRow].length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[potentialRow][mid] == target) {
                return true;
            } 

            if (matrix[potentialRow][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
