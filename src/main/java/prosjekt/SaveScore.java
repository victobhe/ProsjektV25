package prosjekt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

public class SaveScore {

    public static void Save(int round, double balance) {
        try {
            File file = new File("scores.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                /* LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = date.format(formatter);
                writer.write(formattedDate + "      Round: " + round + " | Balance: " + balance + " \n"); */
                writer.write((int)balance + " \n");;
                writer.close();
            } catch (IOException e) {
                System.out.println("An error occurred attempting to save the score");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("An error occurred attempting to save the score");
            e.printStackTrace();
        }
    }
}
