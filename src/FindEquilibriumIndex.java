//find the index in array where value of elements to left == value of elements to right
import utils.UsefulMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindEquilibriumIndex {

    public static void main(String[] args) {
        int[] myArray = UsefulMethods.generateRandomArrayWithNegatives(10, 5);
        //int[] myArray2 = new int[]{-1, 3, -1, -2, -1, -2, -1, 2, -1, 3};
        System.out.println(Arrays.toString(myArray));
        equilibriumIndexBruteForce(myArray);
        equilibriumIndexOptimized(myArray);
    }
    //O(n) time & space
    //create auxillary arrays for left and for right, storing the sum of left and right subarrays for each index i
    public static List<Integer> equilibriumIndexBruteForce(int[] array){
        int[] leftSub = new int[array.length];    //stores the sum of elements of subarray `A[0…i-1]`
        leftSub[0] = 0;
        for (int i = 1; i < array.length; i++) {
            leftSub[i] = leftSub[i-1] + array[i-1];
        }
        int right = 0;  // right` stores the sum of elements of subarray `A[i+1…n)
        List<Integer> equilibriumIndices = new ArrayList<>();
        for (int i = array.length-1; i>=0; i--) {
            if (leftSub[i] == right) {   //If the sum of elements of subarray `A[0…i-1]` is equal to the sum of elements of the subarray `A[i+1…n)` i.e.
                                         // (A[0] + … + A[i-1]) = (A[i+1] + A[i+2] + … + A[n-1])
                equilibriumIndices.add(i);
            }
            right += array[i];    //new right is A[i] + (A[i+1] + A[i+2] + … + A[n-1])
        }
        System.out.println("Equilibrium found at indices " + equilibriumIndices);
        return equilibriumIndices;
    }

    public static List<Integer> equilibriumIndexOptimized(int[] array){
        int totalEntireArraySum = IntStream.of(array).sum();
        int rightSubArraySum = 0;
        List<Integer> equilibriumIndices = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            int leftSubArraySum = totalEntireArraySum - (array[i] + rightSubArraySum);
            if (rightSubArraySum == leftSubArraySum) equilibriumIndices.add(i);
            rightSubArraySum += array[i];
        }
        System.out.println("Equilibrium found at indices " + equilibriumIndices);
        return equilibriumIndices;
    }


    }

/*
2 9 5 '2' 8 3 5
left sub; start at each index 0 every time
    end at each i across whole array
right sub;
    start at where i ended
















    end at index length-1 every thime

 */
