import javax.swing.*;
import java.awt.*;

public class MyRectangle extends JComponent {
    private int origin_X;
    private int origin_Y;

    public MyRectangle(int x, int y){
        origin_X = x;
        origin_Y = y;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        printRectangle(g2);
    }

    public void printRectangle(Graphics2D g){
        Rectangle rectangle = new Rectangle(origin_X, origin_Y, 20, 10);
        g.draw(rectangle);
    }
}
