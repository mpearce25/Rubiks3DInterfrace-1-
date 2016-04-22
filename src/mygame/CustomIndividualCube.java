package mygame;

import com.jme3.scene.Spatial;

public class CustomIndividualCube {

	Spatial spatialObject;
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
}
