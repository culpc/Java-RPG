//Imported class to obtain methods.
import java.util.*;

/**
   This class is used for creating an Enemy class
   Yaxin Fu 
*/
public class Enemy extends Fighter 
{
   //Create field
   private double hitChance; //The hit chance of the enemy.

   /**
      This constructs Enemy with health, a name, and a hit chance.
      @param h The health of the enemy.
      @param n The name of the enemy.
      @param hit The hit chance of the enemy.
   */
   public Enemy(double h, String n, double hit)
   {
      super(h, n);
      hitChance = hit;
   }

   /**
      The setHitChance method stores the enemy's hit chance in the hitChance field.
      @param h The hit chance of the enemy.
   */
   public void setHitChance(double h){
       hitChance = h;   
   }
   
   /**
      The getHitChance method returns the enemy's hit chance.
      @return The enemy's hit chance.
   */
   public double getHitChance() {
      return hitChance; 
   }
   


}
