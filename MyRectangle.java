import javax.swing.*;
import java.awt.*;

public class MyRectangle extends JComponent implements MovingComponents {
    private int origin_X;
    private int origin_Y;
    Rectangle rectangle;

    public MyRectangle(int x, int y){
        origin_X = x;
        origin_Y = y;
        rectangle = new Rectangle(origin_X, origin_Y, 100, 50);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(rectangle);
    }

    public void move(){
        rectangle.translate(1, 0);
        repaint();
    }
}
