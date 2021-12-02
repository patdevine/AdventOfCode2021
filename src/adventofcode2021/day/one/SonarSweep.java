package adventofcode2021.day.one;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class SonarSweep {

    // each line is a measurement of the sea floor depth as the sweep looks further and further away from the submarine.
    public static int[] exampleInput = new int[]{199,200,208,210,200,207,240,269,260,263};

    public static int exampleResult = 7;

    public static int countNumberOfTimesDepthMeasurementIncreases(int[] exampleInput) {
        int counter = 0;
        for (int i = 1; i < exampleInput.length; i++) {
            if (exampleInput[i-1] < exampleInput[i]) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String args[]){
        if (countNumberOfTimesDepthMeasurementIncreases(SonarSweep.exampleInput) == exampleResult) {
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
