import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyEllipse extends JComponent implements MovingComponents {
    private double x;
    private double y;
    Ellipse2D.Double ellipse;

    public MyEllipse(double x, double y){
        this.x = x;
        this.y = y;
        ellipse = new Ellipse2D.Double(x, y, 100, 100);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(ellipse);
    }

    public void move(){

    }
}
