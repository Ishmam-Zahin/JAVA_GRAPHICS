import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private MainFrame frame;
    private MovingSnake snake;

    public MyActionListener(MainFrame obj){
        frame = obj;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getActionCommand().equals("START")){
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.myComponents();
        }
        else if(event.getActionCommand().equals("RETRY")){
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.myComponents();
        }
        else{
            frame.exit();
        }
    }
}
