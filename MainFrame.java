import javax.swing.*;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 300;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawComponent();
    }

    public void drawComponent(){
        MyRectangle myRectangle = new MyRectangle(10, 20);
        add(myRectangle);
        setVisible(true);
    }
}
