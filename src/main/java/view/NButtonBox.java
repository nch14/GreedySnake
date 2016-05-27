package view;

import java.util.ArrayList;

public class NButtonBox {
	ArrayList<NButton> buttons=new ArrayList<NButton>();
	NButton currentSelectButton;
	
	
	
	public void addButton(NButton b){
		if(!buttons.contains(b)){
			buttons.add(b);
			b.addButtonBox(this);
		}
	}
	public void removeButton(NButton b){
		if(buttons.contains(b)){
			buttons.remove(b);
		}
	}
	public void switchState(NButton b){
		currentSelectButton=b;
		for(int i=0;i<buttons.size();i++){
			buttons.get(i).switchViewHelp(3);
		}
	}
	
	
}
