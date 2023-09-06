import javax.swing.*;
import java.awt.*;

public class MovingCar extends JComponent{
    private int origin_x;
    private int origin_y;
    private int u_body_width, u_body_height, l_body_width, l_body_height;
    private int l_x, l_y, u_x, u_y;
    private double b_x, b_y, f_x, f_y, diameter;
    Rectangle lowerBody, upperBody;
    MovingWheel backWheel, frontWheel;

    public MovingCar(int origin_x, int origin_y){
        this.origin_x = origin_x;
        this.origin_y = origin_y;
        l_body_width = 100;
        l_body_height = 30;
        u_body_height = 15;
        u_body_width = 70;
        l_x = origin_x;
        l_y = origin_y+u_body_height;
        lowerBody = new Rectangle(l_x, l_y, l_body_width, l_body_height);
        u_x = origin_x+10;
        u_y = origin_y;
        upperBody = new Rectangle(u_x, u_y, u_body_width, u_body_height);
        b_x = origin_x+5;
        b_y = origin_y+u_body_height+l_body_height;
        diameter = 25;
        backWheel = new MovingWheel(b_x, b_y, diameter);
        f_x = origin_x+70;
        f_y = b_y;
        frontWheel = new MovingWheel(f_x, f_y, diameter);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(lowerBody);
        g2.draw(upperBody);
        backWheel.paintComponent(g);
        frontWheel.paintComponent(g);
    }

    public void move(){
        origin_x++;
        upperBody.translate(1, 0);
        lowerBody.translate(1, 0);
        b_x = origin_x+5;
        backWheel.setBounds(b_x, b_y);
        f_x = origin_x+70;
        frontWheel.setBounds(f_x, f_y);
        repaint();
    }
}
