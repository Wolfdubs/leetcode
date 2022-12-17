import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
    String s = "yyyrislcdjo34nncaersdjsodsekdn3odasdiioe;oiuytredcvbnm";
    int answerBruteForce = longestUniqueSubstringBF(s);
    System.out.println(answerBruteForce);
    int answerSlidingWindow = longestUniqueSubStringSlidingWindow(s);
    System.out.println(answerSlidingWindow);
    int answerSlidingWindowWithoutMap = longestUniqueSubStringWithoutMap(s);
    System.out.println(answerSlidingWindowWithoutMap);

    }
    /*BRUTE FORCE O(n^2)
    loop through every possible substring until that substring repeats a character
    keep a running maximum tracker
    1. Check every substring starting from 0th index, until it hits a repeated character
    2. now move to 1st index, etc
    */
    private static int longestUniqueSubstringBF(String string){
        int maxSubStringLength = 0;
        for (int i=0; i<string.length(); i++){   //looping through each char being the start of the substring being checked
            StringBuilder currentSubstring = new StringBuilder();//need to create a data structure for the below inner loop to add chars to, to build the substring
                                                                //it will reset everytime the outer loop changes the starting char
            for (int j = i; j<string.length(); j++) { //loop to continue to add proceeding chars to the substring until it finds a repetition. substring always starts where i currently is
                //for the next char to be added to the substring, indexOf() returns the index of that char in the current Substring
                if (currentSubstring.indexOf(String.valueOf(string.charAt(j))) != -1)  //if that next char is not in the currentSubstring, then indexOf returns -1
                    break;
                //otherwise, for the next char found in the inner loop, add it to end of the currentSubstring
                currentSubstring.append(string.charAt(j));
                maxSubStringLength = Math.max(currentSubstring.length(), maxSubStringLength);  //Math.max() returns the largest of the 2 inputs

            }  //once a repeating char is found, inner loop breaks, so outer loop increments to the next char in the string to start the substring
        } return maxSubStringLength;
    }

    /* SLIDING WINDOW
    Use HashMap to track the index where we last found the character we are currently looking at
    HashMap<CharacterFound, IndexOfTheLatestTimeWeSawThatCharacter>
    Use 2 pointers; left and right
        these both define the boundaries of the substring
        both start at first index
        check if current char exists in the Map
            if not, then there are no repeats, so check the substring length and compare to max
                then add that char to the Map
                    so the Map knows, the last time char c appeared, it was at index i
                    so map gives constant time lookup, replacing the inner forloop
                update maxtracker
                then shift the right pointer along by 1
                    check if this char is in the map
                        if not, add it to substring
                        and add to the map
                        update maxtracker
           if yes, check if we saw it inside the current substring we are looking at, by looking up the value for that char in the map
                check if the index value for a char is in the current substring, by seeing if the index is within where the left pointer is pointing
        Move left pointer along by 1, so it will move 1 past the index of the 1st index of the repeating char
            update map value so the index of the last time we saw the char is when the rightpointer saw it
        once rightpointer reaches end of string, the loop will exit

        Sliding Window: left and right pointers bound the current substring of interest, and only care about if hashmap indices for chars are within the
        current substring (boundaries of left and right pointers). As the pointers shift ahead during the loop, the 'window' of interest slides along
        the string
     */
    private static int longestUniqueSubStringSlidingWindow(String string){
        int maxSubstringLength = 0;

        //map contains any characters seen, and the latest index they were seen at
        Map<Character,Integer> visitedCharacters = new HashMap<>();

        for (int right = 0, left = 0; right < string.length(); right++){
            char currentChar = string.charAt(right);
            //check if the char at the right pointer is already in the map
            //also check if the latest index for that char is within the current substring in the pointers window boundaries (by being ahead of left boundary)
            if (visitedCharacters.containsKey(currentChar) && visitedCharacters.get(currentChar) >= left){
                //left pointer is only incremented once you find a repeat, to move the new first char of the substring to the next one along
                // (thus eliminating the repeat by shedding the 1st instance)
                left = visitedCharacters.get(currentChar) + 1;  //move left pointer to be 1 past that 1st instance of the repeated char
            }
            maxSubstringLength = Math.max(maxSubstringLength, right - left +1); //gets length of current substring. do +1 because even if both at same index, length should be 1
            visitedCharacters.put(currentChar, right);

        }
        return maxSubstringLength;
    }

    private static int longestUniqueSubStringWithoutMap(String string){
        int maxSubstringLength = 0;
        for (int right = 0, left = 0; right<string.length(); right++){
            //look for the index of the current char the right pointer is looking at, starting only from the left pointer
            // (so you only see if that char already existed inside the current substring window
            //so now have where the particular char we are looking at first appears in the current substring
            int indexOfFirstAppearanceInSubstring = string.indexOf(string.charAt(right), left);
            //if that current char's index is not at the right pointers index, then it is a duplicate elsewhere in the substring
            if (indexOfFirstAppearanceInSubstring!= right){
                left = indexOfFirstAppearanceInSubstring+1;

            }
            maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
        } return maxSubstringLength;
    }

}
