import utils.UsefulMethods;
import utils.UsefulMethods.*;

import java.util.*;

public class ZeroSumSubArrayChecker {
    //check if an array contains an internal array where elements sum to 0, and return them all

    public static void main(String[] args) {
        int[] myArray = UsefulMethods.generateRandomArray(20);
        containsZeroSumSubArray(myArray);
        printZeroSumSubArrays(myArray);
    }

    //Consider every possible subarray
    //O(n^3), as an array of n has n^2 subarrays
    private static void printZeroSumSubArrays(int[] myArray) {
        Map<Integer, List<Integer>> endingIndexOfSubArray = new HashMap<>();   //create multimap
        utilityInsert(endingIndexOfSubArray, 0, -1);  //insert 0,-1 for case where subarray with zero-sum starts at index 0

        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            sum += myArray[i];  //sum the elements seen so far
            if (endingIndexOfSubArray.containsKey(sum)) {
                List<Integer> list = endingIndexOfSubArray.get(sum);
                for (Integer value : list) {
                    System.out.println("Subarray: " + (value+1) + "..." + i);
                }
            }
            utilityInsert(endingIndexOfSubArray, sum, i);  //insert the sum so far, and current index pair
        }

    }

    //for inserting K,V into multiMap
    private static <K, V> void utilityInsert(Map<K, List<V>> hashMap, K key, V value) {
        hashMap.putIfAbsent(key, new ArrayList<>());  //if key is seen for 1st time, initialize the list
        hashMap.get(key).add(value);
    }

    //create a set to store each subarray
    //Traverse array and maintain sum of elements so far
    //if subarray sums to zero, and already exists in the set, return true
    // else add it to a set
    private static boolean containsZeroSumSubArray(int[] myArray) {
        Set<Integer> arrayIntegers = new HashSet<>();
        int sum = 0;
        for (int value : myArray) {
            sum += value;
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if (sum == 0 || arrayIntegers.contains(sum) || myArray[0] == 0){
                return true;
            }
            arrayIntegers.add(sum);
        }
        return false;
    }

}
