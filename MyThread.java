import javax.swing.*;
import java.awt.event.ActionEvent;

public class MyThread implements Runnable{
    private int x;
    private int y;
    private int speed;
    private int sleep;
    MainFrame frame;

    public MyThread(MainFrame frame, int x, int y, int sleep){
        this.frame = frame;
        this.x = x;
        this.y = y;
        this.sleep = sleep;
    }

    public void run(){
        try{
            MovingCar car = new MovingCar(x, y);
            frame.add(car);
            frame.setVisible(true);
            while (true){
                car.move();
                Thread.sleep(sleep);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
