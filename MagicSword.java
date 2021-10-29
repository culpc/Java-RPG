/**
   The MagicSword class a specialized subclass of the Sword class and is needed to defeat the bandit boss.
*/

//Imported class to obtain methods.
import java.util.Random;

public class MagicSword extends Sword
{
   //Create random object.
   Random randomMS = new Random();
   
   //Create fields and initilaize fields to set values for the magic sword's characteristics.
   private double fireDamage = 0, iceDamage = 0, attackM = randomMS.nextInt(20)+10;
   private boolean hasIceSword = false, hasFireSword = false, hasMagicSword = false;
   private int fireOrIce, critC = 15, hitC = 75+randomMS.nextInt(20),stabHitChan = 40+randomMS.nextInt(15); 
   
   /**
      This constructs a Magic Sword with having a magic sword, attack modifier, critical chance, hit, and stab hit.
      @param hMS Status if the player has the magic sword.
      @param attM The attack modifier of the magic sword.
      @param crit The chance of having a critical hit from the magic sword.
      @param hit The hit from the magic sword.
      @param stabHit The stab from the magic sword.
   */
   public MagicSword(boolean hMS, double attM,int crit,int hit,int stabHit)
   { 
      //Calls the Sword superclass
      super(attM, crit, hit, stabHit);
      hasMagicSword = hMS;
      
      //Initializes if the magic sword is a fire or ice sword and the amount of damage based on corresponding random number.
      fireOrIce = randomMS.nextInt(1);
      
      //If random number is 0, the player has the fire magic sword.
      if(fireOrIce == 0)
      {
         hasFireSword = true;
         fireDamage = randomMS.nextInt(15)+10;
      }
      else
      {
         hasIceSword = true;
         iceDamage = randomMS.nextInt(15)+10;
      }
   }
   
   /**
      The getIceDamage method returns the damage of the ice magic sword.
      @return The damage of the ice magic sword.
   */
   public double getIceDamage()
   {
      return iceDamage;
   }
   
   /**
      The getFireDamage method returns the damage of the fire magic sword.
      @return The damage of the fire magic sword.
   */
   public double getFireDamage()
   {
      return fireDamage;
   }
   
   /**
      The getAttackM method returns the attack modifier of the magic sword.
      @return The attack modifier of the magic sword.
   */
   public double getAttackM()
   {
      return attackM;
   }
   
   /**
      The getHasMagicSword method returns if the player obtains the magic sword.
      @return The status whether the player has the magic sword.
   */
   public boolean getHasMagicSword()
   {
      return hasMagicSword;
   }
   
   /**
      The getHasFireDamage method returns if the player obtains the fire magic sword.
      @return The status whether the player has the fire magic sword.
   */
   public boolean getHasFireDamage()
   {
      return hasFireSword;
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
         if (rollForCrit.nextInt(100)<=critC)
         {
            if(hasFireSword == true)
            {
               return this.critHit()+fireDamage;
            }
            else
            {
               return this.critHit()+iceDamage;
            }

         }

         if(hasFireSword == true)
         {
            return attackM+fireDamage;
         }
         else
         {
            return attackM+iceDamage;
         }
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
   @Override
   public double stabAttack()
   {
      //Create Random object to determine chance of attack hitting.
      Random rollForHit = new Random();
      
      //If-statement if stab attack hits the enemy. Then, returns attack modifier.
      if (rollForHit.nextInt(100)<=stabHitChan)
      {
         //Determines if attack is a critical hit.
         if (rollForCrit.nextInt(100)<=critC)
         {
            if(hasFireSword = true)
            {
               return (this.critHit()+fireDamage*1.5);
            }
            else
            {
               return (this.critHit()+iceDamage*1.5);
            }
         }
         if(hasFireSword == true)
         {
            return (1.5*attackM+fireDamage);
         }
         else
         {
            return (1.5*attackM+iceDamage);
         }
      }
      else 
      {
         return 2;
      }
   }  


}
