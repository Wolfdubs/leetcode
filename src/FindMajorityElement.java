import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//find element appearing at least n/2 times
public class FindMajorityElement {
    public static void main(String[] args) {
        int[] myArray = {2, 5, 4, 4, 7, 6, 4, 4, 4, 4, 9, 4, 7, 4, 4, 4, 1, 4, 4, 4};
        findMajorityElementBruteForce(myArray);
        findMajorityElementFrequencyHashMap(myArray);
        findMajorityElementFrequencyBoyerMoore(myArray);
    }

    //count occurrence of each int in 1st half of array
    //O(n^2)
    public static int findMajorityElementBruteForce(int[] array) {
        for (int i = 0; i <= array.length / 2; i++) {     //only check elements in 1st half, as if not there, it cannot have a majority
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {   //count all elements after i
                if (array[j] == array[i]) count++;    //anytime an element after i equals i, increment count
            }
            if (count > array.length / 2) {
                System.out.println("BF method: " + array[i]);
                return array[i];
            }
        }
        System.out.println("BF method: " + -1);
        return -1;
    }

    public static int findMajorityElementFrequencyHashMap(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : array) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0)+1);  //storing each elements frequency in hashmap
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > array.length/2) {
                System.out.println("HashMap method: " + entry.getKey());
                return entry.getKey();
            }
        }
        System.out.println("HashMap method: " + -1);
        return -1;
    }

    //process elements 1 at a time
    //if counter is at 0, set current candidate to element e, and counter to 1
    //if counter != 0, decrement/increment depending on if e is current candidate
    //Drawback: it only produces correct majority if one is present in input (may still output answer even if no majority)
    public static int findMajorityElementFrequencyBoyerMoore(int[] array) {
        int majorityCandidate = -1;  //stores majority element candidate
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (counter == 0) {   //if it is the 1st time we;ve seen this element
                majorityCandidate = array[i];
                counter = 1;
            } else if (array[i] == majorityCandidate) {
                counter++;  //if we've seen the element, increment the counter
            } else {
                counter--;
            }
        }
        System.out.println("Boyer Moore: " + majorityCandidate);
        return majorityCandidate;


    }


}





















