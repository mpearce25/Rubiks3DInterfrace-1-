package mygame;
import java.util.ArrayList;
import java.util.Collections;

import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.scene.Spatial;

public class CustomIndividualCube {

	Spatial spatialObject;
	private Boolean rotate = false;
	public ArrayList<Quaternion> rotations = new ArrayList<Quaternion>();
	int rotX;
	int rotY;
	int rotZ;
	private ArrayList<String> colorOrientation = new ArrayList<String>();
	
	
	
	public CustomIndividualCube(Spatial spatialObject){
		this.spatialObject = spatialObject;
		colorOrientation.add("yellow");
		colorOrientation.add("green");
		colorOrientation.add("red");
		colorOrientation.add("blue");
		colorOrientation.add("orange");
		colorOrientation.add("white");
		
		rotX = 0;
		rotY = 0;
		rotZ = 0;
	}
	public CustomIndividualCube(Spatial spatialObject, int rotX, int rotY, int rotZ){
		this.spatialObject = spatialObject;
		colorOrientation.add("yellow");
		colorOrientation.add("green");
		colorOrientation.add("red");
		colorOrientation.add("blue");
		colorOrientation.add("orange");
		colorOrientation.add("white");
		
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
	}
	
	public ArrayList<String> getColorOrientation(){
		return colorOrientation;
	}
	
	
	public void frontNormalRotateColors(){
		Collections.swap(colorOrientation, 0, 4);
		Collections.swap(colorOrientation, 0, 5);
		Collections.swap(colorOrientation, 0, 2);
		//System.out.println(colorOrientation);
	}
	public void frontInverseRotateColors(){
		Collections.swap(colorOrientation, 0, 2);
		Collections.swap(colorOrientation, 0, 5);
		Collections.swap(colorOrientation, 0, 4);
		//System.out.println(colorOrientation);
		
		//System.out.println(fullCubeMatch(this.colorOrientation));
	}
	
	
	public void topNormalRotateColors(){
		Collections.swap(colorOrientation, 1, 2);
		Collections.swap(colorOrientation, 1, 3);
		Collections.swap(colorOrientation, 1, 4);
		//System.out.println(colorOrientation);
	}
	public void topInverseRotateColors(){
		Collections.swap(colorOrientation, 1, 4);
		Collections.swap(colorOrientation, 1, 3);
		Collections.swap(colorOrientation, 1, 2);
		//System.out.println(colorOrientation);
	}
	
	
	public void rightNormalRotateColors(){
		Collections.swap(colorOrientation, 1, 0);
		Collections.swap(colorOrientation, 1, 3);
		Collections.swap(colorOrientation, 1, 5);
		//System.out.println(colorOrientation);
	}
	public void rightInverseRotateColors(){
		Collections.swap(colorOrientation, 1, 5);
		Collections.swap(colorOrientation, 1, 3);
		Collections.swap(colorOrientation, 1, 0);
		//System.out.println(colorOrientation);
	}
	
	
	
	public void matchOrientation(ArrayList<String> colorOrientationToMatch){
		
		Boolean fullMatch = false;
		if(!fullCubeMatch(colorOrientationToMatch)){
			
			matchTopBot(colorOrientationToMatch);
			//System.out.println("full cube match? " + fullCubeMatch(colorOrientationToMatch));
			}
			
		/*for(int i = 0; i < 3; i ++){
			if (!fullMatch){
			
				this.spatialObject.rotate(0, 90 * FastMath.DEG_TO_RAD,0);
				topInverseRotateColors();
			}
			
			if(fullCubeMatch(colorOrientation)){
				fullMatch = true;
				System.out.println("full cube match found");
			}
		} /*///side matching

	
	}
	
	private void matchTopBot(ArrayList<String> colorOrientationToMatch){
		//add in database updates
		if(!this.colorOrientation.get(0).equals(colorOrientationToMatch.get(0))){
		
			//System.out.println(findMatchLocation(colorOrientation, this.colorOrientation.get(0)));
			switch(findMatchLocation(colorOrientationToMatch.get(0))){ //flipping these fies things
			case(-1):{
				System.out.println("match location not found");
			}
			case(1):{
				this.spatialObject.rotate(FastMath.DEG_TO_RAD * 90, 0,0);
				rightNormalRotateColors();
				//System.out.println("Does top match: " + singleColorMatchTest(colorOrientationToMatch, 0));	
				//System.out.println("hey");
			}
			break;
			case(2):{
				this.spatialObject.rotate(0,0,FastMath.DEG_TO_RAD * -90);
				frontNormalRotateColors();
				//System.out.println("Does top match: " + singleColorMatchTest(colorOrientationToMatch, 0));	
			}
			break;
			case(3):{
				//System.out.println(colorOrientationToMatch.get(0) + " " + this.colorOrientation.get(3));
				this.spatialObject.rotate(FastMath.DEG_TO_RAD * -90,0, 0);
				rightInverseRotateColors();
				//System.out.println("Does top match: " + singleColorMatchTest(colorOrientationToMatch, 0));	
				
			}
			break;
			case(4):{
				this.spatialObject.rotate(0,0,FastMath.DEG_TO_RAD * 90);
				frontInverseRotateColors();
				//System.out.println("Does top match: " + singleColorMatchTest(colorOrientationToMatch, 0));	
			}
			break;
			
			case(5):{
				this.spatialObject.rotate(FastMath.DEG_TO_RAD * 180,0, 0);
				rightNormalRotateColors();
				rightNormalRotateColors();//not a typo having this twice
				//System.out.println("Does top match: " + singleColorMatchTest(colorOrientationToMatch, 0));	
			}
			break;
			
			}
		}
		System.out.println("Does top match: " + singleColorMatchTest(colorOrientationToMatch, 0));	
	}
	
	public Boolean singleColorMatchTest(ArrayList<String> colorOrientationToMatch, int index){
		System.out.println(colorOrientationToMatch.get(index) + "                   " + colorOrientationToMatch.get(index).toString());
		return colorOrientationToMatch.get(index).toString().equals(this.colorOrientation.get(index).toString());
	}
	public int findMatchLocation(String color){
		int matchLocation = -1;
		for (int i = 0; i < 6; i++){
			//System.out.println(color + "     " + this.colorOrientation.get(i));
			if(color.equals(this.colorOrientation.get(i))){
				matchLocation = i;
			}
		}
		if (matchLocation == -1){
			//System.out.println("no match location found");
		}
		return matchLocation;
	}
	
	public Boolean fullCubeMatch(ArrayList<String> colorOrientation){
		Boolean fullMatch = true;
		
		for(int i = 0; i < 6; i++){
			if(!colorOrientation.get(i).equals(this.colorOrientation.get(i))){
				fullMatch = false;
			}
		}
		return fullMatch;
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
	
	public int getRotX() {
		return rotX;
	}

	public void setRotX(int rotX) {
		this.rotX = rotX;
		if (this.rotX >= 360){
			this.rotX -= 360;
		}
	}

	public int getRotY() {
		return rotY;
		
	}

	public void setRotY(int rotY) {
		this.rotY = rotY;
		if (this.rotY >= 360){
			this.rotY -= 360;
		}
	}

	public int getRotZ() {
		return rotZ;
	}

	public void setRotZ(int rotZ) {
		this.rotZ = rotZ;
		if (this.rotZ >= 360){
			this.rotZ -= 360;
		}
	}
	
	
}
