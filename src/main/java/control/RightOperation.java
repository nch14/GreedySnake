package control;

/**
 * Created by chenh on 2016/5/27.
 */
public class RightOperation extends SnakeOperation {

    public RightOperation(){
        super();
    }

    public void execute(){
        ProcessingQueue.gameModelService.turnRight();
    }
}
