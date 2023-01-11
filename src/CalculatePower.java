public class CalculatePower {

    public static void main(String[] args) {
        System.out.printf("%d", calculatePower(8, 4));
        System.out.printf("\n%d", calculatePowerRecursive(8, 4));
        System.out.printf("\n%d", calculatePowerMemoized(8, 4));
        System.out.printf("\n%f", calculatePowerHandleNegatives(3, -3));
    }

    //O(logn)
    public static int calculatePowerRecursive(int x, int y) {
        if (x == 0) return 0;
        if (y == 0) return 1;
        else return x * calculatePowerRecursive(x, y - 1);
    }


    //O(n) time & space
    public static int calculatePower(int x, int y) {
        if (y == 0) return 1;
        else if (y % 2 == 0) return calculatePower(x, y / 2) * calculatePower(x, y / 2);
        else return x * calculatePower(x, y / 2) * calculatePower(x, y / 2);
    }

    //calculates power(x, y/2) once then stores it
    public static int calculatePowerMemoized(int x, int y) {
        int temp;
        if (y == 0) return 1;
        temp = calculatePowerMemoized(x, y / 2);
        if (y % 2 == 0) return temp * temp;
        else return x * temp * temp;
    }

    public static float calculatePowerHandleNegatives(int x, int y) {
        float temp;
        if (y == 0) return 1;
        temp = calculatePowerHandleNegatives(x, y / 2);
        if (y % 2 == 0) return temp * temp;
        else {
            if (y > 0) return x * temp * temp;
            else return (temp * temp) / x;
        }
    }
}
