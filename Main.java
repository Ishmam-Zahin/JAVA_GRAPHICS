import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[] a = {4, 1, 3, 7, 2, 9, 3, 8, 4, 2};
        SelectionSort selectionSort = new SelectionSort(a);

        ThreadSorter threadSorter = new ThreadSorter(selectionSort);
        Thread t1 = new Thread(threadSorter);
        t1.start();

        ThreadPainter threadPainter = new ThreadPainter(selectionSort, frame);
        Thread t2 = new Thread(threadPainter);
        t2.start();
    }
}
