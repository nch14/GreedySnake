package view;

import common.FunctionPanel;
import common.MouseEventListener;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * Created by chenh on 2016/5/24.
 */
public class GameFrame extends JFrame{
    JPanel contentPanel;
    private static GameFrame gameFrame;
    public static GameFrame getInstance(){
        if (gameFrame==null)
            gameFrame=new GameFrame();
        return gameFrame;
    }
    private GameFrame(){
        this.setBounds(0,0,1000,625);
        this.setLayout(null);
        contentPanel=new ChoosePanel();

        FunctionPanel functionPanel=new FunctionPanel();
        MouseEventListener mouseListener=new MouseEventListener(this);
        functionPanel.addMouseMotionListener(mouseListener);
        functionPanel.addMouseListener(mouseListener);

        this.add(functionPanel);
        this.add(contentPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setVisible(true);

    }
    public void setPanel(JPanel jPanel){
        this.remove(contentPanel);
        contentPanel=jPanel;
        this.add(contentPanel);


    }
    public static void main(String[] args ){
        GameFrame g=GameFrame.getInstance();
    }

}
