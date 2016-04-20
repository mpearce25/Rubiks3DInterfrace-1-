package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Utility extends SimpleApplication{

	public Spatial createSpatial(Node node, String modelPath, Vector3f translation, float rotX, float rotY,
			float rotZ) {

		Spatial object = assetManager.loadModel(modelPath);
		object.scale(1, 1, 1);
		object.rotate(FastMath.DEG_TO_RAD * rotX, FastMath.DEG_TO_RAD * rotY, FastMath.DEG_TO_RAD * rotZ);
		object.setLocalTranslation(translation);
		node.attachChild(object);

		return object;
	}

	@Override
	public void simpleInitApp() {
		// TODO Auto-generated method stub
		
	}
}
