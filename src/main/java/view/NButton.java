package view;

import javax.swing.*;

public class NButton extends JLabel{
	
	private boolean hasIcon;
	private int currentState;
	/**
	 * 3位，依次保存：普通状态，鼠标移入，被点击状态
	 */
	private String[] iconSrc;
	/**
	 * 是否可以通过再次单击撤销选中状态
	 */
	private boolean canCancel;
	/**
	 * 是否隶属于某一个单选Button组
	 */
	private boolean buttonBoxFlag;
	/**
	 * 所隶属的buttonBoxFlag组
	 */
	private NButtonBox buttonBox;
    public NButton(Icon image, int horizontalAlignment) {
        super(null, image, horizontalAlignment);
    }
    public NButton(Icon image) {
        super(image);
    }
    public NButton(String src) {
        super(src);
    }
    public NButton() {
        super();
    }
	public void initView(String[] iconSrc){
		this.iconSrc=iconSrc;
		hasIcon=true;
		this.setIcon(new ImageSetter(iconSrc[0],this.getWidth(),this.getHeight()).getNewIcon());
	}
	
	/**
	 * 更改button的外观、用于加强交互
	 * @param type 下一个状态（0:off,1:in,2:click,3:loseClick）
	 */
	public void swichView(int type){
		if(!hasIcon)
			return;
		if(buttonBoxFlag){
			if(currentState!=2&&type==2){
				buttonBox.switchState(this);
			}	
		}
		switchViewHelp(type);
	}
	public void switchViewHelp(int type){
		int end=0;	
		if(type==3){
			end=0;
		}
		//如果当前状态为clicked，只有unclicked会引起改变
		else if(currentState==2){
			if(type==2&&canCancel){
				end=0;	
			}else{
				return;
			}
		}
		//如果当前状态为off，只有in和click会引起改变
		else if(currentState==0){
			if(type==1||type==2){
				end=type;
			}
		}
		//如果当前状态为in，只有off和click会引起改变
		else if(currentState==1){
			if(type==0||type==2){
				end=type;
			}
		}
		currentState=end;
		//System.out.println(iconSrc[end]+" "+this.getWidth()+" "+this.getHeight());
		this.setIcon(new ImageSetter(iconSrc[end],this.getWidth(),this.getHeight()).getNewIcon());				
	}
	
	public void setCanCancel(){
		this.canCancel=true;
	}
	
	public void addButtonBox(NButtonBox box){
		this.buttonBoxFlag=true;
		this.buttonBox=box;
	}
}