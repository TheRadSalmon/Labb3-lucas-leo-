import javax.swing.*;
import java.util.*;

public class HighScore {
    private DefaultListModel<String> dlm;  // DefaultListModel för att hantera highscore-listan

    public HighScore() {
        dlm = new DefaultListModel<>();
    }

    public void addScore(int score) {
        // Fråga användaren om initialer (namn)
        String name = JOptionPane.showInputDialog("Enter your initials:");

        // Lägg till poäng och namn i DefaultListModel
        dlm.addElement(name + ": " + score);

        // Sortera listan i fallande ordning baserat på poäng
        sortListModel();

        // Om det finns fler än 10 element, ta bort det lägsta
        if (dlm.size() > 10) {
            dlm.removeElementAt(dlm.size() - 1); // Ta bort det sista elementet (lägsta poängen)
        }
    }

    // Hjälpmetod för att sortera DefaultListModel baserat på poäng
    private void sortListModel() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < dlm.size(); i++) {
            list.add(dlm.getElementAt(i));
        }

        // Sortera listan i fallande ordning baserat på poäng
        list.sort((e1, e2) -> {
            int score1 = Integer.parseInt(e1.split(": ")[1]);
            int score2 = Integer.parseInt(e2.split(": ")[1]);
            return Integer.compare(score2, score1); // Sortera från högsta till lägsta
        });

        // Uppdatera DefaultListModel med den sorterade listan
        dlm.clear();
        for (String entry : list) {
            dlm.addElement(entry);
        }
    }

    public DefaultListModel<String> getModel() {
        return dlm;
    }
}
