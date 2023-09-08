import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeActionListener implements ActionListener {
    private MovingSnake snake;

    public SnakeActionListener(MovingSnake snake){
        this.snake = snake;
    }

    public void actionPerformed(ActionEvent event){
        snake.snakeController();
    }
}
