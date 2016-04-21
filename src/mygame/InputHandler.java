package mygame;

import java.util.ArrayList;

import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;

public class InputHandler {

	InputManager inputManager;
	ActionListener actionListener;
	ArrayList<String> keysPressed = new ArrayList<String>();

	public InputHandler(InputManager inputManager, ActionListener actionListener) {
		this.inputManager = inputManager;
		this.actionListener = actionListener;
	}

	public void addKeyListener(String actionPhrase, int character) {
		inputManager.addMapping(actionPhrase, new KeyTrigger(character));
		inputManager.addListener(actionListener, actionPhrase);
	}
	
	public void inputEvent(String keyName, boolean pressed){
		if (pressed){
			keysPressed.add(keyName);
		}
		else{
			int indexLocation = findKeyLocation(keyName);
			if (indexLocation == -1){
				System.out.println("The key was not found in the array");
			}
			else{
				keysPressed.remove(indexLocation);
			}	
		}
	}
	
	private int findKeyLocation(String keyName){
		int indexLocation = -1;
		for (int i = 0; i < keysPressed.size(); i++){
			if (keysPressed.get(i).equalsIgnoreCase(keyName)){
				indexLocation = i;
			}
		}
		
		return indexLocation;
	}
	
	public String getKeysPressed(){
		String keys = "";
		for (String keyString: keysPressed){
			keys += keyString;
		}
		if (keys.contains("x") && keys.indexOf("x") != 0){
			String tempKeys = keys;
			keys = "x" + tempKeys.charAt(0);
		}
		System.out.println(keysPressed);
		return keys;
	}
}
