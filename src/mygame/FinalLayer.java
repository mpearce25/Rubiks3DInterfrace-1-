package mygame;
import java.io.IOException;

public class FinalLayer extends Solver
{
   final static Algorithm corners   = new Algorithm("RFRBBRFRBBRR", "101000110000");
   final static Algorithm edge = new Algorithm("FFULRFFLRUFF", "001010010100");
   
   public static void solve(Rubiks cube)
   {
	   try{
	   cube.setFace("blue", "yellow");
	   cornerAction(cube, cornerState(cube));
	   middles(cube);
       } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }
      
   }
   
   public static int cornerState(Rubiks cube) throws IOException
   {
	   if ( (cube.getF(0) == cube.getF(2) && cube.getL(0) == cube.getL(2) &&
			   cube.getB(0) == cube.getB(2) && cube.getR(0) == cube.getR(2)))
		   return 0;
	   if (!(cube.getF(0) == cube.getF(2) || cube.getL(0) == cube.getL(2) ||
			   cube.getB(0) == cube.getB(2) || cube.getR(0) == cube.getR(2)))
		   return 1;
	   for (int k = 0; k < 4; k++)
	   {
		   if (cube.getB(0) == cube.getB(2))
			   return 2;
		   cube.U(0);
	   }
	   System.out.println("EEEKKK");
	   return -1;
	   
   }
   
   public static void cornerAction(Rubiks cube, int state) throws IOException
   {
	   switch (state)
	   {
	   case 0 : break;
	   case 1 : cube.algorithm(corners); cube.U(0); cube.algorithm(corners); break;
	   case 2 : cube.algorithm(corners); break;
	   }
	   while (!(cube.getF(0) == cube.getF(4)))
		   cube.U(0);
   }
   
   public static void middles(Rubiks cube) throws IOException
   {
	   if (!( cube.getF(1) == cube.getF(4) || cube.getL(1) == cube.getL(4) ||
			  cube.getB(1) == cube.getB(4) || cube.getR(1) == cube.getR(4)))
		   cube.algorithm(edge);
	   for (int k = 0; k < 4; k++)
	   {
		   if (cube.getB(1) == cube.getB(0))
		   {
			   while (!(cube.getF(1) == cube.getF(4)))
			   {
				   cube.algorithm(edge);
			   }
			   break;
		   }
		   cube.rotateCubeX(0);
	   }
   }

}


