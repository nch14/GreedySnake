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
    JLabel title;
    public GamePanel(){
        this.setLayout(null);
        this.setBounds(0,0,1000,600);
        this.setBackground(Color.WHITE);

        snakeLabel=new ArrayList<>();
        snake=new Snake();
        this.requestFocus();
        title=new JLabel("HHH");
        title.setOpaque(false);
        title.setBackground(Color.black);
        title.setBounds(0,400,400,30);
        this.add(title);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)
                    snake.swift(0);
                if (e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)
                    snake.swift(1);
                if (e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)
                    snake.swift(2);
                if (e.getKeyCode()==KeyEvent.VK_DOWN|e.getKeyCode()==KeyEvent.VK_S)
                     snake.swift(3);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        Thread t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (snake.state) {
            while (snakeLabel.size()<snake.bodies.size()){
                snakeLabel.add(new JLabel("l"));
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
