import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyBoardListener implements KeyListener {
    private MovingSnake snake;

    public void assignSnake(MovingSnake obj){
        snake = obj;
    }
    public void keyPressed(KeyEvent event){
        String key = KeyStroke.getKeyStrokeForEvent(event).toString();
        key = key.replace("pressed ", "");
        //System.out.println(key);
        if(snake.direction.equals("u") || snake.direction.equals("d")){
            if(key.equals("W") || key.equals("S")) return;
        }
        else if(snake.direction.equals("r") || snake.direction.equals("l")){
            if(key.equals("A") || key.equals("D")) return;
        }

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
        else{
            return;
        }
    }

    public void keyTyped(KeyEvent event){};
    public void keyReleased(KeyEvent event){};
}
