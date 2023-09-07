public class ThreadSorter implements Runnable{
    private SelectionSort selectionSort;

    public ThreadSorter(SelectionSort obj){
        selectionSort = obj;
    }

    public void run(){
        try{
            selectionSort.sort();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
