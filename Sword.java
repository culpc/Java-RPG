/**
   The Sword class is a specialized subclass of the Equipment class.
*/

//Imported classes to obtain methods.
import java.util.Random; 
import java.util.Scanner; 
import java.util.ArrayList;

public class Sword extends Equipment
{
   //Create Random object to correspond with random sword used by the character.
   Random randomSword = new Random();

   //Create fields
   private double attackModifier =(5+Equipment.getSwordsCreated()+randomSword.nextInt(10)); //Initialize attack modifier added to base attack.
   private String description = "Sword has an attack modifier of "+attackModifier+".\n"; //Initialize description of sword attack modifier.
   private int index, critChance = 10, stabHitChance = 40, hitChance = 70; //Initialize critical hit chance to 10.
   
   //Create Random object to determine if hit is a critical hit.
   Random rollForCrit = new Random();
   
   /**
      The constructor calls the Equipment superclass with the attack modifier.
      @param n The attack modifier.
   */
   public Sword(double n)
   {
      super(n);
   }
   
   /**
      This constructs Sword calls the Equipment superclass and has an attack modifier, critical chance, hit chance, and stab hit chance.
      @param attMod The attack modifier of the sword.
      @param cC The critical chance of the sword.
      @param hC The hit chance of the sword.
      @param sHC The stab hit chance of the sword.
   */
   public Sword(double attMod,int cC,int hC, int sHC)
   {
      super(attMod, cC, hC);
      attackModifier = attMod;
      stabHitChance = sHC;      
   }
   
   /**
      The setDescription method stores the sword's description in the description field.
      @param str The value to store in description.
   */
   public void setDescription(String str)
   {
      description = str; 
   }
   
   /**
      The getAttackModifer method returns an Equipment object's attackModifier.
      @return The value in the attackModifier field.
   */
   public double getAttackModifier()
   {
      return attackModifier;
   }
   /**
   The getDescription method describes the sword's attack modifier information.
   @return  The description of the sword.
   */
   public String getDescription()
   {
      
      return description; 
   }
   
   /**
      The getStabHitChance method returns the stab hit chance.
      @return The hit chance of the stab.
   */
   public int getStabHitChance()
   {
      return stabHitChance;
   }  
   
   /**
      The use method determines the sword slash attack type: hitting and critical hit.
      @return The attack modifier to be added to base attack.
   */
   @Override
   public double use()
   {
      //Create Random object to determine chance of attack hitting.
      Random rollForHit = new Random();
      
      //If-statement if attack hits the enemy. Then, returns attack modifier.
      if(rollForHit.nextInt(100) <= (this.getHitChance()))
      {
         //Determines if attack is a critical hit.
         if (rollForCrit.nextInt(100)<=critChance)
         {
            return (this.critHit());
         }

         return attackModifier;
      }
      else
      {
         return 0;
      }
   }
   
   /**
      The stabAttack method determines the sword stab attack type: hitting and critical hit.
      @return The attack modifier to be added to base attack.
   */
   public double stabAttack()
   {
      //Create Random object to determine chance of attack hitting.
      Random rollForHit = new Random();
      
      //If-statement if stab attack hits the enemy. Then, returns attack modifier.
      if (rollForHit.nextInt(100)<=stabHitChance)
      {
         //Determines if attack is a critical hit.
         if (rollForCrit.nextInt(100)<=critChance)
         {
            return (this.critHit()*1.5);
         }
         return (1.5*attackModifier);
      }
      else 
      {
         return 2;
      }
   }  
   
   /**
      The critHit method returns the sword critical hit damage.
      @return double The attackModifier * 2.
   */
   public double critHit()
   {
      return 2*attackModifier;
   }
   
}
