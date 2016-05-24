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
    @Override
    public void run() {
        while (true){
            try {
                if (GamePanel.getInstance().doYouHaveBonus()){

                }else {
                    int  i=(int)(Math.random()*30);
                    int  j=(int)(Math.random()*50);
                    Block block =new Block(i,j);
                    System.out.println("加了一块肉");
                    GamePanel.getInstance().addBonus(block);
                    t+=1;
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
