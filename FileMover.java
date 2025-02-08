import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileMover {
    public static void main(String Datei) {
        File sourceFile = new File(Datei);
        File destDirectory = new File(FileChooser.chooseDirectory());

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
        EKGGraph.main_method(Datei);
    }
}