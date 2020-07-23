package keep;

import java.awt.Button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Keep extends Application {
    private double xOffset  = 0 ; 
    private double yOffset = 0 ;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        stage.setResizable(false);

        //  root.setOnMousePressed(new EventHandler<MouseEvent>(){
           
        //       @Override
        //     public void handle(MouseEvent event) {
        //          xOffset = event.getSceneX() ; 
        //        yOffset = event.getSceneY() ; 
                
        //     }
            
        // }) ;
        //root.setOnMouseDragged(new EventHandler<MouseEvent>(){

        //    @Override
        //   public void handle(MouseEvent event) {
        //        stage.setX(event.getSceneX()-xOffset);
        //      stage.setY(event.getSceneY()-yOffset);
        //   }
        // });
        
        
        
        
        
        
	    
	    
	    
	    
        
        
        
        
        
        
        scene.setFill(Color.TRANSPARENT);   
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
