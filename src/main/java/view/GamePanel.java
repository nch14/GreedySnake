package view;

import common.Block;
import common.bonusCreater;
import common.Snake;
import control.DownSnakeOperation;
import control.LeftSnakeOperation;
import control.RightOperation;
import control.UpSnakeOperation;
import model.GameModelFactory;
import model.GameModelService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/24.
 */
public class GamePanel extends JPanel implements Runnable{
    ArrayList<JLabel> snakeLabel;
    JLabel bonus;
    boolean hasBonus;
    GameModelService gameModelService;
    ArrayList<Color> colors;
    Color nowRenderColor;
    private static GamePanel gamePanel;
    public static GamePanel getInstance(){
        if (gamePanel==null)
            gamePanel=new GamePanel();
        return gamePanel;
    }
    private GamePanel(){
        this.setLayout(null);
        this.setBounds(0,25,1000,600);
        this.setBackground(Color.WHITE);
        this.requestFocus();
        gameModelService= GameModelFactory.getGameModelService();
        snakeLabel=new ArrayList<>();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)
                   new LeftSnakeOperation();
                if (e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)
                    new RightOperation();
                if (e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)
                   new UpSnakeOperation();
                if (e.getKeyCode()==KeyEvent.VK_DOWN|e.getKeyCode()==KeyEvent.VK_S)
                   new DownSnakeOperation();
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        Thread thread=new Thread(this);
        thread.start();
    }


    @Override
    public void run() {

        while (gameModelService.nowDie()){

            //除去旧的蛇
            try{
                for (JLabel label:snakeLabel)
                    this.remove(label);
                snakeLabel.clear();
            }catch (Exception e){
                e.printStackTrace();
            }

            //绘制新的蛇
            ArrayList<Snake> snakes=gameModelService.getSnake();
            for (Snake snake:snakes){
                snake.askBodyData();
                ArrayList<Block> blocks=snake.getBodies();
                for (int i=0;i<blocks.size();i++){
                    Block block=blocks.get(i);
                    JLabel label=new JLabel();
                    label.setOpaque(true);
                    label.setBackground(nowRenderColor);
                    label.setBounds(block.j*20,block.i*20,20,20);
                    this.add(label);
                    snakeLabel.add(label);
                }
                snake.borrow=false;
                nextColor();
            }
            this.updateUI();
            //System.out.println("在跑");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.requestFocus();
        }
    }


    public void nextColor(){
        nowRenderColor=Color.black;
    }
}
