//Given an array where all its elements are sorted in increasing order except two swapped elements, sort it in linear time.
// Assume there are no duplicates in the array.
public class SortArrayInOneSwapWith2DisorderedElements {
    public static void main(String[] args) {
        int[] array = utils.UsefulMethods.generateRandomArray(20,20);
        sortArrayInOneSwapWith2DisorderedElements(array);
    }

    //start from 2nd array element, comparing each to previous
    //pointers x and y
    //is previous element is greater, x = its index, y = current index
    public static void sortArrayInOneSwapWith2DisorderedElements(int[] array) {
        int x = -1, y = -1;
        int previousValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (previousValue > array[i]) {
                //1st occurrence of conflict
                if (x == -1) {
                    x = i -1;
                    y = i;
                } else {
                    y = i;
                }

            }
            previousValue = array[i];
        }
        utils.UsefulMethods.swap(array, x, y);
    }
}
