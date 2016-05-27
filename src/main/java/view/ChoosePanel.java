package view;

import model.GameModelFactory;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by chenh on 2016/5/27.
 */
public class ChoosePanel extends JPanel{
    NButton nButton1;
    NButton nButton2;
    public ChoosePanel(){
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0,25,1000,600);

        nButton1=new NButton("本地模式");
        nButton2=new NButton("网络模式");
        nButton1.setBounds(60,200,100,100);
        nButton2.setBounds(460,200,100,100);
        nButton1.addMouseListener(new ModelChoose(0));
        nButton2.addMouseListener(new ModelChoose(1));
        this.add(nButton1);
        this.add(nButton2);
    }

    class ModelChoose implements MouseListener{
        int id;
        public ModelChoose(int i){
            id=i;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if (id == 0) {
                GameModelFactory.localModel();
            }
            if (id == 1){
                GameModelFactory.netModel();
            }
            GameFrame.getInstance().setPanel(GamePanel.getInstance());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
