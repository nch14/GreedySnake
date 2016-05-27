package model;

import common.Block;
import common.Snake;

import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/27.
 */
public interface GameModelService {

    /**
     * 是否已经gg
     * @return
     */
    public boolean nowDie();
    /**
     * 获得蛇的实例
     * @return
     */
    public ArrayList<Snake> getSnake();

    /**
     * 获得bonus的位置
     */
    public ArrayList<Block> getBlock();

    public void turnLeft();
    public void turnRight();
    public void turnUp();
    public void turnDown();
    public void start();
    public boolean canStartNow();
}
