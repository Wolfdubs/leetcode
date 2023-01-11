/*
Given a 2d grid of chars of 1's or 0's
Could how many islands of 1's there are (1's connected horizontally or vertically)
11110
11010
11000
00000
output = 1

11000
11000
00100
00011
output = 3
 */


import java.util.Stack;

//iterating across all rows, at each index iterate across all columns.
//each time a 1 is seen, increment counter (of number of islands)
//use BFS - call it; passing in the [][], i and j
    //check if still in the [][], and than i, j are not 0
    //set i and j to 0, so not double counted
//  then recursively call BFS with i - 1, i+1, j-1, j+1, to get horizontal and vertical conections, and check if they are 1
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] oneIsland = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'}};
        char[][] threeIslands = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};


        countIslandsRecursive(oneIsland);
        countIslandsRecursive(threeIslands);
        countIslandsStack(oneIsland);
        countIslandsStack(threeIslands);

    }

    private static int countIslandsRecursive(char[][] grid) {
        int islandCounter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandCounter++;
                    bfs(grid, i, j);
                }
            }
        }
        System.out.printf("There are %d islands\n", islandCounter);
        return islandCounter;
    }

    private static void bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';   //marking current position as visited, so not double counted
        bfs(grid, i + 1, j); //search next position up in grid
        bfs(grid, i - 1, j); //search next position down in grid
        bfs(grid, i, j + 1); //search next position right in grid
        bfs(grid, i, j - 1); //search next position left in grid
    }

    //O(n*m) time and space
    private static int countIslandsStack(char[][] grid) {
        int islandCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                visited[i][j] = false;   //boolean grid now totally populated with falses
            }
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    stack.push(i + "," + j);   //push the current position into the stack
                    dfs(stack, grid, visited);
                    islandCount++;
                }
            }
        }
        System.out.printf("Stack says there are %d islands\n", islandCount);
        return islandCount;
    }

    public static void dfs(Stack<String> stack, char[][] grid, boolean[][] visited) {
        while (!stack.empty()) {
            String currentPosition = stack.pop();
            int row = Integer.parseInt(currentPosition.split(",")[0]);
            int column = Integer.parseInt(currentPosition.split(",")[1]);
            if (row<0 || row>=grid.length ||column<0 || column>grid[row].length || grid[row][column] == '0') continue;
            stack.push((row+1) + "," + column);
            stack.push((row-1) + "," + column);
            stack.push(row + "," + (column+1));
            stack.push(row + "," + (column-1));
        }
    }
}
























