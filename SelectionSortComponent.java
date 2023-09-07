import javax.swing.*;
import java.awt.*;

public class SelectionSortComponent extends JComponent {
    SelectionSort selectionSort;

    public SelectionSortComponent(SelectionSort obj){
        selectionSort = obj;
    }

    public void paintComponent(Graphics g){
        selectionSort.draw(g);
    }
}
