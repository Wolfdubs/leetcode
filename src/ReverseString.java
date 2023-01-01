import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println("Enter string to reverse");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println(reverseString(userInput));
    }

    private static String reverseString(String str){
        String reversedString = "";
        for (int i=str.length()-1; i>=0; i--){
            char temp = str.charAt(i);
            reversedString = reversedString + temp;
        }
        return reversedString;
    }
}


//iterate backwards through input string
//add each encountered char to the next positon from start in output string
