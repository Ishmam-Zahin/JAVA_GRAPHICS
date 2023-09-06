import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        MainFrame myframe = new MainFrame();
        MyThread thread1 = new MyThread(myframe, 20, 30, 10);
        MyThread thread2 = new MyThread(myframe, 20, 200, 9);
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(thread1);
        pool.execute(thread2);

    }
}
