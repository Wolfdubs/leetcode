import java.util.Scanner;

public class GeneratePattern {
    public static void main(String[] args) {
        System.out.println("Enter number of stars");
        Scanner scanner = new Scanner(System.in);
        boolean validNum = false;
        int num = 0;
        do {
            try {
                String numString = scanner.nextLine();
                num = Integer.parseInt(numString);
                if (num<1){
                    System.out.println("Number cannot be negative or zero");
                    validNum=false;
                } else {
                    validNum = true;
                }
            } catch (NumberFormatException nfe){
                System.out.println("Input must be a valid number");
                validNum = false;
            }
        } while (!validNum);
        scanner.close();
        printPattern(num);

    }


    public static void printPattern(int length){
        for (int i = 0; i<length; i++){
            for (int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = length; i>0; i--){
            for (int j = i; j>0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
