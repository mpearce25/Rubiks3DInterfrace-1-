package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class AssetStorage {
	public static Node rootNode = null;
	public static AssetManager assetManager = null;
	public static String topFaceColor = "";
	public static String frontFaceColor = "";
	public static String leftFaceColor = "";
	public static Vector3f cubeCenter = null;
	public static Node getRootNode() {
		return rootNode;
	}
	public static void setRootNode(Node rootNode2) {
		rootNode = rootNode2;
	}
	public static AssetManager getAssetManager() {
		return assetManager;
	}
	public static void setAssetManager(AssetManager assetManager2) {
		assetManager = assetManager2;
	}
	public static String getTopFaceColor() {
		return topFaceColor;
	}
	public static void setTopFaceColor(String topFaceColor2) {
		topFaceColor = topFaceColor2;
	}
	public static String getFrontFaceColor() {
		return frontFaceColor;
	}
	public static void setFrontFaceColor(String frontFaceColor2) {
		frontFaceColor = frontFaceColor2;
	}
	public static String getLeftFaceColor() {
		return leftFaceColor;
	}
	public static void setLeftFaceColor(String leftFaceColor2) {
		leftFaceColor = leftFaceColor2;
	}
	public static Vector3f getCubeCenter() {
		return cubeCenter;
	}
	public static void setCubeCenter(Vector3f cubeCenter2) {
		cubeCenter = cubeCenter2;
	}
	
	
}
