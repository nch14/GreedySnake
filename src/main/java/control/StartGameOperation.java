package control;

import model.GameModelService;

/**
 * Created by chenh on 2016/5/27.
 */
public class StartGameOperation extends SnakeOperation {




    public void execute() {
        ProcessingQueue.gameModelService.start();

    }
}
