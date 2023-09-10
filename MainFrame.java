import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 500;
    private MyActionListener myActionListener;
    private MyKeyBoardListener keyBoardListener;
    private SnakeActionListener snakeActionListener;
    private BugListener bugListener;
    public int bug_x;
    public int bug_y;
    public int [][] map;
    public boolean eaten;
    Timer t1, t2;

    MovingSnake snake;
    MyBug bug;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake game");

        snake = new MovingSnake(this);
        bug = new MyBug(this);

        map = new int[100][100];
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                map[i][j]=0;
            }
        }

        eaten = true;

        myActionListener = new MyActionListener(this);
        keyBoardListener = new MyKeyBoardListener(snake);
        bugListener = new BugListener(bug);
        snakeActionListener = new SnakeActionListener(snake);
        addKeyListener(keyBoardListener);

        t1 = new Timer(100, snakeActionListener);
        t2 = new Timer(100, bugListener);
    }

    public boolean isEaten(int x, int y){
        if(x == bug_x && y == bug_y){
            return true;
        }
        else{
            return false;
        }
    }

    public void myComponents(){
        setFocusable(true);
        requestFocus();
        snake.resetSnake();
        add(snake);
        setVisible(true);
        add(bug);
        setVisible(true);

        t1.start();
        t2.start();

    }

    public void increaseSpeed(){
        t1.setDelay((t1.getDelay()-50));
    }

    public void stop(){
        t1.stop();
        t2.stop();
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
