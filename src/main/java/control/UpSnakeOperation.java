package control;

/**
 * Created by chenh on 2016/5/27.
 */
public class UpSnakeOperation extends SnakeOperation {
    public UpSnakeOperation(){
        super();
    }

    @Override
    public void execute() {
        ProcessingQueue.gameModelService.turnUp();
    }


}
