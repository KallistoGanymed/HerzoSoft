import java.io.*;
import java.util.*;
import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class READ
{
    public static void main(String Datei) {

        List<Point> points = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(Datei));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                double x = Double.parseDouble(values[0]); // Zeitstempel
                double y = Double.parseDouble(values[1]); // EKG-Wert
                points.add(new Point(x, y));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Hier können Sie die Punkte zum Zeichnen des Graphen verwenden
        for (Point point : points) {
            System.out.println("x: " + point.x + ", y: " + point.y);
            //Hier kommt statt dessen der Darstellungsteil rein (Drawingarea o.ä.)
        }
    }

    public static void fileMover(String Datei) {
        File sourceFile = new File(Datei);
        File destDirectory = new File(chooseDirectory());

        File destFile = new File(destDirectory, sourceFile.getName());

        try {
            // Überprüfe, ob das Zielverzeichnis existiert, und erstelle es, falls nicht
            if (!destDirectory.getParentFile().exists()) {
                destDirectory.getParentFile().mkdirs();
            }

            // Datei kopieren
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);


            System.out.println("Datei erfolgreich kopiert");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fehler beim Verschieben der Datei");
        }
        main(Datei);
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

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

