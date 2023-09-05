import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MyEventListener implements ActionListener {
    MyComponents myComponents;
    public MyEventListener(MyComponents obj){
        myComponents = obj;
    }

    public void actionPerformed(ActionEvent event){
        myComponents.moveRectangle();
    }
}
