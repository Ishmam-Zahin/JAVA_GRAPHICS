import javax.swing.*;

public class ThreadPainter implements Runnable{
    private SelectionSort selectionSort;
    private JFrame frame;

    public ThreadPainter(SelectionSort obj, JFrame frame){
        selectionSort = obj;
        this.frame = frame;
    }

    public void run(){
        try {
            SelectionSortComponent selectionSortComponent = new SelectionSortComponent(selectionSort);
            frame.add(selectionSortComponent);
            frame.setVisible(true);

            for(int i=1; i<=100; i++){
                selectionSortComponent.repaint();
                Thread.sleep(100);
            }
        }
        catch (Exception e){

        }
    }
}
