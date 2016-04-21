package mygame;

import com.jme3.scene.Spatial;

public class CustomIndividualCube {

	Spatial spatialObject;
	private int rotX;
	private int rotY;
	private int rotZ;
	public CustomIndividualCube(Spatial spatialObject){
		this.spatialObject = spatialObject;
	}
	
	public Spatial getSpatialObject(){
		return spatialObject;
		
	}

	public int getRotX() {
		return rotX;
	}

	public void setRotX(int rotX) {
		this.rotX = rotX;
	}

	public int getRotY() {
		return rotY;
	}

	public void setRotY(int rotY) {
		this.rotY = rotY;
	}

	public int getRotZ() {
		return rotZ;
	}

	public void setRotZ(int rotZ) {
		this.rotZ = rotZ;
	}
	
	
}
