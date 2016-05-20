package mygame;
public class Algorithm
{
   protected String actions;
   protected String inverses;
   
   public Algorithm()
   {
      actions = "";
      inverses = "";
   }
   public Algorithm(String act, String inv)
   {
      actions = act;
      inverses = inv;
   }
   
   public void setActions(String act)  {actions = act;}
   public void setInverses(String inv) {inverses = inv;}
   
   public String getActions()  {return actions;}
   public String getInverses() {return inverses;}
}