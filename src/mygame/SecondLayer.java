package mygame;
import java.io.IOException;

public class SecondLayer extends Solver
{
   final static Algorithm flip = new Algorithm("LULUFUF-U-LULUFUF", "1000011-0-1000011");
   
   final static Algorithm top    		= new Algorithm("ULULUFUF", "11000011");
   final static Algorithm leftBack		= new Algorithm("X-LULUFUF-XU-LULUFUF","1-1000011-00-1000011");
   final static Algorithm rightBack    	= new Algorithm("XX-LULUFUF-XXU-LULUFUF","00-1000011-000-1000011");
   final static Algorithm rightFront    = new Algorithm("X-LULUFUF-XU-LULUFUF","0-1000011-10-1000011");

   
   public static void solve(Rubiks cube)
   {
	   Rubiks target = new Rubiks();
	   solve(cube, target);
	   System.out.println("Second layer done!");
   }
   
   public static void solve(Rubiks cube, Rubiks target)
   {
	   try{
	   solvePiece(cube, target, "red");
	   solvePiece(cube, target, "blue");
	   solvePiece(cube, target, "orange");
	   solvePiece(cube, target, "green");
	   } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }
	   System.out.println("Second layer done!");
   }
   
   public static int findPiece(Rubiks cube, char piece1, char piece2) throws IOException
   {
	   
	   boolean ts1;
	   boolean ts2;
	   
	   ts1 = cube.getF(3) == piece1 && cube.getL(5) == piece2;
	   ts2 = cube.getF(3) == piece2 && cube.getL(5) == piece1;
	   if (ts1 || ts2)
		   return 0;
	   ts1 = cube.getL(3) == piece1 && cube.getB(5) == piece2;
	   ts2 = cube.getL(3) == piece2 && cube.getB(5) == piece1;
	   if (ts1 || ts2)
		   return 1;
	   ts1 = cube.getB(3) == piece1 && cube.getR(5) == piece2;
	   ts2 = cube.getB(3) == piece2 && cube.getR(5) == piece1;
	   if (ts1 || ts2)
		   return 2;
	   ts1 = cube.getR(3) == piece1 && cube.getF(5) == piece2;
	   ts2 = cube.getR(3) == piece2 && cube.getF(5) == piece1;
	   if (ts1 || ts2)
		   return 3;
	   
	   for (int k = 0; k < 4; k++)
	   {
		   ts1 = cube.getF(1) == piece1 && cube.getU(7) == piece2;
		   ts2 = cube.getF(1) == piece2 && cube.getU(7) == piece1;
		   if (ts1 || ts2)
			   return 4;
		   cube.U(0);
	   }
	   System.out.println("Could not find edge piece for second layer");
	   return -1;
   }
   
   public static void pieceToPlace(Rubiks cube, Rubiks target, int num) throws IOException
   {
	   switch (num)
	   {
	   		case 0 : break;
	   		case 1 : cube.algorithm(leftBack); break;
	   		case 2 : cube.algorithm(rightBack); break;
	   		case 3 : cube.algorithm(rightFront); break;
	   		case 4 : cube.algorithm(top); break;
	   }
	   if (!(cube.getF(3) == target.getF(3) && cube.getL(5) == target.getL(5)) )
	   {
		   cube.algorithm(flip);
	   }
   }
   
   public static void solvePiece(Rubiks cube, Rubiks target, String face) throws IOException
   {
	   cube.setFace(face, "yellow");
	   target.setFace(face, "yellow");
	   pieceToPlace(cube, target, findPiece(cube, target.getF(3), target.getL(5)));
   }
}
