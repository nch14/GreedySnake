package common;

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
    Snake snake;

    JLabel addABody;
    Block bonus;
    boolean hasBonus;


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

        snakeLabel=new ArrayList<>();
        snake=new Snake();
        this.requestFocus();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("把蛇hhh");
                if (e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)
                    snake.changeFunction(0);
                if (e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)
                    snake.changeFunction(1);
                if (e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)
                    snake.changeFunction(2);
                if (e.getKeyCode()==KeyEvent.VK_DOWN|e.getKeyCode()==KeyEvent.VK_S)
                     snake.changeFunction(3);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        addABody=new JLabel();
        addABody.setOpaque(true);
        addABody.setBackground(Color.black);

        BodyCreater bodyCreater=BodyCreater.getInstance();

        Thread tCreater=new Thread(bodyCreater);
        tCreater.start();

        Thread tDraw=new Thread(this);
        tDraw.start();

        Thread tSnake=new Thread(snake);
        tSnake.start();
    }
    public void addBonus(Block block){
        bonus= block;
        int x= block.i*20;
        int y= block.j*20;
        addABody.setBounds(y,x,20,20);
        this.add(addABody);
        hasBonus=true;
        updateUI();
    }
    public boolean doYouHaveBonus(){
        return hasBonus;
    }

    public boolean isBonus(int i,int j){
        if (bonus==null)
            return false;
        if(bonus.i==i&&bonus.j==j){
            this.remove(addABody);
            hasBonus=false;
            return true;
        }
        return false;
    }
    public boolean isSnakeBody(Block block){
        for (int i=0;i<snake.bodies.size();i++){
            if(block.i==snake.bodies.get(i).i&&block.j==snake.bodies.get(i).j)
                return true;
        }
        return false;
    }
    @Override
    public void run() {
        while (snake.state) {
            while (snakeLabel.size()<snake.bodies.size()){
                snakeLabel.add(new JLabel());
            }
            for (int i = 0; i < snakeLabel.size(); i++) {
                try {
                    this.remove(snakeLabel.get(i));
                }catch (Exception e){

                }
            }
            for (int i = 0; i < snakeLabel.size(); i++) {
                JLabel label=snakeLabel.get(i);
                label.setOpaque(true);
                label.setBackground(Color.black);
                int x=snake.bodies.get(i).i*20;
                int y=snake.bodies.get(i).j*20;
                label.setBounds(y,x,20,20);
                this.add(label);
            }
            this.updateUI();
            this.requestFocus();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
