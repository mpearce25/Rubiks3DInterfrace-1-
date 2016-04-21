package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.light.*;
import com.jme3.math.*;
import com.jme3.scene.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends SimpleApplication {
	InputHandler inputHandler;
	int rotationsFromBaseFront = 0;
	
	private  ActionListener actionListener = new ActionListener() {
	public void onAction(String name, boolean pressed, float tpf) {

	inputHandler.inputEvent(name, pressed);	
	String keysPressed = inputHandler.getKeysPressed();
	
		//if (pressed){
			System.out.println(keysPressed);
			switch (keysPressed){
		case("right"):{
			
		}
		break;
		
		case("f"):{
			
			//System.out.println(rotateFrontNormDegrees);
			rotateFrontNorm();
			
			/*rotationsFromBaseFront += 1;
			if (rotationsFromBaseFront > 3){
				rotationsFromBaseFront = 0;
			}*/
			//System.out.println(rotationsFromBaseFront);
		}
		break;
		
		case("xf"):{
			rotateFrontInverse();
			
		}
		break;
		
		case("i"):{
			System.out.println(rotateFrontInverseDegrees);
			rotateFrontInverse();
			/*rotationsFromBaseFront -= 1;
			if (rotationsFromBaseFront < 0){
				rotationsFromBaseFront = 3;
			}*/
			
			//rotateFrontNormDegrees += 90;
			/*if (rotateFrontNormDegrees >= 0){
				rotateFrontNormDegrees = -270;
			}*/
			
		}
		break;
		
		case("bottom"):{
			
		}
		break;
		
		case("back"):{
			
		}
		break;
		}
		
		//}
		
	}
	
};
	
	Cube cube;
	Node lightingNode = new Node();
	

	public static void main(String[] args) {
		Main app = new Main();
		app.start();
		//triggers the simpleInitApp() method
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
	
	
	public void assignCubesToNode2(ArrayList<CustomIndividualCube> cubes){
		for(int i = 0; i < 27; i++){
			switch (i){
			case(0):{
				float ogRotX = cubes.get(i).getRotX() * FastMath.DEG_TO_RAD;
				float ogRotY = cubes.get(i).getRotY()* FastMath.DEG_TO_RAD;
				float ogRotZ = cubes.get(i).getRotZ()* FastMath.DEG_TO_RAD;
				
				cubes.get(i).getSpatialObject().setLocalTranslation(new Vector3f(2,2,2));
				cubes.get(i).getSpatialObject().rotate(ogRotX, ogRotY + (FastMath.DEG_TO_RAD * 180) , ogRotZ);
				cubes.get(i).setRotX(ogRotX);
				cubes.get(i).setRotY(ogRotY + 180);
				cubes.get(i).setRotZ(ogRotZ);
				
				//System.out.println(cubes.get(i).getSpatialObject().getLocalRotation().getX());
				rootNode.attachChild(cubes.get(i).getSpatialObject());
				System.out.println("hi");
			}
			break;
			
			}
		}
	}
	public void assignCubesToNode(ArrayList<CustomIndividualCube> cubes) {
		
		rootNode.attachChild(cubes.get(0).getSpatialObject());
		
		//for (Spatial cube : cubes) {
			//rootNode.attachChild(cube);
		//}
	}

	public void initInputHandler(){
		inputHandler = new InputHandler(inputManager, actionListener);
		inputHandler.addKeyListener("f",KeyInput.KEY_F);
		inputHandler.addKeyListener("right",KeyInput.KEY_R);
		inputHandler.addKeyListener("x",KeyInput.KEY_LCONTROL);
		inputHandler.addKeyListener("i", KeyInput.KEY_I);
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
	
	
	
	int rotateFrontNormDegrees = -90;
	public void rotateFrontNorm(){
		
		
		
		Node frontRotateNormNode = new Node();
		
		for (int i = 0; i < 9; i++){
			frontRotateNormNode.attachChild( cube.getCubesArray().get(i).getSpatialObject());
		}
		
		rootNode.attachChild(frontRotateNormNode);
		frontRotateNormNode.rotate(  0f,  0f, rotateFrontNormDegrees*FastMath.DEG_TO_RAD);
		
		rotateFrontNormDegrees -= 90;
		if (rotateFrontNormDegrees <= -360) {
			rotateFrontNormDegrees = 0;
		}
		
		/*for (int i = 0; i < 9; i++){
			rootNode.detachChildAt(i);
		}*/
		frontRotateNormNode.detachAllChildren();
		//System.out.println(frontRotateNormNode.getLocalRotation());
		
		//array restructuring
		//corners
		Collections.swap(cube.getCubesArray(), 0, 6);
		Collections.swap(cube.getCubesArray(), 0, 8);
		Collections.swap(cube.getCubesArray(), 0, 2);
		
		//edges
		Collections.swap(cube.getCubesArray(), 1, 3);
		Collections.swap(cube.getCubesArray(), 1, 7);
		Collections.swap(cube.getCubesArray(), 1, 5);
		
		
		delay(500);
		
		assignCubesToNode2(cube.getCubesArray());
	}
	
	int rotateFrontInverseDegrees = 90;
	public void rotateFrontInverse(){
		
		
		
		Node frontRotateInverseNode = new Node();
		
		for (int i = 0; i < 9; i++){
			frontRotateInverseNode.attachChild(cube.getCubesArray().get(i).getSpatialObject());
		}
		
		rootNode.attachChild(frontRotateInverseNode);
		frontRotateInverseNode.rotate(  0f,  0f, rotateFrontInverseDegrees*FastMath.DEG_TO_RAD);
		
		rotateFrontInverseDegrees += 90;
		if (rotateFrontInverseDegrees >= 360) {
			rotateFrontInverseDegrees = 0;
		}
		
		//array restructuring
		//corners
		/*Collections.swap(cube.getCubesArray(), 0, 6);
		Collections.swap(cube.getCubesArray(), 0, 8);
		Collections.swap(cube.getCubesArray(), 0, 2);
		
		//edges
		Collections.swap(cube.getCubesArray(), 1, 3);
		Collections.swap(cube.getCubesArray(), 1, 7);
		Collections.swap(cube.getCubesArray(), 1, 5);	*/
	}
	
	public static void delay(int time) {
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < time)
			endDelay = System.currentTimeMillis();
	}
	
	
	/*int rotateFrontTopDegrees = -90;
	public void rotateTopNorm(){
		//Node rightRotateNormNode = new Node();
		
		Node topRotateNormNode = new Node();
		
		topRotateNormNode.attachChild(cube.getCubesArray().get(0));
		topRotateNormNode.attachChild(cube.getCubesArray().get(1));
		topRotateNormNode.attachChild(cube.getCubesArray().get(2));
		
		topRotateNormNode.attachChild(cube.getCubesArray().get(9));
		topRotateNormNode.attachChild(cube.getCubesArray().get(10));
		topRotateNormNode.attachChild(cube.getCubesArray().get(11));
		
		topRotateNormNode.attachChild(cube.getCubesArray().get(18));
		topRotateNormNode.attachChild(cube.getCubesArray().get(19));
		topRotateNormNode.attachChild(cube.getCubesArray().get(20));
		
		rootNode.attachChild(topRotateNormNode);
		topRotateNormNode.rotate(  0f,rotateFrontNormDegrees*FastMath.DEG_TO_RAD,  0f );
		
		rotateFrontNormDegrees -= 90;
		if (rotateFrontNormDegrees <= -360) {
			rotateFrontNormDegrees = 0;
		}
		
		//array restructuring
		//corners
		Collections.swap(cube.getCubesArray(), 0, 2);
		Collections.swap(cube.getCubesArray(), 0, 20);
		Collections.swap(cube.getCubesArray(), 0, 18);
		
		//edges
		Collections.swap(cube.getCubesArray(), 1, 11);
		Collections.swap(cube.getCubesArray(), 1, 19);
		Collections.swap(cube.getCubesArray(), 1, 9);
	}*/
}