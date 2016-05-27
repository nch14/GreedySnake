package control;

/**
 * Created by chenh on 2016/5/27.
 */
public class LeftSnakeOperation extends SnakeOperation {
    public LeftSnakeOperation(){
        super();
    }

    @Override
    public void execute() {
        ProcessingQueue.gameModelService.turnLeft();
    }
}
