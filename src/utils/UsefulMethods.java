package utils;

import java.util.Random;

public class UsefulMethods {

    public static int[] generateRandomArray(int size){
        int[] myArray = new int[size];
        Random random = new Random();
        for (int i =0; i<myArray.length; i++){
            myArray[i] = random.nextInt(0,100);
           // myArray[i] = (int) (Math.random() *10);
        }
        return myArray;
    }

    public static int[] generateRandomArray(int size, int bound){
        int[] myArray = new int[size];
        Random random = new Random();
        for (int i =0; i<myArray.length; i++){
            myArray[i] = random.nextInt(0,bound+1);
            // myArray[i] = (int) (Math.random() *10);
        }
        return myArray;
    }

    public static int[] generateRandomArrayWithNegatives(int size, int bound){
        int[] myArray = new int[size];
        Random random = new Random();
        for (int i =0; i<myArray.length; i++){
            myArray[i] = (random.nextInt(0,bound+1) - bound/2);
            // myArray[i] = (int) (Math.random() *10);
        }
        return myArray;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
