package mygame;


import com.jme3.input.InputManager;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;

public class InputHandler {

	private ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean pressed, float tpf) {
			//System.out.println(name + " = " + pressed);
			System.out.println(name);
			if (pressed){
			switch (name){
			case("right"):{
				//rotateRightNorm();
				//rotateFrontNorm();
				System.out.println("right");
			}
			break;
			
			case("frontNorm"):{
				//rotateFrontNorm();
			}
			break;
			
			case("topNorm"):{
				//rotateTopNorm();
			}
			break;
			
			case("left"):{
			
			}
			break;
			
			case("bottom"):{
				
			}
			break;
			
			case("back"):{
				
			}
			break;
			}
			}
			/*if (pressed) {
				rotateD(tpf, allCubes);
			}*/
		}

		
	};
	
	
	InputManager inputManager;
	//ActionListener actionListener;
	public InputHandler(InputManager inputManager){
		
		this.inputManager = inputManager;
		
		addKeyListener(KeyInput.KEY_R);
		/*
		
		inputManager.addMapping("rightNorm", new KeyTrigger(KeyInput.KEY_R));
		inputManager.addListener( actionListener,"right");
		
		inputManager.addMapping("frontNorm", new KeyTrigger(KeyInput.KEY_F));
		inputManager.addListener( actionListener,"frontNorm");
		
		inputManager.addMapping("topNorm", new KeyTrigger(KeyInput.KEY_T));
		inputManager.addListener( actionListener,"topNorm");*/
	}
	
	public void addKeyListener(int character){
		inputManager.addMapping("rightNorm", new KeyTrigger(character));
		inputManager.addListener( actionListener,"right");
	}
}
