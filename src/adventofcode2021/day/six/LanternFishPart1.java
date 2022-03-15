package adventofcode2021.day.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LanternFishPart1 {
    public static void main(String[] args) {
        String[] split = example.split(",");
        List<LanternFish> initialState = Arrays.asList(split).stream().map(LanternFish::new).collect(Collectors.toList());

        System.out.println("intial state\n------------\n");
        int numDays = 256 ;
        for (int i = 0 ; i < numDays; i++){
            List<LanternFish> newFish = new ArrayList<>();
            initialState.stream().forEach(fish -> {
                fish.passDay();
                if (fish.getTimer() < 0) {
                    fish.resetTimer();
                    newFish.add(new LanternFish("8"));
                }
            });
            initialState.addAll(newFish);
            System.out.println(" \nsize: " + initialState.size());

        }
    }

    public static final String input = "3,5,3,1,4,4,5,5,2,1,4,3,5,1,3,5,3,2,4,3,5,3,1,1,2,1,4,5,3,1,4,5,4,3,3,4,3,1,1,2,2,4,1,1,4,3,4,4,2,4,3,1,5,1,2,3,2,4,4,1,1,1,3,3,5,1,4,5,5,2,5,3,3,1,1,2,3,3,3,1,4,1,5,1,5,3,3,1,5,3,4,3,1,4,1,1,1,2,1,2,3,2,2,4,3,5,5,4,5,3,1,4,4,2,4,4,5,1,5,3,3,5,5,4,4,1,3,2,3,1,2,4,5,3,3,5,4,1,1,5,2,5,1,5,5,4,1,1,1,1,5,3,3,4,4,2,2,1,5,1,1,1,4,4,2,2,2,2,2,5,5,2,4,4,4,1,2,5,4,5,2,5,4,3,1,1,5,4,5,3,2,3,4,1,4,1,1,3,5,1,2,5,1,1,1,5,1,1,4,2,3,4,1,3,3,2,3,1,1,4,4,3,2,1,2,1,4,2,5,4,2,5,3,2,3,3,4,1,3,5,5,1,3,4,5,1,1,3,1,2,1,1,1,1,5,1,1,2,1,4,5,2,1,5,4,2,2,5,5,1,5,1,2,1,5,2,4,3,2,3,1,1,1,2,3,1,4,3,1,2,3,2,1,3,3,2,1,2,5,2";
    public static final String example = "3,4,3,1,2";
}
