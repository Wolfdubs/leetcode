//given input target, return the longest subarray that sums to it. subarray must occupy sequential positions
import utils.UsefulMethods;
import utils.UsefulMethods.*;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarraySummingToTarget {
    public static void main(String[] args) {
        int[] array = UsefulMethods.generateRandomArray(20, 20);
        findLongestSubarraySummingToTargetBruteForce(array, 30);
    }

    //consider every possible subarray
    //use maxLengthSubarray tracker
    //O(n^3)
    private static void findLongestSubarraySummingToTargetBruteForce(int[] array, int target) {
        int maxSubarrayLength = 0;
        int endIndex = -1;   //stores end index of maxSubarray summing to target
        for (int i = 0; i < array.length; i++) {
            int targetTracker = 0;
            for (int j = i; j < array.length; j++) {
                targetTracker += array[j];
                if (targetTracker == target) {
                    if (maxSubarrayLength < j - i + 1) {   //j-i+1 is the length of the current subarray
                        maxSubarrayLength = j - i + 1;
                        endIndex = j;
                    }
                }
            }
        }
        System.out.print("Indices = [");
        for (int i = (endIndex - maxSubarrayLength + 1); i <= endIndex; i++)     //endIndex - arraylength + 1 is the 1st index of the subarray
            System.out.print(i + " ");
        System.out.println("]");
        System.out.print("Values = [");
        for (int i = endIndex - maxSubarrayLength + 1; i <= endIndex; i++)
            System.out.print(array[i] + " ");
        System.out.println("]     All sum to " + target);
    }

    //Map stores subarrays of various sums, with their ending indices
    //O(n)
    private static void findLongestSubarraySummingToTargetMap(int[] array, int target) {
        Map<Integer, Integer> endingIndexToSubarrayLengthMap = new HashMap<>();
        endingIndexToSubarrayLengthMap.put(0,-1);  //to handle case where subarray starts at index 0
        int targetTracker = 0;
        int maxSubarrayLength = 0;
        int endIndex = -1;
        for (int i = 0; i<array.length; i++) {
            targetTracker+=array[i];
            endingIndexToSubarrayLengthMap.putIfAbsent(targetTracker, i);//if sum seen for 1t time, put it in map with ints index
            if (endingIndexToSubarrayLengthMap.containsKey(targetTracker - target) && maxSubarrayLength < i - endingIndexToSubarrayLengthMap.get(targetTracker - target)) {
                maxSubarrayLength = i - endingIndexToSubarrayLengthMap.get(targetTracker - target);
                endIndex = i;
            }
        }
        System.out.print("Indices = [");
        for (int i = (endIndex - maxSubarrayLength + 1); i <= endIndex; i++)     //endIndex - arraylength + 1 is the 1st index of the subarray
            System.out.print(i + " ");
        System.out.println("]");
        System.out.print("Values = [");
        for (int i = endIndex - maxSubarrayLength + 1; i <= endIndex; i++)
            System.out.print(array[i] + " ");
        System.out.println("]     All sum to " + target);

    }
}





















