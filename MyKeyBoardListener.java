import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyBoardListener implements KeyListener {
    private MovingSnake snake;

    public MyKeyBoardListener(MovingSnake obj){
        snake = obj;
    }
    public void keyPressed(KeyEvent event){
        String key = KeyStroke.getKeyStrokeForEvent(event).toString();
        key = key.replace("pressed ", "");
        //System.out.println(key);
        if(key.equals("w") || key.equals("W")){
            snake.direction = "u";
        }
        else if(key.equals("d") || key.equals("D")){
            snake.direction = "r";
        }
        else if(key.equals("a") || key.equals("A")){
            snake.direction = "l";
        }
        else if(key.equals("s") || key.equals("S")){
            snake.direction = "d";
        }
        else if(key.equals("p") || key.equals("P")){
            snake.increaseSize();
        }
    }

    public void keyTyped(KeyEvent event){};
    public void keyReleased(KeyEvent event){};
}
