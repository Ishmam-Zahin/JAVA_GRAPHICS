import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MyEventListener implements ActionListener {
    MyRectangle rectangle;

    public MyEventListener(MyRectangle obj){
        rectangle = obj;
    }
    public void actionPerformed(ActionEvent event){
        rectangle.move();
    }
}
