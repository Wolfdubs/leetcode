import java.util.*;

public class PangramChecker {
    //pangram is sentence where each letter appears once
    public static void main(String[] args) {
        pangram("womble is a penkingese");
        pangram("the five boxing wizards jump quickly");
        System.out.println("Enter a string to check if it is a pangram");
        pangram2("mungo is dumb");
        pangram2("pack my box with five dozen liquor jugs");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        pangram(input);

    }

    private static boolean pangram(String str) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : str.toLowerCase().replaceAll(" \\.,!","").toCharArray()) {
            characterSet.add(c);
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (!characterSet.contains((char) i)) {
                System.out.println("not a pangram - string doesn't contain the character " + (char) i);
                return false;
            }
        }
        System.out.println("string is a pangram");
        return true;

    }

    private static boolean pangram2(String s) {
        int[] ascii = new int[128];
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int current = chars[i];
            if (current <= 128)
                ascii[current]++;
        }
        for (int i = 97; i <= 122; i++) {
            if (ascii[i] == 0) {
                System.out.println(s + ": is not a pangram, it doesn't have the letter " + (char)i);
                return false;
            }
        }
        System.out.println(s + ": is a pangram");
        return true;


    }
}
