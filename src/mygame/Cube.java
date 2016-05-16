package mygame;


import java.util.ArrayList;
import com.jme3.asset.AssetManager;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Cube{

	Node cubeNode = new Node();
	RelativeVector origin = new RelativeVector(0,0,0);
	public ArrayList<CustomIndividualCube> cubes = new ArrayList<CustomIndividualCube>();
	
	
	
	public ArrayList<CustomIndividualCube> getCubes() {
		return cubes;
	}


	public Cube(AssetManager assetManager){
		//cube 0 = top right corner - red blue white
		//front slice cubes 0 - 8
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, 2, 2), 0, 270, 180));
		//cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, 2, 2), 180, 90, 0));
		//cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, 2, 2), 180, 90, 0));
		
		/*cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, 0, 2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, 0, 2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, 0, 2), 180, 90, 0));
		
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, -2, 2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, -2, 2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, -2, 2), 180, 90, 0));
		
		//mid slice cubes 9 - 17
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, 2, 0), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, 2, 0), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, 2, 0), 180, 90, 0));
		
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, 0, 0), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, 0, 0), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, 0, 0), 180, 90, 0));
		
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, -2, 0), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, -2, 0), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, -2, 0), 180, 90, 0));
		
		//back slive cubes 18-26
		
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, 2, -2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, 2, -2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, 2, -2), 180, 90, 0));
		
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, 0, -2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, 0, -2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, 0, -2), 180, 90, 0));
		
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(2, -2, -2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(0, -2, -2), 180, 90, 0));
		cubes.add(createSpatial(assetManager, cubeNode,  "Models/masterCube/masterCube.j3o", origin.getRelativeVector(-2, -2, -2), 180, 90, 0));*/
		
	}
	
	
	
	public static CustomIndividualCube createSpatial(AssetManager assetManager, Node node, String modelPath, Vector3f translation, float rotX, float rotY,
			float rotZ) {

		Spatial object = assetManager.loadModel(modelPath);
		object.scale(1, 1, 1);	
		object.setLocalTranslation(translation);
		//Quaternion q = new Quaternion
		//object.setLocalRotation(new Quaternion().fromAngles(rotX * FastMath.DEG_TO_RAD, rotY* FastMath.DEG_TO_RAD, rotZ* FastMath.DEG_TO_RAD));
		
		CustomIndividualCube customCubeObject = new CustomIndividualCube(object);
		
		//Quaternion q = new Quaternion();
		//q.fromAngles(rotX * FastMath.DEG_TO_RAD, rotY * FastMath.DEG_TO_RAD, rotZ * FastMath.DEG_TO_RAD);
		//object.rotate(q);
		//object.setLocalRotation(q);

		//System.out.println(FastMath.DEG_TO_RAD);
		return customCubeObject;
	}
}
