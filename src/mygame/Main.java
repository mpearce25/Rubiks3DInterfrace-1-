package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.*;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.scene.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.lwjgl.input.Mouse;

public class Main extends SimpleApplication {
	InputHandler inputHandler;

	Rubiks cube;
	Node lightingNode = new Node();

	
	
	public static void main(String[] args) {
		Main app = new Main();
		app.start();// triggers the simpleInitApp() method
	}

	@Override
	public void simpleInitApp() {
		
		inputManager.deleteMapping(SimpleApplication.INPUT_MAPPING_MEMORY);
		viewPort.setBackgroundColor(new ColorRGBA(.7f,.7f,.7f, 0f));
		rootNode.attachChild(lightingNode);
		initLighting();
		flyCam.setMoveSpeed(15);
		initInputHandler();

		cube = new Rubiks(new Vector3f(0, 0, 0), assetManager, rootNode, "yellow", "blue", "orange");
		assignCubesToNode(cube);

		
		
		flyCam.setEnabled(true);
		inputManager.setCursorVisible(true);
		
		
		
		
		//inputManager.setCursorVisible(true);
	}

	public void assignCubesToNode(Cube cube) {

		for (ArrayList<Geometry> tempArray : cube.getAllFaces()) {
			for (Geometry tempGeo : tempArray) {
				rootNode.attachChild(tempGeo);
			}
		}
	}

	public void initInputHandler() {
		inputHandler = new InputHandler(inputManager, actionListener);
		inputHandler.addKeyListener("f", KeyInput.KEY_F);
		inputHandler.addKeyListener("right", KeyInput.KEY_R);
		inputHandler.addKeyListener("x", KeyInput.KEY_LCONTROL);
		inputHandler.addKeyListener("t", KeyInput.KEY_T);
		inputHandler.addKeyListener("r", KeyInput.KEY_R);
		inputHandler.addKeyListener("l", KeyInput.KEY_L);
		inputHandler.addKeyListener("b", KeyInput.KEY_B);
		inputHandler.addKeyListener("u", KeyInput.KEY_U);
		inputHandler.addKeyListener("v", KeyInput.KEY_V);
		inputHandler.addKeyListener("c", KeyInput.KEY_C);
		inputHandler.addKeyListener("i", KeyInput.KEY_I);
		
		inputHandler.addKeyListener("q", KeyInput.KEY_Q);
		inputHandler.addKeyListener("1", KeyInput.KEY_1);
		inputHandler.addKeyListener("2", KeyInput.KEY_2);
		inputHandler.addKeyListener("3", KeyInput.KEY_3);
		inputHandler.addMouseListener("click", MouseInput.BUTTON_LEFT);

	}

	public void initLighting() {
		addDirectionalLight(lightingNode, new Vector3f(0f, 0f, 0f));
		addDirectionalLight(lightingNode, new Vector3f(1f, 0f, 0f));
		addDirectionalLight(lightingNode, new Vector3f(1f, 1f, 0f));
		addDirectionalLight(lightingNode, new Vector3f(1f, 1f, 1f));
		addDirectionalLight(lightingNode, new Vector3f(-1f, 0f, 0f));
		addDirectionalLight(lightingNode, new Vector3f(-1f, -1f, -1f));

		rootNode.attachChild(lightingNode);
	}

	public void addDirectionalLight(Node node, Vector3f direction) {
		DirectionalLight sun = new DirectionalLight();
		sun.setDirection(direction);
		sun.setColor(ColorRGBA.White.mult(2));
		rootNode.addLight(sun);
	}

	private ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean pressed, float tpf) {

			inputHandler.inputEvent(name, pressed);
			String keysPressed = inputHandler.getKeysPressed();

			//converting to relative faces
			CollisionResults faceCollisionResults = new CollisionResults();
			Ray faceCollisionRay = new Ray();
			
			rootNode.collideWith(faceCollisionRay, faceCollisionResults);
			if(faceCollisionResults.size() > 0){
				Geometry faceCollisionGeometry = faceCollisionResults.getClosestCollision().getGeometry();
				System.out.println(faceCollisionGeometry.getName());
				System.out.println(cube.getFrontFace().get(4).getName());
				if (faceCollisionGeometry.getName().equals(cube.getFrontFace().get(4).getName())){ //Something's screwy
					System.out.println("match maybe found");
				}
				
			}
			
			////////////
			
			
			switch (keysPressed) {
			case("click"):{
				
				
				CollisionResults results  = new CollisionResults();
				Ray ray = new Ray(cam.getLocation(), cam.getDirection());
				
				rootNode.collideWith(ray, results);
				
				if (results.size() > 0){
					Geometry target = results.getClosestCollision().getGeometry();
					if (!target.getMaterial().getName().equals("black")){
						Material randomMaterial = null;
						
						do{
							randomMaterial = cube.getRandomMaterial();
						}while(randomMaterial.getName().equals("black"));
						target.setMaterial(randomMaterial);	
					}
				}
			}
			break;
			case ("t"): {
				cube.rotateTopNorm();
			}
				break;
			case ("xt"): {
				cube.rotateTopInverse();
			}
				break;

			case ("f"): {
				cube.rotateFrontNorm();
			}
				break;

			case ("xf"): {
				cube.rotateFrontInverse();
			}
				break;

			case ("r"): {
				cube.rotateRightNorm();
			}
				break;

			case ("xr"): {
				cube.rotateRightInverse();
			}
				break;
			case ("l"): {
				cube.rotateLeftNorm();
			}
				break;
			case ("b"): {
				cube.rotateBackNorm();
			}
				break;
			case ("xb"): {
				cube.rotateBackNorm();
			}
				break;
			case ("u"): {
				cube.rotateBottomNorm();
			}
				break;
			case ("xu"): {
				cube.rotateBottomInverse();
			}
				break;
			case ("v"): {
				cube.rotateMiddleVerticalNorm();
			}
				break;
			case ("xv"): {
				cube.rotateMiddleVerticalInverse();
			}
				break;

			case ("c"): {
				cube.rotateMiddleHorizontalNorm();
			}
				break;
			case ("xc"): {
				cube.rotateMiddleHorizontalInverse();
			}
				break;
				
			case("i"):{
				cube.rotateCenterSliceNorm();
			}
			break;
			case("xi"):{
				cube.rotateCenterSliceInverse();
			}
			case ("q"): {
				cube.scramble(1000);
				
			}
				break;
			case("1"):{
				for(int i = 0; i < 1; i ++){
					cube.rotateMiddleHorizontalNorm();
					cube.rotateMiddleVerticalNorm();
					cube.rotateMiddleHorizontalInverse();
					cube.rotateMiddleVerticalInverse();
				}
			}
			break;
			case("2"):{
				cube.rotateCenterSliceNorm();
				cube.rotateCenterSliceNorm();
				cube.rotateMiddleHorizontalNorm();
				cube.rotateMiddleHorizontalNorm();
				cube.rotateMiddleVerticalNorm();
				cube.rotateMiddleVerticalNorm();
			}
			break;
			
			case("3"):{
				cube.rotateMiddleVerticalNorm();
				cube.rotateMiddleHorizontalNorm();
				cube.rotateMiddleHorizontalNorm();
				cube.rotateMiddleVerticalInverse();
				cube.rotateMiddleHorizontalInverse();
				cube.rotateMiddleHorizontalInverse();
			}
			break;}
			
			assignCubesToNode(cube);
		}
	};
}