package mygame;

import java.util.ArrayList;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Quad;
import com.sun.prism.paint.Color;
import java.awt.color.*;

public class Cube {

	private RelativeVector cubeCenter;
	private String topFaceColor = "";
	private String frontFaceColor = "";
	private String leftFaceColor = "";
	
	
	private Material white;
	private Material green;
	private Material red;
	private Material orange;
	private Material blue;
	private Material yellow;
	private Material black;

	private ArrayList<Geometry> topFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> frontFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> leftFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> backFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> rightFace = new ArrayList<Geometry>();
	private ArrayList<Geometry> bottomFace = new ArrayList<Geometry>();
	
	private ArrayList<Material> materials = new ArrayList<Material>();

	private Quaternion topFaceRotation = new Quaternion().fromAngles(-90 * FastMath.DEG_TO_RAD, 0, 0);
	private ArrayList<Vector3f> topFaceOffSets = new ArrayList<Vector3f>();

	Quaternion frontFaceRotation = new Quaternion().fromAngles(0, 0, -90 * FastMath.DEG_TO_RAD);
	ArrayList<Vector3f> frontFaceOffSets = new ArrayList<Vector3f>();

	Quaternion leftFaceRotation = new Quaternion().fromAngles(0, -90 * FastMath.DEG_TO_RAD, 0);
	ArrayList<Vector3f> leftFaceOffSets = new ArrayList<Vector3f>();

	Quaternion backFaceRotation = new Quaternion().fromAngles(180 * FastMath.DEG_TO_RAD, 0, -90 * FastMath.DEG_TO_RAD);
	ArrayList<Vector3f> backFaceOffSets = new ArrayList<Vector3f>();

	Quaternion rightFaceRotation = new Quaternion().fromAngles(0, 90 * FastMath.DEG_TO_RAD, 0);
	ArrayList<Vector3f> rightFaceOffSets = new ArrayList<Vector3f>();

	Quaternion bottomFaceRotation = new Quaternion().fromAngles(90 * FastMath.DEG_TO_RAD, 0, 0);
	ArrayList<Vector3f> bottomFaceOffSets = new ArrayList<Vector3f>();

	public Cube(Vector3f cubeCenter, AssetManager assetManager, Node rootNode, String topFaceColor, String frontFaceColor, String leftFaceColor) {

		this.cubeCenter = new RelativeVector(cubeCenter);
		this.topFaceColor = topFaceColor;
		this.frontFaceColor = frontFaceColor;
		this.leftFaceColor = leftFaceColor;
		
		initMaterials(assetManager);
		initOffSets();
		initFaces();
		initFaceGrids(rootNode);

	}

	private void initFaceGrids(Node rootNode) {
		// front face
		rootNode.attachChild(generateHorizontalRuler(frontFaceRotation, -2f, 2f, 2.0001f));
		rootNode.attachChild(generateHorizontalRuler(frontFaceRotation, -2f, 0f, 2.0001f));
		rootNode.attachChild(generateHorizontalRuler(frontFaceRotation, -2f, -2f, 2.0001f));
		rootNode.attachChild(generateHorizontalRuler(frontFaceRotation, -2f, -3.90f, 2.0001f));

		rootNode.attachChild(generateVerticalRuler(new Quaternion().fromAngles(0, 0, 0), -2f, -4f, 2.0001f));
		rootNode.attachChild(generateVerticalRuler(new Quaternion().fromAngles(0, 0, 0), 0f, -4f, 2.0001f));
		rootNode.attachChild(generateVerticalRuler(new Quaternion().fromAngles(0, 0, 0), 2f, -4f, 2.0001f));
		rootNode.attachChild(generateVerticalRuler(new Quaternion().fromAngles(0, 0, 0), 3.9f, -4f, 2.0001f));

		// top face
		rootNode.attachChild(generateVerticalRuler(topFaceRotation, -2f, 2.0001f, 2f));
		rootNode.attachChild(generateVerticalRuler(topFaceRotation, 0f, 2.0001f, 2f));
		rootNode.attachChild(generateVerticalRuler(topFaceRotation, 2f, 2.0001f, 2f));
		rootNode.attachChild(generateVerticalRuler(topFaceRotation, 3.9f, 2.0001f, 2f));

		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(-90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), 4f, 2.0001f, 2f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(-90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), 4f, 2.0001f, 0f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(-90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), 4f, 2.0001f, -2f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(-90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), 4f, 2.0001f,
				-3.9f));

		// left Face
		rootNode.attachChild(generateHorizontalRuler(leftFaceRotation, -2.0001f, -4f, 1.9f));
		rootNode.attachChild(generateHorizontalRuler(leftFaceRotation, -2.0001f, -4f, -.1f));
		rootNode.attachChild(generateHorizontalRuler(leftFaceRotation, -2.0001f, -4f, -2.1f));
		rootNode.attachChild(generateHorizontalRuler(leftFaceRotation, -2.0001f, -4f, -4f));

		rootNode.attachChild(generateVerticalRuler(
				new Quaternion().fromAngles(0, -90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD), -2.0001f, -4f,
				2f));
		rootNode.attachChild(generateVerticalRuler(
				new Quaternion().fromAngles(0, -90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD), -2.0001f, -2.1f,
				2f));
		rootNode.attachChild(generateVerticalRuler(
				new Quaternion().fromAngles(0, -90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD), -2.0001f, -.1f,
				2f));
		rootNode.attachChild(generateVerticalRuler(
				new Quaternion().fromAngles(0, -90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD), -2.0001f, 1.9f,
				2f));

		// back face
		rootNode.attachChild(generateHorizontalRuler(backFaceRotation, 4f, 2f, -4.0001f));
		rootNode.attachChild(generateHorizontalRuler(backFaceRotation, 4f, 0f, -4.0001f));
		rootNode.attachChild(generateHorizontalRuler(backFaceRotation, 4f, -2f, -4.0001f));
		rootNode.attachChild(generateHorizontalRuler(backFaceRotation, 4f, -3.9f, -4.0001f));

		rootNode.attachChild(
				generateVerticalRuler(new Quaternion().fromAngles(180 * FastMath.DEG_TO_RAD, 0, 0), -2f, 2f, -4.0001f));
		rootNode.attachChild(
				generateVerticalRuler(new Quaternion().fromAngles(180 * FastMath.DEG_TO_RAD, 0, 0), 0f, 2f, -4.0001f));
		rootNode.attachChild(
				generateVerticalRuler(new Quaternion().fromAngles(180 * FastMath.DEG_TO_RAD, 0, 0), 2f, 2f, -4.0001f));
		rootNode.attachChild(generateVerticalRuler(new Quaternion().fromAngles(180 * FastMath.DEG_TO_RAD, 0, 0), 3.9f,
				2f, -4.0001f));

		// rightFace
		rootNode.attachChild(generateHorizontalRuler(rightFaceRotation, 4.0001f, -4f, 2f));// these
																							// are
																							// actually
																							// the
																							// vertical
																							// ones
		rootNode.attachChild(generateHorizontalRuler(rightFaceRotation, 4.0001f, -4f, 0f));
		rootNode.attachChild(generateHorizontalRuler(rightFaceRotation, 4.0001f, -4f, -2f));
		rootNode.attachChild(generateHorizontalRuler(rightFaceRotation, 4.0001f, -4f, -3.9f));

		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(0, 90 * FastMath.DEG_TO_RAD, -90 * FastMath.DEG_TO_RAD), 4.001f, 2f, 2f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(0, 90 * FastMath.DEG_TO_RAD, -90 * FastMath.DEG_TO_RAD), 4.001f, 0f, 2f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(0, 90 * FastMath.DEG_TO_RAD, -90 * FastMath.DEG_TO_RAD), 4.001f, -2f, 2f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(0, 90 * FastMath.DEG_TO_RAD, -90 * FastMath.DEG_TO_RAD), 4.001f, -3.9f,
				2f));

		// bottom face
		rootNode.attachChild(generateHorizontalRuler(bottomFaceRotation, 3.9f, -4.0001f, -4));
		rootNode.attachChild(generateHorizontalRuler(bottomFaceRotation, 2f, -4.0001f, -4));
		rootNode.attachChild(generateHorizontalRuler(bottomFaceRotation, 0f, -4.0001f, -4));
		rootNode.attachChild(generateHorizontalRuler(bottomFaceRotation, -2f, -4.0001f, -4));

		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), -2f, -4.0001f, 2f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), -2f, -4.0001f, 0f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), -2f, -4.0001f,
				-2f));
		rootNode.attachChild(generateHorizontalRuler(
				new Quaternion().fromAngles(90 * FastMath.DEG_TO_RAD, 90 * FastMath.DEG_TO_RAD, 0), -2f, -4.0001f,
				-3.9f));

	}

	private Geometry generateHorizontalRuler(Quaternion rotation, float x, float y, float z) {
		Geometry tempGeo = new Geometry("grid1", new Quad(2, 6));
		tempGeo.setMaterial(black);
		tempGeo.setLocalTranslation(cubeCenter.getFloatXOffset(x), cubeCenter.getFloatYOffset(y),
				cubeCenter.getFloatZOffset(z));
		tempGeo.setLocalRotation(rotation);
		tempGeo.setLocalScale(.05f, 1f, 1f);
		return tempGeo;
	}

	private Geometry generateVerticalRuler(Quaternion rotation, float x, float y, float z) {
		Geometry tempGeo = new Geometry("grid1", new Quad(2, 6));
		tempGeo.setMaterial(black);
		tempGeo.setLocalTranslation(cubeCenter.getFloatXOffset(x), cubeCenter.getFloatYOffset(y),
				cubeCenter.getFloatZOffset(z));
		tempGeo.setLocalRotation(rotation);
		tempGeo.setLocalScale(.05f, 1f, 1f);
		return tempGeo;
	}

	private void initMaterials(AssetManager assetManager) {
		white = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		white.setColor("Color", ColorRGBA.White);
		white.setName("white");
		materials.add(white);
		
		black = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		black.setColor("Color", ColorRGBA.Black);
		black.setName("black");
		materials.add(black);

		green = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		green.setColor("Color", ColorRGBA.Green);
		green.setName("green");
		materials.add(green);

		red = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		red.setColor("Color", ColorRGBA.Red);
		red.setName("red");
		materials.add(red);	

		orange = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		orange.setColor("Color", ColorRGBA.Orange);
		orange.setName("orange");
		materials.add(orange);

		blue = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		blue.setColor("Color", convertToColorRGBA(20, 100, 227, 0));
		blue.setName("blue");
		materials.add(blue);

		yellow = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		yellow.setColor("Color", ColorRGBA.Yellow);
		yellow.setName("yellow");
		materials.add(yellow);
		
	}

	private void initOffSets() {
		topFaceOffSets.add(cubeCenter.getOffset(2, 2, 2));
		topFaceOffSets.add(cubeCenter.getOffset(0, 2, 2));
		topFaceOffSets.add(cubeCenter.getOffset(-2, 2, 2));

		topFaceOffSets.add(cubeCenter.getOffset(2, 2, 0));
		topFaceOffSets.add(cubeCenter.getOffset(0, 2, 0));
		topFaceOffSets.add(cubeCenter.getOffset(-2, 2, 0));

		topFaceOffSets.add(cubeCenter.getOffset(2, 2, -2));
		topFaceOffSets.add(cubeCenter.getOffset(0, 2, -2));
		topFaceOffSets.add(cubeCenter.getOffset(-2, 2, -2));

		////////////////////////////////////////////
		frontFaceOffSets.add(cubeCenter.getOffset(2, 2, 2));
		frontFaceOffSets.add(cubeCenter.getOffset(0, 2, 2));
		frontFaceOffSets.add(cubeCenter.getOffset(-2, 2, 2));

		frontFaceOffSets.add(cubeCenter.getOffset(2, 0, 2));
		frontFaceOffSets.add(cubeCenter.getOffset(0, 0, 2));
		frontFaceOffSets.add(cubeCenter.getOffset(-2, 0, 2));

		frontFaceOffSets.add(cubeCenter.getOffset(2, -2, 2));
		frontFaceOffSets.add(cubeCenter.getOffset(0, -2, 2));
		frontFaceOffSets.add(cubeCenter.getOffset(-2, -2, 2));
		////////////////////////////////////////////

		leftFaceOffSets.add(cubeCenter.getOffset(-2, 0, 0));
		leftFaceOffSets.add(cubeCenter.getOffset(-2, 0, -2));
		leftFaceOffSets.add(cubeCenter.getOffset(-2, 0, -4));

		leftFaceOffSets.add(cubeCenter.getOffset(-2, -2, 0));
		leftFaceOffSets.add(cubeCenter.getOffset(-2, -2, -2));
		leftFaceOffSets.add(cubeCenter.getOffset(-2, -2, -4));

		leftFaceOffSets.add(cubeCenter.getOffset(-2, -4, 0));
		leftFaceOffSets.add(cubeCenter.getOffset(-2, -4, -2));
		leftFaceOffSets.add(cubeCenter.getOffset(-2, -4, -4));
		////////////////////////////////////////////

		backFaceOffSets.add(cubeCenter.getOffset(4, 2, -4));
		backFaceOffSets.add(cubeCenter.getOffset(2, 2, -4));
		backFaceOffSets.add(cubeCenter.getOffset(0, 2, -4));

		backFaceOffSets.add(cubeCenter.getOffset(4, 0, -4));
		backFaceOffSets.add(cubeCenter.getOffset(2, 0, -4));
		backFaceOffSets.add(cubeCenter.getOffset(0, 0, -4));

		backFaceOffSets.add(cubeCenter.getOffset(4, -2, -4));
		backFaceOffSets.add(cubeCenter.getOffset(2, -2, -4));
		backFaceOffSets.add(cubeCenter.getOffset(0, -2, -4));
		////////////////////////////////////////////

		rightFaceOffSets.add(cubeCenter.getOffset(4, 0, 2));
		rightFaceOffSets.add(cubeCenter.getOffset(4, 0, 0));
		rightFaceOffSets.add(cubeCenter.getOffset(4, 0, -2));

		rightFaceOffSets.add(cubeCenter.getOffset(4, -2, 2));
		rightFaceOffSets.add(cubeCenter.getOffset(4, -2, 0));
		rightFaceOffSets.add(cubeCenter.getOffset(4, -2, -2));

		rightFaceOffSets.add(cubeCenter.getOffset(4, -4, 2));
		rightFaceOffSets.add(cubeCenter.getOffset(4, -4, 0));
		rightFaceOffSets.add(cubeCenter.getOffset(4, -4, -2));
		////////////////////////////////////////////

		bottomFaceOffSets.add(cubeCenter.getOffset(2, -4, 0));
		bottomFaceOffSets.add(cubeCenter.getOffset(0, -4, 0));
		bottomFaceOffSets.add(cubeCenter.getOffset(-2, -4, 0));

		bottomFaceOffSets.add(cubeCenter.getOffset(2, -4, -2));
		bottomFaceOffSets.add(cubeCenter.getOffset(0, -4, -2));
		bottomFaceOffSets.add(cubeCenter.getOffset(-2, -4, -2));

		bottomFaceOffSets.add(cubeCenter.getOffset(2, -4, -4));
		bottomFaceOffSets.add(cubeCenter.getOffset(0, -4, -4));
		bottomFaceOffSets.add(cubeCenter.getOffset(-2, -4, -4));
	}

	private void initFaces() {
		//face materials order - top, front. left, back, right, bottom
		ArrayList<String> faceMaterialsInOrder = new ArrayList<String>();
		faceMaterialsInOrder.add(topFaceColor);
		faceMaterialsInOrder.add(frontFaceColor);
		faceMaterialsInOrder.add(leftFaceColor);
		faceMaterialsInOrder.add(getOppositeColor(frontFaceColor));
		faceMaterialsInOrder.add(getOppositeColor(leftFaceColor));
		faceMaterialsInOrder.add(getOppositeColor(topFaceColor));
		
		
		
		// top face 
		for (int i = 0; i < 9; i++) {
			Geometry tempGeo = new Geometry("Rect", new Quad(2, 2));
			tempGeo.setMaterial(getCorrespondingMaterial(faceMaterialsInOrder.get(0)));
			tempGeo.setLocalTranslation(topFaceOffSets.get(i));
			tempGeo.setLocalRotation(topFaceRotation);
			topFace.add(tempGeo);
		}
		// front face
		for (int i = 0; i < 9; i++) {
			Geometry tempGeo = new Geometry("Rect", new Quad(2, 2));
			tempGeo.setMaterial(getCorrespondingMaterial(faceMaterialsInOrder.get(1)));
			tempGeo.setLocalTranslation(frontFaceOffSets.get(i));
			tempGeo.setLocalRotation(frontFaceRotation);
			frontFace.add(tempGeo);
		}
		// left face 
		for (int i = 0; i < 9; i++) {
			Geometry tempGeo = new Geometry("Rect", new Quad(2, 2));
			tempGeo.setMaterial(getCorrespondingMaterial(faceMaterialsInOrder.get(2)));
			tempGeo.setLocalTranslation(leftFaceOffSets.get(i));
			tempGeo.setLocalRotation(leftFaceRotation);
			leftFace.add(tempGeo);
		}
		// back face 
		for (int i = 0; i < 9; i++) {
			Geometry tempGeo = new Geometry("Rect", new Quad(2, 2));
			tempGeo.setMaterial(getCorrespondingMaterial(faceMaterialsInOrder.get(3)));
			tempGeo.setLocalTranslation(backFaceOffSets.get(i));
			tempGeo.setLocalRotation(backFaceRotation);
			backFace.add(tempGeo);
		}
		// right face
		for (int i = 0; i < 9; i++) {
			Geometry tempGeo = new Geometry("Rect", new Quad(2, 2));
			tempGeo.setMaterial(getCorrespondingMaterial(faceMaterialsInOrder.get(4)));
			tempGeo.setLocalTranslation(rightFaceOffSets.get(i));
			tempGeo.setLocalRotation(rightFaceRotation);
			rightFace.add(tempGeo);
		}

		// bottom face - yellow
		for (int i = 0; i < 9; i++) {
			Geometry tempGeo = new Geometry("Rect", new Quad(2, 2));
			tempGeo.setMaterial(getCorrespondingMaterial(faceMaterialsInOrder.get(5)));
			tempGeo.setLocalTranslation(bottomFaceOffSets.get(i));
			tempGeo.setLocalRotation(bottomFaceRotation);
			bottomFace.add(tempGeo);
		}
	}

	public ArrayList<Geometry> getTopFace() {
		return topFace;
	}

	public ArrayList<Geometry> getFrontFace() {
		return frontFace;
	}

	public ArrayList<Geometry> getLeftFace() {
		return leftFace;
	}

	public ArrayList<Geometry> getBackFace() {
		return backFace;
	}

	public ArrayList<Geometry> getRightFace() {
		return rightFace;
	}

	public ArrayList<Geometry> getBottomFace() {
		return bottomFace;
	}

	public ArrayList<ArrayList<Geometry>> getAllFaces() {
		ArrayList<ArrayList<Geometry>> allFaces = new ArrayList<ArrayList<Geometry>>();
		allFaces.add(topFace);
		allFaces.add(frontFace);
		allFaces.add(leftFace);
		allFaces.add(backFace);
		allFaces.add(rightFace);
		allFaces.add(bottomFace);

		return allFaces;
	}

	private ColorRGBA convertToColorRGBA(int r, int g, int b, int a) {
		return new ColorRGBA(r / 255f, g / 255f, b / 255f, a * 1f);
	}

	// rotation methods
	public void rotateTopNorm() {
		swapMaterials(rightFace, 2, frontFace, 0);
		swapMaterials(rightFace, 2, leftFace, 0);
		swapMaterials(rightFace, 2, backFace, 2);

		swapMaterials(rightFace, 1, frontFace, 1);
		swapMaterials(rightFace, 1, leftFace, 1);
		swapMaterials(rightFace, 1, backFace, 1);

		swapMaterials(rightFace, 0, frontFace, 2);
		swapMaterials(rightFace, 0, leftFace, 2);
		swapMaterials(rightFace, 0, backFace, 0);

		// top part of top face
		swapMaterials(topFace, 0, topFace, 2);
		swapMaterials(topFace, 0, topFace, 8);
		swapMaterials(topFace, 0, topFace, 6);

		swapMaterials(topFace, 1, topFace, 5);
		swapMaterials(topFace, 1, topFace, 7);
		swapMaterials(topFace, 1, topFace, 3);
	}

	public void rotateTopInverse() {
		swapMaterials(rightFace, 2, backFace, 2);
		swapMaterials(rightFace, 2, leftFace, 0);
		swapMaterials(rightFace, 2, frontFace, 0);

		swapMaterials(rightFace, 1, backFace, 1);
		swapMaterials(rightFace, 1, leftFace, 1);
		swapMaterials(rightFace, 1, frontFace, 1);

		swapMaterials(rightFace, 0, backFace, 0);
		swapMaterials(rightFace, 0, leftFace, 2);
		swapMaterials(rightFace, 0, frontFace, 2);

		// top part
		swapMaterials(topFace, 0, topFace, 6);
		swapMaterials(topFace, 0, topFace, 8);
		swapMaterials(topFace, 0, topFace, 2);

		swapMaterials(topFace, 1, topFace, 3);
		swapMaterials(topFace, 1, topFace, 7);
		swapMaterials(topFace, 1, topFace, 5);
	}

	public void rotateFrontNorm() {
		swapMaterials(rightFace, 0, bottomFace, 0);
		swapMaterials(rightFace, 0, leftFace, 6);
		swapMaterials(rightFace, 0, topFace, 2);

		swapMaterials(rightFace, 3, bottomFace, 1);
		swapMaterials(rightFace, 3, leftFace, 3);
		swapMaterials(rightFace, 3, topFace, 1);

		swapMaterials(rightFace, 6, bottomFace, 2);
		swapMaterials(rightFace, 6, leftFace, 0);
		swapMaterials(rightFace, 6, topFace, 0);

		// front front
		swapMaterials(frontFace, 0, frontFace, 6);
		swapMaterials(frontFace, 0, frontFace, 8);
		swapMaterials(frontFace, 0, frontFace, 2);

		swapMaterials(frontFace, 1, frontFace, 3);
		swapMaterials(frontFace, 1, frontFace, 7);
		swapMaterials(frontFace, 1, frontFace, 5);
	}

	public void rotateFrontInverse() {
		swapMaterials(rightFace, 0, topFace, 2);
		swapMaterials(rightFace, 0, leftFace, 6);
		swapMaterials(rightFace, 0, bottomFace, 0);

		swapMaterials(rightFace, 3, topFace, 1);
		swapMaterials(rightFace, 3, leftFace, 3);
		swapMaterials(rightFace, 3, bottomFace, 1);

		swapMaterials(rightFace, 6, topFace, 0);
		swapMaterials(rightFace, 6, leftFace, 0);
		swapMaterials(rightFace, 6, bottomFace, 2);

		// front front
		swapMaterials(frontFace, 0, frontFace, 2);
		swapMaterials(frontFace, 0, frontFace, 8);
		swapMaterials(frontFace, 0, frontFace, 6);

		swapMaterials(frontFace, 1, frontFace, 5);
		swapMaterials(frontFace, 1, frontFace, 7);
		swapMaterials(frontFace, 1, frontFace, 3);
	}

	public void rotateRightNorm() {
		swapMaterials(topFace, 0, backFace, 0);
		swapMaterials(topFace, 0, bottomFace, 6);
		swapMaterials(topFace, 0, frontFace, 6);

		swapMaterials(frontFace, 0, topFace, 6);
		swapMaterials(frontFace, 0, backFace, 6);
		swapMaterials(frontFace, 0, bottomFace, 0);

		swapMaterials(frontFace, 3, topFace, 3);
		swapMaterials(frontFace, 3, backFace, 3);
		swapMaterials(frontFace, 3, bottomFace, 3);

		// right face
		swapMaterials(rightFace, 0, rightFace, 2);
		swapMaterials(rightFace, 0, rightFace, 8);
		swapMaterials(rightFace, 0, rightFace, 6);

		swapMaterials(rightFace, 1, rightFace, 5);
		swapMaterials(rightFace, 1, rightFace, 7);
		swapMaterials(rightFace, 1, rightFace, 3);
	}

	public void rotateRightInverse() {
		swapMaterials(topFace, 0, frontFace, 6);
		swapMaterials(topFace, 0, bottomFace, 6);
		swapMaterials(topFace, 0, backFace, 0);

		swapMaterials(frontFace, 0, bottomFace, 0);
		swapMaterials(frontFace, 0, backFace, 6);
		swapMaterials(frontFace, 0, topFace, 6);

		swapMaterials(frontFace, 3, bottomFace, 3);
		swapMaterials(frontFace, 3, backFace, 3);
		swapMaterials(frontFace, 3, topFace, 3);

		// right face
		swapMaterials(rightFace, 0, rightFace, 6);
		swapMaterials(rightFace, 0, rightFace, 8);
		swapMaterials(rightFace, 0, rightFace, 2);

		swapMaterials(rightFace, 1, rightFace, 3);
		swapMaterials(rightFace, 1, rightFace, 7);
		swapMaterials(rightFace, 1, rightFace, 5);
	}

	public void rotateLeftNorm() {
		swapMaterials(topFace, 2, frontFace, 8);
		swapMaterials(topFace, 2, bottomFace, 8);
		swapMaterials(topFace, 2, backFace, 2);

		swapMaterials(topFace, 5, frontFace, 5);
		swapMaterials(topFace, 5, bottomFace, 5);
		swapMaterials(topFace, 5, backFace, 5);

		swapMaterials(topFace, 8, frontFace, 2);
		swapMaterials(topFace, 8, bottomFace, 2);
		swapMaterials(topFace, 8, backFace, 8);

		// left front face
		swapMaterials(leftFace, 2, leftFace, 0);
		swapMaterials(leftFace, 2, leftFace, 6);
		swapMaterials(leftFace, 2, leftFace, 8);

		swapMaterials(leftFace, 1, leftFace, 3);
		swapMaterials(leftFace, 1, leftFace, 7);
		swapMaterials(leftFace, 1, leftFace, 5);
	}

	public void rotateLeftInverse() {
		swapMaterials(topFace, 2, backFace, 2);
		swapMaterials(topFace, 2, bottomFace, 8);
		swapMaterials(topFace, 2, frontFace, 8);

		swapMaterials(topFace, 5, backFace, 5);
		swapMaterials(topFace, 5, bottomFace, 5);
		swapMaterials(topFace, 5, frontFace, 5);

		swapMaterials(topFace, 8, backFace, 8);
		swapMaterials(topFace, 8, bottomFace, 2);
		swapMaterials(topFace, 8, frontFace, 2);

		// left front face
		swapMaterials(leftFace, 2, leftFace, 8);
		swapMaterials(leftFace, 2, leftFace, 6);
		swapMaterials(leftFace, 2, leftFace, 0);

		swapMaterials(leftFace, 1, leftFace, 5);
		swapMaterials(leftFace, 1, leftFace, 7);
		swapMaterials(leftFace, 1, leftFace, 3);
	}

	public void rotateBackNorm() {
		swapMaterials(topFace, 6, leftFace, 2);
		swapMaterials(topFace, 6, bottomFace, 8);
		swapMaterials(topFace, 6, rightFace, 8);

		swapMaterials(topFace, 7, leftFace, 5);
		swapMaterials(topFace, 7, bottomFace, 7);
		swapMaterials(topFace, 7, rightFace, 5);

		swapMaterials(topFace, 8, leftFace, 8);
		swapMaterials(topFace, 8, bottomFace, 6);
		swapMaterials(topFace, 8, rightFace, 2);

		// back face
		swapMaterials(backFace, 0, backFace, 2);
		swapMaterials(backFace, 0, backFace, 8);
		swapMaterials(backFace, 0, backFace, 6);

		swapMaterials(backFace, 1, backFace, 5);
		swapMaterials(backFace, 1, backFace, 7);
		swapMaterials(backFace, 1, backFace, 3);
	}

	public void rotateBackInverse() {
		swapMaterials(topFace, 6, rightFace, 8);
		swapMaterials(topFace, 6, bottomFace, 8);
		swapMaterials(topFace, 6, leftFace, 2);

		swapMaterials(topFace, 7, rightFace, 5);
		swapMaterials(topFace, 7, bottomFace, 7);
		swapMaterials(topFace, 7, leftFace, 5);

		swapMaterials(topFace, 8, rightFace, 2);
		swapMaterials(topFace, 8, bottomFace, 6);
		swapMaterials(topFace, 8, leftFace, 8);

		// back face
		swapMaterials(backFace, 0, backFace, 6);
		swapMaterials(backFace, 0, backFace, 8);
		swapMaterials(backFace, 0, backFace, 2);

		swapMaterials(backFace, 1, backFace, 3);
		swapMaterials(backFace, 1, backFace, 7);
		swapMaterials(backFace, 1, backFace, 5);
	}

	public void rotateBottonNorm() {
		swapMaterials(frontFace, 8, rightFace, 6);
		swapMaterials(frontFace, 8, backFace, 6);
		swapMaterials(frontFace, 8, leftFace, 8);

		swapMaterials(frontFace, 7, rightFace, 7);
		swapMaterials(frontFace, 7, backFace, 7);
		swapMaterials(frontFace, 7, leftFace, 7);

		swapMaterials(frontFace, 6, rightFace, 8);
		swapMaterials(frontFace, 6, backFace, 8);
		swapMaterials(frontFace, 6, leftFace, 6);

		// bottom face
		swapMaterials(bottomFace, 0, bottomFace, 6);
		swapMaterials(bottomFace, 0, bottomFace, 8);
		swapMaterials(bottomFace, 0, bottomFace, 2);

		swapMaterials(bottomFace, 1, bottomFace, 3);
		swapMaterials(bottomFace, 1, bottomFace, 7);
		swapMaterials(bottomFace, 1, bottomFace, 5);
	}

	public void rotateBottomInverse() {
		swapMaterials(frontFace, 8, leftFace, 8);
		swapMaterials(frontFace, 8, backFace, 6);
		swapMaterials(frontFace, 8, rightFace, 6);

		swapMaterials(frontFace, 7, leftFace, 7);
		swapMaterials(frontFace, 7, backFace, 7);
		swapMaterials(frontFace, 7, rightFace, 7);

		swapMaterials(frontFace, 6, leftFace, 6);
		swapMaterials(frontFace, 6, backFace, 8);
		swapMaterials(frontFace, 6, rightFace, 8);

		// bottom face
		swapMaterials(bottomFace, 0, bottomFace, 2);
		swapMaterials(bottomFace, 0, bottomFace, 8);
		swapMaterials(bottomFace, 0, bottomFace, 6);

		swapMaterials(bottomFace, 1, bottomFace, 5);
		swapMaterials(bottomFace, 1, bottomFace, 7);
		swapMaterials(bottomFace, 1, bottomFace, 3);
	}

	public void rotateMiddleVerticalNorm() {
		swapMaterials(frontFace, 1, topFace, 7);
		swapMaterials(frontFace, 1, backFace, 7);
		swapMaterials(frontFace, 1, bottomFace, 1);

		swapMaterials(frontFace, 4, topFace, 4);
		swapMaterials(frontFace, 4, backFace, 4);
		swapMaterials(frontFace, 4, bottomFace, 4);

		swapMaterials(frontFace, 7, topFace, 1);
		swapMaterials(frontFace, 7, backFace, 1);
		swapMaterials(frontFace, 7, bottomFace, 7);
	}

	public void rotateMiddleVerticalInverse() {
		swapMaterials(frontFace, 1, bottomFace, 1);
		swapMaterials(frontFace, 1, backFace, 7);
		swapMaterials(frontFace, 1, topFace, 7);

		swapMaterials(frontFace, 4, bottomFace, 4);
		swapMaterials(frontFace, 4, backFace, 4);
		swapMaterials(frontFace, 4, topFace, 4);

		swapMaterials(frontFace, 7, bottomFace, 7);
		swapMaterials(frontFace, 7, backFace, 1);
		swapMaterials(frontFace, 7, topFace, 1);
	}

	public void rotateMiddleHorizontalNorm() {
		swapMaterials(frontFace, 5, rightFace, 3);
		swapMaterials(frontFace, 5, backFace, 3);
		swapMaterials(frontFace, 5, leftFace, 5);

		swapMaterials(frontFace, 4, rightFace, 4);
		swapMaterials(frontFace, 4, backFace, 4);
		swapMaterials(frontFace, 4, leftFace, 4);

		swapMaterials(frontFace, 3, rightFace, 5);
		swapMaterials(frontFace, 3, backFace, 5);
		swapMaterials(frontFace, 3, leftFace, 3);
	}

	public void rotateMiddleHorizontalInverse() {
		swapMaterials(frontFace, 5, leftFace, 5);
		swapMaterials(frontFace, 5, backFace, 3);
		swapMaterials(frontFace, 5, rightFace, 3);

		swapMaterials(frontFace, 4, leftFace, 4);
		swapMaterials(frontFace, 4, backFace, 4);
		swapMaterials(frontFace, 4, rightFace, 4);

		swapMaterials(frontFace, 3, leftFace, 3);
		swapMaterials(frontFace, 3, backFace, 5);
		swapMaterials(frontFace, 3, rightFace, 5);
	}
	
	public void rotateCenterSliceNorm(){
		swapMaterials(topFace, 5, rightFace, 1);
		swapMaterials(topFace, 5,bottomFace, 3);
		swapMaterials(topFace, 5, leftFace, 7);
		
		swapMaterials(topFace, 4, rightFace, 4);
		swapMaterials(topFace, 4, bottomFace, 4);
		swapMaterials(topFace, 4, leftFace, 4);
		
		swapMaterials(topFace, 3, rightFace, 7);
		swapMaterials(topFace, 3, bottomFace, 5);
		swapMaterials(topFace, 3,leftFace, 1);	
	}
	
	public void rotateCenterSliceInverse(){
		swapMaterials(topFace, 5, leftFace, 7);
		swapMaterials(topFace, 5,bottomFace, 3);
		swapMaterials(topFace, 5, rightFace, 1);
		
		swapMaterials(topFace, 4, leftFace, 4);
		swapMaterials(topFace, 4, bottomFace, 4);
		swapMaterials(topFace, 4, rightFace, 4);
		
		swapMaterials(topFace, 3, leftFace, 1);
		swapMaterials(topFace, 3, bottomFace, 5);
		swapMaterials(topFace, 3,rightFace, 7);	
	}

	private void swapMaterials(ArrayList<Geometry> array1, int index1, ArrayList<Geometry> array2, int index2) {
		Material tempMaterial = array1.get(index1).getMaterial();
		array1.get(index1).setMaterial(array2.get(index2).getMaterial());
		array2.get(index2).setMaterial(tempMaterial);
	}

	public void scramble(int rotations) {
		char[] potentialRotations = { 'r', 't', 'f', 'l', 'b', 'u', 'c', 'v' };

		for (int i = 0; i < rotations; i++) {
			String keysPressed = "";

			if (Math.random() <= .5) {
				keysPressed += "x";
			}

			keysPressed += potentialRotations[(int) (Math.random() * potentialRotations.length)];

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
			case ("l"): {
				rotateLeftNorm();
			}
				break;
			case ("b"): {
				rotateBackNorm();
			}
				break;
			case ("xb"): {
				rotateBackNorm();
			}
				break;
			case ("u"): {
				rotateBottonNorm();
			}
				break;
			case ("xu"): {
				rotateBottomInverse();
			}
				break;
			case ("v"): {
				rotateMiddleVerticalNorm();
			}
				break;
			case ("xv"): {
				rotateMiddleVerticalInverse();
			}
				break;

			case ("c"): {
				rotateMiddleHorizontalNorm();
			}
				break;
			case ("xc"): {
				rotateMiddleHorizontalInverse();
			}
				break;

			}
		}
	}
	
	public Material getRandomMaterial(){
		return materials.get((int)(Math.random() * materials.size()));
	}
	
	private String getOppositeColor(String color){
		switch(color){
		case("white"): return "yellow";
		case("yellow"): return "white";

		case("blue"): return "green";
		case("green"): return "blue";
		
		case("red"): return "orange";
		case("orange"): return "red";
		
		}
		System.out.println("oppisite could not be determined");
		return null;
	}
	
	private Material getCorrespondingMaterial(String color){
		switch(color){
		case("white"): return white;
		case("yellow"): return yellow;

		case("blue"): return blue;
		case("green"): return green;
		
		case("red"): return red;
		case("orange"): return orange;
		
		}
		System.out.println("material could not be found");
		return null;
	}
	
	public void coolPatern1(){
		
	}
	public void delay(int time) {
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < time)
			endDelay = System.currentTimeMillis();
	}
}
