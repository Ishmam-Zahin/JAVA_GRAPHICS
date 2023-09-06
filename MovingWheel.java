import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class MovingWheel extends JComponent implements MovingComponents {
    private double origin_x;
    private double origin_y;
    private double radious;
    private double x1, y1;
    private int angle1, angle2, angle3;
    private final double PI = 3.1416;
    Ellipse2D.Double wheel;
    Line2D.Double line1, line2, line3;

    public MovingWheel(double x, double y, double diameter){
        origin_x = x;
        origin_y = y;
        radious = diameter/2;
        wheel = new Ellipse2D.Double(origin_x, origin_y, diameter, diameter);
        x1 = origin_x+diameter/2;
        y1 = origin_y+diameter/2;
        angle1=30;
        line1 = new Line2D.Double(x1, y1, (x1+radious*Math.cos((PI*angle1)/180)), (y1+radious*Math.sin((PI*angle1)/180)));
        angle2=150;
        line2 = new Line2D.Double(x1, y1, (x1+radious*Math.cos((PI*angle2)/180)), (y1+radious*Math.sin((PI*angle2)/180)));
        angle3=270;
        line3 = new Line2D.Double(x1, y1, (x1+radious*Math.cos((PI*angle3)/180)), (y1+radious*Math.sin((PI*angle3)/180)));
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(wheel);
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);
    }

    public void setBounds(double x, double y){
        origin_x = x;
        origin_y = y;
        move();
    }

    public void move(){
        wheel.setFrame(origin_x, origin_y, radious*2, radious*2);
        x1 = origin_x+radious;
        y1 = origin_y+radious;
        rotateLines();
        repaint();
    }

    public void rotateLines(){
        angle1 = (angle1+5)%360;
        line1.setLine(x1, y1, (x1+radious*Math.cos((PI*angle1)/180)), (y1+radious*Math.sin((PI*angle1)/180)));
        angle2 = (angle2+5)%360;
        line2.setLine(x1, y1, (x1+radious*Math.cos((PI*angle2)/180)), (y1+radious*Math.sin((PI*angle2)/180)));
        angle3 = (angle3+5)%360;
        line3.setLine(x1, y1, (x1+radious*Math.cos((PI*angle3)/180)), (y1+radious*Math.sin((PI*angle3)/180)));
    }
}
