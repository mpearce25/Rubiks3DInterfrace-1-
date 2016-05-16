package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
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

	
	private ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean pressed, float tpf) {

			inputHandler.inputEvent(name, pressed);
			String keysPressed = inputHandler.getKeysPressed();

			switch (keysPressed) {
			case ("t"): {
				rotateTopNorm();
			}
				break;
			case ("xt"): {
				rotateTopInverse();
			}
				break;

			case ("f"): {
				rotateFrontNorm();
			}
				break;

			case ("xf"): {
				rotateFrontInverse();
			}
				break;
				
			case ("r"): {
				rotateRightNorm();
			}
				break;
				
			case ("xr"): {
				rotateRightInverse();
			}
				break;
			case ("p"): {
				matchCubes();
			}
				break;
			}
		}
	};

	Cube cube;
	Node lightingNode = new Node();

	public static void main(String[] args) {
		Main app = new Main();
		app.start();// triggers the simpleInitApp() method
	}

	@Override
	public void simpleInitApp() {
		rootNode.attachChild(lightingNode);
		initLighting();
		flyCam.setMoveSpeed(10);
		initInputHandler();

		cube = new Cube(assetManager);
		assignCubesToNode(cube.getCubes());
		
		String test1 = "test1";
		String test2 = "test1";
				//System.out.println("Strings equal? " + test1.equals(test2));
	}

	public void assignCubesToNode(ArrayList<CustomIndividualCube> cubes) {
		for (CustomIndividualCube cube : cubes) {
			rootNode.attachChild(cube.getSpatialObject());
		}
		
		/*System.out.println("\n\n" +cube.getCubes().get(0).getRotX() + ", " + cube.getCubes().get(0).getRotY() + ", " + cube.getCubes().get(0).getRotZ());
		cube.getCubes().get(0).setRotX(155);
		cube.getCubes().get(0).setRotY(155);
		cube.getCubes().get(0).setRotZ(155);
		System.out.println("\n\n" +cube.getCubes().get(0).getRotX() + ", " + cube.getCubes().get(0).getRotY() + ", " + cube.getCubes().get(0).getRotZ());
		*/
		//System.out.println(cube.getCubes().get(0).fullCubeMatch(cube.getCubes().get(1).getColorOrientation()));
		//System.out.println("\n\n" + cube.getCubes().get(0).getColorOrientation() + "\n" + cube.getCubes().get(2).getColorOrientation());
	}

	Boolean secondTurn = false;
	public void rotateCubes(int rotX, int rotY, int rotZ) {
		for (int i = 0; i < cube.getCubes().size(); i++) {
			if (cube.getCubes().get(i).getRotate()) {
			
				
				
				Quaternion q = new Quaternion();/*
				if(rotX != 0){
					q.fromAngleAxis(rotX, Vector3f.UNIT_X);
				}
				else if(rotY != 0){
					q.fromAngleAxis(rotY * FastMath.DEG_TO_RAD, new Vector3f(0,1,0));
				}
				else if(rotZ != 0){
					q.fromAngleAxis(rotZ * FastMath.DEG_TO_RAD, new Vector3f(0,0,1));
				}*/
				System.out.println("rotation to be made" + rotX + ", " + rotY + ", "+ rotZ) ;
				System.out.println("\n\n" +cube.getCubes().get(i).getRotX() + ", " + cube.getCubes().get(i).getRotY() + ", " + cube.getCubes().get(i).getRotZ());
				if (rotX < 0){
					rotX *= -3;
				}
				if (rotY < 0){
					rotY *= -3;
				}
				if (rotZ < 0){
					rotZ *= -3;
				}
				
				
				
				
				if(rotX != 0){
					cube.getCubes().get(i).setRotX(cube.getCubes().get(i).getRotX() + rotX);
				}
				
				if(rotY != 0){
					cube.getCubes().get(i).setRotY(cube.getCubes().get(i).getRotY() + rotY);
				}
				if (rotZ != 0){
					cube.getCubes().get(i).setRotZ(cube.getCubes().get(i).getRotZ() + rotZ);
					
					
				}
				
				int x = cube.getCubes().get(i).getRotX();
				int y = cube.getCubes().get(i).getRotY();
				int z = cube.getCubes().get(i).getRotZ();
				
				q.fromAngles(cube.getCubes().get(i).getRotX() * FastMath.DEG_TO_RAD, cube.getCubes().get(i).getRotY() * FastMath.DEG_TO_RAD, cube.getCubes().get(i).getRotZ() * FastMath.DEG_TO_RAD);
				
				cube.getCubes().set(i, Cube.createSpatial(assetManager, rootNode,  "Models/masterCube/masterCube.j3o", new RelativeVector(0,0,0).getRelativeVector(2, 2, 2), 0, 0, 0));
				rootNode.detachAllChildren();
				assignCubesToNode(cube.getCubes());
				
				cube.getCubes().get(i).setRotX(x);
				cube.getCubes().get(i).setRotY(y);
				cube.getCubes().get(i).setRotZ(z);
				System.out.println(cube.getCubes().get(i).getRotX() + ", " + cube.getCubes().get(i).getRotY() + ", " + cube.getCubes().get(i).getRotZ());
				//cube.getCubes().get(i).getSpatialObject().rotate(rotX * FastMath.DEG_TO_RAD, rotY * FastMath.DEG_TO_RAD, rotZ * FastMath.DEG_TO_RAD);
				//cube.getCubes().get(i).getSpatialObject().rotate(q);
				//cube.getCubes().get(i).getSpatialObject().setLocalRotation(new Quaternion().fromAngles(0, 0, 0));
				cube.getCubes().get(i).getSpatialObject().setLocalRotation(q);
				cube.getCubes().get(i).getSpatialObject().getLocalRotation().set(q);
				//cube.getCubes().get(i).getSpatialObject().updateGeometricState();
				//cube.getCubes().get(i).getSpatialObject().updateModelBound();
				cube.getCubes().get(i).setRotate(false);
			}
		}	
	}

	
	
	
	
	
	
	
	
	

	public void rotateFrontNorm() {
		List<Integer> cubesAffected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		for (int i = 0; i < cube.getCubes().size(); i++) {
			if (cubesAffected.contains(i)) {
				cube.getCubes().get(i).setRotate(true);
				cube.getCubes().get(i).frontNormalRotateColors();
			}
		}
		rotateCubes(0, 0, -90);
		//System.out.println("\n\n" + cube.getCubes().get(0).getColorOrientation() + "\n" + cube.getCubes().get(2).getColorOrientation());
	}

	public void rotateFrontInverse() {
		List<Integer> cubesAffected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		for (int i = 0; i < cube.getCubes().size(); i++) {
			if (cubesAffected.contains(i)) {
				cube.getCubes().get(i).setRotate(true);
				cube.getCubes().get(i).frontInverseRotateColors();
			}
		}
		rotateCubes(0, 0, 90);
		//System.out.println("\n\n" + cube.getCubes().get(0).getColorOrientation() + "\n" + cube.getCubes().get(2).getColorOrientation());
	}

	
	
	public void rotateTopNorm() {
		List<Integer> cubesAffected = Arrays.asList(0, 1, 2, 9, 10, 11, 18, 19, 20);
		for (int i = 0; i < cube.getCubes().size(); i++) {
			if (cubesAffected.contains(i)) {
				cube.getCubes().get(i).setRotate(true);
				cube.getCubes().get(i).topNormalRotateColors();
			}
		}
		rotateCubes( 0, -90, 0);
		//System.out.println("\n\n" + cube.getCubes().get(0).getColorOrientation() + "\n" + cube.getCubes().get(2).getColorOrientation());
	}

	public void rotateTopInverse() {
		List<Integer> cubesAffected = Arrays.asList(0, 1, 2, 9, 10, 11, 18, 19, 20);
		for (int i = 0; i < cube.getCubes().size(); i++) {
			if (cubesAffected.contains(i)) {
				cube.getCubes().get(i).setRotate(true);
				cube.getCubes().get(i).topInverseRotateColors();
			}
		}
		rotateCubes(0, 90, 0);
	}
	
	
	
	public void rotateRightNorm(){
		List<Integer> cubesAffected = Arrays.asList(0,3,6,9,12,15,18,21,24);
		for (int i = 0; i < cube.getCubes().size(); i++) {
			if (cubesAffected.contains(i)) {
				cube.getCubes().get(i).setRotate(true);
				cube.getCubes().get(i).rightNormalRotateColors();
			}
		}
		rotateCubes(-90, 0, 0);
		//System.out.println("\n\n" + cube.getCubes().get(0).getColorOrientation() + "\n" + cube.getCubes().get(2).getColorOrientation());
	}
	public void rotateRightInverse(){
		List<Integer> cubesAffected = Arrays.asList(0,3,6,9,12,15,18,21,24);
		for (int i = 0; i < cube.getCubes().size(); i++) {
			if (cubesAffected.contains(i)) {
				cube.getCubes().get(i).setRotate(true);
				cube.getCubes().get(i).rightInverseRotateColors();
			}
		}
		rotateCubes(90, 0, 0);
	}
	
	
	
	
	
	
	
	public void matchCubes(){
		cube.getCubes().get(0).matchOrientation(cube.getCubes().get(2).getColorOrientation());
	}
	
	public static void delay(int time) {
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < time)
			endDelay = System.currentTimeMillis();
	}
	
	
	public void initInputHandler() {
		inputHandler = new InputHandler(inputManager, actionListener);
		inputHandler.addKeyListener("f", KeyInput.KEY_F);
		inputHandler.addKeyListener("right", KeyInput.KEY_R);
		inputHandler.addKeyListener("x", KeyInput.KEY_LCONTROL);
		inputHandler.addKeyListener("t", KeyInput.KEY_T);
		inputHandler.addKeyListener("r", KeyInput.KEY_R);
		inputHandler.addKeyListener("p", KeyInput.KEY_P);
	}

	public void initLighting() {
		addDirectionalLight(lightingNode, new Vector3f(0f, 0f, 0f));
		//addDirectionalLight(lightingNode, new Vector3f(1f, 0f, 0f));
		addDirectionalLight(lightingNode, new Vector3f(1f, 1f, 0f));
		addDirectionalLight(lightingNode, new Vector3f(1f, 1f, 1f));
		addDirectionalLight(lightingNode, new Vector3f(-1f, 0f, 0f));
		addDirectionalLight(lightingNode, new Vector3f(-1f, -1f, -1f));

		rootNode.attachChild(lightingNode);
	}

	public void addDirectionalLight(Node node, Vector3f direction) {
		DirectionalLight sun = new DirectionalLight();
		sun.setDirection(direction);
		sun.setColor(ColorRGBA.White.mult(1));
		rootNode.addLight(sun);
	}
}