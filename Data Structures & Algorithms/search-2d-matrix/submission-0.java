class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top=0, bottom=rows-1;
        while(top<=bottom){
            int row = (top+bottom)/2;
            if(target > matrix[row][cols-1]){
                top = row+1;
            }else if(target < matrix[row][0]){
                bottom = row-1;
            }else{
                break;
            }
        }

        if(!(top<=bottom)){
            return false;
        }

        int row = (top+bottom)/2;

        int lo=0,hi=cols-1;
        while(lo<=hi){
            int m = (lo+hi)/2;

            if(target>matrix[row][m]){
                lo = m+1;
            }else if(target<matrix[row][m]){
                hi = m-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
