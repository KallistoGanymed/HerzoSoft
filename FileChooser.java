import javax.swing.*;
import java.io.File;

public class FileChooser {
    public static void main() {
        // Swing-Komponenten im Event-Dispatching-Thread ausführen
        SwingUtilities.invokeLater(() -> {
            String filePath = chooseFile();
            if (filePath != null) {
                System.out.println("Ausgewählte Datei: " + filePath);
            } else {
                System.out.println("Keine Datei ausgewählt.");
            }
        });
    }

    public static String chooseFile() {
        JFileChooser fileChooser = new JFileChooser();

        // Standard-Option: Nur Dateien auswählen (nicht Verzeichnisse)
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // FileChooser anzeigen und Auswahl abwarten
        int result = fileChooser.showOpenDialog(null);

        // Überprüfen, ob der Benutzer eine Datei ausgewählt hat
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            return null;
        }
    }

    public static String chooseDirectory() {
        JFileChooser fileChooser = new JFileChooser();

        // Standard-Option: Nur Dateien auswählen (nicht Verzeichnisse)
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // FileChooser anzeigen und Auswahl abwarten
        int result = fileChooser.showOpenDialog(null);

        // Überprüfen, ob der Benutzer eine Datei ausgewählt hat
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            return selectedDirectory.getAbsolutePath();
        } else {
            return null;
        }
    }
}