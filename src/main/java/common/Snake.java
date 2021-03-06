package common;

import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/23.
 */
public class Snake implements Runnable{
    ArrayList<Block> bodies;
    int guide=0;
    boolean state=true;
    boolean adding;
    public Snake(){
        bodies=new ArrayList<>();
        int i=0;
        int j=0;
/*        while (i<10){
            i=(int)Math.random()*40;
        }
        while (j<10){
            j=(int)Math.random()*20;
        }*/
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
        boolean isTrue=GamePanel.getInstance().isBonus(nextHead.i,nextHead.j);
        return isTrue;
    }
    public void extendBody(Block block){
        adding=true;
        ArrayList<Block> newBodies=new ArrayList<>();
        newBodies.add(block);
        for (int i=0;i<bodies.size();i++){
            newBodies.add(bodies.get(i));
        }
        bodies=newBodies;
        adding=false;
    }

    public void checkIfTouchMyBody(){
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
    }

    public void move(){
        /**
         * 1.检查有没有撞墙
         */

        /**
         * 2.检查有没有撞到bonus
         */
        boolean getBonus=checkIfGetBonus();
        if (getBonus){
            extendBody(getNextHead());
            return;
        }
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
        if ((this.guide==0&&guide!=1)||(this.guide==1&&guide!=0))
            this.guide=guide;
        if ((this.guide==2&&guide!=3)||(this.guide==3&&guide!=2))
            this.guide=guide;
    }

    @Override
    public void run() {
        while (state){
            //System.out.println("开始"+state);
            if (!adding)
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
