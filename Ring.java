public class Ring extends Equipment
{
   //Create field
   private static int hitChance; //The player's hit chance of attack.
   
   /**
      The constructor calls the Equipment superclass if the character has a ring.
      @param hasRing Determine whether the character has a ring to improve the hit chance against the enemy.
   */
   public Ring(boolean hasRing)
   {
      super(hasRing);
   }
   
   /**
      The getImprovedHitChance method initializes the hitChance of attack depending on the number of rings obtained.
      @return The player's imrpoved hit chance with ring(s).
   */
   static int getImprovedHitChance()
   {
      hitChance = 10+Equipment.ringsCreated;
      return hitChance;
   }
   
   /**
      The getDescription method describes the improved hit chance corresponding to the ring.
      @return The description of the ring.
   */
   public String getDescription()
   {
      String str = "This ring improves hit chance by "+hitChance+".";
      return str;
   }
   
}
