import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNumbers {
    public static void main(String[] args) {
        List<Integer> primeNumbersList = primeNumbers(100);
        for (int i : primeNumbersList){
            System.out.print(i + ", ");
        }
        System.out.println();
        List<Integer> firstNPrimeNumbers = findFirstNPrimeNumbers(20);
        for (int i : firstNPrimeNumbers){
            System.out.print(i + ", ");
        }
        System.out.println();
        List<Integer> primeNumbersBetweenRange = findPrimesBetweenRange(1,1000);
        primeNumbersBetweenRange.forEach(i -> System.out.print(i + ", "));
    }

    private static List<Integer> primeNumbers(int n){
        List<Integer> integerList = new ArrayList<>();
        for (int numberToCheck=2; numberToCheck <= n; numberToCheck++){   //as 0 and 1 can never be prime
            boolean isPrime = true;
            for (int factor = 2; factor <= Math.sqrt(numberToCheck); factor++){
                if (numberToCheck % factor == 0){
                    isPrime = false;
                    break;
                }
            } if (isPrime){
            integerList.add(numberToCheck);}
        }
        return integerList;
    }

    private static List<Integer> findFirstNPrimeNumbers (int n){
        List<Integer> primeList = new ArrayList<>();
        int numberToCheck = 2;   //start at 2, as 0 and 1 are not prime
        int countOfPrimes = 0;   //tracker for the number of primes found so far
        while(true){   //with each loop, we are checking if the current number, starting from 2 and incrementing every loop,is prime, using a boolean to control flow
            boolean isPrime = true;
            for (int factor = 2; factor <= Math.sqrt(numberToCheck); factor++){
                if (numberToCheck%factor == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primeList.add(numberToCheck);
                countOfPrimes++;
                if (countOfPrimes>=n){   //exit the while loop once you have as many primes as was requested
                    break;
                }
            }
            numberToCheck++;  //increments the number to check if i is prime, with every while loop
        }
        return primeList;
    }

    private static List<Integer> findPrimesBetweenRange(int start, int end){
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = start; i <=end; i++){
            boolean isPrime = false;
            for (int factor = 2; factor<=Math.sqrt(i); factor++){
                if (i % factor != 0 ){
                    isPrime = true;
                } else {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
