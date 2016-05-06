package mygame;
import java.util.ArrayList;

import com.jme3.math.Quaternion;
import com.jme3.scene.Spatial;

public class CustomIndividualCube {

	Spatial spatialObject;
	private Boolean rotate = false;
	public ArrayList<Quaternion> rotations = new ArrayList<Quaternion>();
	
	public CustomIndividualCube(Spatial spatialObject){
		this.spatialObject = spatialObject;
	}

	public Spatial getSpatialObject() {
		return spatialObject;
	}

	public void setSpatialObject(Spatial spatialObject) {
		this.spatialObject = spatialObject;
	}

	public Boolean getRotate() {
		return rotate;
	}

	public void setRotate(Boolean rotate) {
		this.rotate = rotate;
	}
	
	public ArrayList<Quaternion> getRotationsHistory(){
		return rotations;
	}
	public void addRotation(Quaternion rotation){
		rotations.add(rotation);
	}
}
