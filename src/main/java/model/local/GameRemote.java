package model.local;

import common.Block;
import common.Snake;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/27.
 */
public interface GameRemote extends Remote {

    /**
     * 是否已经gg
     * @return
     */
    public boolean nowDie()throws RemoteException;
    /**
     * 获得蛇的实例
     * @return
     */
    public ArrayList<Snake> getSnake()throws RemoteException;

    /**
     * 获得bonus的位置
     */
    public ArrayList<Block> getBlock()throws RemoteException;

    public void turnLeft()throws RemoteException;
    public void turnRight()throws RemoteException;
    public void turnUp()throws RemoteException;
    public void turnDown()throws RemoteException;

    /**
     * 告诉服务器自己准备好了
     */
    public void start()throws RemoteException;

    /**
     * 检查服务器有没有准备好
     * @return
     */
    public boolean canStartNow()throws RemoteException;
}
