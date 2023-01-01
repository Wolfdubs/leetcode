public class NextStringPermutation {
    //generating the next highest lexicographical permutation of a string; the next ordered set in the permutations
    //basically making the next highest number from the current numbers/chars
        //find the longest non-increasing suffix, traversing from the rear; 0 1 2 5 3 3 0
        //pivot is the single number in front of this suffix; 2
        //starting from the rearmost index, find the first number greater than the pivot; 3
        //swap it with the pivot; 1 2 3 5 3 2 0
        //reverse the suffix; 1 2 3 0 2 3 5

    public static void main(String[] args) {
        System.out.println(getNextPermutation("dkhc"));
        System.out.println(getNextPermutation("zyxw"));
    }

    public static String getNextPermutation(String string) {
        char[] letters = string.toCharArray();   //to make a mutable object; can swap positions of letters
        int startLargestNonIncreasing = letters.length-1;
        while (startLargestNonIncreasing>0 && letters[startLargestNonIncreasing] <= letters[startLargestNonIncreasing-1]){   //find start of largest non-increasing suffix
            startLargestNonIncreasing--;      //this terminates at the pivot point, so sets the var to be the pivot
        }

        //if the while loop exits only once the startLargestNonIncreasing is at index 0, then string was already in the highest possible permutation - cannot be rearranged to be 1 higher
        if (startLargestNonIncreasing<=0)
            return null;

        //swap pivot with an element higher than it, starting from rightmost index
        int largerThanPivot = letters.length-1;
        while (letters[startLargestNonIncreasing-1] <= letters[largerThanPivot]){  //traverse backwards until finding the elements to swap
            largerThanPivot--;
        }
        char temp = letters[startLargestNonIncreasing-1];
        letters[startLargestNonIncreasing-1] = letters[largerThanPivot];
        letters[largerThanPivot] = temp;


        //reverse the suffix sequence
        var end = letters.length-1;
        while (startLargestNonIncreasing < end) {
            temp = letters[startLargestNonIncreasing];
            letters[startLargestNonIncreasing] = letters[end];
            letters[end] = temp;
            startLargestNonIncreasing++;
            end--;
        }
        return new String(letters);
    }
}

