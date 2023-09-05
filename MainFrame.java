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
        MyRectangle rectangle1 = new MyRectangle(10, 20);
        add(rectangle1);
        setVisible(true);
        MyEventListener listener = new MyEventListener(rectangle1);
        Timer t = new Timer(1000, listener);
        t.start();

        MyRectangle rectangle2 = new MyRectangle(10, 80);
        add(rectangle2);
        setVisible(true);
        MyEventListener listener1 = new MyEventListener(rectangle2);
        Timer t1 = new Timer(100, listener1);
        t1.start();
    }
}
