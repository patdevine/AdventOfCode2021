package adventofcode2021.day.three;

import adventofcode2021.day.FileReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BinaryDiagnosticPartOne {

    public static int runDiagnostic(List<String> input) {
        int half = input.size() / 2;
        Map<Integer, Integer> positions = new HashMap<>();

        input.stream().forEach(binary -> {
            char[] chars = binary.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    Integer position = positions.get(i);
                    if (position == null) {
                        positions.put(i, 1);
                    } else {
                        positions.put(i, position + 1);
                    }
                }
            }
        });

        String gamma =  positions.keySet().stream().map(p -> {
            if (positions.get(p) > half) {
                return "1";
            } else {
                return "0";
            }
        }).collect(Collectors.joining());
        int gammaRate = Integer.parseInt(gamma, 2);

        String epsilon = positions.keySet().stream().map(p -> {
            if (positions.get(p) < half) {
                return "1";
            } else {
                return "0";
            }
        }).collect(Collectors.joining());
        int epsilonRate = Integer.parseInt(epsilon, 2);


        return epsilonRate * gammaRate;
    }

    public static void main(String[] args) {
        List<String> exampleInput = Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");
        System.out.println("example: " + runDiagnostic(exampleInput));

        List<String> actualInput = FileReader.readFile("three");
        System.out.println("actual: " + runDiagnostic(actualInput));

    }
}
