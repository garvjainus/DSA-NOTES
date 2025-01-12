//calculate sub matrices, like you arent trying to get EVERY cell from 00 to i,j, just the square that is created from 00 to ij

class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                sum[i][j] = matrix[i][j];
                if(i>0) sum[i][j] += sum[i-1][j];
                if(j>0) sum[i][j] += sum[i][j-1];
                if(j>0 && i>0) sum[i][j] -= sum[i-1][j-1];
                //this is because, adding above gives you the sqaure matrix above, and adding left gives you the square matrix left, but these have inherent overlap

                //* * -
                //* * -
                //+ + <--- this is i, j, asterisks are overlap that we need to subtract, and substracting i-1 and j-1 will subtract the matrix from 0, 0 to i-1, j-1 from the sum ONCE, since it happens twice this is fine and gives us the correct numbers

            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) { //if you calculate the sum of a region or a range every time with a for loop, itll be O(n) every time, but if u do prefixz sum in constructor then its O(1)
        int sum1 = 0;
        sum1 += sum[row2][col2];
        if(row1>0) sum1 -= sum[row1-1][col2];
        if(col1>0) sum1 -= sum[row2][col1-1];
        if(row1>0 && col1>0) sum1 += sum[row1-1][col1-1];//add back the overlap you removed twice, opposite of before
        return sum1;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 Approach 2:

class NumMatrix {
    private int[][] sum; // 2D prefix sum array

    // Constructor: Builds the prefix sum matrix in O(m * n) time
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return; // Handle empty matrix
        
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
        sum = new int[m + 1][n + 1]; // Extra row and column for easier calculations

        // Compute the prefix sum for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = matrix[i][j] 
                                    + sum[i][j + 1]  // Sum above
                                    + sum[i + 1][j]  // Sum left
                                    - sum[i][j];     // Remove double counting
            }
        }

        // Print the prefix sum array for debugging
        System.out.println("Prefix Sum Array:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    // Function to get the sum of a submatrix from (row1, col1) to (row2, col2)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1]
             - sum[row1][col2 + 1]  // Remove extra rows
             - sum[row2 + 1][col1]  // Remove extra columns
             + sum[row1][col1];     // Add back the overlapping part
    }
}

//sum[i+1][j+1]=matrix[i][j]+sum[i][j+1]+sum[i+1][j]−sum[i][j]


[
[3  0]
[5  6]  
]

sum[1][2] = [3, 0] //First row in this case 
sum[2][1] = [3, 5] // 8 First column in this case 
sum[1][1] =  3 // Counted twice 

sum[2][2]=matrix[1][1]+sum[1][2]+sum[2][1]−sum[1][1]


Prefix Sum Array:
0 0 0 0 0 0 
0 3 3 4 8 10 
0 8 14 18 24 27 
0 9 17 21 28 36 
0 13 22 26 34 49 
0 14 23 30 38 58 
----------------------
Sum of region (2,1) to (4,3): 8
Sum of region (1,1) to (2,2): 11
Sum of region (1,2) to (2,4): 12

 */