package mygame;
import java.util.*;
import java.io.IOException;

public class Solver
{
   
   public static void solve(Rubiks cube) throws IOException
   {
	   RubiksNoExtend target = new RubiksNoExtend();
	   solve(cube, target);
   }
   
   public static void solve(Rubiks cube, RubiksNoExtend target) throws IOException
   {
	   String f = target.getFaceFront();
	   String t = target.getFaceTop();
	   System.out.println("Starting solve!");
	   WhiteCross.solve(cube);
	   WhiteCorners.solve(cube);
	   SecondLayer.solve(cube);
	   YellowCross.solve(cube);
	   //YellowFace.solve(cube);
	   //FinalLayer.solve(cube);
	   target.setFace(f, t);
   }
   
   
   public static void shuffleCube(Rubiks cube, int turns, boolean middles, boolean output) throws IOException
   {
      int face;
      int direction;
      String temp = "";
      Random rand = new Random();
      int cases = 6;
      if (middles)
    	  cases = 9;
      for (int k = 0; k < turns; k++)
      {
    	
    	 face = rand.nextInt(cases);
         
         direction = rand.nextInt(2);
         
         switch (face)
         {
            case 0 : cube.F(direction); temp += "F" + direction + " "; break;
            case 1 : cube.B(direction); temp += "B" + direction + " ";break;
            case 2 : cube.R(direction); temp += "R" + direction + " ";break;
            case 3 : cube.L(direction); temp += "L" + direction + " ";break;
            case 4 : cube.U(direction); temp += "U" + direction + " ";break;
            case 5 : cube.D(direction); temp += "D" + direction + " ";break;
            case 6 : cube.X(direction); temp += "X" + direction + " ";break;
            case 7 : cube.Y(direction); temp += "Y" + direction + " ";break;
            case 8 : cube.Z(direction); temp += "Z" + direction + " ";break;
         }
      }
      //System.out.println(temp);
      if (output)
         System.out.println(turns + " random turns complete.");
   }
}
