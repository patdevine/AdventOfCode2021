package adventofcode2021.day.three;

import adventofcode2021.day.FileReader;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BinaryDiagnosticPartTwo {

    private static int runDiagnostic(List<String> input) {
        int oxygen        = filter(input, (ones, zeros) -> ones >= zeros ? '1' : '0', true);
        int carbonDioxide = filter(input, (ones, zeros) -> ones >= zeros ? '0' : '1', false);
        return oxygen * carbonDioxide;
    }

    private static int filter(List<String> numList, BiFunction<Integer, Integer, Character> bitSelector, boolean isOxygen) {
        var numsAsBits = numList;
        for (int i = 0; i < numsAsBits.get(0).length() && numsAsBits.size() > 1; ++i) {
            int j = i;
            int oneCount = (int) numsAsBits.stream().filter(s -> s.charAt(j) == '1').count();
            int zeroCount = numsAsBits.size() - oneCount;
            char expectedChar = bitSelector.apply(oneCount, zeroCount);
            char expectedChar2 = getFilterChar(isOxygen, oneCount, zeroCount);
            if (expectedChar != expectedChar2) {
                System.out.println("mismatch!");
            }
            numsAsBits = numsAsBits.stream().filter(s -> s.charAt(j) == expectedChar).collect(Collectors.toList());
        }
        return Integer.parseInt(numsAsBits.get(0), 2);
    }

    public static char getFilterChar(boolean isOxygen, int ones, int zeros) {
        if (isOxygen) {
            return ones > zeros ? '1' : '0';
        }
        return ones < zeros ? '0':'1';
    }


    public static void main(String[] args) {
        List<String> exampleInput = Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");
        System.out.println("example: " + runDiagnostic(exampleInput));

        List<String> actualInput = FileReader.readFile("three");
        System.out.println("actual: " + runDiagnostic(actualInput));

    }
}
