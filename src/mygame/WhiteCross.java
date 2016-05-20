package mygame;
 import java.io.IOException;

public class WhiteCross extends Solver
{
   final static Algorithm topFlip 		= new Algorithm("FRDRFF", "011000");
   
   final static Algorithm topLeft 		= new Algorithm("LLDFF", "00000");
   final static Algorithm topRight  	= new Algorithm("RRDFF", "00100");
   final static Algorithm topBack 		= new Algorithm("BBDDFF", "000000");
   final static Algorithm frontLeft   	= new Algorithm("F", "0");
   final static Algorithm frontBottom 	= new Algorithm("FF", "00");
   
   public static void solve(Rubiks cube)
   {
	   try{
		      RubiksNoExtend target = new RubiksNoExtend();
		      solve(cube, target);
		      
			  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			  }
		      System.out.println("White cross done!");
   }
   
   public static void solve(Rubiks cube, Rubiks target)
   {
	   try{
		      solvePiece(cube, target, "blue");
		      solvePiece(cube, target,  "red");
		      solvePiece(cube, target, "green");
		      solvePiece(cube, target, "orange");
		      
			  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			  }
		      System.out.println("White cross done!");
   }
   
   public static int findPiece(Rubiks cube, char pieceF, char pieceT) throws IOException
   {
	   
	   boolean ts1;
	   boolean ts2;
	   
	   ts1 = cube.getU(7) == pieceT   && cube.getF(1) == pieceF;
	   ts2 = cube.getU(7) == pieceF && cube.getF(1) == pieceT;
	   if (ts1 || ts2)
		   return 0;
	   ts1 = cube.getU(3) == pieceT   && cube.getL(1) == pieceF;
	   ts2 = cube.getU(3) == pieceF && cube.getL(1) == pieceT;
	   if (ts1 || ts2)
		   return 1;
	   ts1 = cube.getU(1) == pieceT   && cube.getB(1) == pieceF;
	   ts2 = cube.getU(1) == pieceF && cube.getB(1) == pieceT;
	   if (ts1 || ts2)
		   return 2;
	   ts1 = cube.getU(5) == pieceT   && cube.getR(1) == pieceF;
	   ts2 = cube.getU(5) == pieceF && cube.getR(1) == pieceT;
	   if (ts1 || ts2)
		   return 3;
	   
	   for (int k = 0; k < 4; k++)
	   {
		   ts1 = cube.getF(3) == pieceT   && cube.getL(5) == pieceF;
		   ts2 = cube.getF(3) == pieceF && cube.getL(5) == pieceT;
		   if (ts1 || ts2)
			   return 4;
		   ts1 = cube.getF(7) == pieceT   && cube.getD(1) == pieceF;
		   ts2 = cube.getF(7) == pieceF && cube.getD(1) == pieceT;
		   if (ts1 || ts2)
			   return 5;
		   cube.X(0);
		   cube.D(1);
	   }
	   System.out.println("Could not find piece");
	   return -1;
   }
   
   public static void pieceToTop(Rubiks cube, Rubiks target, int num) throws IOException
   {
	   switch (num)
	   {
	       case 0 : break;
	       case 1 : cube.algorithm(topLeft); break;
	       case 2 : cube.algorithm(topBack); break;
	       case 3 : cube.algorithm(topRight); break;
	       case 4 : cube.algorithm(frontLeft); break;
	       case 5 : cube.algorithm(frontBottom); break;
		   
	   }
	   if (!(cube.getU(7) == target.getU(7)))
	   {
		   cube.algorithm(topFlip);
	   }
   }
   
   public static void solvePiece(Rubiks cube, Rubiks target, String face) throws IOException
   {
	   cube.setFace(face, "white"); 
	   target.setFace(face, "white");
	   pieceToTop(cube, target, findPiece(cube, target.getF(1), target.getU(7) ));
	   for (int k = 0; k < 4; k++)
	   {
		   cube.X(0);
		   if (cube.getF(4) == target.getF(4))
			   break;
	   }
   }
}
