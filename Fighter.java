//Imported classes to obtain methods.
import java.util.*;

/**
   This class is used for creating a superclass Fighter for Character&Enemy class
   Yaxin Fu 
*/
public class Fighter{
   //Create fields
   private double health; //The Fighter's helath
   private String name; //The Fighter's name
   private int damage;  //The Fighter's damage
   
   /**
      This constructs a fighter with health and a name.
      @param h The fighter's health.
      @param n The fighter's name.
   */
   public Fighter(double h, String n) {
      health = h;
      name = n; 
   } 
      
   /**
      The setHealth method stores the fighter's health in the health field.
      @param h The value to store in health.
   */
   public void setHealth(double h) {
      health = h;
      
      }
      
   /**   
      The getHealth method returns a Fighter object's health.
      @return The value in the health field.
   */
   public double getHealth() {
      return health;
      }
      
   /**
      The setName method stores the fighter's name in the name field.
      @param n The value to store in name.
   */
   public void setName(String n) {
      name = n;
      
      }
      
   /**
      The getName method returns a Fighter object's name.
      @return The value in the name field.
   */
   public String getName() {
      return name;
      }
      
   /**
      The setDamage method stores the fighter's damage in the damage field.
      @param d The value to store in damage.
   */
   public void setDamage(int d) {
      damage = d;
      
      }
      
   /**
      The getDamage method returns a Fighter object's damage.
      @return The value in the damage field.
   */
   public int getDamage() {
      return damage;
      }



}
