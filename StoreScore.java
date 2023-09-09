import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class StoreScore {
    File scoreFile;

    public StoreScore(){
        scoreFile = new File("myScore.txt");
    }

    public int read(){
        try {
            if(!scoreFile.exists()){
                scoreFile.createNewFile();
            }
            Scanner readFile = new Scanner(scoreFile);
            if(readFile.hasNextLine()) return readFile.nextInt();
            else return 0;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public void write(int newHighScore){
        try {
            PrintWriter outFile = new PrintWriter(scoreFile);
            outFile.println(newHighScore);
            outFile.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
