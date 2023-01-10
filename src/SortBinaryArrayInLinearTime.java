import java.util.Arrays;

//sort a binary array
public class SortBinaryArrayInLinearTime {
    public static void main(String[] args) {
        int[] myArray = new int[]{1,1,0,0,1,0,1,1,1,1,0,0,1,0,0,1,0,0,1,1,0,0,0,0,0,1};
        sortBinaryArrayInLinearTime(myArray);
        sortBinaryArrayInLinearTime2(myArray);



    }

    //count the zeros in the array
    //add that many zeros to the start, then the rest as 1's
    // O(n). no extra space
    public static int[] sortBinaryArrayInLinearTime(int[] array) {
        int zerosCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zerosCount++;
            }
        }

        int k = 0;
        while(zerosCount-- != 0)
            array[k++] = 0;
        /*for (int i = 0; i < zerosCount; i++) {   //Alternative way of doing the above
            array[i] = 0;
        }*/

        while (k < array.length){
            array[k++] = 1;
        }
      /*  for (int i = zerosCount; i < array.length; i++) {   //Alt way of populating the 1's
            array[i] = 1;
        }*/

        System.out.println(Arrays.toString(array));
        return array;
    }

    //if current element is 0, place 0 at next index, then fill remaining indicies with 1
    public static int[] sortBinaryArrayInLinearTime2(int[] array) {
        int k = 0;  //k stores index of next available position
        for (int i : array) {
            if (i ==0) array[k++] = 0;
        }
        for (int i = k; i< array.length; i++){
            array[k++] = 1;

        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int[] sortBinaryArrayViaQuickSort(int[] array) {
        int pivot = 1;
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {    //each time 0 is encountered, increment j and place the 0 before the pivot
                swap(array, i, j++);
            }
        }
        System.out.println(Arrays.toString(array));
        return array;


    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    }























