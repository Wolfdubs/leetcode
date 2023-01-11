import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayContainsDuplicate {

    public static void main(String[] args) {
        int[] unique = {1,2,3,4,5,6,7,8,9,0};
        int[] duplicates = {1,2,3,4,4,5,6,7,8,9,0};
        int[] anotherDuplicates = {1,2,3,4,5,6,7,8,9,9,9};
        containsDuplicateSorting(unique);
        containsDuplicateSorting(duplicates);
        containsDuplicateSorting(anotherDuplicates);
        containsDuplicateHashing(unique);
        containsDuplicateHashing(duplicates);
        containsDuplicateHashing(anotherDuplicates);

    }
    //best for space complexity
    public static boolean containsDuplicateSorting(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] == array[i]) {
                System.out.printf("Duplicate value found: %d\n", array[i]);
                return true;
            }
        }
        System.out.printf("No duplicates found\n");
        return false;

    }
    //loop through array and add elements to hashset
    //if hashset already contains an element to be added, then return true
    public static boolean containsDuplicateHashing(int[] array) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (values.contains(array[i])) {
                System.out.printf("Duplicate value found via hashing: %d\n", array[i]);
                return true;
            }
            values.add(array[i]);
        }
        System.out.println("No duplicates found via hashing");
        return false;
    }
}
