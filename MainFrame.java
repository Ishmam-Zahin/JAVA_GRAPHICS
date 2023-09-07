import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 500;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myComponents();
    }

    public void myComponents(){
        MovingSnake snake = new MovingSnake(20, 20);
        MyKeyBoardListener keyBoardListener = new MyKeyBoardListener(snake);
        snake.addKeyListener(keyBoardListener);
        snake.setFocusable(true);
        snake.requestFocus();
        add(snake);
        setVisible(true);
        Timer t = new Timer(100, snake);
        t.start();
    }
}
