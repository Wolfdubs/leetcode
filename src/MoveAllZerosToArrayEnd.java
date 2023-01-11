import java.util.Arrays;
import utils.UsefulMethods;

public class MoveAllZerosToArrayEnd {
    public static void main(String[] args) {
        int[] array = {0,3,4,1,0,0,8,0,6,0,4,1,7,0};
        moveAllZerosToArrayEnd(array);
        moveAllZerosToArrayEndQuicksort(array);
    }

    //if current element is not zero, place at next available position in array. then fill remaining end indices with zero
    public static void moveAllZerosToArrayEnd(int[] array) {
        int k = 0;   //stores next available index
        for (int i : array) {
            if (i!=0){
                array[k++] = i;
            }
        }
        for (int i = k; i < array.length; i++){
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

    //use 0 as the pivot and make one pass of partitioning process
    //swap every non-pivot element with 1st occurence of pivot
    public static void moveAllZerosToArrayEndQuicksort(int[] array) {
        int j = 0;
        //each time encounter a non-zero, increment j, and place that element before the pivot
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {   //pivot is 0
                utils.UsefulMethods.swap(array, i, j);
                j++;
            }
        }
        System.out.println(Arrays.toString(array));
    }




}

















