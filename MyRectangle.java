import javax.swing.*;
import java.awt.*;

public class MyRectangle extends JComponent {
    private int origin_X;
    private int origin_Y;
    Rectangle rectangle;

    public MyRectangle(int x, int y){
        origin_X = x;
        origin_Y = y;
        rectangle = new Rectangle(origin_X, origin_Y, 100, 200);
    }

    public void drawRectangle(Graphics2D g){
        g.draw(rectangle);
    }

    public void moveRectangle(){
        rectangle.translate(1, 1);
        System.out.println("x");
    }
}
