import javax.swing.*;

public class MainFrame extends JFrame {
    private final Integer FRAME_HEIGHT = 400;
    private final Integer FRAME_WIDTH = 300;

    public MainFrame(){
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
