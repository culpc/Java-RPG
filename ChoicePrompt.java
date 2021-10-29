//Imported classes to obtain methods.
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


  class ChoicePrompt {
    
    //Create field
    private final String result;

    
    ChoicePrompt(Window owner) {
      
      //Create Stage. Then, create features for the window.
      final Stage dialog = new Stage();

      //dialog.setTitle("Enter your option.");
      dialog.initOwner(owner);
      dialog.initStyle(StageStyle.UNDECORATED);
      dialog.initModality(Modality.WINDOW_MODAL);
      dialog.setX(owner.getX() + (owner.getWidth() - 300));
      dialog.setY(owner.getY() + 350);

      //Create textField object for input. Then, create button to go to next window.
      final TextField textField = new TextField();
      final Button submitButton = new Button("Submit");
      submitButton.setDefaultButton(true);
      submitButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent t) {
          dialog.close();
        }
      });
      textField.setMinHeight(TextField.USE_PREF_SIZE);

      //Create VBox and then, create features for the background
      final VBox layout = new VBox(10);
      layout.setAlignment(Pos.CENTER_RIGHT);
      layout.setStyle("-fx-background-color: purple; -fx-padding: 10;");
      layout.getChildren().setAll(textField, submitButton);

      //Set scene and then, show window.
      dialog.setScene(new Scene(layout));
      dialog.showAndWait();

      //Initialize to the text in textField 
      result = textField.getText();
      
      
    }
    
    /**
      The getResult method returns the ChoicePrompt object's result.
      @return The value in the result field.
    */
    public String getResult() {
         return result;
      }
}
