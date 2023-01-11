/*
in a given 2D array, there can be many hourglass data sets, aka in shape of
	a b c
	  d
	e f g
Find the max sum of the hourglasses in a matrix
    So need to identify all possible hourglasses
    Then sum all 7 values in each
    Then find which is the max
 */
public class MaxHourglassIn2DArray {

    public static void main(String[] args) {
        int[][] grid = {{1,4,6,2,7,9},
                        {7,2,3,1,9,0},
                        {8,2,9,1,0,5},
                        {2,9,9,9,1,4},
                        {7,3,1,2,1,4},
                        {6,4,9,9,1,0}};
        maxHourglassValue(grid);
    }

    /*
    Brute Force is only way
    loop rows and columns in nested loop; only to length-2 (to check for hourglasses), as loop then checked indices 2 right and 2 down
    et each index, calculate hourglass sum
        hourglass = current value + 2 to the right + 1 down and right + 2 down, 2 down 1 right, 2 down 2 right
    update maxTracker, initialized to min int
     */
    public static int maxHourglassValue(int[][] array){
        int maxHourglass = Integer.MIN_VALUE;
        int hourglass;
        for (int i = 0; i < array.length-2; i++) {
            for (int j = 0; j < array[i].length-2; j++) {
                int topRow = array[i][j] + array[i][j+1] + array[i][j+2];
                int middleRow = array[i+1][j+1];
                int bottomRow = array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
                hourglass = topRow + middleRow + bottomRow;
                maxHourglass = Math.max(maxHourglass, hourglass);
            }
        }
        System.out.printf("The max hourglass is %d", maxHourglass);
        return maxHourglass;
    }
}
