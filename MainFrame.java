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
        MyComponents myComponents = new MyComponents();
        add(myComponents);
        ActionListener listener = new MyEventListener(myComponents);
        Timer t = new Timer(1000, listener);
        t.start();
    }
}
