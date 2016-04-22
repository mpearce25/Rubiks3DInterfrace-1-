package mygame;

import com.jme3.scene.Spatial;

public class CustomIndividualCube {

	Spatial spatialObject;
	float rotX = 0;
	float rotY= 0;
	float rotZ= 0;
	private Boolean rotate = false;
	
	
	public CustomIndividualCube(Spatial spatialObject, Float rotX, Float rotY, Float rotZ){
		this.spatialObject = spatialObject;
		//this.rotX = rotX;
		//this.rotY = rotY;
		//this.rotZ = rotZ;
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
