import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MovingSnake extends JComponent {
    private int origin_x;
    private int origin_y;
    public String direction;
    private ArrayList<Rectangle> body;
    private int [][] map;
    private Random random;
    private MainFrame frame;
    private Rectangle bug;
    private boolean eaten;
    private int ct;
    private StoreScore storeScore;
    private int highScore;
    private int speedLevel;

    public MovingSnake(int x, int y, MainFrame frame){
        speedLevel = 1;
        storeScore = new StoreScore();
        highScore = storeScore.read();
        ct = 1;
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
        g2.drawLine(5, 20, 5, 355);
        g2.drawLine(5, 20, 480, 20);
        g2.drawLine(480, 20, 480, 355);
        g2.drawLine(5, 355, 480, 355);
        for(int i=0; i<body.size(); i++){
            g2.draw(body.get(i));
        }

        if(eaten) createBug(g2);
        else{
            if(ct==1){
                g2.setColor(Color.RED);
                ct = (ct+1)%2;
            }
            else{
                g2.setColor(Color.BLUE);
                ct = (ct+1)%2;
            }
            g2.fill(bug);
        }

        g2.setColor(Color.RED);
        g2.drawString(("Score: "+(body.size()-5)), 5, 13);
        g2.drawString(("HighScore: "+highScore), 200, 13);

        if((body.size()-5) == 5 && speedLevel == 1){
            speedLevel++;
            frame.increaseSpeed();
        }
        if((body.size()-5) == 10 && speedLevel == 2){
            speedLevel++;
            frame.increaseSpeed();
        }
        if((body.size()-5) == 25 && speedLevel == 3){
            speedLevel++;
            frame.increaseSpeed();
        }
        if((body.size()-5) == 30 && speedLevel == 4){
            speedLevel++;
            frame.increaseSpeed();
        }
        if((body.size()-5) == 35 && speedLevel == 5){
            speedLevel++;
            frame.increaseSpeed();
        }
        if((body.size()-5) == 40 && speedLevel == 6){
            speedLevel++;
            frame.increaseSpeed();
        }
        if((body.size()-5) == 45 && speedLevel == 7){
            speedLevel++;
            frame.increaseSpeed();
        }
        if((body.size()-5) == 50 && speedLevel == 8){
            speedLevel++;
            frame.increaseSpeed();
        }
    }

    public void createBug(Graphics2D g){
        int x, y;
        do{
            x = random.nextInt(90);
            y = random.nextInt(50);
            x = x-(x%5);
            y = y-(y%5);
            x=x+5;
            y=y+20;
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

    public void snakeController(){
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
            if((body.size()-5)>highScore){
                storeScore.write((body.size()-5));
            }
            frame.gameFinished();
        }
    }

    public void moveDown(){
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (head_x == 0 || head_x == 480 || head_y == 15 || head_y == 355 || map[head_x / 5][(head_y + 5) / 5] == 1) {
                direction = "null";
                return;
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

    public void moveUp(){
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (head_x == 0 || head_x == 480 || head_y == 15 || head_y == 355 || map[head_x / 5][(head_y - 5) / 5] == 1) {
                direction = "null";
                return;
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

    public void moveRight(){
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (head_x == 0 || head_x == 480 || head_y == 15 || head_y == 355 || map[(head_x + 5) / 5][head_y / 5] == 1) {
                direction = "null";
                return;
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

    public void moveLeft(){
            int head_x = body.get(0).x;
            int head_y = body.get(0).y;
            if (head_x == bug.x && head_y == bug.y) {
                eaten = true;
                increaseSize();
            }
            if (head_x == 0 || head_x == 480 || head_y == 15 || head_y == 355 || map[(head_x - 5) / 5][head_y / 5] == 1) {
                direction = "null";
                return;
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
}
