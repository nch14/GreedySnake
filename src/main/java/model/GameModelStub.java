package model;

import common.Block;
import common.Snake;

import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/27.
 */
public class GameModelStub implements GameModelService {
    @Override
    public boolean nowDie() {
        return false;
    }

    @Override
    public ArrayList<Snake> getSnake() {
        return null;
    }

    @Override
    public ArrayList<Block> getBlock() {
        return null;
    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnUp() {

    }

    @Override
    public void turnDown() {

    }

    @Override
    public void start() {

    }

    @Override
    public boolean canStartNow() {
        return false;
    }
}
