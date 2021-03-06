package common;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by chenh on 2016/5/24.
 */
public class MouseEventListener implements MouseInputListener {

    Point origin;
    //鼠标拖拽想要移动的目标组件
    GameFrame frame;

    public MouseEventListener(GameFrame frame) {
        this.frame = frame;
        origin = new Point();
    }


    public void mouseClicked(MouseEvent e) {}

    /**
     * 记录鼠标按下时的点
     */
    @Override
    public void mousePressed(MouseEvent e) {
        origin.x = e.getX();
        origin.y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    /**
     * 鼠标移进标题栏时，设置鼠标图标为移动图标
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        //this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
    /**
     * 鼠标移出标题栏时，设置鼠标图标为默认指针
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // this.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    /**
     * 鼠标在标题栏拖拽时，设置窗口的坐标位置
     * 窗口新的坐标位置  = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = this.frame.getLocation();
        this.frame.setLocation(
                p.x + (e.getX() - origin.x),
                p.y + (e.getY() - origin.y));
    }
    @Override
    public void mouseMoved(MouseEvent e){

    }
}
