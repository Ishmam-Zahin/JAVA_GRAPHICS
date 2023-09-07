import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MovingSnake extends JComponent implements ActionListener {
    private int origin_x;
    private int origin_y;
    public String direction;
    private ArrayList<Rectangle> body;

    public MovingSnake(int x, int y){
        origin_x = x;
        origin_y = y;
        direction = "r";
        body = new ArrayList<>();
        body.add(new Rectangle(origin_x, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-5, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-10, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-15, origin_y, 5, 5));
        body.add(new Rectangle(origin_x-20, origin_y, 5, 5));
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0; i<body.size(); i++){
            g2.draw(body.get(i));
        }
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
    }

    public void moveDown(){
        int head_x = body.get(0).x;
        int head_y = body.get(0).y;
        body.get(0).translate(0, 5);
        for(int i=1; i<body.size(); i++){
            int x = body.get(i).x;
            int y = body.get(i).y;
            body.get(i).setBounds(head_x, head_y, 5, 5);
            head_x = x;
            head_y = y;
        }
        repaint();
    }

    public void moveUp(){
        int head_x = body.get(0).x;
        int head_y = body.get(0).y;
        body.get(0).translate(0, -5);
        for(int i=1; i<body.size(); i++){
            int x = body.get(i).x;
            int y = body.get(i).y;
            body.get(i).setBounds(head_x, head_y, 5, 5);
            head_x = x;
            head_y = y;
        }
        repaint();
    }

    public void moveRight(){
        int head_x = body.get(0).x;
        int head_y = body.get(0).y;
        body.get(0).translate(5, 0);
        for(int i=1; i<body.size(); i++){
            int x = body.get(i).x;
            int y = body.get(i).y;
            body.get(i).setBounds(head_x, head_y, 5, 5);
            head_x = x;
            head_y = y;
        }
        repaint();
    }

    public void moveLeft(){
        int head_x = body.get(0).x;
        int head_y = body.get(0).y;
        body.get(0).translate(-5, 0);
        for(int i=1; i<body.size(); i++){
            int x = body.get(i).x;
            int y = body.get(i).y;
            body.get(i).setBounds(head_x, head_y, 5, 5);
            head_x = x;
            head_y = y;
        }
        repaint();
    }
}
