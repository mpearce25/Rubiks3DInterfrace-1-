package mygame;


import java.util.ArrayList;
import com.jme3.asset.AssetManager;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Cube{

	Node cubeNode = new Node();
	RelativeVector origin = new RelativeVector(0,0,0);
	ArrayList<CustomIndividualCube> cubes = new ArrayList<CustomIndividualCube>();
	
	public Cube(Vector3f originPoint, AssetManager assetManager){
		this.origin.setOriginPoint((int)originPoint.getX(), (int)originPoint.getY(), (int)originPoint.getZ());
		createCubeObject(assetManager);
		
	}
	
	private void createCubeObject(AssetManager assetManager){
		CustomIndividualCube cube1 = createSpatial(assetManager, cubeNode,  "Models/C-rwb/C-rwb.j3o", origin.getRelativeVector(2, 2, 2), 180, 90, 0);
		cubes.add(cube1);
	
		CustomIndividualCube cube2 = createSpatial(assetManager, cubeNode,  "Models/E-rw/E-rw.j3o", origin.getRelativeVector(0, 2, 2), 180, 90, 0);
		cubes.add(cube2);

		CustomIndividualCube cube3 = createSpatial(assetManager, cubeNode,  "Models/C-rwg/C-rwg.j3o", origin.getRelativeVector(-2, 2, 2), 180, 90, 0);
		cubes.add(cube3);

		CustomIndividualCube cube4 = createSpatial(assetManager, cubeNode,  "Models/E-rb/E-rb.j3o", origin.getRelativeVector(2, 0, 2), 180, 90, 0);
		cubes.add(cube4);

		CustomIndividualCube cube5 = createSpatial(assetManager, cubeNode,  "Models/S-r/S-r.j3o", origin.getRelativeVector(0, 0, 2), 180, 90, 0);
		cubes.add(cube5);

		CustomIndividualCube cube6 = createSpatial(assetManager, cubeNode,  "Models/E-rg/E-rg.j3o", origin.getRelativeVector(-2, 0, 2), 180, 90, 0);
		cubes.add(cube6);

		CustomIndividualCube cube7 = createSpatial(assetManager, cubeNode,  "Models/C-ryb/C-ryb.j3o", origin.getRelativeVector(2, -2, 2), 0, 270, 180);
		cubes.add(cube7);

		CustomIndividualCube cube8 = createSpatial(assetManager, cubeNode,  "Models/E-ry/E-ry.j3o", origin.getRelativeVector(0, -2, 2), 0, 270, 180);
		cubes.add(cube8);

		CustomIndividualCube cube9 = createSpatial(assetManager, cubeNode,  "Models/C-ryg/C-ryg.j3o", origin.getRelativeVector(-2, -2, 2), 180, 90, 0);
		cubes.add(cube9);

		/*CustomIndividualCube cube10 = createSpatial(assetManager, cubeNode,  "Models/E-bw/E-bw.j3o", origin.getRelativeVector(2, 2, 0), 0, 180, 180);
		cubes.add(cube10);

		CustomIndividualCube cube11 = createSpatial(assetManager, cubeNode,  "Models/S-w/S-w.j3o", origin.getRelativeVector(0, 2, 0), 0, 180, 180);
		cubes.add(cube11);

		CustomIndividualCube cube12 = createSpatial(assetManager, cubeNode,  "Models/E-gw/E-gw.j3o", origin.getRelativeVector(-2, 2, 0), 0, 270, 180);
		cubes.add(cube12);

		CustomIndividualCube cube13 = createSpatial(assetManager, cubeNode,  "Models/S-b/S-b.j3o", origin.getRelativeVector(2, 0, 0), 0, 180, 180);
		cubes.add(cube13);

		CustomIndividualCube cube14 = createSpatial(assetManager, cubeNode,  "Models/S-center/S-center.j3o", origin.getRelativeVector(0, 0, 0), 0, 180, 180);
		cubes.add(cube14);

		CustomIndividualCube cube15 = createSpatial(assetManager, cubeNode,  "Models/S-g/S-g.j3o", origin.getRelativeVector(-2, 0, 0), 0, 270, 180);
		cubes.add(cube15);

		CustomIndividualCube cube16 = createSpatial(assetManager, cubeNode,  "Models/E-by/E-by.j3o", origin.getRelativeVector(2, -2, 0), 0, 180, 180);
		cubes.add(cube16);

		CustomIndividualCube cube17 = createSpatial(assetManager, cubeNode,  "Models/S-y/S-y.j3o", origin.getRelativeVector(0, -2, 0), 0, 180, 180);
		cubes.add(cube17);

		CustomIndividualCube cube18 = createSpatial(assetManager, cubeNode,  "Models/E-gy/E-gy.j3o", origin.getRelativeVector(-2, -2, 0), 0, 270, 180);
		cubes.add(cube18);

		CustomIndividualCube cube19 = createSpatial(assetManager, cubeNode,  "Models/C-bow/C-bow.j3o", origin.getRelativeVector(2, 2, -2), 0, 180, 180);
		cubes.add(cube19);

		CustomIndividualCube cube20 = createSpatial(assetManager, cubeNode,  "Models/E-ow/E-ow.j3o", origin.getRelativeVector(0, 2, -2), 0, 180, 180);
		cubes.add(cube20);

		CustomIndividualCube cube21 = createSpatial(assetManager, cubeNode,  "Models/C-gwo/C-gwo.j3o", origin.getRelativeVector(-2, 2, -2), 0, 270, 180);
		cubes.add(cube21);

		CustomIndividualCube cube22 = createSpatial(assetManager, cubeNode,  "Models/E-bo/E-bo.j3o", origin.getRelativeVector(2, 0, -2), 0, 180, 180);
		cubes.add(cube22);

		CustomIndividualCube cube23 = createSpatial(assetManager, cubeNode,  "Models/S-o/S-o.j3o", origin.getRelativeVector(0, 0, -2), 0, 180, 180);
		cubes.add(cube23);

		CustomIndividualCube cube24 = createSpatial(assetManager, cubeNode,  "Models/E-go/E-go.j3o", origin.getRelativeVector(-2, 0, -2), 0, 270, 180);
		cubes.add(cube24);

		CustomIndividualCube cube25 = createSpatial(assetManager, cubeNode,  "Models/C-boy/C-boy.j3o", origin.getRelativeVector(2, -2, -2), 0, 180, 180);
		cubes.add(cube25);

		CustomIndividualCube cube26 = createSpatial(assetManager, cubeNode,  "Models/E-oy/E-oy.j3o", origin.getRelativeVector(0, -2, -2), 0, 180, 180);
		cubes.add(cube26);

		CustomIndividualCube cube27 = createSpatial(assetManager, cubeNode,  "Models/C-gyo/C-gyo.j3o", origin.getRelativeVector(-2, -2, -2), 0, 270, 180);
		cubes.add(cube27);*/
	}
	
	public ArrayList<CustomIndividualCube> getCubesArray(){
		return cubes;
	}
	public CustomIndividualCube createSpatial(AssetManager assetManager, Node node, String modelPath, Vector3f translation, float rotX, float rotY,
			float rotZ) {

		Spatial object = assetManager.loadModel(modelPath);
		object.scale(1, 1, 1);
		object.rotate(FastMath.DEG_TO_RAD * rotX, FastMath.DEG_TO_RAD * rotY, FastMath.DEG_TO_RAD * rotZ);
		object.setLocalTranslation(translation);
		//node.attachChild(object);

		CustomIndividualCube customCubeObject = new CustomIndividualCube(object);
		customCubeObject.setRotX(rotX);
		customCubeObject.setRotY(rotY);
		customCubeObject.setRotZ(rotZ);
		
		return customCubeObject;
	}
}
