import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MyEventListener implements ActionListener {
    MovingComponents movingComponents;

    public MyEventListener(MovingComponents obj){
        movingComponents = obj;
    }
    public void actionPerformed(ActionEvent event){
        movingComponents.move();
    }
}
