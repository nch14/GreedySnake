package common;

import java.util.ArrayList;

/**
 * Created by chenh on 2016/5/23.
 */
public class Snake implements Runnable{
    ArrayList<Body> bodies;
    int guide=0;
    boolean state=true;
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
        this.bodies.add(new Body(i,j));
        this.bodies.add(new Body(i,j+1));
        this.bodies.add(new Body(i,j+2));

        Thread t=new Thread(this);
        t.start();
    }

    public void addBody(){
        Body body1=bodies.get(bodies.size()-2);
        Body body2=bodies.get(bodies.size()-1);
        if (body1.i==body2.i){
            if(body1.j>body2.j)
                bodies.add(new Body(body1.i,body2.j-1));
            else
                bodies.add(new Body(body1.i,body2.j+1));
        }else{
            if(body1.i>body2.i)
                bodies.add(new Body(body2.i-1,body2.j));
            else
                bodies.add(new Body(body2.i+1,body2.j));
        }
    }

    public void check(){
        for(int i=0;i<bodies.size()-1;i++){
            Body body=bodies.get(i);
            for(int j=i+1;j<bodies.size();j++){
                Body bodyTemp=bodies.get(j);
                if(body.i==bodyTemp.i&&body.j==bodyTemp.j) {
                    state = false;
                    return;
                }
            }
        }
    }
    public void move(){
        int i=bodies.get(0).i;
        int j=bodies.get(0).j;
        for (int i1=bodies.size()-1;i1>0;i1--){
            System.out.println("第"+(i1+1)+"格的原位置为"+bodies.get(i1).i+" "+bodies.get(i1).j);
            bodies.get(i1).i=bodies.get(i1-1).i;
            bodies.get(i1).j=bodies.get(i1-1).j;
            System.out.println("第"+(i1+1)+"格的现在位置为"+bodies.get(i1).i+" "+bodies.get(i1).j);
        }
        System.out.println(bodies.size());
        switch (guide){
            case 0:j--;
                if (bodies.get(0).j<0)
                    j=49;
                bodies.get(0).j=j;
                break;
            case 1:j++;
                if (bodies.get(0).j>49)
                    j=0;
                bodies.get(0).j=j;
                break;
            case 2:i--;
                if (bodies.get(0).i<0)
                    i=29;
                bodies.get(0).i=i;
                break;
            case 3: i++;
                if (bodies.get(0).i>29)
                    i=0;
                bodies.get(0).i=i;
                break;
        }
        check();
    }
    public void swift(int guide){
        this.guide=guide;
    }

    @Override
    public void run() {
        while (state){
            move();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
