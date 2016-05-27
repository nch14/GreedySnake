package model;

import model.local.GameModelImpl;
import model.net.GameModelNetImpl;

/**
 * Created by chenh on 2016/5/27.
 */
public class GameModelFactory {

    private static GameModelService gameModelService;


    public static GameModelService getGameModelService(){
        return gameModelService;
    }

    public static void localModel(){
        gameModelService=new GameModelImpl();
        gameModelService.start();
    }

    public static void netModel(){
        gameModelService=new GameModelNetImpl();
    }
}
