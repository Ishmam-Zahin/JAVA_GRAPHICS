import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 1020;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawComponent();
    }

    public void drawComponent(){
        MovingWheel wheel = new MovingWheel(20, 20, 50);
        add(wheel);
        setVisible(true);
        MyEventListener listener = new MyEventListener(wheel);
        Timer t = new Timer(10, listener);
        t.start();
    }
}
