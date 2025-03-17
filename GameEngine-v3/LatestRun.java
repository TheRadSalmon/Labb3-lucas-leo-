import javax.swing.*;

public class LatestRun {
    private DefaultListModel<String> dlm;  // DefaultListModel för att hantera de senaste poängen

    public LatestRun() {
        dlm = new DefaultListModel<>();
    }

    public void addScore(int score) {
        // Lägg till poängen i DefaultListModel
        dlm.addElement("Poäng: " + score);

        // Om det finns fler än 3 element, ta bort det äldsta
        if (dlm.size() > 3) {
            dlm.removeElementAt(0); // Ta bort det första elementet (äldsta poängen)
        }
    }

    public DefaultListModel<String> getModel() {
        return dlm;
    }
}
