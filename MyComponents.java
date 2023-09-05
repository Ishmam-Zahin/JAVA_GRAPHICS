import javax.swing.*;
import java.awt.*;

public class MyComponents extends JComponent {
    MyRectangle myRectangle;

    public MyComponents(){
        myRectangle = new MyRectangle(10, 20);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        myRectangle.drawRectangle(g2);
    }

    public void moveRectangle(){
        myRectangle.moveRectangle();
        repaint();
    }
}
