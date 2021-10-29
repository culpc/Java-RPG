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
import javafx.scene.paint.Color; //lets you fill text with color
import java.util.*;
public class Character {

   private String name;
   private double health, maxHealth;
   private int critChance;
   private boolean hasImprovedCritChance = false, critAchievement = false;
   private double attackDamage, enemyAttackDamage, enemyAttackDamage2;
   private double experience; 
   private double gold;
   private int expLevel, prevLevel, expNeeded, level;
   
   /**
      This constructs a Character with a name, health, max health, experience system, and gold system.
      @param playerName The character's name.
      @param h The character's heatlh.
      @param e The character's experience in the experience system.
      @param g The character's gold system.
   */
   public Character(String playerName, double h, double e, double g, int exp) {
      name = playerName;
      health = h;
      maxHealth = h;
      experience = e;
      gold = g; 
      expNeeded = exp;
      
      }
     
     /**
      The getExperience method returns a Character's experience object.
      @return The character's experience in the experience system.
   */
     public double getExperience() {
      return(experience);
      } 
      
      
      public int getExperienceLevel() {
      
         return level;
         
      } 
   
   /**
      The getGold method returns a Character's gold object.
      @return The character's gold system status.
   */ 
   public double getGold() {
      return(gold);
      }
   public double getExpNeeded(){
      return expNeeded;
      }
   
   /**
      The getName method returns the character's name.
      @return The name of the character.
   */
   public String getName() {
      return name;
      }
   
   /**
      The getMaxHealth method returns the character's max health.
      @return The max health of the character.
   */   
   public double getMaxHealth(){
      return(maxHealth);
      }
   
   /**
      The getHealth method returns the character's health.
      @return The health of the character.
   */   
   public double getHealth() {
      return(health);
      }
      
   private void setExpNeeded(int i){
      expNeeded = i;
      }    
   /**
      The setHealth method stores the character's health in the health field.
      @param t The character's health.
   */   
   public void setHealth(double t) {    
      this.health = t;
      //System.out.println("Health set to " + (getHealth()));    
      }
   public void setMaxHealth(double h){
         maxHealth = h;
      }  
       
   /**
      The setName method stores the character's name in the name field. Then, prints the name.
      @param t The character's name.
    */   
   public void setName(String t) {
      this.name = t;
      System.out.println("Name set to " + (getName()));
      }
   
   /**
      The setGold method stores the character's gold system status in the gold field.
      @param g The character's gold system status.
   */   
   public void setGold(double g) {    
      this.gold = g;    
      }   
      
   /**
      The setExperience method stores the character's experience in the experience field.
      @param e The character's experience.
   */
   public void setExperience(double e) {    
      this.experience = e;    
      }
  
   public void levelUp(BorderPane bordP, Character c, Text pL, Text pG, Text oB, Text oC, Text oD, Text oE, Text oF){
      if(experience >= expNeeded){
         level++;
         health= health+.5*maxHealth;
         maxHealth *= 1.25;
         expNeeded *= 2.5;
         this.setHealth(health);
         maxHealth*=1.25;
         oB.setText("Press ENTER to Continue");
         oC.setText(" ");
         oD.setText("Congratulations "+this.getName()+",");
         oE.setText("you have leveled up!");
         oF.setText("Max health is now "+this.getMaxHealth());
         pL.setText("Level: "+this.getExperienceLevel());
         pG.setText("Gold: "+this.getGold());
         ChoicePrompt pause = new ChoicePrompt(bordP.getScene().getWindow());
         oB.setText("Enter SLASH");
         oC.setText("or STAB");
         oD.setText(" ");
         oE.setText(" ");
         oF.setText(" ");
      }
   }    
      

   //Kelly
   /**
      method to determine whether player has improved Critical hit chance
      @param int numOfStabAttacks - number of stab Attacks taken
      @return int critChance - critical hit chance
   */   
   public int improvedCritChance(int numOfStabAttacks)
   {
      if(numOfStabAttacks>10)
      {
         hasImprovedCritChance = true;
         critChance = 30;
      
      }
      return critChance;
   }
   //Kelly
   /**
      method to tell the main that player's crit hit chance is already improved
      @return boolean hasImprovedCritChance - has improved critical hit chance  
   */
   public boolean getHasImprovedCritChance()
   {
      return hasImprovedCritChance;
   }
   
   //Kelly
   /**
      The combatSequenceForOneEnemy method performs a one versus one combat with weapons.
      @param bP The BorderPane 
      @param weapon1 The character weapon from the Sword class
      @param enemy The enemy from the Enemy class
      @param weapon2 The enemy weapon from the Club class
      @param player The character from the Character class
      @param sAC The number of stab attacks.
      @param roomI The room the character is in
      @param eH Displays the enemy's health
      @param pH Displays the player's health 
      @param cons Dummy value for character death message
      @param optA Option A 
      @param optB Option B 
      @param optC Option C 
      @param optD Option D 
      @param optE Option E 
      */
   public int combatSequenceForOneEnemy(BorderPane bP, Sword weapon1, MagicSword mS1, Enemy enemy, Club weapon2, Character player, int sAC, Text roomI, Text eH, Text pH, Text pE, Text cL, Text cG, Text cons, Text optA, Text optB, Text optC, Text optD, Text optE, Text optF){
      
      do{
         ChoicePrompt prompt11 = new ChoicePrompt(bP.getScene().getWindow());
         String choice11 = prompt11.getResult();

      
            if (choice11.compareToIgnoreCase("slash")== 0) 
            { 
               
               //getting value for attack factoring hit chance
               attackDamage = weapon1.use();
               //displaying message about damage done
               optD.setText("You attack the enemy and do "+attackDamage+" slashing damage.");
               //lowering enemy health
               enemy.setHealth(enemy.getHealth()-attackDamage); 
               eH.setText("HP: "+ enemy.getHealth());
               //enemy attack
               enemyAttackDamage = weapon2.use();
               optE.setText("Goblin attacks you for "+enemyAttackDamage+ " bludgeoning damage!");
               //lowering character health
               health = player.getHealth() - enemyAttackDamage;
               player.setHealth(health);
               //Yaxin for every attack, the experience increase enemyAttackDamage
               expLevel = player.getExperienceLevel();
               experience = player.getExperience() + enemyAttackDamage;   
               /*if (player.getExperienceLevel() - expLevel >= 1)
               {
                  this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                  player.setHealth(maxHealth);
               }*/                         
               player.setExperience(experience);
               this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF);
               pH.setText("HP: "+ player.getHealth());
               pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded());  
               //pH.setText("HP: "+ player.getHealth());
               this.characterDeath(player, bP, roomI, cons, optA, optB, optC, optD, optE);
            }
            else if( choice11.compareToIgnoreCase("stab") == 0)
            {
               if(mS1.getHasMagicSword() == true)
               {
                  //getting value for attack factoring hit chance
                  attackDamage = weapon1.stabAttack();
                  if(mS1.getHasFireDamage()==true)
                     {
                        if(attackDamage==(mS1.getAttackM()*1.5+mS1.getFireDamage())){
                           //displaying message about damage done
                           optD.setText("You attack the goblin and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getFireDamage()+" fire damage.");
                           //lowering enemy health
                           enemy.setHealth(enemy.getHealth()-attackDamage);  
                           eH.setText("HP: " + enemy.getHealth());
                        }
                        else{
                           //display message about damage done
                           optD.setText("You attack the goblina and do 2 piercing damage.");
                           enemy.setHealth(enemy.getHealth()-attackDamage);  
                           eH.setText("HP: " + enemy.getHealth());
                        }
                     }
                     else
                     {
                        if(attackDamage==(mS1.getAttackM()*1.5+mS1.getIceDamage())){
                           //displaying message about damage done
                           optD.setText("You attack the goblin and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getIceDamage()+" ice damage.");
                           //lowering enemy health
                           enemy.setHealth(enemy.getHealth()-attackDamage);  
                           eH.setText("HP: " + enemy.getHealth());
                        }
                        else{
                           //display message about damage done
                           optD.setText("You attack the goblina and do 2 piercing damage.");
                           enemy.setHealth(enemy.getHealth()-attackDamage);  
                           eH.setText("HP: " + enemy.getHealth());
                        }
                     }
               }
               else{
               {
                  //getting value for attack factoring hit chance
                  attackDamage = weapon1.stabAttack();
                  //displaying message about damage done
                  optD.setText("You attack the goblin and do "+attackDamage+" piercing damage.");
                  //lowering enemy health
                  enemy.setHealth(enemy.getHealth()-attackDamage);  
                  eH.setText("HP: " + enemy.getHealth()); 
               }
               //enemy attack
               enemyAttackDamage = (weapon2.use());
               optE.setText("Goblin attacks you for "+enemyAttackDamage+ " bludgeoning damage!");
               health = player.getHealth() - enemyAttackDamage;
               player.setHealth(health);
               //lowering character health
               expLevel = player.getExperienceLevel();
               experience = player.getExperience() + enemyAttackDamage;   
               /*if (player.getExperienceLevel() - expLevel >= 1)
                  {
                 this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                  player.setHealth(maxHealth);
                  }     */
                  this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF);      
               pH.setText("HP: "+player.getHealth() );
               pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded());
               //tracking stab attacks for character improvement
               sAC++;
               weapon1.setCritHitChance(player.improvedCritChance(sAC), player.getHasImprovedCritChance());
               this.characterDeath(player, bP, roomI, cons, optA, optB, optC, optD, optE);
               }
            }
            //code to exit the program
            else if(choice11.compareToIgnoreCase("quit") == 0)
            {
               System.exit(1);
            }
         }while(enemy.getHealth() > 0);
     return sAC;
   }
   
 //Kelly
   /**
      The getCritAchievementMessage displays a critical hit chance improvement statement.
      @param critMess  The critical Hit Achievement Message
      @param player1 The character
      @param oA Option A 
      @param oB Option B
      @param oC Option C
      @param oD Option D
      @param bP The BorderPane
      @return critAchievement The critical achievement message
   */ 
   public boolean getCritAchievementMessage(boolean critMess, Character player1,Text con, Text oA, Text oB, Text oC, Text oD, BorderPane bP){
         if(critMess == false){
            if(player1.getHasImprovedCritChance() == true){
                  con.setText("Congrats, your repetition has paid off!");
                  oA.setText("Your Critical Hit Chance has increased to 30%.");
                  oB.setText("Enjoy!");
                  oC.setText(" ");
                  oC.setText(" ");
                  ChoicePrompt trial1 = new ChoicePrompt(bP.getScene().getWindow());
                  critAchievement = true;
            }
            else{
               oA.setText(" ");
               oB.setText(" ");
               oC.setText(" ");
               oD.setText(" ");
               con.setText(" ");
            }
          }
          else{
            oA.setText(" ");
            oB.setText(" ");
            oC.setText(" ");
            oD.setText(" ");
            con.setText(" ");
          }  
         return critAchievement;
    }
   
   //Kelly
   /**
      The characterDeath method displays the character's death message and then, exits the game.
      @param player The character
      @param bordP The BorderPane
      @param rI   To help with formatting text
      @param con  The character death message
      @param oA   The character death message continued
      @param oB   To help with formatting text
      @param oC To help with formatting text
      @param oC To help with formatting text
      @param oD To help with formatting text
      @param oE To help with formatting text
   */   
   public void characterDeath(Character player, BorderPane bordP, Text rI, Text con, Text oA, Text oB, Text oC, Text oD, Text oE){
      if(player.getHealth()<=0)
      {
         rI.setText(" ");
         con.setText("THE ENEMY HAS KILLED YOU!!!");
         oA.setText("You LOSE ");
         oB.setText(" ");
         oC.setText(" ");
         oD.setText("");
         oE.setText("");
         ChoicePrompt pause = new ChoicePrompt(bordP.getScene().getWindow());
         System.exit(1);        
      }   
   }
   
   //function to perform 1v2 combat with swords
   //Kelly
   /**
      The combatSequenceForTwoEnemy method performs a one versus two combat with weapons.
      @param bP The BorderPane
      @param weapon1 The character's weapon
      @param enemy The first enemy
      @param enemy2 The second enemy
      @param weapon2 The first enemy's weapon
      @param weapon3 The second enemy's weapon
      @param player  The character
      @param sAC The number of stab attacks.
      @param roomI The room the character is in
      @param eH Displays the enemy's health
      @param pH Displays the player's health 
      @param cons Dummy value for character death message
      @param optA Option A 
      @param optB Option B 
      @param optC Option C 
      @param optD Option D 
      @param optE Option E 
   */
   public int combatSequenceForTwoEnemy(BorderPane bP, Sword weapon1, MagicSword mS1, Enemy enemy, Enemy enemy2, Club weapon2, Club weapon3, Character player, int sAC, Text roomI, Text eH, Text eH2, Text pH, Text pE, Text cL, Text cG, Text cons, Text optA, Text optB, Text optC, Text optD, Text optE, Text optF){
      
      do{
         ChoicePrompt fightPrompt = new ChoicePrompt(bP.getScene().getWindow());
         String fightPrompt2 = fightPrompt.getResult();

      
            if (fightPrompt2.compareToIgnoreCase("slash")== 0) 
            { 
               if(enemy.getHealth()>= 0&&enemy2.getHealth()>=0)
               {
                  //getting value for attack factoring hit chance
                  attackDamage = weapon1.use();
                  //displaying message about damage done
                  optC.setText("You attack the "+enemy.getName()+" and do "+attackDamage+" slashing damage.");
                  //lowering enemy health
                  enemy.setHealth(enemy.getHealth()-attackDamage);      
                  eH.setText("HP: "+ enemy.getHealth());
                  //enemy attack
                  enemyAttackDamage = (weapon2.use());
                  optD.setText(enemy.getName()+" attacks you for "+enemyAttackDamage+ " bludgeoning damage!");
                  //lowering character health
                  player.setHealth(player.getHealth()-enemyAttackDamage);
                  expLevel = player.getExperienceLevel();
                  experience = player.getExperience() + enemyAttackDamage;   
                  player.setExperience(player.getExperience()+enemyAttackDamage);
                  /*if (player.getExperienceLevel() - expLevel >= 1)
                     {
                     this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                     player.setHealth(maxHealth);
                     }          */  
                  pH.setText("HP: "+player.getHealth());
                  pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded());
                  //pH.setText("HP: "+player.getHealth());  
                  enemyAttackDamage2 = weapon3.use();
                  optE.setText(enemy2.getName()+" attacks you for "+enemyAttackDamage2+ " bludgeoning damage!");
                  //lowering character health
                  health = player.getHealth() - enemyAttackDamage2;               
                 expLevel = player.getExperienceLevel();
                  player.setExperience(player.getExperience()+enemyAttackDamage2);
                  /*if (player.getExperienceLevel() - expLevel >= 1)
                     {
                     this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                     player.setHealth(maxHealth);
                     }         */
                     this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF);
                  pH.setText("HP: "+player.getHealth());
                  pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded()); 
                  this.characterDeath(player, bP, cons, roomI, optA, optB, optC, optD, optE);
               }
               else{
                  optE.setText(" ");
                  //getting value for attack factoring hit chance
                  attackDamage = weapon1.use();
                  //displaying message about damage done
                  optC.setText("You attack the "+enemy2.getName()+" and do "+attackDamage+" slashing damage.");
                  //lowering enemy health
                  enemy2.setHealth(enemy2.getHealth()-attackDamage); 
                  eH2.setText("HP: "+ enemy2.getHealth());
                  enemyAttackDamage2 = weapon3.use();
                  optD.setText(enemy2.getName()+" attacks you for "+enemyAttackDamage2+ " bludgeoning damage!");
                  //lowering character health
                  health = player.getHealth() - enemyAttackDamage2;               
                  player.setHealth(health);
                  expLevel = player.getExperienceLevel();
                  player.setExperience(player.getExperience()+enemyAttackDamage2);
                 /* if (player.getExperienceLevel() - expLevel >= 1)
                     {
                     this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                     player.setHealth(maxHealth);
                     }  */
                     this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF);
                  pH.setText("HP: "+player.getHealth());
                  pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded());
                  player.setExperience(player.getExperience()+enemyAttackDamage2);
                  this.characterDeath(player, bP, roomI, cons, optA, optB, optC, optD, optE);
               }
            }
            else if(fightPrompt2.compareToIgnoreCase("stab") == 0)
            {
               
               if(enemy.getHealth()>= 0&&enemy2.getHealth()>=0){
                  if(mS1.getHasMagicSword() == true)
                  {
                     //getting value for attack factoring hit chance
                     attackDamage = weapon1.stabAttack();
                     if(mS1.getHasFireDamage()==true)
                        {
                           if(attackDamage==(mS1.getAttackM()*1.5+mS1.getFireDamage())){
                              //displaying message about damage done
                              optD.setText("You attack "+enemy.getName()+" and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getFireDamage()+" fire damage.");
                              //lowering enemy health
                              enemy.setHealth(enemy.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy.getHealth());
                           }
                           else{
                              //display message about damage done
                              optD.setText("You attack the "+enemy.getName()+" and do 2 piercing damage.");
                              enemy.setHealth(enemy.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy.getHealth());
                              }
                        }
                        else
                        {
                           if(attackDamage==(mS1.getAttackM()*1.5+mS1.getIceDamage())){
                              //displaying message about damage done
                              optD.setText("You attack "+enemy.getName()+" and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getIceDamage()+" ice damage.");
                              //lowering enemy health
                              enemy.setHealth(enemy.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy.getHealth());
                           }
                           else{
                              //display message about damage done
                              optD.setText("You attack "+enemy.getName()+" and do 2 piercing damage.");
                              enemy.setHealth(enemy.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy.getHealth());
                           }
                        }
                  }
               else{
                  if(mS1.getHasMagicSword() == true)
                     {
                        //getting value for attack factoring hit chance
                        attackDamage = weapon1.stabAttack();
                     if(mS1.getHasFireDamage()==true)
                              {
                           if(attackDamage==(mS1.getAttackM()*1.5+mS1.getFireDamage())){
                                 //displaying message about damage done
                                 optD.setText("You attack "+enemy.getName()+" and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getFireDamage()+" fire damage.");
                                 //lowering enemy health
                                 enemy.setHealth(enemy.getHealth()-attackDamage);  
                                 eH.setText("HP: " + enemy.getHealth());
                              }
                              else{
                                 //display message about damage done
                                 optD.setText("You attack the "+enemy.getName()+" and do 2 piercing damage.");
                                 enemy.setHealth(enemy.getHealth()-attackDamage);  
                                 eH.setText("HP: " + enemy.getHealth());
                                 }
                           }
                      else{
                             if(attackDamage==(mS1.getAttackM()*1.5+mS1.getIceDamage())){
                             //displaying message about damage done
                              optD.setText("You attack "+enemy.getName()+" and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getIceDamage()+" ice damage.");
                              //lowering enemy health
                              enemy.setHealth(enemy.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy.getHealth());
                           }
                           else{
                              //display message about damage done
                              optD.setText("You attack "+enemy.getName()+" and do 2 piercing damage.");
                              enemy.setHealth(enemy.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy.getHealth());
                           }
                        }
                      }
                   else{     
                     //getting value for attack factoring hit chance
                     attackDamage = weapon1.stabAttack();
                     //displaying message about damage done
                     optC.setText("You attack the "+enemy.getName()+" and do "+attackDamage+" piercing damage.");
                     //lowering enemy health
                     enemy.setHealth(enemy.getHealth()-attackDamage); 
                     eH.setText("HP: "+ enemy.getHealth());
                     //enemy attack
                     enemyAttackDamage = (weapon2.use());
                     optD.setText(enemy.getName()+" attacks you for "+enemyAttackDamage+ " bludgeoning damage!");
                     //lowering character health
                     player.setHealth(player.getHealth()-enemyAttackDamage);
                     expLevel = player.getExperienceLevel();
                     player.setExperience(player.getExperience()+enemyAttackDamage);                  
                     /*if (player.getExperienceLevel() - expLevel >= 1)
                     {
                        this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                        player.setHealth(maxHealth);
                        }  */
                     pH.setText("HP: "+player.getHealth());
                     pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded());   
                     enemyAttackDamage2 = weapon3.use();
                     optE.setText(enemy2.getName()+" attacks you for "+enemyAttackDamage2+ " bludgeoning damage!");
                     //lowering character health
                     health = player.getHealth() - enemyAttackDamage2;               
                     player.setHealth(health);
                     pH.setText("HP: "+ player.getHealth()); 
                     expLevel = player.getExperienceLevel();
                     player.setExperience(player.getExperience()+enemyAttackDamage2);                  
                     pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded());
                     /*if (player.getExperienceLevel() - expLevel >= 1)
                           {
                        this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                        player.setHealth(maxHealth);
                        }  */
                     this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF);   
                     sAC++;
                     weapon1.setCritHitChance(player.improvedCritChance(sAC), player.getHasImprovedCritChance());
                     this.characterDeath(player, bP, roomI, cons, optA, optB, optC, optD, optE);
                  }
               } 
               }  
              else{
               if(mS1.getHasMagicSword() == true){
                     //getting value for attack factoring hit chance
                     attackDamage = weapon1.stabAttack();
                     if(mS1.getHasFireDamage()==true)
                        {
                           if(attackDamage==(mS1.getAttackM()*1.5+mS1.getFireDamage())){
                              //displaying message about damage done
                              optD.setText("You attack "+enemy2.getName()+" and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getFireDamage()+" fire damage.");
                              //lowering enemy health
                              enemy.setHealth(enemy2.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy2.getHealth());
                           }
                           else{
                              //display message about damage done
                              optD.setText("You attack the "+enemy2.getName()+" and do 2 piercing damage.");
                              enemy.setHealth(enemy2.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy2.getHealth());
                              }
                        }
                        else
                        {
                           if(attackDamage==(mS1.getAttackM()*1.5+mS1.getIceDamage())){
                              //displaying message about damage done
                              optD.setText("You attack "+enemy2.getName()+" and do "+mS1.getAttackM()+" piercing damage\n and "+mS1.getIceDamage()+" ice damage.");
                              //lowering enemy health
                              enemy.setHealth(enemy2.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy2.getHealth());
                           }
                           else{
                              //display message about damage done
                              optD.setText("You attack "+enemy2.getName()+" and do 2 piercing damage.");
                              enemy.setHealth(enemy2.getHealth()-attackDamage);  
                              eH.setText("HP: " + enemy2.getHealth());
                           }
                        }
                     }
                  else{      
                     //getting value for attack factoring hit chance
                     attackDamage = weapon1.stabAttack();
                     //displaying message about damage done
                        optC.setText("You attack the "+enemy2.getName()+" and do "+attackDamage+" slashing damage.");
                     //lowering enemy health
                     enemy2.setHealth(enemy2.getHealth()-attackDamage); 
                     eH2.setText("HP: "+ enemy2.getHealth());
                     enemyAttackDamage2 = weapon3.use();
                     optD.setText(enemy2.getName()+" attacks you for "+enemyAttackDamage2+ " bludgeoning damage!");
                     optE.setText(" ");
                     //lowering character health
                     health = player.getHealth() - enemyAttackDamage2;               
                     player.setHealth(health);
                     expLevel = player.getExperienceLevel();
                     player.setExperience(player.getExperience()+enemyAttackDamage2);                 
                    /* if (player.getExperienceLevel() - expLevel >= 1)
                        {
                        this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF );
                        player.setHealth(maxHealth);
                        }  */
                        this.levelUp(bP, player, cL, cG, optB, optC, optD, optE, optF);
                     pH.setText("HP: "+player.getHealth() + "\nExp: " + player.getExperience());
                     pE.setText("Exp: "+player.getExperience()+" out of "+player.getExpNeeded());   
                     this.characterDeath(player, bP, roomI, cons, optA, optB, optC, optD, optE);
                     //tracking stab attacks for character improvement
                     sAC++;
                     weapon1.setCritHitChance(player.improvedCritChance(sAC), player.getHasImprovedCritChance());
                     this.characterDeath(player, bP, roomI, cons, optA, optB, optC, optD, optE);
                }  
              }
            }
            //code to exit the program
            else if(fightPrompt2.compareToIgnoreCase("quit") == 0)
            {
               System.exit(1);
            }
         }while(enemy2.getHealth() > 0);
     return sAC;
   }

}