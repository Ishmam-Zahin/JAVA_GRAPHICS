import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SelectionSort {
    private int alreadySorted;
    private int markedItem;
    private Lock sortState;
    private int[] array;

    public SelectionSort(int[] a){
        alreadySorted = -1;
        markedItem = -1;
        array = a;
        sortState = new ReentrantLock();
    }

    public void sort() throws InterruptedException{
        for(int i=0; i<array.length; i++){
            int min = minPos(i);
            sortState.lock();
            try {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
                alreadySorted = i;
            }
            finally {
                sortState.unlock();
            }
            Thread.sleep(100);
        }
        markedItem = -1;
    }

    public int minPos(int x) throws InterruptedException{
        int min = x;
        for(int i=x+1; i<array.length; i++){
            sortState.lock();
            try{
                if(array[i]<array[min]){
                    min = i;
                }
                markedItem = i;
            }
            finally {
                sortState.unlock();
            }
            Thread.sleep(100);
        }
        return min;
    }

    public void draw(Graphics g){
        int dis = 5;
        sortState.lock();
        try{
            for(int i=0; i<array.length; i++){
                if(i==markedItem){
                    g.setColor(Color.RED);
                }
                else if(i<=alreadySorted){
                    g.setColor(Color.BLUE);
                }
                else{
                    g.setColor(Color.BLACK);
                }

                g.drawLine((i+1)*dis, 0, (i+1)*dis, array[i]*10);
            }
        }
        finally {
            sortState.unlock();
        }
    }
}
