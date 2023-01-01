public class ReverseAnInteger {
    public static void main(String[] args) {
        System.out.println(getSize(1234));
        System.out.println(reverseInt(12345));
    }


    private static int getSize (int n){
        return (int) Math.floor(Math.log10(n)) + 1;
    }

    private static int reverseInt(int n){
        int length = getSize(n);           //get the length of the integer
        int reversed = 0;
        while (n>0){
            int lastDigit = n % 10;
            n=n/10;
            reversed += lastDigit * (int) Math.pow(10,length-1);
            length--;
        }
        return reversed;
    }
}
