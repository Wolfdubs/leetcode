import java.util.*;

public class SortIntArrayByFrequency {

    private int[] array;
    private int random;


    {   //using an instance initializer block that initializes elements when object is created. just for fun here
        array = new int[25];
        for (int i = 0; i< array.length; i++){
            random = (new Random().nextInt(10)+1);
            array[i] = random;
        }
    }

    public static void main(String[] args) {
        SortIntArrayByFrequency siabf = new SortIntArrayByFrequency();
        System.out.println("Array before sorting int array by frequency");
        Arrays.stream(siabf.array).forEach(i -> System.out.print(i + " "));
      //  siabf.sortByFrequencyWithHashMapAndComparator(siabf.array);
        siabf.sortWith2DArray(siabf.array);
        System.out.println("\nArray after sorting int array by frequency");
        Arrays.stream(siabf.array).forEach(i -> System.out.print(i + " "));

    }

    // Using two maps, one for array element as an index and after this second map whose keys are frequency and value are array elements.
    //Time Complexity: O(N log N), where the N is the size of the array
    //Auxiliary Space: O(N)

    public void sortByFrequencyWithHashMapAndComparator(Integer[] arr) {
        List<Integer> listArray = Arrays.asList(arr);
        final Map<Integer, Integer> frequencyOfIntOccurrence = new HashMap<>();
        final Map<Integer, Integer> indexOfFirstAppearanceOfIntInArray = new HashMap<>();

        for (int i = 0; i<arr.length; i++ ){
            if (frequencyOfIntOccurrence.containsKey(arr[i])) {
                frequencyOfIntOccurrence.put(arr[i], frequencyOfIntOccurrence.get(arr[i])+1);
            } else {
                frequencyOfIntOccurrence.put(arr[i], 1);
                indexOfFirstAppearanceOfIntInArray.put(arr[i], i);  //map captures index of 1st appearance of ints in the array
            }
        }

        Collections.sort(listArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int frequency1 = frequencyOfIntOccurrence.get(i1);
                int frequency2 = frequencyOfIntOccurrence.get(i2);
                if (frequency1 != frequency2) {
                    return frequency2 - frequency1;
                } else {
                    return indexOfFirstAppearanceOfIntInArray.get(frequency1) -
                            indexOfFirstAppearanceOfIntInArray.get(frequency2);  //elements with lower index get returned
                }
            }
        });
        System.out.println();
        System.out.println(listArray);

        for (int i = 0; i< listArray.size(); i++) {
            array[i] = listArray.get(i);
        }

    }

    public void sortWith2DArray(int[] arr){
        //sort elements, and then store their original indices (so if same frequency earlier comes first)
        //iterate array and construct 2D array where its {value, frequency}
        //sort 2D array by count
        class MyElement {
            int frequency, index, value;
        }
        class valueComparison implements Comparator<MyElement> {
            @Override
            public int compare(MyElement o1, MyElement o2) {
                return o1.value - o2.value;
            }
        }
        class frequencyAndIndexComparison implements Comparator<MyElement> {
            @Override
            public int compare(MyElement a, MyElement b) {
                if (a.frequency!=b.frequency) {
                    return a.frequency - b.frequency;
                } return b.index - a.index;
            }
        }

        List<MyElement> elements = new ArrayList<>();
        for (int i = 0; i<arr.length; i++) {
            elements.add(new MyElement());
            elements.get(i).index = i;                    //Fill indices
            elements.get(i).frequency = 0;             //Initialize frequency as 0
            elements.get(i).value = arr[i];           //Fill in the actual values
        }


        elements.sort(new valueComparison());      //Sort elements based on their values
        elements.get(0).frequency = 1;            //initialize count of 1st element as 1
        for (int i = 1; i<arr.length; i++) {                                    //count frequency of remaining elements
            if (elements.get(i).value == elements.get(i-1).value) {    //works because the list is sorted
                elements.get(i).frequency = elements.get(i-1).frequency+1;
                elements.get(i-1).frequency = -1;   //because elements will be sorted based on frequency
                elements.get(i).index = elements.get(i-1).index;  //to retain 1st appearance of the element
            } else {
                elements.get(i).frequency = 1;  //previous element doesn't match the current, so set frequency to 1
            }
        }

        //now have frequency nd 1st index for all elements
        elements.sort(new frequencyAndIndexComparison());
        for (int i = arr.length - 1, index = 0; i >= 0; i--) {
            if (elements.get(i).frequency != -1) {
                for (int j = 0; j < elements.get(i).frequency; j++) {
                    arr[index] = elements.get(i).value;
                }
            }
        }
    }
























}
