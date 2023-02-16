import java.io.*;

public class SaveToFile {


    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("saves.txt");
            fw.write(Game.rows + "\n" + Game.columns + "\n" + Game.moves + "\n" + Game.sum + "\n" + Game.target + "\n" + Game.tempX + "\n" + Game.tempY);
            fw.close();
            System.out.println("Succesfully written to file!");


            File fout = new File("values.txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            for(int i=0; i<Game.rows; i++) {
                for(int j=0; j<Game.columns; j++) {
                    bw.write(String.valueOf(Game.numValues[i][j]));
                    bw.newLine();
                }
            }
            bw.close();

        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

}
