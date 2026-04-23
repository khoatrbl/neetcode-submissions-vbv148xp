class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find the potential row that the target might be in using binary search
        // when we found it, perform binary search on that row

        int lowR = 0;
        int highR = matrix.length - 1;
        int potentialR = 0;

        while (lowR <= highR) {
            int midR = lowR + (highR - lowR)/2;

            if (target >= matrix[midR][0] && 
                target <= matrix[midR][matrix[midR].length - 1]) {

                potentialR = midR;
                break;
            }

            if (target < matrix[midR][0]) {
                highR = midR - 1;
            }

            if (target > matrix[midR][matrix[midR].length - 1]) {
                lowR = midR + 1;
            }
        }

        int l = 0;
        int r = matrix[potentialR].length - 1;

        while (l <= r) {
            int mid = l + (r - l)/2;

            if (target == matrix[potentialR][mid]) {
                return true;
            }

            if (target < matrix[potentialR][mid]) {
                r = mid - 1;
            }

            if (target > matrix[potentialR][mid]) {
                l = mid + 1;
            }
        }

        return false;
    }
}
