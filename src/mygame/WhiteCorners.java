package mygame;
import java.io.IOException;

public class WhiteCorners extends Solver
{
   final static Algorithm stateCycle = new Algorithm("LDLDLDL","0011001");
   
   final static Algorithm toTopLeft  	= new Algorithm("LDL", "001");
   final static Algorithm topLeftBack 	= new Algorithm("LDLDLDL", "1000001");
   final static Algorithm topRightBack 	= new Algorithm("RDDRLDL", "0001001");
   final static Algorithm topRightFront = new Algorithm("RDRLDL", "110001");
   
   public static void solve(Rubiks cube)
   {
	  Rubiks target = new Rubiks();
      solve(cube, target);
      System.out.println("White corners done!");
   }
   
   public static void solve(Rubiks cube, Rubiks target)
   {
	  try{
      solvePiece(cube, target, "blue");
      solvePiece(cube, target, "red");
      solvePiece(cube, target, "green");
      solvePiece(cube, target, "orange");
	  } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
	  }
      System.out.println("White corners done!");
   }
   
   public static int findPiece(Rubiks cube, char piece1, char piece2, char pieceT) throws IOException
   {
	   
	   boolean ts1;
	   boolean ts2;
	   boolean ts3;
	   
	   ts1 = cube.getU(6) == pieceT && cube.getF(0) == piece1 && cube.getL(2) == piece2;
	   ts2 = cube.getU(6) == piece1 && cube.getF(0) == piece2 && cube.getL(2) == pieceT;
	   ts3 = cube.getU(6) == piece2 && cube.getF(0) == pieceT && cube.getL(2) == piece1;
	   if (ts1 || ts2 || ts3)
		   return 0;
	   ts1 = cube.getU(0) == pieceT && cube.getL(0) == piece1 && cube.getB(2) == piece2;
	   ts2 = cube.getU(0) == piece1 && cube.getL(0) == piece2 && cube.getB(2) == pieceT;
	   ts3 = cube.getU(0) == piece2 && cube.getL(0) == pieceT && cube.getB(2) == piece1;
	   if (ts1 || ts2 || ts3)
		   return 1;
	   ts1 = cube.getU(2) == pieceT && cube.getB(0) == piece1 && cube.getR(2) == piece2;
	   ts2 = cube.getU(2) == piece1 && cube.getB(0) == piece2 && cube.getR(2) == pieceT;
	   ts3 = cube.getU(2) == piece2 && cube.getB(0) == pieceT && cube.getR(2) == piece1;
	   if (ts1 || ts2 || ts3)
		   return 2;
	   ts1 = cube.getU(8) == pieceT && cube.getR(0) == piece1 && cube.getF(2) == piece2;
	   ts2 = cube.getU(8) == piece1 && cube.getR(0) == piece2 && cube.getF(2) == pieceT;
	   ts3 = cube.getU(8) == piece2 && cube.getR(0) == pieceT && cube.getF(2) == piece1;
	   if (ts1 || ts2 || ts3)
		   return 3;
	   
	   for (int k = 0; k < 4; k++)
	   {
		   ts1 = cube.getF(6) == pieceT && cube.getD(0) == piece1 && cube.getL(8) == piece2;
		   ts2 = cube.getF(6) == piece1 && cube.getD(0) == piece2 && cube.getL(8) == pieceT;
		   ts3 = cube.getF(6) == piece2 && cube.getD(0) == pieceT && cube.getL(8) == piece1;
		   if (ts1 || ts2 || ts3)
			   return 4;
		   cube.D(0);
	   }
	   System.out.println("Could not find corner piece");
	   return -1;
	   
   }
   
   public static void pieceToTop(Rubiks cube, Rubiks target, int num) throws IOException
   {
	   switch (num)
	   {
	       case 0 : break;
	       case 1 : cube.algorithm(topLeftBack); break;
	       case 2 : cube.algorithm(topRightBack); break;
	       case 3 : cube.algorithm(topRightFront); break;
	       case 4 : cube.algorithm(toTopLeft); break;
		   
	   }
	   while (!(cube.getU(6) == target.getU(6)))
	   {
		   cube.algorithm(stateCycle);
	   }
   }
   
   public static void solvePiece(Rubiks cube, Rubiks target, String face) throws IOException
   {
	   cube.setFace(face, "white");
	   target.setFace(face, "white");
	   pieceToTop(cube, target, findPiece(cube, target.getF(0), target.getL(2), target.getU(6)));
   }
}
