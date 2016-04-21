package mygame;

import com.jme3.scene.Spatial;

public class CustomIndividualCube {

	Spatial spatialObject;
	private float rotX;
	private float rotY;
	private float rotZ;
	public CustomIndividualCube(Spatial spatialObject){
		this.spatialObject = spatialObject;
	}
	
	public Spatial getSpatialObject(){
		return spatialObject;
		
	}

	public float getRotX() {
		return rotX;
	}

	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	public float getRotZ() {
		return rotZ;
	}

	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	
	
	
}
