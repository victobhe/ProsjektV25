package prosjekt;

import java.io.File;

import java.util.Scanner;

public class FindScore {

    public String findFirstPlace(){
        try {
            File score = new File("scores.txt");
            Scanner scanner = new Scanner(score);
            int first = 0;
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                double mellom = Double.parseDouble(data);
                int x = (int) mellom;
                if (x > first){
                    first = x;
                }
            }
            scanner.close();
            String tmp = String.valueOf(first);
            return tmp;
        } catch (Exception e) {
           return "0";
        
    }
}
    public String findSecondPlace(){
        try {
            File score = new File("scores.txt");
            Scanner scanner = new Scanner(score);
            int first = 0;
            int second = 0;
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                double mellom = Double.parseDouble(data);
                int x = (int) mellom;
                if (x > second){
                    if (x > first){
                        second = first;
                        first = x;
                        continue;
                    }
                    second = x;
                }
            }
            scanner.close();
            String tmp = String.valueOf(second);
            return tmp;
        } catch (Exception e) {
        return "0";
        }
    }
    public String findThirdPlace(){
        try {
            File score = new File("scores.txt");
            Scanner scanner = new Scanner(score);
            int first = 0;
            int second = 0;
            int third = 0;
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                double mellom = Double.parseDouble(data);
                int x = (int) mellom;
                if (x > third){
                    if (x > second){
                        if (x > first){
                            third = second;
                            second = first;
                            first = x;
                            continue;
                        }
                        third = second;
                        second = x;
                        continue;
                    }
                    third = x;
                }
            }
            scanner.close();
            String tmp = String.valueOf(third);
            return tmp;
        } catch (Exception e) {
        return "0";
        }
    }
}




