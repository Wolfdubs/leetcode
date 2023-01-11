public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialRecursive(5));
        System.out.println(factorialForLoop(8));
        System.out.println(factorialForLoopBasic(6));

    }

    public static int factorialForLoopBasic(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++)
            factorial *= i;
        return factorial;
    }

    public static int factorialForLoop(int n) {
        int f;
        for (f = 1; n > 1; n--)
            f *=n;
        return f;
    }

    public static int factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }

}
