import java.util.HashSet;
import java.util.Set;

public class UniqueCharChecker {

    static String notUnique = "qwertyqwerty";
    static String unique = "qwerty";

    public static void main(String[] args) {
        System.out.println(isUnique(notUnique));
        System.out.println(isUnique(unique));
    }

    public static boolean isUnique(String s){
        Set<Character> charSet = new HashSet<>();
        boolean seenChar = false;
        if (s.equals(null) || s.equals("")){
            System.out.println("invalid string input");
            return false;
        }
        for (char c : s.toCharArray()){
            if (!charSet.contains(Character.toLowerCase(c))){
                charSet.add(c);
            } else {
                seenChar = true;
            }
        }
        if (!seenChar) {
            System.out.println("The string " + s + " has all unique characters");
        } else System.out.println("The string " + s + " has repeating characters");
        return !seenChar;
    }
}
