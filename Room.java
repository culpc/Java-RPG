//Imported classes to obtain methods
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
import java.util.*;
import java.io.File;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


//casey
//v2 of Room class
import java.util.*;
public class Room {

   //Create fields
   private String name; //The name of the room
   private String description; //The description of the room
   private String roomImage, searchFeature; //The image of the room and the feature to search the room
   private String roomResponse;
   
   /**
      This constructs a room with its room name and description.
      @param roomName The name of the room.
      @param roomDescription The description of the room.
   */
   public Room(String roomName, String roomDescription) {
      name = roomName;
      description = roomDescription;
      
      //Set to "nothing" as a null search feature
      searchFeature = ("nothing");     
   }

   /**
      The getName method returns the name of the room to the user.
      @return The name of the room.
   */
   public String getName() {
      return name;
   }
    
   /**
      The getDescription method returns the description of the room to the user.
      @return The description of the room.
   */
   public String getDescription() {    
      return description;
   }
   
   public void setDescription(String d) {
      this.description = d;
   }
      
   /**
      The getFeature method returns a Room object's searchFeature.
      @return The value in the searchFeature field.
   */
   public String getFeature() {
      return searchFeature;
   }
   
   /**
      The setFeature method stores the room's feature in the searchFeature field.
      @param f The room's feature to be searched.
   */
   public void setFeature(String f) {
      this.searchFeature = f;
   }
   
   /**
      The playSong method plays the room song using jFugue features.
      @param song The room's song.
   */
   public void playSong(String song) {
   
   
   
         new Thread() {
         
         
            @Override
            public void run() {            
               try {
                  Player player = new Player();                  
                  Pattern pattern = new Pattern(MidiFileManager.loadPatternFromMidi(new File(song)));
                  player.play(pattern); 
                     
               }catch(Exception e){System.out.println(e);}
            }
         }.start(); 
         
   
         
   
         
   }
   
   
   //*******************************************************FOREST2 / GENERAL OPTIONS
   /**
      The roomOption method allows the user to select options within the forest2 room.
      @param bP The BorderPane
      @param player The character
      @param roomI The room
      @param pH The character's health.
      @param pG The character's gold
      @param optA To format text
      @param optB To format text
      @param optC To format text
      @param optD To format text
      
   */
   public void roomOption(BorderPane bP, Room room, Character player, Text roomI, Text pH, Text pG, Text optA, Text optB, Text optC, Text optD){
      String roomChoice;
      do{
         
         //Prompts user to search and move around the room and exit the game. Also, displays the character's player health, experience and gold.
         ChoicePrompt promptRoom = new ChoicePrompt(bP.getScene().getWindow());
         roomChoice = promptRoom.getResult();     
      
      
         if (roomChoice.compareToIgnoreCase("search")== 0) 
         { 
               
            if (room.getFeature() == "nothing") {
               optB.setText("You find nothing useful.");
               optC.setText("");
            }
            else if(room.getFeature().compareToIgnoreCase("stream")==0) {
               optB.setText("You find a stream and drink from it.");
               optC.setText("You gain 25 HP.");
                  
               if(player.getHealth() + 25<=player.getMaxHealth()) {
                  player.setHealth(player.getHealth() + 25);
                  pH.setText("HP: " + player.getHealth());
                  room.setFeature("nothing");               //set the feature to nothing so it can't be used again
                     
               }
               else {
                  player.setHealth(player.getMaxHealth());
                  pH.setText("HP: " + player.getHealth());
                  room.setFeature("nothing"); 
               }
            }   
            else if(room.getFeature().compareToIgnoreCase("goldCache")==0) {
               optB.setText("You found an old coin purse.");
               optC.setText("You gain 20 gold!");
               player.setGold(player.getGold()+20);
               pH.setText("HP: " + player.getHealth());
               pG.setText("Gold: " + player.getGold());
               room.setFeature("nothing");  
            } 
            
            
            else
            {
               optB.setText(room.getFeature());
            }
         }
         else if( roomChoice.compareToIgnoreCase("forward") == 0) {
            break;
         }            
         
            //code to exit the program
         else if((roomChoice.compareToIgnoreCase("quit")==0) || (roomChoice.compareToIgnoreCase("exit") == 0))
         {
            System.exit(1);
         }
      }while(true);
     
   } 
   




   /**
      The castleGateOption method allows the user to select options within the castle room.
      @param bP The BorderPane
      @param player The character
      @param roomI The room
      @param pH The character's health.
      @param optA To format text
      @param optB To format text
      @param optC To format text
      @param optD To format text
   */
   public void castleGateOption(BorderPane bP, Room room, Character player, Text roomI, Text pH, Text optA, Text optB, Text optC, Text optD){
      String roomChoice;
      do{
         //Prompt user to search, look, and move around room and exit game.
         ChoicePrompt promptRoom = new ChoicePrompt(bP.getScene().getWindow());
         roomChoice = promptRoom.getResult();     
      
      /*the options for this room will be:
      Type ENTER to enter the castle -response- The gates are locked. / You use the key to open the gates./n and enter the castle.
      Type LOOK to look around -response- There's a key on the ground. You obtained the Skeleton Key.
      optC text field will remind you to try the gate again
      */      
      
         if (roomChoice.compareToIgnoreCase("look")== 0) 
         { 
               
         
            
            if(room.getFeature().compareToIgnoreCase("nothing")==0) {
               optB.setText("There's a key on the ground.");
               optC.setText("You obtained the Skeleton Key.");
               optD.setText("Type ENTER to enter the castle.");
            
               room.setFeature("skeletonkey");    //setting the feature to skeletonkey 
                                 
            }
            
            else
            {
               optB.setText(room.getFeature());
            }
         }
         else if( roomChoice.compareToIgnoreCase("enter") == 0) {
            if (room.getFeature().compareToIgnoreCase("nothing") == 0) {
               optA.setText("The gates are locked.");
            }
            else if(room.getFeature().compareToIgnoreCase("skeletonkey")==0) {
            
             
                    
            
               break;
            }
         }            
         
            //Code to exit the program
         else if((roomChoice.compareToIgnoreCase("quit")==0) || (roomChoice.compareToIgnoreCase("exit") == 0))
         {
            System.exit(1);
         }
      }while(roomChoice.compareToIgnoreCase("search")!=0 || roomChoice.compareToIgnoreCase("forward")!=0 || roomChoice.compareToIgnoreCase("quit")!=0 );
     
   }    


   /**
      The castleHallOption method allows the user to select options within the castle room.
      @param bP The BorderPane
      @param player The character
      @param roomI The room
      @param pH The character's health.
      @param optA To format text
      @param optB To format text
      @param optC To format text
      @param optD To format text
   */
   public void castleHallOption(BorderPane bP, Room room, Character player, Text roomI, Text pH, Text pG, Text optA, Text optB, Text optC, Text optD){
      String roomChoice;
      String buyChoice;
      //Prompt user to help, go forward or exit game.
    
      do{
         ChoicePrompt promptRoom = new ChoicePrompt(bP.getScene().getWindow());
         roomChoice = promptRoom.getResult();         
      
      /*the options for this room will be:
      Type HELP to help the fairy. This will start a fight.
      Type FORWARD continue without helping. this will skip to the next room.
      */      
      
         if (roomChoice.compareToIgnoreCase("help")== 0) { 
  
            optB.setText("You decide to help the fairy.");
            optC.setText("Prepare to fight!");
            optD.setText("Press Enter to continue.");
            room.setFeature("help");    //setting the feature to help to indicate your choice to help the fairy 
            break;                  
         }
         
         else if( roomChoice.compareToIgnoreCase("forward") == 0) {
         
            optA.setText("You decided to leave the fairy to its fate.");
            optB.setText("Press Enter to continue.");
            break;   
         }            
         
            //Code to exit the program
         else if((roomChoice.compareToIgnoreCase("quit")==0) || (roomChoice.compareToIgnoreCase("exit") == 0))
         {
            System.exit(1);
         }
      }while(roomChoice.compareToIgnoreCase("help")!=0 || roomChoice.compareToIgnoreCase("forward")!=0 || roomChoice.compareToIgnoreCase("quit")!=0 );
     
   }
   public void castleHallOption2(BorderPane bP, Room room, Character player, Text roomI, Text pH, Text pG, Text cons, Text optA, Text optB, Text optC, Text optD, Text optE, Text optF){
      String buyChoice = "no"; 
      do{
         if (room.getFeature().compareToIgnoreCase("Help")==0){
            cons.setText("The goblins are dead!"); 
            optA.setText("You remove the fairy's chains.");
            optB.setText("It offers to help you as thanks.");
            optC.setText("You can buy Potion with 20 gold!");
            optD.setText("Do you want to buy, Yes or No?");
           
            ChoicePrompt promptBuy = new ChoicePrompt(bP.getScene().getWindow());
            buyChoice =  promptBuy.getResult();
            if (buyChoice.compareToIgnoreCase("Yes")== 0)
            {
               Potion potion = new Potion();
               player.setGold(player.getGold()-20);
               potion.drink(player);
               optB.setText("You bought a potion.");
               optC.setText("Health is restored by "+potion.getHealingAmount()+".");
               optD.setText("The fairy eats the gold you gave it ");
               optE.setText("and teleports away.");
               pH.setText("HP: " + player.getHealth());
               pG.setText("Gold: " + player.getGold());
               break; 
            }
            else
            {
               optB.setText("You did not buy a potion.");
               optC.setText("The fairy leaves you to your doom.");
               optD.setText("");
               optE.setText("");
               optF.setText("");               
               break;
            }  
          }       
      }while(buyChoice.compareToIgnoreCase("Yes")!=0||buyChoice.compareToIgnoreCase("no")!=0);
   }     
}