/**
   This code creates the Club class which is a subclass of Equipment
   A club is a weapon used to deal damage
*/

//Imported classes to obtain methods.
import java.util.Random; 

public class Club extends Equipment
{
   //Create Random object
   Random randomClub = new Random();

   //Create fields
   private final double attackModifier =(5+Equipment.getClubsCreated()+randomClub.nextInt(4));
   private int critChance = 10, hitChance = 65;
   
   /**
      This constructs Club with dummy values to call the Equipment superclass constructor.
      @param n Integer value for superclass constructor.
      @param m Double value for superclass constructor.
   */
   public Club(int n, double m){
      super(n, m);
   }
   
   /**
      The use method randomly determines if the attack was hit and if the hit was critical. (use = atttack)
      @return attackModifier The attack modifier.
   */
   @Override
   public double use(){
      
      //Create Random object
      Random rollForHit = new Random();
      
      //If-else statement to calculate whether the attack hits.
      if(rollForHit.nextInt(100)<= this.getHitChance()){
         
          //Create Random object
         Random rollForCrit = new Random();
         
         //If-statement to calculate whether hit is critical or not.
         if(rollForCrit.nextInt(100)<= 10)
         {  
            return (attackModifier*2);
         }
         return attackModifier;
      }
      else{
         return 0;
      }
   }
   
}
