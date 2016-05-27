package model.local;

import common.Block;
import common.Snake;
import control.ProcessingQueue;
import model.GameModelService;

import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/27.
 */
public class GameModelImpl implements GameModelService,Runnable{
    Snake snake;
    String snakeName;
    @Override
    public boolean nowDie() {
        return snake.state;
    }

    @Override
    public ArrayList<Snake> getSnake() {
        ArrayList<Snake> snakes=new ArrayList<>();
        snakes.add(snake);
        return snakes;
    }

    @Override
    public ArrayList<Block> getBlock() {
        ArrayList<Block> blocks=new ArrayList<>();
        blocks.add(new Block(14,19));
        return blocks;
    }

    @Override
    public void turnLeft() {
        snake.changeFunction(0);
    }

    @Override
    public void turnRight() {
        snake.changeFunction(1);
    }

    @Override
    public void turnUp() {
        snake.changeFunction(2);
    }

    @Override
    public void turnDown() {
        snake.changeFunction(3);
    }

    @Override
    public void start() {
        snake=new Snake(snakeName,this);
        Thread thread=new Thread(this);
        thread.start();
    }

    @Override
    public boolean canStartNow() {
        ProcessingQueue processingQueue=new ProcessingQueue(this);
        return true;
    }


    @Override
    public void run() {
        while (!canStartNow()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread thread=new Thread(snake);
        thread.start();
    }
}
