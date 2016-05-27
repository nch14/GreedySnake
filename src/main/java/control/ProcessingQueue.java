package control;

import model.GameModelService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chenh on 2016/5/27.
 */
public class ProcessingQueue implements Runnable {

    public static GameModelService gameModelService;

    private static BlockingQueue<SnakeOperation> queue;

    public ProcessingQueue(GameModelService gameModelService){
        this.gameModelService=gameModelService;
        queue=new ArrayBlockingQueue<SnakeOperation>(1000);
        Thread t=new Thread(this);
        t.start();
    }
    public  static GameModelService getGameModelService(){
        return gameModelService;
    }

    public static void addOperation(SnakeOperation SnakeOperation){
        queue.add(SnakeOperation);

    }
    private static SnakeOperation getNewMineOperation () {
        SnakeOperation operation = null;
        try {
            operation = queue.take();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return operation;
    }

    @Override
    public void run() {
        while(true){
            SnakeOperation operation = getNewMineOperation();
            if(operation instanceof StartGameOperation){
                operation.execute();
            }else{
                if(gameModelService.nowDie()){
                    operation.execute();
                }
            }
        }
    }
}
