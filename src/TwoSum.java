//Given an array of integers and a target, return the 2 indices that sum to the target.
//Cannot use same element twice.
//Assume there is always 1 solution

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] myArray = {5,8,2,4,1,0,6,9,5,3,8};
        Arrays.stream(myArray).forEach(i -> System.out.print(i + ", "));
        int[] answer = twoSumComplimentsHashMap(myArray, 11);
        System.out.println("\nAnswer: ");
        Arrays.stream(answer).forEach(i -> System.out.print(i + ", "));

    }
    //EFFICIENT MAPPING: O(n). Does need more memory due to HashMap
    //Loop through array 1 time,
    // For each value, calculate the compliment required to sum to the target
    // Put compliment as a key into a HashMap, and the index of the actual real element as the HashMap value
    // For each value, also check if the required addition is already present as a key in the HashMap
    // If so, retrieve its value (index location of the original value)
    // HashMap lookup is constant time due to hashing mechanism
    // -> Means as you loop through the array, for each number, you can check if you've already seen its required compliment by checking the HashMap

    public static int[] twoSumComplimentsHashMap(int[] inputArray, int target) {
        HashMap<Integer, Integer> complimentsMap = new HashMap<>();
        for (int i =0; i<inputArray.length; i++) {       //loop through the array
            int complimentValue = target - inputArray[i];    //each time, calculate the compliment required for the current value to reach the target
            if (complimentsMap.containsKey(complimentValue)){       //if the hashmap contains that compliment required (ie as already seen it)
                int complimentIndex = complimentsMap.get(complimentValue);   //get the index that that compliment value is at in the input array
                return new int[]{i, complimentIndex};        //return the current looping index, and the index with the required compliment value
            } else {
                complimentsMap.put(inputArray[i], i);    //else, add the current value and its index into the hashmap (so it can be checked for as a compliment for later loops
            }
        } return inputArray;
    }

    //walk low and high pointers up and down the sorted array. if their sum exceeds target, lower the higher ointer and vice versa, until they meet or find target
    public static int[] twoSumSortingAndPointers(int[] inputArray, int target) {
        Arrays.sort(inputArray);
        int lowIndex = 0;
        int highIndex = inputArray.length -1;
        while (lowIndex < highIndex) {
            int sum = inputArray[lowIndex] + inputArray[highIndex];
            if (sum == target) {
                return new int[]{lowIndex, highIndex};
            } else if (sum < target ) {
                lowIndex++;
            } else {
                highIndex--;
            }
        }
        System.out.println("Target not found");
        return new int[]{Integer.parseInt(null)};

    }

    //for each number, store its compliment as the HashMap key, and store that numbers index as the value
    //while traversing array, for each number, check if it already exists in the HashMap as the compliment for another number
        //otherwise, add the compliment for current number to HashMap
        //HashMap<Compliment, IndexOfOriginalValue>
    public static int[] twoSumMapping2(int[] inputArray, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            Integer complementIndex = complements.get(inputArray[i]);   //for each number, check if it already exists as a compliment key in the HashMap. this returns null if not present
            if (complementIndex != null) {   //if its not null, it must have been present in the HashMap
                return new int[]{i, complementIndex};
            } else {
                Integer complement = target - inputArray[i];//add the complement of the current number to the Map
                complements.put(complement, i);
            }
        } return inputArray;
    }

    //BRUTE FORCE = O(N^2) due to nested for loops iterating array
    public static int[] twoSumBruteForce(int[] inputArray, int target){
        for (int i = 0; i<inputArray.length; i++){
            for (int j=i+1; j<inputArray.length; j++){    //start next loop at the index after where the first pointer is
                if (inputArray[i] + inputArray[j] == target){   //dont need manual check for i!=j because the for loop logic covers that
                    //once find the indices, must insert them into a new array to return
                    return new int[]{i,j};
                }
            }
        } return inputArray;   //not doing anything, just default to return if no solution found with the if statement
    }
}




