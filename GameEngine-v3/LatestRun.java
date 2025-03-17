import javax.swing.*;
import java.util.*;

public class LatestRun {
    private LinkedList<Integer> latestRuns = new LinkedList<>();
  
    public void addScore(int score) {
        if (latestRuns.size() >= 3) {
            latestRuns.poll(); 
        }
        latestRuns.add(score);
    }

    public LinkedList<Integer> getLatestRuns() {
        return latestRuns;
    }
}
