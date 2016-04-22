package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.light.*;
import com.jme3.math.*;
import com.jme3.scene.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends SimpleApplication {
	InputHandler inputHandler;
	
	private  ActionListener actionListener = new ActionListener() {
	public void onAction(String name, boolean pressed, float tpf) {

	inputHandler.inputEvent(name, pressed);	
	String keysPressed = inputHandler.getKeysPressed();
	
			switch (keysPressed){
		case("t"):{
		rotateTopNorm();	
		}
		break;
		case("xt"):{
			rotateTopInverse();	
			}
			break;
		
		case("f"):{
			rotateFrontNorm();
		}
		break;
		
		case("xf"):{
			rotateFrontInverse();	
		}
		break;
		}
	}
};
	
	Cube cube;
	Node lightingNode = new Node();
	
	public static void main(String[] args) {
		Main app = new Main();
		app.start();//triggers the simpleInitApp() method
	}

	@Override
	public void simpleInitApp() {
		rootNode.attachChild(lightingNode);
		initLighting();
		flyCam.setMoveSpeed(10);
		initInputHandler();
		
		cube = new Cube(new Vector3f(0,0,0), assetManager);
		assignCubesToNode(cube.getCubesArray());	
	}
	
	public void assignCubesToNode(ArrayList<CustomIndividualCube> cubes) {
		for (CustomIndividualCube cube : cubes) {
			rootNode.attachChild(cube.getSpatialObject());
		}
	}
	
	
	public void rotateCubes( float rotX, float rotY, float rotZ){
		//rootNode.detachAllChildren();
		
		for(int i = 0; i < cube.getCubesArray().size(); i++){
			//System.out.println(cube.getCubesArray().get(i).getRotate());
			//System.out.println("\n\n" + cube.getCubesArray().get(10).getRotate());
			//System.out.println(cube.getCubesArray().get(10).getRotX());
			if (cube.getCubesArray().get(i).getRotate()){
				//System.out.println("hel");
				System.out.println(cube.getCubesArray().get(10).getRotX());
				float initialRotationX = cube.getCubesArray().get(i).getRotX();
				float initialRotationY = cube.getCubesArray().get(i).getRotY();
				float initialRotationZ = cube.getCubesArray().get(i).getRotZ();
				//System.out.println(initialRotationX + ", " + initialRotationY + ", " + initialRotationZ + "\n");
				
				
				cube.getCubesArray().get(i).getSpatialObject().setLocalTranslation(cube.getIndividualCubeOffsets().get(i));
				
				cube.getCubesArray().get(i).getSpatialObject().rotate((FastMath.DEG_TO_RAD * rotX) + (FastMath.DEG_TO_RAD * initialRotationX), FastMath.DEG_TO_RAD * rotY + (FastMath.DEG_TO_RAD * initialRotationY) , FastMath.DEG_TO_RAD * rotZ + (FastMath.DEG_TO_RAD * initialRotationZ));
				cube.getCubesArray().get(i).setRotate(false);
				System.out.println(cube.getCubesArray().get(10).getRotX());
				cube.getCubesArray().get(i).getSpatialObject().updateGeometricState();
				cube.getCubesArray().get(i).setRotX(20f);
				cube.getCubesArray().get(i).setRotX(initialRotationY + rotY);
				cube.getCubesArray().get(i).setRotX(initialRotationZ + rotZ);
				
				//cube.getCubesArray().get(i).getSpatialObject().updateGeometricState();
				//System.out.println(initialRotationX + ", " + initialRotationY + ", " + initialRotationZ);
				//System.out.println(cubes.get(i).getSpatialObject().getWorldRotation());
				
				//rootNode.attachChild(cubes.get(i).getSpatialObject());
			}
		}
	}

	public void initInputHandler(){
		inputHandler = new InputHandler(inputManager, actionListener);
		inputHandler.addKeyListener("f",KeyInput.KEY_F);
		inputHandler.addKeyListener("right",KeyInput.KEY_R);
		inputHandler.addKeyListener("x",KeyInput.KEY_LCONTROL);
		inputHandler.addKeyListener("t", KeyInput.KEY_T);
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
	
	
	public void rotateFrontNorm(){
		for (int i = 0; i < 9; i++){
			cube.getCubesArray().get(i).setRotate(true);	
		}
		//array restructuring
		//corners
		Collections.swap(cube.getCubesArray(), 0, 6);
		Collections.swap(cube.getCubesArray(), 0, 8);
		Collections.swap(cube.getCubesArray(), 0, 2);
		
		//edges
		Collections.swap(cube.getCubesArray(), 1, 3);
		Collections.swap(cube.getCubesArray(), 1, 7);
		Collections.swap(cube.getCubesArray(), 1, 5);
		
		rotateCubes(cube.getCubesArray(), 90,0,0);
	}
	
	public void rotateFrontInverse(){
		for (int i = 0; i < 9; i++){
			cube.getCubesArray().get(i).setRotate(true);	
		}
		//array restructuring
		//corners
		Collections.swap(cube.getCubesArray(), 0, 2);
		Collections.swap(cube.getCubesArray(), 0, 8);
		Collections.swap(cube.getCubesArray(), 0, 6);
		
		//edges
		Collections.swap(cube.getCubesArray(), 1, 5);
		Collections.swap(cube.getCubesArray(), 1, 7);
		Collections.swap(cube.getCubesArray(), 1, 3);	
		rotateCubes(cube.getCubesArray(), -90,0,0);
	}
	
	public static void delay(int time) {
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < time)
			endDelay = System.currentTimeMillis();
	}
	
	
	public void rotateTopNorm(){
		List<Integer> cubesAffected = Arrays.asList(0,1,2,9,10,11,18,19,20);
		for(int i = 0; i < cube.getCubesArray().size(); i ++){
			if (cubesAffected.contains(i)){
				cube.getCubesArray().get(i).setRotate(true);
				//.getCubesArray().get(i).setRotX(00);
				
			}
		}
		cube.getCubesArray().get(10).setRotX(cube.getCubesArray().get(10).getRotX() + 10);
		//System.out.println(cube.getCubesArray().get(10).getRotX());
		//System.out.println(cube.getCubesArray().get(10).getRotate());
		//array restructuring
		//corners
		Collections.swap(cube.getCubesArray(), 0, 2);
		Collections.swap(cube.getCubesArray(), 0, 20);
		Collections.swap(cube.getCubesArray(), 0, 18);
		
		//edges
		Collections.swap(cube.getCubesArray(), 1, 11);
		Collections.swap(cube.getCubesArray(), 1, 19);
		Collections.swap(cube.getCubesArray(), 1, 9);
		
		
		//System.out.println("\n\n" + cube.getCubesArray().get(10).getRotate());
		//System.out.println(cube.getCubesArray().get(10).getRotX());
		rotateCubes(0,90,0);
		
	}
	
	public void rotateTopInverse(){
		List<Integer> cubesAffected = Arrays.asList(0,1,2,9,10,11,18,19,20);
		for(int i = 0; i < cube.getCubesArray().size(); i ++){
			if (cubesAffected.contains(i)){
				cube.getCubesArray().get(i).setRotate(true);
			}
		}
		
		//array restructuring
		//corners
		Collections.swap(cube.getCubesArray(), 0, 18);
		Collections.swap(cube.getCubesArray(), 0, 20);
		Collections.swap(cube.getCubesArray(), 0, 2);
		
		//edges
		Collections.swap(cube.getCubesArray(), 1, 9);
		Collections.swap(cube.getCubesArray(), 1, 19);
		Collections.swap(cube.getCubesArray(), 1, 11);
		
		rotateCubes(cube.getCubesArray(), 0,-90,0);
	}
}