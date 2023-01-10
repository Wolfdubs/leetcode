import java.util.Arrays;

//find the subarray (contiguous) with the max sum
public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] array = utils.UsefulMethods.generateRandomArrayWithNegatives(10,10);
        System.out.println(Arrays.toString(array));
        maxSumSubarrayKadane(array);
    }

    //have a maximum positive-sum subarray ending at each index; which is either empty (so sum = 0), or has 1 more element than max subarray ending at previous index
    public static int maxSumSubarrayKadane(int[] array) {
        int maxSoFar = 0;   //stores max subarray found so far
        int maxEndingAtCurrentIndex = 0;

        int maxElement = Arrays.stream(array).max().getAsInt();   //must check case where every element is negative, as then the algorithm won't work
        if (maxElement < 0) return maxElement;
        //alternatively, manage entirely negative arrays via
        //maxSoFar = Integer.MIN_VALUE;

        for (int i : array) {
            maxEndingAtCurrentIndex = maxEndingAtCurrentIndex + i;//update max sum of subarray ending at i buy adding the sum of the subarray up to the prior index, with current value
            maxEndingAtCurrentIndex = Integer.max(maxEndingAtCurrentIndex,0);  //if max sum is negative, set to 0 (empty subarray)
            maxSoFar = Integer.max(maxSoFar, maxEndingAtCurrentIndex);
        }
        System.out.println("The max sum of contiguous elements in the array = " + maxSoFar);
        return maxSoFar;
    }
}
