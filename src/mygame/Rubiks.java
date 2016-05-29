package mygame;
import java.awt.*;
import java.io.*;

import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

public class Rubiks extends Cube
{
   protected char[] back;
   protected char[] front;
   protected char[] right;
   protected char[] left;
   protected char[] top;
   protected char[] bottom;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   protected int x;
   protected int y;
   protected int s;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   protected File file;
   protected FileWriter writer;
   protected BufferedWriter buffer;
   protected boolean recordSteps;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public Rubiks(Vector3f cubeCenter, AssetManager assetManager, Node rootNode, String topFaceColor, String frontFaceColor, String leftFaceColor)
   {
	  super(cubeCenter, assetManager, rootNode, topFaceColor, frontFaceColor, leftFaceColor);
      back  = new char[9];
      for (int k = 0; k < 9; k++)
         back[k] = 'g';
         
      front   = new char[9];
      for (int k = 0; k < 9; k++)
         front[k] = 'b';
         
      right    = new char[9];
      for (int k = 0; k < 9; k++)
         right[k] = 'r';
         
      left = new char[9];
      for (int k = 0; k < 9; k++)
         left[k] = 'o';
         
      top = new char[9];
      for (int k = 0; k < 9; k++)
         top[k] = 'y';
         
      bottom  = new char[9];   
      for (int k = 0; k < 9; k++)
         bottom[k] = 'w';
         
      x = 10;
      y = 10;
      s = 10;
      try{
      file = new File("steps.dat");
      writer = new FileWriter(file);
      buffer = new BufferedWriter(writer);
      }catch(IOException  | StackOverflowError e){System.out.println("some error in rubiks ");}
      recordSteps = false;
   }
   public Rubiks(){
	   super();
	   back  = new char[9];
	      for (int k = 0; k < 9; k++)
	         back[k] = 'g';
	         
	      front   = new char[9];
	      for (int k = 0; k < 9; k++)
	         front[k] = 'b';
	         
	      right    = new char[9];
	      for (int k = 0; k < 9; k++)
	         right[k] = 'r';
	         
	      left = new char[9];
	      for (int k = 0; k < 9; k++)
	         left[k] = 'o';
	         
	      top = new char[9];
	      for (int k = 0; k < 9; k++)
	         top[k] = 'y';
	         
	      bottom  = new char[9];   
	      for (int k = 0; k < 9; k++)
	         bottom[k] = 'w';
	         
	      x = 10;
	      y = 10;
	      s = 10;
	      try{
	      file = new File("steps.dat");
	      writer = new FileWriter(file);
	      buffer = new BufferedWriter(writer);
	      }catch(IOException  | StackOverflowError e){System.out.println("some error in rubiks ");}
	      recordSteps = false;
   }
   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void setX(int x){this.x = x;}
   public void setY(int y){this.y = y;}
   public void setS(int s){this.s = s;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void addX(int x){this.x += x;}
   public void addY(int y){this.y += y;}
   public void addS(int s){this.s += s;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public int getX(){return x;}
   public int getY(){return y;}
   public int getS(){return s;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public char[] getF(){return front;}
   public char[] getB(){return back;}   
   public char[] getR(){return right;}   
   public char[] getL(){return left;}   
   public char[] getU(){return top;}   
   public char[] getD(){return bottom;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public char getF(int k){return front[k];}
   public char getB(int k){return back[k];}   
   public char getR(int k){return right[k];}   
   public char getL(int k){return left[k];}   
   public char getU(int k){return top[k];}   
   public char getD(int k){return bottom[k];}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void setF(int k, char c){front[k] = c;}
   public void setB(int k, char c){back[k] = c;}
   public void setR(int k, char c){right[k] = c;}
   public void setL(int k, char c){left[k] = c;}
   public void setU(int k, char c){top[k] = c;}
   public void setD(int k, char c){bottom[k] = c;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void setF(char[] c){if (c.length == 9) front = c;}
   public void setB(char[] c){if (c.length == 9) back = c;}
   public void setR(char[] c){if (c.length == 9) right = c;}
   public void setL(char[] c){if (c.length == 9) left = c;}
   public void setU(char[] c){if (c.length == 9) top = c;}
   public void setD(char[] c){if (c.length == 9) bottom = c;}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
   public void drawCubeNet(Graphics g)
   {
      int tempX = x;
      int tempY = y;
      
      x += 7*s/2;
      drawSide(top,g);
      
      x = tempX;
      y += 7*s/2;
      drawSide(left,g);
      x += 7*s/2;
      drawSide(front,g);
      x += 7*s/2;
      drawSide(right,g);
      x += 7*s/2;
      drawSide(back,g);
      
      x = tempX;
      y += 7*s/2;
      x += 7*s/2;
      drawSide(bottom,g);
      
      x = tempX;
      y = tempY;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   private void drawSide(char[] side, Graphics g)
   {
      g.setColor(charToColor(side[0]));
      g.fillRect(x,y,s,s);
      g.setColor(charToColor(side[1]));
      g.fillRect(x + s,y,s,s);
      g.setColor(charToColor(side[2]));
      g.fillRect(x + 2*s,y,s,s);
      
      g.setColor(charToColor(side[3]));
      g.fillRect(x,y + s,s,s);
      g.setColor(charToColor(side[4]));
      g.fillRect(x + s,y + s,s,s);
      g.setColor(charToColor(side[5]));
      g.fillRect(x + 2*s,y + s,s,s);
      
      g.setColor(charToColor(side[6]));
      g.fillRect(x,y + 2*s,s,s);
      g.setColor(charToColor(side[7]));
      g.fillRect(x + s,y + 2*s,s,s);
      g.setColor(charToColor(side[8]));
      g.fillRect(x + 2*s,y + 2*s,s,s);
      
      g.setColor(Color.black);
      g.drawRect(x,y,3*s,3*s);
      g.drawRect(x+s,y,s,3*s);
      g.drawRect(x,y+s,3*s,s);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   private void swapEdge(char[] c1, char[] c2, int c11, int c12, int c13, int c21, int c22, int c23)
   {
      c1[c11] = c2[c21];
      c1[c12] = c2[c22];
      c1[c13] = c2[c23];
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   private void rotateSide(char[] side, boolean inverse)/////////////
   {
   
      char temp = side[0];
      char pmet = side[1];
      if (!inverse)
      {
         side[0] = side[6];
         side[6] = side[8];
         side[8] = side[2];
         side[2] = temp;
         
         side[1] = side[3];
         side[3] = side[7];
         side[7] = side[5];
         side[5] = pmet;
      }
      else
      {
         side[0] = side[2];
         side[2] = side[8];
         side[8] = side[6];
         side[6] = temp;
         
         side[1] = side[5];
         side[5] = side[7];
         side[7] = side[3];
         side[3] = pmet;
      }

   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void F(int inv) 
   {
	  super.F(inv);
	  System.out.println("front face rotation");
      char[] temp = new char[9];
      boolean inverse = (inv > 0);     
      int k;
      int j;      
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)   
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];           
         swapEdge(top,  left,  6,7,8,   8,5,2);
         swapEdge(left,  bottom,   8,5,2,   2,1,0);
         swapEdge(bottom,   right,     2,1,0,   0,3,6);
         swapEdge(right,     temp,    0,3,6,   6,7,8);
      } 
      rotateSide(front,inverse);
      if (recordSteps)
      {
    	  String line = "F" + inv;
    	  try{
    	  buffer.write(line);
    	  buffer.newLine();}
    	  catch(IOException e){}
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void B(int inv) 
   {
	  super.B(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);      
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];            
         swapEdge(top,  right,     2,1,0,   8,5,2);
         swapEdge(right,     bottom,   8,5,2,   6,7,8);
         swapEdge(bottom,   left,  6,7,8,   0,3,6);
         swapEdge(left,  temp,    0,3,6,   2,1,0);
      }   
      rotateSide(back,inverse);
      if (recordSteps)
      {
    	  String line = "B" + inv;
    	  try{
    	  buffer.write(line);
    	  buffer.newLine();
    	  }
    	  catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void R(int inv) 
   {
	  super.R(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);      
      int k;
      int j;      
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];         
         swapEdge(top,  front,    8,5,2,   8,5,2);
         swapEdge(front,    bottom,   8,5,2,   8,5,2);
         swapEdge(bottom,   back,   8,5,2,   0,3,6);
         swapEdge(back,   temp,    0,3,6,   8,5,2);
      }
      rotateSide(right,inverse);  
      if (recordSteps)
      {
    	  String line = "R" + inv;
    	  try{buffer.write(line);
    	  buffer.newLine();
    	  }
    	  catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void L(int inv)
   {
	  super.L(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);      
      int k;
      int j;      
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];
         swapEdge(top,  back,   0,3,6,   8,5,2);
         swapEdge(back,   bottom,   8,5,2,   0,3,6);
         swapEdge(bottom,   front,    0,3,6,   0,3,6);
         swapEdge(front,    temp,    0,3,6,   0,3,6);
      }
      rotateSide(left,inverse);
      if (recordSteps)
      {
    	  String line = "L" + inv;
    	  try{buffer.write(line);
    	  buffer.newLine();
    	  }
    	  catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public void U(int inv) 
   {
	  super.U(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];         
         swapEdge(front,    right,     2,1,0,   2,1,0);
         swapEdge(right,     back,   2,1,0,   2,1,0);
         swapEdge(back,   left,  2,1,0,   2,1,0);
         swapEdge(left,  temp,    2,1,0,   2,1,0);
      }
      rotateSide(top,inverse);  
      if (recordSteps)
      {
    	  String line = "U" + inv;
    	 try{ buffer.write(line);
    	 buffer.newLine();
    	 }
    	 catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
   public void D(int inv)
   {
	  super.D(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];
         swapEdge(front,    left,  6,7,8,   6,7,8);
         swapEdge(left,  back,   6,7,8,   6,7,8);
         swapEdge(back,   right,     6,7,8,   6,7,8);
         swapEdge(right,     temp,    6,7,8,   6,7,8);
      }
      rotateSide(bottom,inverse);
      if (recordSteps)
      {
    	  String line = "D" + inv;
    	 try{ buffer.write(line);
    	  buffer.newLine();
    	 }
    	 catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void X(int inv) 
   {
	  super.X(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];
         swapEdge(front,    right,     3,4,5, 3,4,5);
         swapEdge(right,     back,   3,4,5, 3,4,5);
         swapEdge(back,   left,  3,4,5, 3,4,5);
         swapEdge(left,  temp,    3,4,5, 3,4,5);
      }
      if (recordSteps)
      {
    	  String line = "X" + inv;
    	  try{buffer.write(line);
    	  buffer.newLine();
    	  }
    	  catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void Y(int inv) 
   {
	  super.Y(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = front[k];
         swapEdge(front,    bottom,   1,4,7, 1,4,7);
         swapEdge(bottom,   back,   1,4,7, 7,4,1);
         swapEdge(back,   top,  7,4,1, 1,4,7);
         swapEdge(top,  temp,    1,4,7, 1,4,7);
      }
      if (recordSteps)
      {
    	  String line = "Y" + inv;
    	  try{buffer.write(line);
    	  buffer.newLine();
    	  }
    	  catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void Z(int inv) 
   {
	  super.Z(inv);
      char[] temp = new char[9];
      boolean inverse = (inv > 0);
      int k;
      int j;
      int x = 1;
      if (inverse)
         x = 3;
         
      for (j = 0; j < x; j++)
      {
         for (k = 0; k < 9; k++)
            temp[k] = top[k];
         swapEdge(top,  left,  3,4,5, 7,4,1);
         swapEdge(left,  bottom,   1,4,7, 3,4,5);
         swapEdge(bottom,   right,     3,4,5, 7,4,1);
         swapEdge(right,     temp,    1,4,7, 3,4,5);
      }
      if (recordSteps)
      {
    	  String line = "Z" + inv;
    	 try{ buffer.write(line);
    	  buffer.newLine();}
    	 catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void rotateCubeX(int inv)
   {
	  boolean temp = recordSteps;
	  recordSteps = false;
      this.X(inv);
      this.U(inv);
      this.D(-inv + 1);
      recordSteps = temp;
      if (recordSteps)
      {
    	  String line = "Rotate cube X " + inv;
    	 try{ buffer.write(line);
    	  buffer.newLine();
    	 }
    	 catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void rotateCubeY(int inv) 
   {
	  boolean temp = recordSteps;
	  recordSteps = false;
      this.Y(inv);
      this.R(inv);
      this.L(-inv + 1);
      recordSteps = temp;
      if (recordSteps)
      {
    	  String line = "Rotate cube Y " + inv;
    	 try{ buffer.write(line);
    	  buffer.newLine();
    	 }
    	 catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void rotateCubeZ(int inv)
   {
	  boolean temp = recordSteps;
	  recordSteps = false;
      this.Z(inv);
      this.F(inv);
      this.B(-inv + 1);
      recordSteps = temp;
      if (recordSteps)
      {
    	  String line = "Rotate cube Z " + inv;
    	 try{ buffer.write(line);
    	  buffer.newLine();
    	 }catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   public boolean isSolved()
   {
      boolean output  = true;
      boolean tempTB  = true;
      boolean tempLR  = true;
      boolean tempFB  = true;
      for(int k = 0; k < 8; k++)
      {
    	 tempTB = (bottom[k] == bottom[k+1]) && (top[k]   == top[k+1]);
    	 tempLR = (left[k]   == left[k+1])   && (right[k] == right[k+1]);
    	 tempTB = (front[k]  == front[k+1])  && (back[k]  == back[k+1]);
         if (!(tempTB && tempLR && tempFB))
         {
        	 output = false;
        	 break;
         }
      }
      return output;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void algorithm(Algorithm alg)
   {
      multiAction(alg.getActions(), alg.getInverses());
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   public void multiAction(String actions, String inverses)
   {
      if (!(actions.length() == inverses.length()))
      {
         System.out.println("Error in inputs to multiAction method. Lengths of parameters must be equal.");
      }
      else
      {
    	 int temp = 0;
         for (int k = 0; k < actions.length(); k++)
         {
        	if (inverses.charAt(k) == '-')
        		temp = 0;
        	else
        		temp = Integer.parseInt(inverses.substring(k,k+1));
            singleAction(actions.charAt(k), temp);
         }
      }
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   public void singleAction(char action, int inv)
   {
      switch (action)
      {
         case 'F' : this.F(inv); break;
         case 'B' : this.B(inv); break;
         case 'U' : this.U(inv); break;
         case 'D' : this.D(inv); break;
         case 'R' : this.R(inv); break;
         case 'L' : this.L(inv); break;
         case 'X' : this.X(inv); break;
         case 'Y' : this.Y(inv); break;
         case 'Z' : this.Z(inv); break;
         case '-' : break;
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void setFace(String f, String t)
   {
System.out.println("this prints setFace: " + t);
	   boolean temp = recordSteps;
	  recordSteps = false;
      char fr = stringToChar(f);
      char to   = stringToChar(t);
      
      boolean bg = ((f.equals("blue")  && t.equals("green"))   || (t.equals("blue")  && f.equals("green")));
      boolean wy = ((f.equals("white") && t.equals("yellow"))  || (t.equals("white") && f.equals("yellow")));
      boolean ro = ((f.equals("red")   && t.equals("orange"))  || (t.equals("red")   && f.equals("orange")));
      if (bg || wy || ro)
      {
         System.out.println("Opposite sides can not be front and top at the same time");
      }
      else
      {
    	
    	  //System.out.println(front[4]);
    	  
    	  
         while (!(fr == front[4]))
         {
            rotateCubeY(0);
            if (fr == front[4])
               break;
            rotateCubeX(0);
         }
         while(!(to == top[4]))
            rotateCubeZ(0);
      } 
      recordSteps = temp;
      if (recordSteps)
      {
    	  String line = "Set front face to " + f + " and top face to " + t;
    	  try{
    	  buffer.write(line);
    	  buffer.newLine();
    	  }catch(IOException e){};
      }
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public char stringToChar(String s)
   {
      char c = ' ';
      switch (s.toLowerCase())
      {
         case "blue"    : c = 'b'; break;
         case "green"   : c = 'g'; break;
         case "red"     : c = 'r'; break;
         case "orange"  : c = 'o'; break;
         case "white"   : c = 'w'; break;
         case "yellow"  : c = 'y'; break;
      }
      return c;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public String charToString(char c)
   {
      String s = "";
      switch (c)
      {
         case 'b'   : s = "blue";     break;
         case 'g'   : s = "green";    break;
         case 'r'     : s = "red";      break;
         case 'o'  : s = "orange";   break;
         case 'w'   : s = "white";    break;
         case 'y'  : s = "yellow";   break;
      }
      return s;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public Color charToColor(char cha)
   {
      Color c = new Color(0,0,0);
      switch (cha)
      {
         case 'b' : c = Color.blue;     break;
         case 'g' : c = Color.green;    break;
         case 'r' : c = Color.red;      break;
         case 'o' : c = Color.orange;   break;
         case 'w' : c = Color.white;    break;
         case 'y' : c = Color.yellow;   break;
      }
      return c;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public Color stringToColor(String s)
   {
      Color c = new Color(0,0,0);
      switch (s.toLowerCase())
      {
         case "blue"    : c = Color.blue;     break;
         case "green"   : c = Color.green;    break;
         case "red"     : c = Color.red;      break;
         case "orange"  : c = Color.orange;   break;
         case "white"   : c = Color.white;    break;
         case "yellow"  : c = Color.yellow;   break;
      }
      return c;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public String colorToString(Color c)
   {
      if (c.equals(Color.blue))
    	  return "blue";
      if (c.equals(Color.green))
    	  return "green";
      if (c.equals(Color.red))
    	  return "red";
      if (c.equals(Color.orange))
    	  return "orange";
      if (c.equals(Color.white))
    	  return "white";
      if (c.equals(Color.yellow))
    	  return "yellow";
      return "";
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public char colorToChar(Color c)
   {
      if (c.equals(Color.blue))
    	  return 'b';
      if (c.equals(Color.green))
    	  return 'g';
      if (c.equals(Color.red))
    	  return 'r';
      if (c.equals(Color.orange))
    	  return 'o';
      if (c.equals(Color.white))
    	  return 'w';
      if (c.equals(Color.yellow))
    	  return 'y';
      return ' ';
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void beginStepRecord()
   {
	   recordSteps = true;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void endStepRecord() throws IOException
   {
	   recordSteps = false;
	   buffer.close();
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public String getFaceTop()
   {
	   return charToString(top[4]);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public String getFaceFront()
   {
	   return charToString(front[4]);
   }
}
