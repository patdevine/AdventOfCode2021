package adventofcode2021.day.eleven;

public class DumboOctopusP1 {

    

    public static void main(String[] args) {
        int[][] inputMatrix = new int[10][10];

        String[] row = example.split("\n");
        for (int i = 0 ; i < row.length; i++) {
            String[] col = row[i].split("");
            for (int j = 0; j < col.length; j++) {
                int value = Integer.valueOf(col[j]);
                inputMatrix[i][j] = value;
                System.out.print("%d".formatted(value));
            }
        System.out.println();
        }
    }

    static String example = """
            5483143223
            2745854711
            5264556173
            6141336146
            6357385478
            4167524645
            2176841721
            6882881134
            4846848554
            5283751526
            """;

    static String input = """
            1553421288
            5255384882
            1224315732
            4258242274
            1658564216
            6872651182
            5775552238
            5622545172
            8766672318
            2178374835
            """;
}
