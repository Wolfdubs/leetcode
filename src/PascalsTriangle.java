/*
each number in triangle is sum of the 2 numbers above it
given a number of rows; generate pascals triangle from it
     1
    1 1
   1 2 1
  1 3 3 1
 1 4 6 4 1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
triangle data structure will be List<List<Integer>>
base case; where numRows == 0, return empty ListList
1st row; just a List with 1
then add that list to triangle
2 loops;
    outer loop through all rows from 1 to numRows to generate internal lists, adding to triangle,
        grab previous row (why 1st row had be outside the for loop as has no previous)
        1st element of row is always a 1,
    inner loop through elements in each row from index 1
        at each index, add sum of previous rows j-1 and j
        add 1 to last index
        add completed row to triangle

 */

public class PascalsTriangle {

    public static void main(String[] args) {
        pascalsTriangle(5);
        pascalsTriangleRecursive(10);
        pascalsTriangleRows(5);
    }

    private static List<List<Integer>> pascalsTriangle(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows ==0 ) return triangle;
        List<Integer> firstRow = Arrays.asList(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = triangle.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j-1) + previousRow.get(j));
            }
            currentRow.add(1);
            triangle.add(currentRow);
        }
        System.out.println(triangle);
        return triangle;

    }


    //for n number of rows
    //iterate outer loop n times to print rows
    //iterate inner loop n - i times
    //print single " "
    //closer inner loop
    //inner iteration to i
    //print nCr calculate for i and j
    //close inner loop
    //print newline
    private static void pascalsTriangleRows(int numRows){
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + calculateNCR(i,j));
            }
            System.out.println();
        }
    }
    private static int factorialNonRecursive(int n) {
        int f;
        for (f=1; n>1; n--) f *=n;
        return f;
    }

    private static int calculateNCR(int n, int r) {
        return factorialNonRecursive(n) / (factorialNonRecursive(n-r) * factorialNonRecursive(r));
    }


    //O(N^2)
    //formula to calculate row =  n ! / ( n – r ) ! r !
    private static void pascalsTriangleRecursive(int numRows){
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <=numRows-i; j++) {
                System.out.print(" ");  //for left spacing
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + factorial(i) / (factorial(i-j) * factorial(j)));
            }
            System.out.println();
        }
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }
}
