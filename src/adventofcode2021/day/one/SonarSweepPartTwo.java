package adventofcode2021.day.one;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class SonarSweepPartTwo {

    // each line is a measurement of the sea floor depth as the sweep looks further and further away from the submarine.
    public static int[] exampleInput = new int[]{199,200,208,210,200,207,240,269,260,263};

    public static int exampleResult = 5;

    // comparing sums of previous 1, current, and next to current, cur+1, cur+2. \
    // Stopping if there isnt current +2 positions left
    public static int countNumberOfTimesDepthMeasurementIncreases(int[] exampleInput) {
        int counter = 0;
        for (int i = 1; i < exampleInput.length - 2; i++) {
            int sumOne = exampleInput[i-1] + exampleInput[i] + exampleInput[i+1];
            int sumTwo = exampleInput[i] + exampleInput[i+1] + exampleInput[i+2];
            if (sumOne < sumTwo) counter++;
        }
        return counter;
    }

    public static void main(String args[]){
        if (countNumberOfTimesDepthMeasurementIncreases(SonarSweepPartTwo.exampleInput) == exampleResult) {
            System.out.println("sample output passed.");
        } else {
            System.out.println("failed");
        }

        System.out.println(countNumberOfTimesDepthMeasurementIncreases(readFile()));
    }

    public static int[] readFile() {
        try {
            int[] intArray = Files.lines(FileSystems.getDefault().getPath("D:\\Intellij-Workspace\\AdventOfCode2021\\src\\adventofcode2021\\day\\one", "input"))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            return intArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[0];
    }

}
