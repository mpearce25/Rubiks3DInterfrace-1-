package mygame;


//array swap code works but i think the objects are still centerred aroundt the wrong thing after their rotation -- might have to redraw array everythime 
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

	
	Cube cube;
	ArrayList<Spatial> allCubes = new ArrayList<Spatial>();
	
	

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
		
		
		cube = new Cube(new Vector3f(0,0,0), assetManager);
		assignCubesToNode(cube.getCubesArray());

		InputHandler inputHandler = new InputHandler(inputManager);

		
	}

	public void assignCubesToNode(ArrayList<Spatial> cubes) {
		for (Spatial cube : cubes) {
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
			frontRotateNormNode.attachChild( cube.getCubesArray().get(i));
		}
		
		rootNode.attachChild(frontRotateNormNode);
		frontRotateNormNode.rotate(  0f,  0f, rotateFrontNormDegrees*FastMath.DEG_TO_RAD);
		
		rotateFrontNormDegrees -= 90;
		if (rotateFrontNormDegrees <= -360) {
			rotateFrontNormDegrees = 0;
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
		
	}
	
	
	
	int rotateFrontTopDegrees = -90;
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
	}
	
	
	
	@Override
	public void simpleUpdate(float tpf) {

		// rotateD(tpf);
		// bottomRow.rotate(FastMath.DEG_TO_RAD * 180f, 0f, 0f);
		// testRow.rotate(rotation);

	}

	

	public static void delay(int time) {
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < time)
			endDelay = System.currentTimeMillis();
	}
}