import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class MovingSnake extends JComponent implements ActionListener {
    private int origin_x;
    private int origin_y;
    public String direction;
    private ArrayList<Rectangle> body;
    private int [][] map;

    private Random random;
    private MainFrame frame;

    private Rectangle bug;

    private boolean eaten;

    public MovingSnake(int x, int y, MainFrame frame){
        this.frame = frame;
        random = new Random();
        bug = new Rectangle();
        eaten = true;
        origin_x = x;
        origin_y = y;
        direction = "r";
        body = new ArrayList<>();
        body.add(new Rectangle(origin_x, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-5, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-10, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-15, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-20, origin_y, 5, 5));
        map = new int[100][100];
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                map[i][j]=0;
            }
        }
        map[(origin_x)/5][origin_y/5] = 1;
        map[(origin_x-5)/5][origin_y/5] = 1;
        map[(origin_x-10)/5][origin_y/5] = 1;
        map[(origin_x-15)/5][origin_y/5] = 1;
        map[(origin_x-20)/5][origin_y/5] = 1;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0; i<body.size(); i++){
            g2.draw(body.get(i));
        }

        if(eaten) createBug(g2);
        else{
            g2.setColor(Color.BLUE);
            g2.fill(bug);
        }
    }

    public void createBug(Graphics2D g){
        int x, y;
        do{
            x = random.nextInt(95);
            y = random.nextInt(75);
            x = x-(x%5);
            y = y-(y%5);
        }while (map[x][y]==1);

        bug.setBounds(x*5, y*5, 5, 5);
        g.setColor(Color.BLUE);
        g.fill(bug);
        //System.out.println(x+" "+y);
        eaten = false;
    }

    public void increaseSize(){
        body.add(new Rectangle());
    }

    public void actionPerformed(ActionEvent event){
        //System.out.println(this.getHeight());
        if(direction.equals("r")){
            moveRight();
        }
        else if(direction.equals("l")){
            moveLeft();
        }
        else if(direction.equals("u")){
            moveUp();

        }
        else if(direction.equals("d")){
            moveDown();
        }
        else{
            System.out.println("GAME FINISHED!!!");
            frame.stop();
        }
    }

    public void moveDown(){
        try {
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (map[head_x / 5][(head_y + 5) / 5] == 1) {
                //System.out.println("GAME FINISHED!!!");
                direction = "null";
            }
            body.get(0).translate(0, 5);
            map[head_x / 5][(head_y + 5) / 5] = 1;
            map[head_x / 5][head_y / 5] = 0;
            for (int i = 1; i < body.size(); i++) {
                int x = body.get(i).x;
                int y = body.get(i).y;
                map[x / 5][y / 5] = 0;
                body.get(i).setBounds(head_x, head_y, 5, 5);
                map[head_x / 5][head_y / 5] = 1;
                head_x = x;
                head_y = y;
            }
            repaint();
        }
        catch (Exception e){
            System.out.println("GAME FINISHED!!!");
            frame.stop();
        }
    }

    public void moveUp(){
        try {
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (map[head_x / 5][(head_y - 5) / 5] == 1) {
                //System.out.println("GAME FINISHED!!!");
                direction = "null";
            }
            body.get(0).translate(0, -5);
            map[head_x / 5][(head_y - 5) / 5] = 1;
            map[head_x / 5][head_y / 5] = 0;
            for (int i = 1; i < body.size(); i++) {
                int x = body.get(i).x;
                int y = body.get(i).y;
                map[x / 5][y / 5] = 0;
                body.get(i).setBounds(head_x, head_y, 5, 5);
                map[head_x / 5][head_y / 5] = 1;
                head_x = x;
                head_y = y;
            }
            repaint();
        }
        catch (Exception e){
            System.out.println("GAME FINISHED!!!");
            frame.stop();
        }
    }

    public void moveRight(){
        try {
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (map[(head_x + 5) / 5][head_y / 5] == 1) {
                //System.out.println("GAME FINISHED!!!");
                direction = "null";
            }
            body.get(0).translate(5, 0);
            map[(head_x + 5) / 5][head_y / 5] = 1;
            map[head_x / 5][head_y / 5] = 0;
            for (int i = 1; i < body.size(); i++) {
                int x = body.get(i).x;
                int y = body.get(i).y;
                map[x / 5][y / 5] = 0;
                body.get(i).setBounds(head_x, head_y, 5, 5);
                map[head_x / 5][head_y / 5] = 1;
                head_x = x;
                head_y = y;
            }
            repaint();
        }
        catch (Exception e){
            System.out.println("GAME FINISHED!!!");
            frame.stop();
        }
    }

    public void moveLeft(){
        try {
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (map[(head_x - 5) / 5][head_y / 5] == 1) {
                //System.out.println("GAME FINISHED!!!");
                direction = "null";
            }
            body.get(0).translate(-5, 0);
            map[(head_x - 5) / 5][head_y / 5] = 1;
            map[head_x / 5][head_y / 5] = 0;
            for (int i = 1; i < body.size(); i++) {
                int x = body.get(i).x;
                int y = body.get(i).y;
                map[x / 5][y / 5] = 0;
                body.get(i).setBounds(head_x, head_y, 5, 5);
                map[head_x / 5][head_y / 5] = 1;
                head_x = x;
                head_y = y;
            }
            repaint();
        }
        catch (Exception e){
            System.out.println("GAME FINISHED!!!");
            frame.stop();
        }
    }
}
