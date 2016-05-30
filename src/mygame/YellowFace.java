package mygame;
import java.io.IOException;

public class YellowFace extends Solver
{
   final static Algorithm normCorners = new Algorithm("R-U-R-U-R-UU-R", "0-0-1-0-0-00-1");
   final static Algorithm invCorners  = new Algorithm("RUURURUR", "00011010");
   
   public static void solve(Rubiks cube)
   {
	   try{
	   cube.setFace("blue", "yellow");
	   while (findState(cube) != 0)
		   doAlgorithms(cube, findState(cube));
	   } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }
   }
   
   public static int findState(Rubiks cube) throws IOException
   {
	   char y = 'y';
	   for (int k = 0; k < 4; k++)
	   {
		   if (  (cube.getU(0) == y) && (cube.getU(2) == y) &&
			     (cube.getU(6) == y) && (cube.getU(8) == y) )
				   return 0;
		   else if (cube.getR(0) == y && cube.getL(2) == y)
			   return 1;
		   else if (cube.getU(6) == y && cube.getR(0) == y &&
				    cube.getB(0) == y && cube.getL(0) == y)
			   return 1;
		   else if (cube.getU(6) == y && cube.getF(2) == y &&
				    cube.getB(2) == y && cube.getR(2) == y)
			   return 1;
		   else if (cube.getU(0) == y && cube.getU(8) == y &&
				    cube.getL(2) == y && cube.getB(0) == y)
			   return 1;
		   else if (cube.getU(0) == y && cube.getU(2) == y &&
				    cube.getF(2) == y && cube.getF(0) == y)
			   return 1;
		   cube.U(0);
	   }
	   
	   
	   System.out.println("There's something rotten in Denmark");
	   return -1;   
   }
   
   public static void doAlgorithms(Rubiks cube, int state) throws IOException
   {
	   switch (state)
	   {
	   case 0  : break;
	   case 1  : cube.algorithm(normCorners); break;
	   case 2  : cube.algorithm(invCorners); break;
	   case -1 : break;

	   }
   }
   

}
