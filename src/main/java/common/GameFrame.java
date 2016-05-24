package common;

import javax.swing.*;

/**
 * Created by chenh on 2016/5/24.
 */
public class GameFrame extends JFrame{
    public GameFrame(){
        this.setBounds(0,0,1000,600);
        this.setLayout(null);
        GamePanel gamePanel=GamePanel.getInstance();
        gamePanel.requestFocus();
        this.add(gamePanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args ){
        GameFrame g=new GameFrame();
    }

}
