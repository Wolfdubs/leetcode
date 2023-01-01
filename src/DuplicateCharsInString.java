import java.util.*;

public class DuplicateCharsInString {

    public static void main(String[] args) {
        String input = "aabbccddddddefghixxyz";

        int totalDuplicates = countDuplicates(input);
        System.out.println("There were " + totalDuplicates + " in the string");

        String withoutDuplicates = removeDuplicates(input);
        System.out.println("The string without duplicates is " + withoutDuplicates);

        String d = returnDuplicates(input);
        System.out.println(d);

    }

    private static int countDuplicates(String s){
        HashMap<Character, Integer> charCount = new HashMap<>();
        int duplicateCounter = 0;
        for (char c : s.toCharArray()) {
            if (!charCount.containsKey(c)) {
                charCount.put(c,0);
            } else {
                int priorCountForCurrentChar = charCount.get(c);
                charCount.replace(c, ++priorCountForCurrentChar);
                duplicateCounter++;
            }
        }
        return duplicateCounter;
    }

    private static String removeDuplicates(String s){
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()){
            if (!charList.contains(c)){
                charList.add(c);
            }
        }
        return charList.toString();
    }

    private static String returnDuplicates(String s) {
        String characters = "";
        String duplicates = "";
        for (char c : s.toCharArray()) {
            if (characters.contains(String.valueOf(c))) {
                if (!duplicates.contains(String.valueOf(c))) {
                    duplicates += c + " ";
                }
            }
            characters+= c;
        }
        return duplicates;
    }
}
