package model.net;

import common.Block;
import common.Snake;
import model.GameModelService;
import model.local.GameRemote;

import java.rmi.Naming;
import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/27.
 */
public class GameModelNetImpl implements GameModelService {

    @Override
    public boolean nowDie() {
        /*try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            System.out.println(hello.nowDie());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return true;
    }

    @Override
    public ArrayList<Snake> getSnake() {
        try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            return hello.getSnake();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Block> getBlock() {
        try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            return hello.getBlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void turnLeft() {
        try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            hello.turnLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void turnRight() {
        try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            hello.turnRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void turnUp() {
        try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            hello.turnUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void turnDown() {
        try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            hello.turnDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            GameRemote hello = (GameRemote) Naming.lookup("rmi://127.0.0.1:32000/hello");
            hello.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean canStartNow() {
        return true;
    }
}
