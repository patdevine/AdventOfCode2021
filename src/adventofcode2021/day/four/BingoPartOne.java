package adventofcode2021.day.four;

import adventofcode2021.day.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoPartOne {


    public static void main(String[] args) {
        List<String> four = FileReader.readFile("four");
        // First line is the call order;
        String order = four.get(0);
        four.remove(0);
        four.remove(0); // remove first line break
        List<BingoBoard> boards = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        for (String line : four) {
            BingoBoard newBingoBoard = new BingoBoard();
            if (line == null || line.isBlank() || line.isBlank()) {
                newBingoBoard.setupBoard(lines);
                boards.add(newBingoBoard);
                lines.clear();
            } else {
                lines.add(line);
            }
        }

        List<String> callOrder = Arrays.asList(order.split(","));

        for (String number : callOrder) {
           for (BingoBoard bingoBoard : boards) {
               if (bingoBoard.call(number)) {
                   break;
               }
           }
        }
    }

}
