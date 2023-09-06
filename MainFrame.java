import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 1920;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawComponent();
    }

    public void drawComponent(){
        MovingCar car1 = new MovingCar(20, 30);
        add(car1);
        setVisible(true);
        MyEventListener listener1 = new MyEventListener(car1);
        Timer t1 = new Timer(10, listener1);
        t1.start();

        MovingCar car2 = new MovingCar(20, 200);
        add(car2);
        setVisible(true);
        MyEventListener listener2 = new MyEventListener(car2);
        Timer t2 = new Timer(1, listener2);
        t2.start();
    }
}
