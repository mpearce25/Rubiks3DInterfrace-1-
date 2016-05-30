package mygame;
import java.io.IOException;

public class YellowCross extends Solver
{
   final static Algorithm curve   = new Algorithm("FURURF", "000111");
   final static Algorithm line    = new Algorithm("FRURUF", "000111");
   
   public static void solce(Rubiks cube)
   {
	   Rubiks target = new Rubiks();
	   solve(cube,target);
   }
   
   public static void solve(Rubiks cube, Rubiks target)
   {
	   try{
	   cube.setFace("blue", "yellow");
	   target.setFace("blue",  "yellow");
	   while(findState(cube) != 0){
		   doAlgorithms(cube, findState(cube));
		   System.out.println("error here?");
	   }
	   } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	   }
   }
   
   public static int findState(Rubiks cube) throws IOException
   {
	   if ( ((cube.getU(1) == cube.getU(1) && cube.getB(1) == cube.getB(1)) ||
			 (cube.getU(1) == cube.getU(3) && cube.getB(1) == cube.getL(1)) ||
			 (cube.getU(1) == cube.getU(5) && cube.getB(1) == cube.getR(1)) ||
			 (cube.getU(1) == cube.getU(7) && cube.getB(1) == cube.getF(1)))&&
			
		    ((cube.getU(3) == cube.getU(1) && cube.getL(1) == cube.getB(1)) ||
		     (cube.getU(3) == cube.getU(3) && cube.getL(1) == cube.getL(1)) ||
		     (cube.getU(3) == cube.getU(5) && cube.getL(1) == cube.getR(1)) ||
			 (cube.getU(3) == cube.getU(7) && cube.getL(1) == cube.getF(1)))&&
			
		    ((cube.getU(5) == cube.getU(1) && cube.getR(1) == cube.getB(1)) ||
		     (cube.getU(5) == cube.getU(3) && cube.getR(1) == cube.getL(1)) ||
			 (cube.getU(5) == cube.getU(5) && cube.getR(1) == cube.getR(1)) ||
			 (cube.getU(5) == cube.getU(7) && cube.getR(1) == cube.getF(1)))&&
					
		    ((cube.getU(7) == cube.getU(1) && cube.getF(1) == cube.getB(1)) ||
		     (cube.getU(7) == cube.getU(3) && cube.getF(1) == cube.getL(1)) ||
			 (cube.getU(7) == cube.getU(5) && cube.getF(1) == cube.getR(1)) ||
			 (cube.getU(7) == cube.getU(7) && cube.getF(1) == cube.getF(1))) )
	   {
		   return 0;
	   }
	   
	   if(!(((cube.getU(1) == cube.getU(1) && cube.getB(1) == cube.getB(1)) ||
			 (cube.getU(1) == cube.getU(3) && cube.getB(1) == cube.getL(1)) ||
			 (cube.getU(1) == cube.getU(5) && cube.getB(1) == cube.getR(1)) ||
			 (cube.getU(1) == cube.getU(7) && cube.getB(1) == cube.getF(1)))||
				
		    ((cube.getU(3) == cube.getU(1) && cube.getL(1) == cube.getB(1)) ||
			 (cube.getU(3) == cube.getU(3) && cube.getL(1) == cube.getL(1)) ||
			 (cube.getU(3) == cube.getU(5) && cube.getL(1) == cube.getR(1)) ||
		     (cube.getU(3) == cube.getU(7) && cube.getL(1) == cube.getF(1)))||
				
		    ((cube.getU(5) == cube.getU(1) && cube.getR(1) == cube.getB(1)) ||
			 (cube.getU(5) == cube.getU(3) && cube.getR(1) == cube.getL(1)) ||
	    	 (cube.getU(5) == cube.getU(5) && cube.getR(1) == cube.getR(1)) ||
		     (cube.getU(5) == cube.getU(7) && cube.getR(1) == cube.getF(1)))||
						
		    ((cube.getU(7) == cube.getU(1) && cube.getF(1) == cube.getB(1)) ||
		 	 (cube.getU(7) == cube.getU(3) && cube.getF(1) == cube.getL(1)) ||
		     (cube.getU(7) == cube.getU(5) && cube.getF(1) == cube.getR(1)) ||
			 (cube.getU(7) == cube.getU(7) && cube.getF(1) == cube.getF(1)))))
	   {
		   return 1;
	   }
	   for (int k = 0; k < 4; k++)
	   {
		   
		   if (((cube.getU(3) == cube.getU(1) && cube.getL(1) == cube.getB(1)) ||
			    (cube.getU(3) == cube.getU(3) && cube.getL(1) == cube.getL(1)) ||
				(cube.getU(3) == cube.getU(5) && cube.getL(1) == cube.getR(1)) ||
				(cube.getU(3) == cube.getU(7) && cube.getL(1) == cube.getF(1))) )
		   {
			   if (((cube.getU(1) == cube.getU(1) && cube.getB(1) == cube.getB(1)) ||
					(cube.getU(1) == cube.getU(3) && cube.getB(1) == cube.getL(1)) ||
					(cube.getU(1) == cube.getU(5) && cube.getB(1) == cube.getR(1)) ||
					(cube.getU(1) == cube.getU(7) && cube.getB(1) == cube.getF(1))) )
			   {
				   return 2;
			   }
			   else if(((cube.getU(5) == cube.getU(1) && cube.getR(1) == cube.getB(1)) ||
						(cube.getU(5) == cube.getU(3) && cube.getR(1) == cube.getL(1)) ||
						(cube.getU(5) == cube.getU(5) && cube.getR(1) == cube.getR(1)) ||
						(cube.getU(5) == cube.getU(7) && cube.getR(1) == cube.getF(1))) )
			   {
				   return 3;
			   }
		   }
		   cube.U(0);
	   }
	   System.out.println("Something in the yellow cross is whack");
	   return -1;     
   }
   
   public static void doAlgorithms(Rubiks cube, int state) throws IOException
   {
	   System.out.println(state);
	   switch (state)
	   {
	   case 0 : break;
	   case 1 : cube.algorithm(curve); cube.U(0); cube.algorithm(line); break;
	   case 2 : cube.algorithm(curve); break;
	   case 3 : cube.algorithm(line);; break;
	   }
   }
}
