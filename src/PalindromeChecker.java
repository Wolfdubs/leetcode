import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("racecar"));
        System.out.println(checkForPalindrome("womble"));
        System.out.println(checkForPalindrome("pullup"));
        System.out.println(checkForPalindrome("I love java"));
        System.out.println("Enter word to check if palindrome");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();;
        System.out.println(checkForPalindrome(word));
        System.out.println(checkForPalindromeViaReverse("poop"));
        System.out.println(checkForPalindromeViaReverse("mungo"));
        System.out.println(checkForPalindromeViaReverse("nurses run"));
    }

    public static boolean checkForPalindrome(String str){
        boolean isPalindrome = true;
        int end = str.length()-1;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)!=str.charAt(end)) {
                isPalindrome = false;
                System.out.println("Word was found to not be a palindrome at character " + str.charAt(i));
                break;
            }
            end--;
        }
        return isPalindrome;
    }

    public static boolean checkForPalindromeViaReverse(String s){
        String reverse = "";
        for (int i = s.length()-1; i>=0; i--){
            reverse += s.charAt(i);
        }
        boolean isPalindrome = true;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) != reverse.charAt(i)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
