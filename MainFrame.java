import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 500;

    private MyActionListener myActionListener;
    private MyKeyBoardListener keyBoardListener;
    Timer t;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake game");

        myActionListener = new MyActionListener(this);
        keyBoardListener = new MyKeyBoardListener();
        addKeyListener(keyBoardListener);
    }

    public void myComponents(){
        setFocusable(true);
        requestFocus();
        MovingSnake snake = new MovingSnake(20, 30, this);
        keyBoardListener.assignSnake(snake);
        add(snake);
        setVisible(true);
        SnakeActionListener snakeActionListener = new SnakeActionListener(snake);
        t = new Timer(80, snakeActionListener);
        t.start();
    }

    public void stop(){
        t.stop();
    }

    public void startMenu(){
        JPanel myPanel = new JPanel();
        myPanel.setLayout(null);
        JButton start = new JButton("START");
        JButton exit = new JButton("EXIT");
        JLabel text = new JLabel();
        text.setFont(new Font("Ariel", Font.BOLD, 30));
        text.setText("Sanke Game");


        start.setBounds(190, 100, 80, 50);
        exit.setBounds(190, 160, 80, 50);
        text.setBounds(130, 50, 400, 50);


        start.addActionListener(myActionListener);
        exit.addActionListener(myActionListener);

        myPanel.add(start);
        myPanel.add(exit);
        myPanel.add(text);

        add(myPanel);
        setVisible(true);

    }

    public void exit(){
        dispose();
    }

    public void gameFinished(){
        stop();
        setFocusable(false);
        getContentPane().removeAll();
        repaint();

        JPanel panel = new JPanel();
        JLabel finished = new JLabel();
        panel.setLayout(null);
        finished.setFont(new Font("Ariel", Font.BOLD, 30));
        finished.setText("GAME FINISHED!!!");
        finished.setBounds(130, 50, 400, 50);

        JButton exit = new JButton("EXIT");
        exit.setBounds(150, 160, 80, 50);
        exit.addActionListener(myActionListener);

        JButton retry = new JButton("RETRY");
        retry.addActionListener(myActionListener);
        retry.setBounds(260, 160, 80, 50);

        panel.add(finished);
        panel.add(exit);
        panel.add(retry);
        add(panel);
        setVisible(true);
    }
}
