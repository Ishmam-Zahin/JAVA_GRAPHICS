import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 300;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawComponent();
    }

    public void drawComponent(){
        MyStraightLine line1 = new MyStraightLine(150, 200, 200, 200, 0);
        add(line1);
        setVisible(true);
        MyEventListener listener1 = new MyEventListener(line1);
        Timer t1 = new Timer(10, listener1);
        t1.start();

        MyStraightLine line2 = new MyStraightLine(150, 200, 150, 250, 90);
        add(line2);
        setVisible(true);
        MyEventListener listener2 = new MyEventListener(line2);
        Timer t2 = new Timer(10, listener2);
        t2.start();

        MyStraightLine line3 = new MyStraightLine(150, 200, 100, 200, 180);
        add(line3);
        setVisible(true);
        MyEventListener listener3 = new MyEventListener(line3);
        Timer t3 = new Timer(10, listener3);
        t3.start();

        MyStraightLine line4 = new MyStraightLine(150, 200, 150, 150, 270);
        add(line4);
        setVisible(true);
        MyEventListener listener4 = new MyEventListener(line4);
        Timer t4 = new Timer(10, listener4);
        t4.start();

        MyEllipse ellipse1 = new MyEllipse(100, 150);
        add(ellipse1);
        setVisible(true);
    }
}
