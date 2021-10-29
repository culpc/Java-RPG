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

/**
 *  Test Game Engine v2
 */

public class TestEnginev2 extends Application
{
   public static void main(String[] args)
   {
      //launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   
   {
      primaryStage.setTitle("awesome game WOW!");
      
      //create some elements.
      double attackDamage, health, enemyAttackDamage;
      String item;
      int stabAttackCount =0;
      boolean critAchievementMessage = false;
      Sword weapon = new Sword(1);
      Sword fathersSword = new Sword(13,15,83,45);   
      weapon = fathersSword;
      weapon.setDescription("Your father's sword has an attack of "+weapon.getAttackModifier());
      
      Random randomMS = new Random();
      
      
      //This text will go in the Top Box (title/level area)
      Text roomName = new Text("Welcome to Text-Based-RPG TEST");
      roomName.setFont(Font.font ("Arial Black", FontWeight.BOLD, 30));
      roomName.setFill(Color.WHITE);
         
      
      //These texts will go on the left box. Character and Enemy info.
      Text characterTitle = new Text(null);
      characterTitle.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));
      characterTitle.setFill(Color.PALEGREEN);
      
      Text characterName = new Text(null);
      characterName.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 20));
      characterName.setFill(Color.LIMEGREEN);
      
      Text characterLevel = new Text(null);
      characterLevel.setFont(Font.font ("Arial",15));
      characterLevel.setFill (Color.LIMEGREEN);
      
      Text characterHealth = new Text(null);
      characterHealth.setFont(Font.font ("Arial", 15));
      characterHealth.setFill(Color.PALEGREEN);
      
      Text characterExp = new Text(null);
      characterExp.setFont(Font.font ("Arial", 15));
      characterExp.setFill(Color.WHITE);
      
      Text characterGold = new Text(null);
      characterGold.setFont(Font.font ("Arial", 15));
      characterGold.setFill(Color.YELLOW);
      
      Text spacer = new Text(null);
      
      Text enemyTitle = new Text(null);
      enemyTitle.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));
      enemyTitle.setFill(Color.CORAL);
      
      Text enemyTitle2 = new Text(null);
      enemyTitle2.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));
      enemyTitle2.setFill(Color.CORAL);
      
      Text enemyName = new Text(null);
      enemyName.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 20));
      enemyName.setFill(Color.CRIMSON);
      
      Text enemyName2 = new Text(null);
      enemyName2.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 20));
      enemyName2.setFill(Color.CRIMSON);
      
      Text enemyHealth = new Text(null);
      enemyHealth.setFont(Font.font ("Arial", 15));
      enemyHealth.setFill(Color.CORAL);
      
      Text enemyHealth2 = new Text(null);
      enemyHealth2.setFont(Font.font ("Arial", 15));
      enemyHealth2.setFill(Color.CORAL);
      
      //buttons if we want to use buttons to attack enemies
      //Button slashButton = new Button("Slash");
      //Button stabButton = new Button("Stab");
      
      
      //These will go on the right side. Game text/prompts and options
      Text console = new Text(null);
      console.setFont(Font.font ("Arial", 20));
      //option text objects to show character options
      Text optionA = new Text(null);
      optionA.setFont(Font.font ("Arial", 15));
      Text optionB = new Text(null);
      optionB.setFont(Font.font ("Arial", 15));
      Text optionC = new Text(null);
      optionC.setFont(Font.font ("Arial", 15));
      Text optionD = new Text(null);
      optionD.setFont(Font.font ("Arial", 15));
      Text optionE = new Text(null);
      optionE.setFont(Font.font ("Arial", 15));
      Text optionF = new Text(null);
      optionF.setFont(Font.font ("Arial", 15));
   
      
   
      
      //make image for the center box
      Image roomImage = new Image("file:title.jpg");
      //create imageview component
      ImageView roomIView = new ImageView(roomImage);
      
      
      //This text goes into the bottom box and describes the room with getDescription
      Text roomInfo = new Text(null);
      roomInfo.setFont(Font.font ("Arial", 25));
      roomInfo.setFill(Color.SKYBLUE);
      
   
      
      /////////////below is the original input field i had and the event handler for it
      
      //TextField input = new TextField();    
      //input.setEditable(true);
      //Text inputHistory = new Text("Last thing entered:");
      //Text userInput = new Text(null);
      
      
      
   //       //this was action event handler for pressing enter in the original input text field
   //       input.setOnAction(
   //          new EventHandler<ActionEvent>() {
   //             @Override public void handle(ActionEvent e) {
   //       // enter has been pressed in the text field.
   //       
   //             userInput.setText(input.getText());
   //          }
   //       });
   
   
      
      
      //adding each element to its own layout container.
           
      //center
      HBox centerBox = new HBox(roomIView);
      centerBox.setStyle("-fx-background-color: black; -fx-padding: 10;");
      centerBox.setPrefSize(400, 500);    
      
      //top
      HBox topBox = new HBox(roomName);
      topBox.setStyle("-fx-background-color: indigo; -fx-padding: 10;");
      topBox.setPrefSize(600, 50);
      
      //bottom
      HBox bottomBox = new HBox(roomInfo);
      bottomBox.setStyle("-fx-background-color: midnightblue; -fx-padding: 10;");
      bottomBox.setPrefSize(600, 50);
      
      //left
      VBox leftBox = new VBox(characterTitle, characterName, characterLevel, characterHealth, characterExp, characterGold, spacer, enemyTitle, enemyName, enemyHealth, enemyTitle2, enemyName2, enemyHealth2);
      leftBox.setStyle("-fx-background-color: black; -fx-padding: 10;");
      leftBox.setPrefSize(200, 500);
      
      //right
      VBox rightBox = new VBox(console, optionA, optionB, optionC, optionD, optionE, optionF);
      rightBox.setStyle("-fx-background-color: slateblue; -fx-padding: 10;");
      rightBox.setPrefSize(350, 500);
      
   
      //set the alignment
      topBox.setAlignment(Pos.TOP_CENTER);
      bottomBox.setAlignment(Pos.CENTER);
      leftBox.setAlignment(Pos.TOP_LEFT);
      rightBox.setAlignment(Pos.TOP_RIGHT);
      centerBox.setAlignment(Pos.CENTER);
      
      
   
      
      //create the BorderPane.
      BorderPane borderPane = 
         new BorderPane(centerBox, topBox, rightBox, bottomBox, leftBox);
                        
        //set the Size of the VBox
      borderPane.setPrefSize(1200, 600);     
        //set the Style-properties of the BorderPane
      borderPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: purple;");
      
      //create a Scene with the BorderPane as its root node.
      Scene scene = new Scene(borderPane);
      
      //add the Scene to the Stage.
      primaryStage.setScene(scene);
      
      //show the window.
      primaryStage.show();
      
      
      //*****************************************************************START OF GAME
      
      console.setText("Press Enter to Start.");
      //Press Enter to Start
      ChoicePrompt prompt = new ChoicePrompt(borderPane.getScene().getWindow()); 
      roomName.setText(null);
   
           
   
   
   ///////////////////////////Loop I tried that didn't work. I tried a lot of different things but deleted them.
       /*this didn't work because the variable was declared in the loop. I think it does what you want it to now*/
      String name;
      while(true) {
                  
         console.setText("Who are you?");
               
         ChoicePrompt prompt2 = new ChoicePrompt(borderPane.getScene().getWindow());
          
         name = prompt2.getResult();
                  
         if(prompt2.getResult().isEmpty()) { 
         
            continue;
         } 
         
         else {
            break;
         }
          
      }
      Character character = new Character(null, 100, 0, 10, 110);
      character.setName(name);      
       
      Room village = new Room("Village of Meridine", "This is your home. It was peaceful until the day a group of humanoid bandits \ntook up residence in a nearby castle.\n"
                                                   +"They have stolen everything of value from your village and now they want more.\nYou have taken up your father's old sword to eradicate them once and for all.");
      
      roomName.setText("Level: " + village.getName());
      roomInfo.setText(village.getDescription());
      
      //play Cavernous Shadows song
      village.playSong("Cavernous Shadows.mid");
      
      //make the new image. once these are finalized we can instantiate them all in the same place in the code.
      Image forestvillage1Image = new Image("file:forest village 1.jpg");
      //set the room image
      roomIView.setImage(forestvillage1Image);  
      console.setText("Press Enter to continue...");
      ChoicePrompt cont = new ChoicePrompt(borderPane.getScene().getWindow());
      
   
      
      //fill the null characterTitle with "Character:"
      //appears on screen when the character is created.
      characterTitle.setText("Character:");
      
      //these null text objects will be filled with character info.
      characterName.setText(character.getName());
      characterHealth.setText("HP: "+character.getHealth());
      characterGold.setText("Gold: "+character.getGold());
      characterExp.setText("Exp: "+character.getExperience()+" out of "+character.getExpNeeded());
      characterLevel.setText("Level: "+character.getExperienceLevel());
      
      //************************************************************CREATING FIRST ROOM
      //************************************************************Level 1
   
           
      //creating room, a new Room, with this name and description
      Room forest = new Room("Forest", "A dense forest lies between Meridine and the castle.\n" + 
                                                                     "The forest road used to be safe, but no longer.\n" +
                                                                     "You decide travel along beside the road, but well into the trees.\n" +
                                                                     "The trip will take longer, but at least you won't be seen.");      
      roomName.setText("Level: " + forest.getName());
      roomInfo.setText(forest.getDescription());
      forest.setFeature("goldCache");

      //make the new image. once these are finalized we can instantiate them all in the same place in the code. if we want. to look neater.
      Image forestImage = new Image("file:forestroad.jpg");
      //set the room image
      roomIView.setImage(forestImage);
      roomIView.setFitWidth(600);
      roomIView.setFitHeight(350);
      roomIView.setPreserveRatio(true);
      
      characterName.setText(character.getName());
      characterHealth.setText("HP: "+character.getHealth());
      characterGold.setText("Gold: "+character.getGold());
      characterExp.setText("Exp: "+character.getExperience()+" out of "+character.getExpNeeded());
      characterLevel.setText("Level: "+character.getExperienceLevel());
      
      
      console.setText("What will you do, " + character.getName() + "?" );
      optionA.setText("Type FORWARD to continue forward.");
      optionB.setText("Type SEARCH to search the area.");
       
      forest.roomOption(borderPane, forest, character, roomInfo, characterHealth, characterGold, optionA, optionB, optionC, optionD);
      
   
      
   
      //************************************************************CREATING SECOND ROOM
      //************************************************************Level 2      
      
      
      
      
      //creating room2, a new Room, with this name and description
      Room forest2 = new Room("Forest's Edge", "You've been travelling for hours, and it's gotten dark.\nThe trees are thinning, revealing a castle silhoutted in moonlight.");
      forest2.setFeature("stream");
      
      roomName.setText("Level: " + forest2.getName());
      roomInfo.setText(forest2.getDescription());
      
      //make the new image. once these are finalized we can instantiate them all in the same place in the code.
      Image forest2Image = new Image("file:forest2.jpg");
      //set the room image
      roomIView.setImage(forest2Image);
      
      characterName.setText(character.getName());
      characterHealth.setText("HP: "+character.getHealth());
      characterGold.setText("Gold: "+character.getGold());
      characterExp.setText("Exp: "+character.getExperience()+" out of "+character.getExpNeeded());
      characterLevel.setText("Level: "+character.getExperienceLevel());
      
      //*************************************************************************FIRST MONSTER ENCOUNTER
      
      
      console.setText("A Goblin appears!");
      Enemy goblin = new Enemy(50, "Goblin", 1);
      Club club1 = new Club(55, 1);
      enemyTitle.setText("Enemy:");
      enemyName.setText(goblin.getName());
      enemyHealth.setText("HP: " + goblin.getHealth());
      //playing Battle1 theme
      forest2.playSong("Battle1.mid");
      MagicSword magicSword = new MagicSword(false, 1,1,1,1);
      
      
      
      optionA.setText("How do you want to attack the goblin?");
      optionB.setText("Enter SLASH");
      optionC.setText("or STAB");
      
         //function to perform combat
      
      stabAttackCount = character.combatSequenceForOneEnemy(borderPane, weapon, magicSword, goblin, club1, character, stabAttackCount, roomInfo, enemyHealth, characterHealth, characterExp, characterLevel, characterGold, console, optionA, optionB, optionC, optionD, optionE, optionF);
      //creating display message about improved crit chance
      critAchievementMessage = character.getCritAchievementMessage(critAchievementMessage, character, console, optionA, optionB, optionC, optionD, borderPane); 
      
      if (goblin.getHealth()<= 0){  
         //playing Victory music
         forest2.playSong("Victory!.mid");
         attackDamage=0;
            //creating the random equipment object
      
            //calling the randomDrop function
         item = weapon.randomDrop(character);
            //changing display text
         console.setText("The goblin is dead.");
         optionA.setText("The goblin dropped a "+item+".");
         optionC.setText("Press Enter to continue.");
         optionB.setText("And 10 gold.");
         optionD.setText(" ");
         optionE.setText(" ");
         character.setGold(character.getGold()+10);
         characterGold.setText("Gold: " + character.getGold());
         ChoicePrompt trial1 = new ChoicePrompt(borderPane.getScene().getWindow());
            //if statement to create new sword and display specs.
         if (item.compareToIgnoreCase("sword")==0){
               //creating new sword object
            Sword sword6 = new Sword(12);
               //getting sword description
            optionC.setText("New "+sword6.getDescription());
            optionD.setText(weapon.getDescription());
               //ask user if they want to use new sword
            optionE.setText("Do you use the new one? YES or NO.");
            String choice12;
            do{
               ChoicePrompt changeSwordPrompt2 = new ChoicePrompt(borderPane.getScene().getWindow());
               choice12 = changeSwordPrompt2.getResult();
                  //if statement to equip sword
               if (choice12.compareToIgnoreCase("yes")==0){
                  weapon = sword6;
                  optionD.setText("New sword is equipped.");
                  try {
                     Thread.sleep(2000);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
                  break;
               }
               else if(choice12.compareToIgnoreCase("no")==0){                  
                  weapon = fathersSword;
                  optionD.setText(" ");
                  optionB.setText(" ");
                  optionC.setText(" ");
                  optionA.setText("New sword is discarded.");
                  optionE.setText(" ");
                  optionF.setText(" ");
                  ChoicePrompt pause1 = new ChoicePrompt(borderPane.getScene().getWindow());
                  break;
               }
            }while(choice12.compareToIgnoreCase("yes")!=0||(choice12.compareToIgnoreCase("no")!=0)); 
               
         }
            // else if to create ring object and offer chance to use
         else if(item.compareToIgnoreCase("ring")==0){
            Ring ring2 = new Ring(true);
            optionC.setText(ring2.getDescription());
            optionD.setText("Do you want to wear it? YES or NO");
            String wearRingChoice2;
            do{
               ChoicePrompt wearRing2 = new ChoicePrompt(borderPane.getScene().getWindow());
               wearRingChoice2 = wearRing2.getResult();
               if(wearRingChoice2.compareToIgnoreCase("Yes")==0)
               {
                  weapon.setHitChance(ring2.getImprovedHitChance(), weapon);
                  optionC.setText("Your new hit chance is "+weapon.getHitChance()+"%.");
                  optionD.setText("");
                  optionE.setText("");
                  optionF.setText("");
                  ChoicePrompt wearRing = new ChoicePrompt(borderPane.getScene().getWindow());
                  break;
               }
           }while(wearRingChoice2.compareToIgnoreCase("yes")!=0||wearRingChoice2.compareToIgnoreCase("no")!=0);               
         }
         else if(item.compareToIgnoreCase("potion")==0){
            Potion healthPotion2 = new Potion();
            optionC.setText(healthPotion2.getDescription());
            optionD.setText("Do you want to drink your potion? Yes or no.");
            optionE.setText("");
            optionF.setText("");
            ChoicePrompt drinkPotion2 = new ChoicePrompt(borderPane.getScene().getWindow());
            String drinkPotionYOrN = drinkPotion2.getResult();
            if (drinkPotionYOrN.compareToIgnoreCase("Yes") == 0)
            {
               healthPotion2.drink(character);
               characterHealth.setText("HP: "+character.getHealth());
               characterGold.setText("Gold: "+character.getGold());
            }
         }
         else if(item.compareToIgnoreCase("magic sword")==0){
            MagicSword magicSword1 = new MagicSword(true, (randomMS.nextInt(20)+10),15,(75+randomMS.nextInt(20)),(40+randomMS.nextInt(15)));
            magicSword = magicSword1;
            optionC.setText("Hit chance is "+magicSword1.getHitChance()+"%");
            optionD.setText("Stab hit chance is "+magicSword1.getStabHitChance()+"%");
            optionB.setText("Sword also deals "+magicSword1.getIceDamage()+" ice damage and "+magicSword1.getFireDamage()+" fire damage.");
            optionE.setText(magicSword1.getDescription());
            optionF.setText("");
            ChoicePrompt pause2 = new ChoicePrompt(borderPane.getScene().getWindow());
            
         }
      }     
          
      //setting all right hand text fields to null    
      optionA.setText(" ");
      optionB.setText(" ");
      optionC.setText(" ");
      optionD.setText(" ");
      optionE.setText(" ");
      optionF.setText(" ");
      //playing Cavernous Shadows
      forest2.playSong("Cavernous Shadows.mid");
      
         
      console.setText("What will you do, " + character.getName() + "?" );
      optionA.setText("Type FORWARD to continue forward.");
      optionB.setText("Type SEARCH to search the area.");
      
      forest2.roomOption(borderPane, forest2, character, roomInfo,  characterHealth, characterGold, optionA, optionB, optionC, optionD);
        
      
      
      //************************************************************CREATING THIRD ROOM
      //************************************************************Level 3 
      
      //creating room3, a new Room, with this name and description
      Room castleGate = new Room("Castle Gates:", "It's very dark. You approach the gates with caution knowing your enemies have sharp ears.");     
      
      roomName.setText("Level: " + castleGate.getName());
      roomInfo.setText(castleGate.getDescription());
     
      
      //make the new image. once these are finalized we can instantiate them all in the same place in the code.
      Image castleGates = new Image("file:Gate.jpg");
      //set the room image
      roomIView.setImage(castleGates);
      
      characterName.setText(character.getName());
      characterHealth.setText("HP: "+character.getHealth());
      characterGold.setText("Gold: "+character.getGold());
      characterExp.setText("Exp: "+character.getExperience()+" out of "+character.getExpNeeded());
      
      
      
      
      
      //*************************************************************************SECOND MONSTER ENCOUNTER - TWO IMPS
      
      
      console.setText("Two Imps are guarding the gate.");
      optionA.setText("Press Enter to continue.");
      optionB.setText("");
      optionC.setText("");
      optionD.setText("");
      
      ChoicePrompt pause0 = new ChoicePrompt(borderPane.getScene().getWindow()); 
      
      
      
      
      optionA.setText("They've spotted you!");
      Enemy imp1 = new Enemy(40, "Imp 1", 1);
      Enemy imp2 = new Enemy(35, "Imp 2", 1);
      Club club2 = new Club(60,1);
      Club club3 = new Club(60,1);
      enemyTitle.setText("Enemy 1:");
      enemyName.setText(imp1.getName());
      enemyHealth.setText("HP: " + imp1.getHealth());
      
      enemyTitle2.setText("Enemy 2:");
      enemyName2.setText(imp2.getName());
      enemyHealth2.setText("HP: " + imp2.getHealth());
      optionB.setText("Enter SLASH");
      optionC.setText("or STAB");
      optionD.setText("");
      optionE.setText("");
      optionF.setText("");
      
      
      //playing Battle1 song
      castleGate.playSong("Battle1.mid");
      //function to perform 1v2 combat
      
      stabAttackCount = character.combatSequenceForTwoEnemy(borderPane, weapon, magicSword, imp1, imp2, club2, club3, character, stabAttackCount, roomInfo, enemyHealth, enemyHealth2, characterHealth, characterExp, characterLevel, characterGold, console, optionA, optionB, optionC, optionD, optionE, optionF);
      
      
   
   //creating display message about improved crit chance
      critAchievementMessage = character.getCritAchievementMessage(critAchievementMessage, character, console, optionA, optionB, optionC, optionD, borderPane);
                  
      if (imp2.getHealth()<= 0){ 
         //play victory music
         castleGate.playSong("Victory!.mid");
          
         attackDamage=0;
            //calling the randomDrop function
         item = weapon.randomDrop(character);
            //changing display text
         console.setText("The goblin is dead.");
         optionA.setText("The goblin dropped a "+item+".");
         optionC.setText("Press Enter to continue.");
         optionB.setText("And 10 gold.");
         optionD.setText(" ");
         optionE.setText(" ");
         optionF.setText("");
         character.setGold(character.getGold()+10);
         characterGold.setText("Gold: " + character.getGold());
         ChoicePrompt trial1 = new ChoicePrompt(borderPane.getScene().getWindow());
            //if statement to create new sword and display specs.
         if (item.compareToIgnoreCase("sword")==0){
               //creating new sword object
            Sword sword6 = new Sword(12);
               //getting sword description
            optionC.setText(sword6.getDescription());
            optionD.setText(weapon.getDescription());
               //ask user if they want to use new sword
            optionE.setText("Do you use the new one? YES or NO.");
            String choice12;
            do{
               ChoicePrompt changeSwordPrompt2 = new ChoicePrompt(borderPane.getScene().getWindow());
               choice12 = changeSwordPrompt2.getResult();
                  //if statement to equip sword
               if (choice12.compareToIgnoreCase("yes")==0){
                  weapon = sword6;
                  optionD.setText("New sword is equipped.");
                  try {
                     Thread.sleep(2000);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
                  break;
               }
               else if(choice12.compareToIgnoreCase("no")==0){                  
                  optionD.setText(" ");
                  optionB.setText(" ");
                  optionC.setText(" ");
                  optionA.setText("New sword is discarded.");
                  optionE.setText(" ");
                  optionF.setText(" ");
                  try {
                     Thread.sleep(2000);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
                  break;
               }
            }while(choice12.compareToIgnoreCase("yes")!=0||(choice12.compareToIgnoreCase("no")!=0)); 
               
         }
                   // else if to create ring object and offer chance to use
         else if(item.compareToIgnoreCase("ring")==0){
            Ring ring3 = new Ring(true);
            optionC.setText(ring3.getDescription());
            optionD.setText("Do you want to wear it? YES or NO");
            String wearRingChoice;
            do{
               ChoicePrompt wearRing = new ChoicePrompt(borderPane.getScene().getWindow());
               wearRingChoice = wearRing.getResult();
               if(wearRingChoice.compareToIgnoreCase("Yes")==0)
               {
                  weapon.setHitChance(ring3.getImprovedHitChance(), weapon);
                  optionC.setText("Your new hit chance is "+weapon.getHitChance()+"%.");
                  optionD.setText("");
                  optionE.setText("");
                  optionF.setText("");
                  ChoicePrompt pause = new ChoicePrompt(borderPane.getScene().getWindow());
                  break;
               }
           }while(wearRingChoice.compareToIgnoreCase("yes")!=0||wearRingChoice.compareToIgnoreCase("no")!=0);    
         }
         else if(item.compareToIgnoreCase("potion")==0){
            Potion healthPotion2 = new Potion();
            optionC.setText(healthPotion2.getDescription());
            optionD.setText("Do you want to drink your potion? YES or NO.");
            ChoicePrompt drinkPotion2 = new ChoicePrompt(borderPane.getScene().getWindow());
            String drinkPotionYOrN = drinkPotion2.getResult();
            if (drinkPotionYOrN.compareToIgnoreCase("Yes") == 0)
            {
               healthPotion2.drink(character);
               characterHealth.setText("HP: "+character.getHealth());
               characterGold.setText("Gold: "+character.getGold());
            }
         }
         else if(item.compareToIgnoreCase("magic sword")==0){
            MagicSword magicSword1 = new MagicSword(true, (randomMS.nextInt(20)+10),15,(75+randomMS.nextInt(20)),(40+randomMS.nextInt(15)));
            magicSword = magicSword1;
            optionC.setText("Hit chance is "+magicSword1.getHitChance()+"%");
            optionD.setText("Stab hit chance is "+magicSword1.getStabHitChance()+"%");
            optionB.setText("Sword also deals "+magicSword1.getIceDamage()+" ice damage and "+magicSword1.getFireDamage()+" fire damage.");
            optionE.setText(magicSword1.getDescription());
            ChoicePrompt pause2 = new ChoicePrompt(borderPane.getScene().getWindow());
            weapon = magicSword;
         }

      }
      castleGate.playSong("Cavernous Shadows.mid");
        
         //setting all right hand text fields to null    
      optionA.setText(" ");
      optionB.setText(" ");
      optionC.setText(" ");
      optionD.setText(" ");
      optionE.setText(" ");
      optionF.setText(" ");
   
      console.setText(imp2.getName()+" dropped something on the ground!");
          //optionA.setText("You do not need to go in now.");
          //optionB.setText("You can return to your village for tonight and come back tomorrow.");
          //optionC.setText("There is no knowing what you will face when you return though...");
      optionA.setText("Type ENTER to enter the castle.");
      optionB.setText("Type LOOK to look around.");
      
 

      castleGate.castleGateOption(borderPane, castleGate, character, roomInfo,  characterHealth, optionA, optionB, optionC, optionD);  
      
      
      //**********************************************************************************ROOM 5 CASTLE AREA START    
      
      Room castleInterior1 = new Room("Castle Hall", "You have entered the castle. Before you is an old, run-down entrance hall.\n" +
                                                      "The hall is empty, but you hear various sounds coming from adjoining rooms\n" +
                                                      "You quiety dash to the dark corner on your left and take cover behind a large, broken urn.");
      roomName.setText("Level 2: " + castleInterior1.getName());
      roomInfo.setText(castleInterior1.getDescription());
      
      //playing Hyrule-Castle for a castle song
      castleInterior1.playSong("Hyrule-Castle.mid");         
          
      
          //make the new image. once these are finalized we can instantiate them all in the same place in the code.
      Image castleHall = new Image("file:CastleHall.jpg");
          //set the room image
      roomIView.setImage(castleHall);
      roomIView.setFitWidth(600);
      roomIView.setFitHeight(350);
      roomIView.setPreserveRatio(true);
      
      characterName.setText(character.getName());
      characterHealth.setText("HP: "+character.getHealth());
      characterGold.setText("Gold: "+character.getGold());
      characterExp.setText("Exp: "+character.getExperience()+" out of "+character.getExpNeeded());
      console.setText("Press Enter to continue.");
      optionA.setText(" ");
      optionB.setText(" ");
      optionC.setText(" ");
      optionD.setText(" ");
      optionE.setText(" ");
      optionF.setText("");
      //cleaning up the previous room's monsters
      enemyTitle.setText("");
      enemyTitle2.setText("");
      enemyName.setText("");
      enemyName2.setText("");
      enemyHealth.setText("");
      enemyHealth2.setText("");
          
      ChoicePrompt pause = new ChoicePrompt(borderPane.getScene().getWindow());
      
      castleInterior1.setDescription("You got to a safe place just in time!\n" +
                                       "Two goblins walk into the room escorting a fairy in chains.\n" +
                                       "The fairy has been beaten badly. It's in pretty rough shape.");
      roomInfo.setText(castleInterior1.getDescription());
      console.setText("What will you do, " + character.getName() + "?");
      optionA.setText("Type FORWARD to continue and leave the fairy.");
      optionB.setText("Type HELP to try to free the fairy.");      
      castleInterior1.castleHallOption(borderPane, castleInterior1, character, roomInfo, characterHealth, characterGold, optionA, optionB, optionC, optionD);
      characterHealth.setText("HP: "+character.getHealth());
      characterGold.setText("Gold: "+character.getGold());
          
   
       ChoicePrompt helpOrNot = new ChoicePrompt(borderPane.getScene().getWindow()); 
      String helpOrNot1 = helpOrNot.getResult();
      
      if(castleInterior1.getFeature().compareToIgnoreCase("Help")==0){
         Enemy goblin2 = new Enemy(50, "Goblin 1", 60);
         Enemy goblin3 = new Enemy(55, "Goblin 2", 60);
         Club club4 = new Club((5+randomMS.nextInt(10)), 60);
         Club club5 = new Club((7+randomMS.nextInt(10)), 60);
         enemyTitle.setText("Enemy 1: ");
         enemyTitle2.setText("Enemy 2: ");
         enemyName.setText(goblin2.getName());
         enemyName2.setText(goblin3.getName());
         enemyHealth.setText("Hp: "+goblin2.getHealth());
         enemyHealth2.setText("Hp: "+goblin3.getHealth());
         
         roomInfo.setText("You jump out hiding to attack the goblins dragging the chained Fairy.");
         console.setText("");
         optionA.setText("Enter SLASH");
         optionB.setText("or STAB!");
         optionC.setText(" ");
         optionD.setText(" ");
         optionE.setText(" ");
         optionF.setText("");
            
         stabAttackCount = character.combatSequenceForTwoEnemy(borderPane, weapon, magicSword, goblin2, goblin3, club4, club5, character, stabAttackCount, roomInfo, enemyHealth, enemyHealth2, characterHealth, characterExp, characterLevel, characterGold, console, optionA, optionB, optionC, optionD, optionE, optionF);
      //fight comes next, only if castleInterior1.getFeature == help.
      //otherwise the fight will get skipped and the next room will load.  
     castleInterior1.castleHallOption2(borderPane, castleInterior1, character, roomInfo, characterHealth, characterGold, console, optionA, optionB, optionC, optionD, optionE, optionF);      
      ChoicePrompt pause3 = new ChoicePrompt(borderPane.getScene().getWindow());
      if (goblin3.getHealth()<= 0){ 
         //play victory music
         castleGate.playSong("Victory!.mid");
          
         attackDamage=0;
            //calling the randomDrop function
         item = weapon.randomDrop(character);
            //changing display text
         console.setText("The goblin is dead.");
         optionA.setText("The goblin dropped a "+item+".");
         optionC.setText("Press Enter to continue.");
         optionB.setText("And 10 gold.");
         optionD.setText(" ");
         optionE.setText(" ");
         optionF.setText("");
         character.setGold(character.getGold()+10);
         characterGold.setText("Gold: " + character.getGold());
         ChoicePrompt trial1 = new ChoicePrompt(borderPane.getScene().getWindow());
            //if statement to create new sword and display specs.
         if (item.compareToIgnoreCase("sword")==0){
               //creating new sword object
            Sword sword6 = new Sword(12);
               //getting sword description
            optionC.setText(sword6.getDescription());
            optionD.setText(weapon.getDescription());
               //ask user if they want to use new sword
            optionE.setText("Do you use the new one? YES or NO.");
            String choice12;
            do{
               ChoicePrompt changeSwordPrompt2 = new ChoicePrompt(borderPane.getScene().getWindow());
               choice12 = changeSwordPrompt2.getResult();
                  //if statement to equip sword
               if (choice12.compareToIgnoreCase("yes")==0){
                  weapon = sword6;
                  optionD.setText("New sword is equipped.");
                  try {
                     Thread.sleep(2000);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
                  break;
               }
               else if(choice12.compareToIgnoreCase("no")==0){                  
                  optionD.setText(" ");
                  optionB.setText(" ");
                  optionC.setText(" ");
                  optionA.setText("New sword is discarded.");
                  optionE.setText(" ");
                  optionF.setText(" ");
                  try {
                     Thread.sleep(2000);
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  }
                  break;
               }
            }while(choice12.compareToIgnoreCase("yes")!=0||(choice12.compareToIgnoreCase("no")!=0)); 
               
         }
                   // else if to create ring object and offer chance to use
         else if(item.compareToIgnoreCase("ring")==0){
            Ring ring3 = new Ring(true);
            optionC.setText(ring3.getDescription());
            optionD.setText("Do you want to wear it? YES or NO");
            String wearRingChoice;
            do{
               ChoicePrompt wearRing = new ChoicePrompt(borderPane.getScene().getWindow());
               wearRingChoice = wearRing.getResult();
               if(wearRingChoice.compareToIgnoreCase("Yes")==0)
               {
                  weapon.setHitChance(ring3.getImprovedHitChance(), weapon);
                  optionC.setText("Your new hit chance is "+weapon.getHitChance()+"%.");
                  optionD.setText("");
                  optionE.setText("");
                  optionF.setText("");
                  ChoicePrompt pause4 = new ChoicePrompt(borderPane.getScene().getWindow());
                  break;
               }
           }while(wearRingChoice.compareToIgnoreCase("yes")!=0||wearRingChoice.compareToIgnoreCase("no")!=0);    
         }
         else if(item.compareToIgnoreCase("potion")==0){
            Potion healthPotion2 = new Potion();
            optionC.setText(healthPotion2.getDescription());
            optionD.setText("Do you want to drink your potion? YES or NO.");
            ChoicePrompt drinkPotion2 = new ChoicePrompt(borderPane.getScene().getWindow());
            String drinkPotionYOrN = drinkPotion2.getResult();
            if (drinkPotionYOrN.compareToIgnoreCase("Yes") == 0)
            {
               healthPotion2.drink(character);
               characterHealth.setText("HP: "+character.getHealth());
               characterGold.setText("Gold: "+character.getGold());
            }
         }
         else if(item.compareToIgnoreCase("magic sword")==0){
            MagicSword magicSword1 = new MagicSword(true, (randomMS.nextInt(20)+10),15,(75+randomMS.nextInt(20)),(40+randomMS.nextInt(15)));
            magicSword = magicSword1;
            optionC.setText("Hit chance is "+magicSword1.getHitChance()+"%");
            optionD.setText("Stab hit chance is "+magicSword1.getStabHitChance()+"%");
            optionB.setText("Sword also deals "+magicSword1.getIceDamage()+" ice damage and "+magicSword1.getFireDamage()+" fire damage.");
            optionE.setText(magicSword1.getDescription());
            ChoicePrompt pause4 = new ChoicePrompt(borderPane.getScene().getWindow());
            weapon = magicSword;
         }

      }           
     Room castleInterior2 = new Room("Castle Throne Room", "As you wandered through the castle you had heard loud, guffawing\n" +
                                                      "echoing through the forgotten halls. Now that you have gotten near enough to the sound, you find\n" +
                                                      "that the evil tone of the voice is unbearable. It is coming from the open set of doors in front of you.");
      roomName.setText("Level 2: " + castleInterior2.getName());
      roomInfo.setText(castleInterior2.getDescription());
      
      //playing Hyrule-Castle for a castle song
      castleInterior2.playSong("Hyrule-Castle.mid");         
          
      
          //make the new image. once these are finalized we can instantiate them all in the same place in the code.
      Image castleDoors = new Image("file:CastleDoors.jpg");
          //set the room image
      roomIView.setImage(castleDoors);


      }

   }   
   
}