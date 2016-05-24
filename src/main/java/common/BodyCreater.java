package common;

/**
 * Created by chenh on 2016/5/24.
 */
public class BodyCreater implements Runnable {
    public static int quan=0;
    public int t=0;
    private static BodyCreater bodyCreater;
    public static BodyCreater getInstance(){
        if (bodyCreater==null)
            bodyCreater=new BodyCreater();
        return bodyCreater;
    }
    private BodyCreater(){
        quan++;
        System.out.print("第"+quan+"个创造者");
    }
    private Block creatBonus(){
        int  i=(int)(Math.random()*30);
        int  j=(int)(Math.random()*50);
        Block block =new Block(i,j);
        return block;
    }
    @Override
    public void run() {
        while (true){
            try {
                if (!GamePanel.getInstance().doYouHaveBonus()){
                    Block block=creatBonus();
                    while (GamePanel.getInstance().isSnakeBody(block)){
                        block=creatBonus();
                    }
                    GamePanel.getInstance().addBonus(block);

                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
