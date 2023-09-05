import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MyStraightLine extends JComponent implements MovingComponents {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    private int angle;
    private final double PI = 3.1416;
    Line2D.Double line;

    public MyStraightLine(double x1, double y1, double x2, double y2, int angle){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.angle = (angle+10)%360;
        line = new Line2D.Double(x1, y1, x2, y2);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(line);
    }

    public void move(){
        //System.out.println(angle);
        double radian = (PI*angle)/180;
        double x = 50*Math.cos(radian);
        double y = 50*Math.sin(radian);
        x2 = x1+x;
        y2 = y1+y;
        line.setLine(x1, y1, x2, y2);
        angle = (angle+10)%360;
        repaint();
    }
}
