package adventofcode2021.day.four;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BingoBoard {
    Map<String, String> board = new HashMap<>();
    Map<String, String> calledNumbers = new HashMap<>();
    boolean winState = false;

    public BingoBoard() {
    }

    public void setupBoard(List<String> values) {
        if (values.size() != 5) {
            System.out.println("board creation failed not 5 lines");
            return;
        }
        // each value is a row
        // iterate with integer to use as x coord
        // only increment y coord
        for (int y = 0 ; y < values.size(); y++) {
            String value = values.get(y);
            String[] s = value.split(" ");
            for (int x = 0; x < s.length; x++) {
                String coord = x + "," + y;
                board.put(s[x], coord);
            }
        }
    }


    public boolean call(String number) {
        if (winState) {
            return true;
        }
        String coordinates = board.get(number);
        board.remove(number);
//        System.out.println("removing " + number);
        calledNumbers.put(coordinates, number);

        if (checkWin()) {
            board.remove("");
            System.out.println(board.keySet().stream().filter( a -> a != null || !"".equals(a)).mapToInt(Integer::valueOf).sum() * Integer.valueOf(number));
            winState = true;
            return true;
        }
        return false;
    }

    private boolean checkWin() {
        int inARow = 0 ;
        // check rows
        for (int y = 0; y < 5; y++) {
            inARow = 0;
           for (int x = 0; x < 5; x++){
//               Coordinates coord = new Coordinates(x,y);
               String coord = x + "," + y;
//               System.out.println("found coord " + coord);

               if (calledNumbers.get(coord) != null ) {
                   inARow++;
                   if (inARow == 4){
                       return true;
                   }
               }
           }
//            System.out.println("not 5 in a row only : " + inARow);

        }

        // check cols
        for (int x = 0; x < 5; x++) {
            inARow = 0;
            for (int y = 0; y < 5; y++){
                String coord = x + "," + y;
                if (calledNumbers.get(coord) != null ) {
//                    System.out.println("found coord " + coord);
                    inARow++;
                    if (inARow == 4){
                        return true;
                    }
                }

            }
//            System.out.println("not 5 in a row only : " + inARow);

        }
        return false;
    }
}
