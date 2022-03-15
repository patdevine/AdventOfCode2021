package adventofcode2021.day.six;

public class LanternFish{
    int timer;

    public LanternFish(String timer) {
        this.timer = Integer.valueOf(timer);
    }

    public boolean passDay(){
        timer--;
        if (timer == -1) {
            return true;
        }
        return false;
    }

    public int getTimer() {
        return timer;
    }

    public void resetTimer() {
        this.timer = 6;
    }

}