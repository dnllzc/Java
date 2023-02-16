import java.io.*;
import java.util.Scanner;

public class ReadFromFile {

    public static void main(String[] args) {
        int count = 0;

        try {
            File saveFile = new File("saves.txt");
            Scanner sc = new Scanner(saveFile);
            while (sc.hasNextLine()) {
                if (count == 0) {Game.rows = sc.nextInt();}
                if (count == 1) {Game.columns = sc.nextInt();}
                if (count == 2) {Game.moves = sc.nextInt();}
                if (count == 3) {Game.sum = sc.nextInt();}
                if (count == 4) {Game.target = sc.nextInt();}
                if (count == 5) {Game.tempX = sc.nextInt();}
                if (count == 6) {Game.tempY = sc.nextInt();}
                count++;
            }
            sc.close();

            File saveFile2 = new File("values.txt");
            FileInputStream fstream = new FileInputStream("values.txt");
            BufferedReader brr = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = brr.readLine()) != null)   {
                Game.numValues[count/Game.rows][count%Game.columns] = Integer.parseInt(strLine);
            }
            fstream.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
