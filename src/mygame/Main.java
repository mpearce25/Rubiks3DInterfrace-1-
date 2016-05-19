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

		cube = new Cube(new Vector3f(0, 0, 0), assetManager, rootNode);
		assignCubesToNode(cube);
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

			switch (keysPressed) {
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
				cube.rotateBottonNorm();
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

			}
			assignCubesToNode(cube);
		}
	};
}