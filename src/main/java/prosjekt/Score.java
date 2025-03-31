package prosjekt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Score {

    public static void InitializeSave() throws IOException {
        try {
            File file = new File("scores.txt");
            file.createNewFile();
            file.getAbsolutePath();
            // BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            // writer.write("Date,Round,Balance");
            // writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("An error occurred when attempting to save the score");
        }
    }
    
    public static void Save(int round, double balance) throws IOException {
        File file = new File("scores.txt");
        if (!file.exists()) {
            InitializeSave();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            // LocalDateTime date = LocalDateTime.now();
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            // String formattedDate = date.format(formatter);
            // writer.write(formattedDate + "," + round + "," + balance + " \n");
            writer.write((int)balance + " \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("An error occurred when attempting to save the score");
        }
    }

    public static void Read() throws IOException {
        try {
            Scanner sc = new Scanner (new File("scores.txt"));
            sc.useDelimiter(" | ");
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("An error occurred when attempting to read the scores");
        }
    }
}
