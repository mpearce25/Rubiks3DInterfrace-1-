package mygame;

import com.jme3.math.Vector3f;

public class RelativeVector {

	Vector3f baseVector = new Vector3f(0,0,0);
	int baseVectorX = 0;
	int baseVectorY = 0;
	int baseVectorZ = 0;
	
	public RelativeVector(int x, int y, int z){
		this.baseVectorX = x;
		this.baseVectorY = y;
		this.baseVectorZ = z;
	}
	public RelativeVector(Vector3f vector){
		this.baseVectorX = (int)vector.getX();
		this.baseVectorY = (int)vector.getY();
		this.baseVectorZ = (int)vector.getZ();
	}
	
	public void setOriginPoint(int x, int y, int z){
		baseVectorX = x;
		baseVectorY = y;
		baseVectorZ = z;
	}
	public Vector3f getRelativeVector(int x, int y, int z){
		return new Vector3f(baseVectorX + x, baseVectorY + y, baseVectorZ + z);
	}
	public Vector3f getOffset(int x, int y, int z){
		return new Vector3f(baseVectorX + x, baseVectorY + y, baseVectorZ + z);
	}
}
