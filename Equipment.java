//Imported classes to obtain methods.
import java.util.Random; 
import java.util.ArrayList; 
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.Scanner;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.scene.*;
import javafx.geometry.Insets;
import javafx.scene.text.*;
import javafx.scene.paint.Color; 

/**
   The Equipment superclass holds information and methods common to the Ring and Sword subclasses.
*/

public class Equipment
{
   //Create fields
   private String itemDropped, item;
   private int itemIdentifier, droppedYOrN, baseHitChance;
   static int swordsCreated = 0, ringsCreated = 0, clubsCreated = 0; //Initialize fields to 0.
   private int hitChance = 70, critChance = 10; //Initialize hitChance to 70 and critChance to 10.
   private double attackModifier = 0;  //Initialize attackModifier to 0.
   private Equipment[] equipmentArr;
  
   /**
      This constructs Equipment with the hitChance field equal to 70 and the critChance field equal to 10.
   */
   public Equipment()
   {
      hitChance = 70;
      critChance = 10;
      baseHitChance = 75;
   }
   
   /**
      This constructs Equipment with an attack modifier. Then, the number of swords created increases and the hitChance field equal to 75.
      @param aM The attack modifier.
   */
   public Equipment(double aM)
   {
      attackModifier = aM;
      swordsCreated++;
      hitChance = 75;
      baseHitChance = 75;
   }
   
   /**
      This constructs Equipment with an attack modifier, critical chance and hit chance. Then, incrases the number of swords created.
      @param aM The attack modifier.
      @param critCh The critical chance.
      @param hitC The hit chance.
   */
   public Equipment(double aM, int critCh, int hitC)
   {
      attackModifier = aM;
      swordsCreated++;
      hitChance = hitC;
      critChance = critCh;
      baseHitChance = hitC;
   }
   
   /**
      This constructs Equipment when the character obtains a ring. Then, increases the number of rings created and increases the hitChance if the argument
      hasRing equals true.
      @param hasRing Determines true/false if the character obtains a ring. 
   */
   public Equipment(boolean hasRing)
   {
      ringsCreated++;
      if( hasRing == true)
      {
         hitChance += Ring.getImprovedHitChance();
      }
   }
   
   /**
      This constructs Equipment with an attack modifier. Then, increases the number of clubs created.
      @param n
      @param aM The attack modifier.
   */
   public Equipment(int n, double aM)
   {
      attackModifier = aM;
      hitChance = n;
      clubsCreated++;
   }
   
   /**
      The setHitChance method stores the hit chance in the hitChance field.
      @param hC The value to store in hitChance.
   */
   public void setHitChance(int hC, Equipment w)
   {
         hitChance = hC +w.getBaseHitChance();
   }
   
   /**
      The getClubsCreated method returns an Equipment object's clubsCreated.
      @return The value in the clubsCreated field.
   */
   static int getClubsCreated()
   {
      return clubsCreated;
   }
   
   /**
      The getHitChance method returns an Equipment object's hitChance added to the hC argument.
      @return The sum of the hitChance field.
   */
   public int getHitChance()
   {
      return hitChance; 
   }
   
   /**
      The getBaseHitChance method returns an Equipment object's base hit chance before any addons are applied.
      @return the baseHitChance field
   */
   public int getBaseHitChance()
   {
      return baseHitChance;
   }   
   
   /**
      The getSwordsCreated method returns an Equipment object's swordsCreated.
      @return The value in the swordsCreated field.
   */
   static int getSwordsCreated()
   {
      return swordsCreated;
   }
   
   /**
      The use method returns an Equipment object's attackModifier.
      @return The value in the attackModifier field.
   */
   public double use()
   {
      return attackModifier;
   }
   
   /**
      The randomDrop method determines what item is dropped based on the corresponding number combinations.
      @return The number of the respected item.
   */ 
   public String randomDrop(Character c)
   {
      //Create a Random object with 10 numbers.
      Random isItemDropped = new Random();
      droppedYOrN = isItemDropped.nextInt(10);
      
      //If-else statement whether item is/not dropped 
      if(droppedYOrN <= 10){
         if(c.getExperienceLevel()>=2){
            //Create a Random object with 5 numbers.
            Random whatItem = new Random();
            itemIdentifier = whatItem.nextInt(5);
            
            //The following segments are the number combinations corresponding to the item. Then, sets itemDropped to the item.
            /*if(itemIdentifier == 0 || itemIdentifier == 1)
            {
               itemDropped = "Sword";
            }
            else if(itemIdentifier == 2||itemIdentifier == 3)
            {
               itemDropped = "Potion";
            }
            else if(itemIdentifier == 4)
            {
               itemDropped = "Ring";
            }
            else*/
            {
               itemDropped = "Magic Sword";
            }
         }
         else{
            //Create a Random object with 5 numbers.
            Random whatItem = new Random();
            itemIdentifier = whatItem.nextInt(5);
            
            //The following segments are the number combinations corresponding to the item. Then, sets itemDropped to the item.
            if(itemIdentifier == 0 || itemIdentifier == 1)
            {
               itemDropped = "Sword";
            }
            else if(itemIdentifier == 2||itemIdentifier == 3)
            {
               itemDropped = "Potion";
            }
            else if(itemIdentifier == 4)
            {
               itemDropped = "Ring";
            }
         }
       }
       else
       {
         itemDropped =  "lot of nothing";
       }
   return itemDropped;
   }
   /**
      The setCritHitChance method calculates the chance of a critical hit.
      @param critHitChance The critical hit chance.
      @param alreadyImproved Determines true/false for the critChance field to equal the critHitChance argument.
   */
   public void setCritHitChance(int critHitChance, boolean alreadyImproved)
   {
      if(alreadyImproved == false)
      {
         critChance = critHitChance;
      }
   }
   
   /**
      The getCritHitChance method returns an Equipment object's critChance.
      @return The value in the critChance field.
   */
   public int getCritHitChance()
   {
      return critChance;
   }
}
