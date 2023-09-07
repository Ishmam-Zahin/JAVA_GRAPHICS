import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 500;
    Timer t;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myComponents();
    }

    public void myComponents(){
        MovingSnake snake = new MovingSnake(20, 20, this);
        MyKeyBoardListener keyBoardListener = new MyKeyBoardListener(snake);
        snake.addKeyListener(keyBoardListener);
        snake.setFocusable(true);
        snake.requestFocus();
        add(snake);
        setVisible(true);
        t = new Timer(80, snake);
        t.start();
    }

    public void stop(){
        t.stop();
    }
}
