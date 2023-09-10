import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyBug extends JComponent {
    private MainFrame frame;
    private Rectangle bug;
    private Random random;
    private int ct;

    public MyBug(MainFrame obj){
        frame = obj;
        bug = new Rectangle();
        random = new Random();
        ct=0;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(ct==0){
            g2.setColor(Color.BLUE);
            g2.fill(bug);
            ct = (ct+1)%2;
        }
        else{
            g2.setColor(Color.RED);
            g2.fill(bug);
            ct = (ct+1)%2;
        }
    }

    public void createBug(){
        if(!frame.eaten){
            repaint();
            return;
        }
        frame.eaten = false;
        int x, y;
        do{
            x = random.nextInt(90);
            y = random.nextInt(50);
            x = x-(x%5);
            y = y-(y%5);
            x=x+5;
            y=y+20;
        }while (frame.map[x][y]==1);
        bug.setBounds(x*5, y*5, 5, 5);
        frame.bug_x = x*5;
        frame.bug_y = y*5;
        repaint();
    }
}
