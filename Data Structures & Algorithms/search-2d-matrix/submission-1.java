class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        

        
        for (int[] row : matrix) {
            int low = 0;
            int high = row.length - 1;

            while (low <= high) {
                int mid = low + (high - low)/2;

                if (target == row[mid]) {
                    return true;
                }

                if (target < row[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }
}
