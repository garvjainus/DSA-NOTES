class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < cols; j++){ //needs to be i + 1 so not do redundnat flips that would keep the same matrix. only want to swap above the diagonal so you dont reflip a flipped value
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp; 
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols-j-1] = temp;
            }
        }
    }
}