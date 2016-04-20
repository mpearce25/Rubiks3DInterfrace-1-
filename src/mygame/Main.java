package mygame;


//array swap code works but i think the objects are still centerred aroundt the wrong thing after their rotation
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.*;
import com.jme3.math.*;
import com.jme3.scene.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends SimpleApplication {

	ArrayList<Spatial> allCubes = new ArrayList<Spatial>();
	
	private ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean pressed, float tpf) {
			//System.out.println(name + " = " + pressed);
			System.out.println(name);
			if (pressed){
			switch (name){
			case("right"):{
				//rotateRightNorm();
				rotateFrontNorm();
			}
			break;
			
			case("frontNorm"):{
				rotateFrontNorm();
			}
			break;
			
			case("topNorm"):{
				rotateTopNorm();
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

	// Nodes
	Node bottomRow = new Node();
	Node frontFace = new Node();
	Node testRow = new Node();
	Node lightingNode = new Node();
	// Quaternion rotation=(new Quaternion()).fromAngles(145 ,78, 19);
	// Quaternion rotation=(new Quaternion()).fromAngles(0, 0,0);
	Quaternion rotation = (new Quaternion()).fromAngleAxis(FastMath.PI / 2, new Vector3f(1, 0, 0));
	Quaternion rotationVelocity = (new Quaternion()).fromAngles(0.1f, .1f, .1f);

	Spatial cube9;

	public static void main(String[] args) {
		Main app = new Main();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		rootNode.attachChild(bottomRow);
		rootNode.attachChild(lightingNode);
		// set lighting
		initLighting();

		// rotation & pan
		Node pivot = new Node("pivot");
		pivot.rotate(2f, 2f, 2f);
		rootNode.attachChild(pivot); // put this node in the scene

		flyCam.setMoveSpeed(10);
		
		RelativeVector origin = new RelativeVector(0,0,0);
		
		
		

		Spatial cube1 = createSpatial(rootNode, "Models/C-rwb/C-rwb.j3o", origin.getRelativeVector(2, 2, 2), 180, 90, 0);
		allCubes.add(cube1);

		Spatial cube2 = createSpatial(rootNode, "Models/E-rw/E-rw.j3o", origin.getRelativeVector(0, 2, 2), 180, 90, 0);
		allCubes.add(cube2);

		Spatial cube3 = createSpatial(rootNode, "Models/C-rwg/C-rwg.j3o", origin.getRelativeVector(-2, 2, 2), 180, 90, 0);
		allCubes.add(cube3);

		Spatial cube4 = createSpatial(rootNode, "Models/E-rb/E-rb.j3o", origin.getRelativeVector(2, 0, 2), 180, 90, 0);
		allCubes.add(cube4);

		Spatial cube5 = createSpatial(rootNode, "Models/S-r/S-r.j3o", origin.getRelativeVector(0, 0, 2), 180, 90, 0);
		allCubes.add(cube5);

		Spatial cube6 = createSpatial(rootNode, "Models/E-rg/E-rg.j3o", origin.getRelativeVector(-2, 0, 2), 180, 90, 0);
		allCubes.add(cube6);

		Spatial cube7 = createSpatial(rootNode, "Models/C-ryb/C-ryb.j3o", origin.getRelativeVector(2, -2, 2), 0, 270, 180);
		allCubes.add(cube7);

		Spatial cube8 = createSpatial(rootNode, "Models/E-ry/E-ry.j3o", origin.getRelativeVector(0, -2, 2), 0, 270, 180);
		allCubes.add(cube8);

		cube9 = createSpatial(rootNode, "Models/C-ryg/C-ryg.j3o", origin.getRelativeVector(-2, -2, 2), 180, 90, 0);
		allCubes.add(cube9);

		Spatial cube10 = createSpatial(rootNode, "Models/E-bw/E-bw.j3o", origin.getRelativeVector(2, 2, 0), 0, 180, 180);
		allCubes.add(cube10);

		Spatial cube11 = createSpatial(rootNode, "Models/S-w/S-w.j3o", origin.getRelativeVector(0, 2, 0), 0, 180, 180);
		allCubes.add(cube11);

		Spatial cube12 = createSpatial(rootNode, "Models/E-gw/E-gw.j3o", origin.getRelativeVector(-2, 2, 0), 0, 270, 180);
		allCubes.add(cube12);

		Spatial cube13 = createSpatial(rootNode, "Models/S-b/S-b.j3o", origin.getRelativeVector(2, 0, 0), 0, 180, 180);
		allCubes.add(cube13);

		Spatial cube14 = createSpatial(rootNode, "Models/S-center/S-center.j3o", origin.getRelativeVector(0, 0, 0), 0, 180, 180);
		allCubes.add(cube14);

		Spatial cube15 = createSpatial(rootNode, "Models/S-g/S-g.j3o", origin.getRelativeVector(-2, 0, 0), 0, 270, 180);
		allCubes.add(cube15);

		Spatial cube16 = createSpatial(rootNode, "Models/E-by/E-by.j3o", origin.getRelativeVector(2, -2, 0), 0, 180, 180);
		allCubes.add(cube16);

		Spatial cube17 = createSpatial(rootNode, "Models/S-y/S-y.j3o", origin.getRelativeVector(0, -2, 0), 0, 180, 180);
		allCubes.add(cube17);

		Spatial cube18 = createSpatial(rootNode, "Models/E-gy/E-gy.j3o", origin.getRelativeVector(-2, -2, 0), 0, 270, 180);
		allCubes.add(cube18);

		Spatial cube19 = createSpatial(rootNode, "Models/C-bow/C-bow.j3o", origin.getRelativeVector(2, 2, -2), 0, 180, 180);
		allCubes.add(cube19);

		Spatial cube20 = createSpatial(rootNode, "Models/E-ow/E-ow.j3o", origin.getRelativeVector(0, 2, -2), 0, 180, 180);
		allCubes.add(cube20);

		Spatial cube21 = createSpatial(rootNode, "Models/C-gwo/C-gwo.j3o", origin.getRelativeVector(-2, 2, -2), 0, 270, 180);
		allCubes.add(cube21);

		Spatial cube22 = createSpatial(rootNode, "Models/E-bo/E-bo.j3o", origin.getRelativeVector(2, 0, -2), 0, 180, 180);
		allCubes.add(cube22);

		Spatial cube23 = createSpatial(rootNode, "Models/S-o/S-o.j3o", origin.getRelativeVector(0, 0, -2), 0, 180, 180);
		allCubes.add(cube23);

		Spatial cube24 = createSpatial(rootNode, "Models/E-go/E-go.j3o", origin.getRelativeVector(-2, 0, -2), 0, 270, 180);
		allCubes.add(cube24);

		Spatial cube25 = createSpatial(rootNode, "Models/C-boy/C-boy.j3o", origin.getRelativeVector(2, -2, -2), 0, 180, 180);
		allCubes.add(cube25);

		Spatial cube26 = createSpatial(rootNode, "Models/E-oy/E-oy.j3o", origin.getRelativeVector(0, -2, -2), 0, 180, 180);
		allCubes.add(cube26);

		Spatial cube27 = createSpatial(rootNode, "Models/C-gyo/C-gyo.j3o", origin.getRelativeVector(-2, -2, -2), 0, 270, 180);
		allCubes.add(cube27);

		assignCubesToNode(allCubes);

		

		inputManager.addMapping("rightNorm", new KeyTrigger(KeyInput.KEY_R));
		inputManager.addListener( actionListener,"right");
		
		inputManager.addMapping("frontNorm", new KeyTrigger(KeyInput.KEY_F));
		inputManager.addListener( actionListener,"frontNorm");
		
		inputManager.addMapping("topNorm", new KeyTrigger(KeyInput.KEY_T));
		inputManager.addListener( actionListener,"topNorm");
		//inputManager.addMapping("RotateD", new KeyTrigger(KeyInput.KEY_R));
		//inputManager.addListener(actionListener, "RotateD");

	}

	public void assignCubesToNode(ArrayList<Spatial> allCubes) {
		for (Spatial cube : allCubes) {
			rootNode.attachChild(cube);
		}
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

	Boolean added = false;
	float degree = FastMath.PI / 2;
	Boolean firstRotate = true;
	Node testRotate = new Node();
	int rotationNumber = 0;
	
	//Node rightRotate = new Node();
	
	
	
	public void rotateD(float tpf, ArrayList<Spatial> allCubes) {

		
		
		if (firstRotate){
			//testRotate.attachChild(allCubes.get(4));
			
			
			
			/*testRotate.attachChild(allCubes.get(0));
			testRotate.attachChild(allCubes.get(1));
			testRotate.attachChild(allCubes.get(2));
			
			testRotate.attachChild(allCubes.get(9));
			testRotate.attachChild(allCubes.get(10));
			testRotate.attachChild(allCubes.get(11));
			
			testRotate.attachChild(allCubes.get(18));
			testRotate.attachChild(allCubes.get(19));
			testRotate.attachChild(allCubes.get(20));*/
				
			
			testRotate.setLocalTranslation(new Vector3f(0,0,0));
			rootNode.attachChild(testRotate);
	}
		
		testRotate.rotate(  0f,  0f, 90*FastMath.DEG_TO_RAD );
		
		/*
	
		
		/*Quaternion rotationVelocityFPS=new Quaternion();
	    rotationVelocityFPS.slerp(Quaternion.IDENTITY, rotationVelocity, tpf);

	    rotation.multLocal(rotationVelocityFPS);
	
	    testRotate.setLocalRotation(rotation);*/
		/*degree += FastMath.PI / 2;
		if (degree > FastMath.PI * 2) {
			degree = 0;
		}*/
		/*Quaternion rotation = (new Quaternion()).fromAngleAxis(degree, new Vector3f(0, 0, 1));

		
	

		Quaternion rotationVelocityFPS = new Quaternion();
		rotationVelocityFPS.slerp(Quaternion.IDENTITY, rotationVelocity, tpf);

		rotation.multLocal(rotationVelocityFPS);

		testRotate.setLocalRotation(rotation);*/

		////////////////#######
		
		
		/*Quaternion rotationVelocityFPS = new Quaternion();
		rotationVelocityFPS.slerp(Quaternion.IDENTITY, rotationVelocity, tpf);

		rotation.multLocal(rotationVelocityFPS);
		
		
		testRotate.setLocalRotation(rotation);
		testRotate.setLocalTranslation(new Vector3f(-6,0,0));*/
		
		/*// for (int i = 0; i < 10; i ++){
		//Node testRotate = new Node();

		if (firstRotate){
			for (int i = 0; i < 9; i++) {

				if (!added) {
					//rootNode.detachChildAt(i);
					added = !added;
				}

				//allCubes.get(i).setLocalTranslation(new Vector3f(0, 0, 0));
				testRotate.attachChild(allCubes.get(i));

			}
		}
		

		rootNode.attachChild(testRotate);
		Quaternion rotation = (new Quaternion()).fromAngleAxis(degree, new Vector3f(0, 0, 1));

		degree += FastMath.PI / 2;
		if (degree > FastMath.PI * 2) {
			degree = 0;
		}
	

		Quaternion rotationVelocityFPS = new Quaternion();
		rotationVelocityFPS.slerp(Quaternion.IDENTITY, rotationVelocity, tpf);

		rotation.multLocal(rotationVelocityFPS);

		if (firstRotate){
			testRotate.setLocalTranslation(-2,-2,0);
		}
		//testRotate.setLocalTranslation(new Vector3f(0,0,0));
		
		

		
		
		testRotate.setLocalRotation(rotation);
		// }
		//

		// delay(2000);
		firstRotate = false;*/
	}
	
	
	int rotateFrontNormDegrees = -90;
	public void rotateFrontNorm(){
		//Node rightRotateNormNode = new Node();
		
		Node frontRotateNormNode = new Node();
		
		for (int i = 0; i < 9; i++){
			frontRotateNormNode.attachChild(allCubes.get(i));
		}
		
		rootNode.attachChild(frontRotateNormNode);
		frontRotateNormNode.rotate(  0f,  0f, rotateFrontNormDegrees*FastMath.DEG_TO_RAD);
		
		rotateFrontNormDegrees -= 90;
		if (rotateFrontNormDegrees <= -360) {
			rotateFrontNormDegrees = 0;
		}
		
		/*for(int i = 0; i < 9; i++){
			System.out.println(i + ":  " + allCubes.get(i));
		}
		System.out.println(allCubes+ "\n\n\n\n");*/
		//array restructuring
		//corners
		Collections.swap(allCubes, 0, 6);
		Collections.swap(allCubes, 0, 8);
		Collections.swap(allCubes, 0, 2);
		
		//edges
		Collections.swap(allCubes, 1, 3);
		Collections.swap(allCubes, 1, 7);
		Collections.swap(allCubes, 1, 5);
		/*for(int i = 0; i < 9; i++){
			System.out.println(i + ":  " + allCubes.get(i));
		}*/
		
	}
	
	
	
	int rotateFrontTopDegrees = -90;
	public void rotateTopNorm(){
		//Node rightRotateNormNode = new Node();
		
		Node topRotateNormNode = new Node();
		
		topRotateNormNode.attachChild(allCubes.get(0));
		topRotateNormNode.attachChild(allCubes.get(1));
		topRotateNormNode.attachChild(allCubes.get(2));
		
		topRotateNormNode.attachChild(allCubes.get(9));
		topRotateNormNode.attachChild(allCubes.get(10));
		topRotateNormNode.attachChild(allCubes.get(11));
		
		topRotateNormNode.attachChild(allCubes.get(18));
		topRotateNormNode.attachChild(allCubes.get(19));
		topRotateNormNode.attachChild(allCubes.get(20));
		
		rootNode.attachChild(topRotateNormNode);
		topRotateNormNode.rotate(  0f,rotateFrontNormDegrees*FastMath.DEG_TO_RAD,  0f );
		
		rotateFrontNormDegrees -= 90;
		if (rotateFrontNormDegrees <= -360) {
			rotateFrontNormDegrees = 0;
		}
		
		//array restructuring
		
		
		/*System.out.println(0 + ": " + allCubes.get(0));
		System.out.println(1 + ": " + allCubes.get(1));
		System.out.println(2 + ": " + allCubes.get(2));
		
		System.out.println(9 + ": " + allCubes.get(9));
		System.out.println(10 + ": " + allCubes.get(10));
		System.out.println(11 + ": " + allCubes.get(11));
		
		System.out.println(18 + ": " + allCubes.get(18));
		System.out.println(19 + ": " + allCubes.get(19));
		System.out.println(20 + ": " + allCubes.get(20) + "\n\n\n\n\n");*/
		
		
		//corners
		
		Collections.swap(allCubes, 0, 2);
		Collections.swap(allCubes, 0, 20);
		Collections.swap(allCubes, 0, 18);
		
		//edges
		Collections.swap(allCubes, 1, 11);
		Collections.swap(allCubes, 1, 19);
		Collections.swap(allCubes, 1, 9);
		/*System.out.println(0 + ": " + allCubes.get(0));
		System.out.println(1 + ": " + allCubes.get(1));
		System.out.println(2 + ": " + allCubes.get(2));
		
		System.out.println(9 + ": " + allCubes.get(9));
		System.out.println(10 + ": " + allCubes.get(10));
		System.out.println(11 + ": " + allCubes.get(11));
		
		System.out.println(18 + ": " + allCubes.get(18));
		System.out.println(19 + ": " + allCubes.get(19));
		System.out.println(20 + ": " + allCubes.get(20)  + "\n\n\n\n\n" );*/
	}
	
	
	
	@Override
	public void simpleUpdate(float tpf) {

		// rotateD(tpf);
		// bottomRow.rotate(FastMath.DEG_TO_RAD * 180f, 0f, 0f);
		// testRow.rotate(rotation);

	}

	public Spatial createSpatial(Node node, String modelPath, Vector3f translation, float rotX, float rotY,
			float rotZ) {

		Spatial object = assetManager.loadModel(modelPath);
		object.scale(1, 1, 1);
		object.rotate(FastMath.DEG_TO_RAD * rotX, FastMath.DEG_TO_RAD * rotY, FastMath.DEG_TO_RAD * rotZ);
		object.setLocalTranslation(translation);
		node.attachChild(object);

		return object;
	}

	public static void delay(int time) {
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < time)
			endDelay = System.currentTimeMillis();
	}
}