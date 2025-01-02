class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;       // Number of rows
        int n = img[0].length;    // Number of columns
        
        int[][] result = new int[m][n]; // To store the smoothed image
        
        // Iterate through each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sumNeighbors = 0;   // Sum of neighbors
                int countNeighbors = 0; // Count of valid neighbors
                
                // Check all 3x3 surrounding cells including the current cell
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int i_ = i + di;
                        int j_ = j + dj;
                        
                        // Check if the neighbor is within bounds
                        if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n) {
                            sumNeighbors += img[i_][j_];
                            countNeighbors++;
                        }
                    }
                }
                
                // Calculate the average and store in the result
                result[i][j] = sumNeighbors / countNeighbors;
            }
        }
        
        return result;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        ImageSmoother smoother = new ImageSmoother();

        // Example input
        int[][] img = {
            {100, 200, 100},
            {200, 50, 200},
            {100, 200, 100}
        };

        // Run the image smoother
        int[][] smoothedImage = smoother.imageSmoother(img);

        // Print the smoothed image
        System.out.println("Smoothed Image:");
        for (int[] row : smoothedImage) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
