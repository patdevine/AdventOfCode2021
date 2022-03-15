package adventofcode2021.day.six;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanternFishPart2 {
    public static void main(String[] args) {
        String[] split = input.split(",");
        List<Integer> initialState = Arrays.asList(split).stream().mapToInt(a -> Integer.valueOf(a) + 1).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        BigInteger[] ocean = new BigInteger[9];

        for (int i = 0; i < 9; i++){
            ocean[i] = BigInteger.ZERO;
        }
        //populate
        for (Integer initialInt: initialState) {
            ocean[initialInt] = ocean[initialInt].add(BigInteger.ONE);
        }

        System.out.println("initial state\n------------\n");
        int numDays = 256 ;
        for (int i = 0 ; i <= numDays; i++){
            BigInteger numFishToAdd = ocean[0];
            for (int j = 1; j < 9; j++) {
                ocean[j-1] = ocean[j];
            }
            ocean[6] = ocean[6].add(numFishToAdd);
            ocean[8] = numFishToAdd;
        }

        // add up
        BigInteger fishCount = BigInteger.ZERO;
        for (int i = 0; i < 9; i++) {
            fishCount = fishCount.add(ocean[i]);
        }

        System.out.println("Fish count: " +  fishCount);
    }

    public static final String input = "3,5,3,1,4,4,5,5,2,1,4,3,5,1,3,5,3,2,4,3,5,3,1,1,2,1,4,5,3,1,4,5,4,3,3,4,3,1,1,2,2,4,1,1,4,3,4,4,2,4,3,1,5,1,2,3,2,4,4,1,1,1,3,3,5,1,4,5,5,2,5,3,3,1,1,2,3,3,3,1,4,1,5,1,5,3,3,1,5,3,4,3,1,4,1,1,1,2,1,2,3,2,2,4,3,5,5,4,5,3,1,4,4,2,4,4,5,1,5,3,3,5,5,4,4,1,3,2,3,1,2,4,5,3,3,5,4,1,1,5,2,5,1,5,5,4,1,1,1,1,5,3,3,4,4,2,2,1,5,1,1,1,4,4,2,2,2,2,2,5,5,2,4,4,4,1,2,5,4,5,2,5,4,3,1,1,5,4,5,3,2,3,4,1,4,1,1,3,5,1,2,5,1,1,1,5,1,1,4,2,3,4,1,3,3,2,3,1,1,4,4,3,2,1,2,1,4,2,5,4,2,5,3,2,3,3,4,1,3,5,5,1,3,4,5,1,1,3,1,2,1,1,1,1,5,1,1,2,1,4,5,2,1,5,4,2,2,5,5,1,5,1,2,1,5,2,4,3,2,3,1,1,1,2,3,1,4,3,1,2,3,2,1,3,3,2,1,2,5,2";
    public static final String example = "3,4,3,1,2";
}
