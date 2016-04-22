package mygame;

import com.jme3.scene.Spatial;

public class CustomIndividualCube {

	Spatial spatialObject;
	float rotX;
	float rotY;
	float rotZ;
	private Boolean rotate = false;
	
	
	public CustomIndividualCube(Spatial spatialObject){
		this.spatialObject = spatialObject;
	}
	
	public Spatial getSpatialObject(){
		return spatialObject;
		
	}
	
	public void setRotate(Boolean rotate){
		this.rotate = rotate;
	}
	public Boolean getRotate(){
		return rotate;
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
