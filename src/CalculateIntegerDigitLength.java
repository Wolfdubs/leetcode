public class CalculateIntegerDigitLength {
    public static void main(String[] args) {
        System.out.println(calculateIntegerDigitLengthWhileLoop(49826));
        
        int[] array = {5,91,2,520583,0,12,22,609474938,3295,0,881};
        int size = array.length;
        for (int i = 0; i<size; i++){
            int count = calculateIntegerDigitLengthString(array[i]);
            System.out.println("The length of the integer " + array[i] + " is " + count);
        }

        System.out.println(calculateIntegerDigitLengthContinuousMultiplication(9583058));
        System.out.println(calculateIntegerDigitLengthLogarithm(1475958380));
        System.out.println(calculateIntegerDigitLengthRecursion(7328));

    }

    public static int calculateIntegerDigitLengthWhileLoop(int n){
        int count = 0;
        while (n!=0){
            n = n/10;
            count++;
        }
        return count;
    }

    public static int calculateIntegerDigitLengthString(int n) {
        String string = String.valueOf(n);
        return string.length();
    }

    public static int calculateIntegerDigitLengthContinuousMultiplication(int n) {
        int counter = 0;
        int temp = 1;
        while (temp <= n) {
            temp *= 10;
            counter++;
        }
        return counter;
    }

    public static int calculateIntegerDigitLengthLogarithm(int n) {
        return (int) (Math.log10(n) + 1);
    }

    public static int calculateIntegerDigitLengthRecursion(int n) {
        if (n/10 ==0) return 1;
        return 1 + calculateIntegerDigitLengthRecursion(n/10);
    }

















}
