package common;

import model.GameModelService;
import view.GamePanel;

import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/23.
 */
public class Snake implements Runnable{
    public String snakeName;
    public ArrayList<Block> bodies;
    public boolean borrow=false;
    public int guide=0;
    public boolean state=true;
    private GameModelService service;
    public Snake(String snakeName, GameModelService service){
        bodies=new ArrayList<>();
        this.snakeName=snakeName;
        this.service=service;
        int i=0;
        int j=0;
        i=15;
        j=8;
        this.bodies.add(new Block(i,j));
        this.bodies.add(new Block(i,j+1));
        this.bodies.add(new Block(i,j+2));
    }
    private Block getNextHead(){
        int i=bodies.get(0).i;
        int j=bodies.get(0).j;
        switch (guide) {
            case 0:
                j--;
                if (bodies.get(0).j < 0)
                    j = 49;
                break;
            case 1:
                j++;
                if (bodies.get(0).j > 49)
                    j = 0;
                break;
            case 2:
                i--;
                if (bodies.get(0).i < 0)
                    i = 29;
                break;
            case 3:
                i++;
                if (bodies.get(0).i > 29)
                    i = 0;
                break;
        }
        return new Block(i,j);
    }
    private boolean checkIfGetBonus(){
        Block nextHead=getNextHead();

        boolean isTrue=false;
        ArrayList<Block> bonus=service.getBlock();
        for (int i=0;i<bonus.size();i++){
            Block block=bonus.get(i);
            if (block.i==nextHead.i&&block.j==nextHead.j) {
                isTrue = true;
                break;
            }
        }
        return isTrue;
    }
    public void extendBody(Block block){
        askBodyData();
        ArrayList<Block> newBodies=new ArrayList<>();
        newBodies.add(block);
        for (int i=0;i<bodies.size();i++){
            newBodies.add(bodies.get(i));
        }
        bodies=newBodies;
        borrow=true;
    }
    public synchronized void askBodyData(){
        while (borrow){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        borrow=true;
    }
    public void checkIfTouchMyBody(){
        askBodyData();
        for(int i=0;i<bodies.size()-1;i++){
            Block block =bodies.get(i);
            for(int j=i+1;j<bodies.size();j++){
                Block blockTemp =bodies.get(j);
                if(block.i== blockTemp.i&& block.j== blockTemp.j) {
                    state = false;
                    return;
                }
            }
        }
        borrow=false;
    }

    public void move(){
        /**
         * 1.检查有没有撞墙
         */

        /**
         * 2.检查有没有撞到bonus
         */
       /* boolean getBonus=checkIfGetBonus();
        if (getBonus){
            extendBody(getNextHead());
            return;
        }*/
        /**
         * 3.移动
         */
        for (int i1=bodies.size()-1;i1>0;i1--){
            bodies.get(i1).i=bodies.get(i1-1).i;
            bodies.get(i1).j=bodies.get(i1-1).j;
        }
        Block head=getNextHead();
        bodies.remove(0);
        bodies.add(0,head);

        /**
         * 4.检查有没有撞到自己的身体
         */
        checkIfTouchMyBody();
    }
    public void changeFunction(int guide){
        System.out.println("方向功能被调用");
        if ((this.guide==0&&guide!=1)||(this.guide==1&&guide!=0))
            this.guide=guide;
        if ((this.guide==2&&guide!=3)||(this.guide==3&&guide!=2))
            this.guide=guide;
    }
    public ArrayList<Block> getBodies(){
        return bodies;
    }
    @Override
    public void run() {
        while (state){
            //System.out.println("开始"+state);
                move();
            //System.out.println("移动控制系统良好");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("结束"+state);
        }
    }
}
