import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BugListener implements ActionListener {
    MyBug bug;
    public BugListener(MyBug obj){
        bug = obj;
    }

    public void actionPerformed(ActionEvent event){
        bug.createBug();
    }
}
