package utils;

import java.util.Random;

public class UsefulMethods {

    public static int[] generateRandomArray(int size){
        int[] myArray = new int[size];
        Random random = new Random();
        for (int i =0; i<myArray.length; i++){
            myArray[i] = random.nextInt(0,100);
        }
        return myArray;
    }
}
