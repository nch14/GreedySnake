package control;

/**
 * Created by chenh on 2016/5/27.
 */
public abstract class SnakeOperation {
    int direction;
    public SnakeOperation(){
        ProcessingQueue.addOperation(this);
    }

    public abstract void execute();

}
