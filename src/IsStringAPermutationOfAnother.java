import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsStringAPermutationOfAnother {
    public static void main(String[] args) {
        String string1 = "abcdefgh";
        String string2 = "hfacdegb";
        String string3 = "xyz";
        String string4 = "xyw";

        System.out.println(isPermutationViaSorting(string1,string2));
        System.out.println(isPermutationViaSorting(string1,string3));
        System.out.println(isPermutationViaSorting(string3,string4));

        System.out.println(isPermutationViaHashMap(string1,string2));
        System.out.println(isPermutationViaHashMap(string1,string3));
        System.out.println(isPermutationViaHashMap(string3,string4));

        System.out.println(isPermutationViaHashMapSubtraction(string1,string2));
        System.out.println(isPermutationViaHashMapSubtraction(string1,string3));
        System.out.println(isPermutationViaHashMapSubtraction(string3,string4));

        System.out.println("Enter string 1");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Enter string 2");
        String input2 = scanner.nextLine();
        System.out.println(isPermutationViaHashMapSubtraction(input,input2));
    }

    //Sort both strings, then compare O(nlogn)
    public static boolean isPermutationViaSorting(String s1, String s2){
        //remove whitespace, then check is lengths are same
        s1 = s1.trim().toLowerCase(); s2 = s2.trim().toLowerCase();
        if (s1.length()!=s2.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        return (new String(c1)).equals(new String(c2));
    }


    //hashmap = O(n)
    public static boolean isPermutationViaHashMap(String s1, String s2){
        //remove whitespace, then check is lengths are same
        s1 = s1.trim().toLowerCase(); s2 = s2.trim().toLowerCase();
        if (s1.length()!=s2.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int charCounter = 1;
            if (!map.containsKey(c)){
                map.put(c,charCounter);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c: s2.toCharArray()){
            int charCounter = 1;
            if (!map2.containsKey(c)){
                map2.put(c,charCounter);
            } else {
                map2.put(c, map2.get(c)+1);
            }
        }
        if (!map.keySet().equals(map2.keySet()))
            return false;
        for (char c : map.keySet()){
            if (!map.get(c).equals(map2.get(c)))
                return false;
        }
        return true;
    }

    //create hashmap with all the char counts for string 1
    //then with string 2, subtract all those string counts from the map
    //if any value left in the hashmap is not 0, there char counts are unequal, so return false
    public static boolean isPermutationViaHashMapSubtraction(String s1, String s2){
        s1 = s1.trim().toLowerCase(); s2 = s2.toLowerCase().trim();
        if (s1.length()!=s2.length()) return false;

        Map<Character,Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c,1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        for (char c : s2.toCharArray()){
            if (!map.containsKey(c)) return false;
            else {
                map.put(c,map.get(c)-1);
            }
        }
        for (int val : map.values()){
            if (val!=0) return false;
        }
        return true;
    }



}
