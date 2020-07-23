/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keep;

import com.jfoenix.controls.*;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Button;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import oracle.jdbc.*;
import oracle.ord.im.OrdMediaUtil;
import	oracle.ord.im.OrdImage; // Pour la classe OrdImage
import	oracle.ord.im.OrdImageSignature;  



public class FXMLDocumentController implements Initializable {
    
    
      public ButtonGroup  buttongrp   ;
        
    
      @FXML
      private JFXButton next;
      @FXML
      private JFXButton next2;
      @FXML
      private JFXButton next3;
      @FXML
      private JFXButton home ;
      @FXML
      private JFXButton search ;
      @FXML
      private JFXButton chooseimage ;
      @FXML
      private JFXButton choosefolder ;
      @FXML
      private JFXButton addimages ;
      @FXML
      private JFXButton result ; 
      @FXML
      private JFXButton advanced ;
      
      @FXML
      private JFXButton addimages1;
      
      @FXML
      private JFXButton closebtn ;
      @FXML
      private JFXButton minimisebtn ;
      
      @FXML
      private void closeButtonAction(){
          // get a handle to the stage
          Stage stage = (Stage) closebtn.getScene().getWindow();
          // do what you have to do
          stage.close();
      }
      
      @FXML
      private void minimiseButtonAction(){
          // get a handle to the stage
          Stage stage = (Stage) closebtn.getScene().getWindow();
          // do what you have to do
          stage.setIconified(true);
      }
      
  
      
      
      
      
      
      @FXML
      private ImageView chooesd_img ; 
      @FXML
      private JFXSlider texture1;
      @FXML
      private JFXSlider color1;
      @FXML
      private JFXSlider shap1;
      @FXML
      private JFXSlider location1;
      @FXML
      private Slider wheight1; 
      @FXML
      private Slider prefferedmaximage;
      
      
      
      
      
      @FXML
      public AnchorPane pane1  ; 
      @FXML 
      public AnchorPane pane2 ;
      @FXML 
      public AnchorPane pane3 ;
      @FXML 
      public AnchorPane pane4;
      @FXML 
      private AnchorPane panelogo ;
      @FXML 
      private AnchorPane paneresult;
      
      @FXML 
      private AnchorPane advanced_anchor;
      @FXML 
      public AnchorPane uploading;
      @FXML 
      public AnchorPane success;
      
      
      
      @FXML 
      public  JFXRadioButton db  ; 
      @FXML
      private JFXRadioButton dir  ; 
      
      @FXML 
      private AnchorPane anchoscene ;
      
      
      @FXML 
      private AnchorPane myresultimages ;
      
      @FXML 
      private AnchorPane bluepane ;
      
      
      
      @FXML
      private JFXButton choose_image ;
      final ToggleGroup group = new ToggleGroup();
      
       
      
      @FXML
      private Spinner spinnerval;
      
      
      @FXML 
      private Label ipload_label ;
      @FXML 
      private Label ipload_label1 ;
      
      
      
      @FXML 
      private ScrollPane scroll ;
      
      
      
  	 private static String search_image_path ;
  	 private static  double color;
  	 private static double texture;
  	 private static double location;
  	 private static double shape;
  	 private static double wheight=15;
  	 private static int number_of_imagesresults=3;
  	
  	 private static String FILE_DIR1 ;//="d:\\images";
  	 private static String FILE_DIR2=null ;
  	 private static String full_path1=null ;//="d:\\images";
  	 private static String IMG1 ;
   	 private static String IMG2 ; 
      
      
     private boolean choose = false;
	 private static int advance_wanted=0;
      
      
      
	 
	 
	  
	 
	  
	 
	   
	   
      
   //fill some variables
        @FXML
    private void singleFilechooser(ActionEvent event){
         FileChooser filechooser  = new FileChooser() ; 
         filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.gif", "*.bmp")) ;
         File f =  filechooser.showOpenDialog(null) ;
        if(f !=null){ 
        	
           FILE_DIR1=f.getParent(); 
 	       if( FILE_DIR2==null)    FILE_DIR2=f.getParent(); 
 	       IMG1= f.getName();
 	       search_image_path = f.getAbsolutePath();
 	       full_path1=f.getAbsolutePath();
 	       
 	      next.setDisable(false);
 	       
 	      
 	      
 	       
 	   //chooesd_img = new ImageView(new Image(full_path1));
 	      //    System.out.println("IMG"+IMG1);  
 	      //     System.out.println("search_image_path"+search_image_path);  
 	      //     System.out.println("full_path1"+full_path1);  
 	     //     System.out.println("FILE_DIR1"+FILE_DIR1);  
 	      //    System.out.println("FILE_DIR2"+FILE_DIR2);
 	      
 	      
 	      
 	      
 	       
        }    
    
    }
    
        
       
        
      //=====================================ADD images TO DB ================================  
        @FXML
        private void ImagefolderFilechooser(ActionEvent event){
        	
             DirectoryChooser Imagefolder = new DirectoryChooser() ; 
             File f =  Imagefolder.showDialog(null) ; 
               if(f !=null){  
            	   
            	  // success.setVisible(true);         uploading.setVisible(true);
                    String path  = f.getAbsolutePath();
                    System.out.println("--->"+path);
                    FILE_DIR1=f.getAbsolutePath();
                     
                    ipload_label.setText(" images Uploaded to database successfully");  ipload_label1.setText(""); 
               try { 
	 				Class.forName("oracle.jdbc.driver.OracleDriver");   
	 				Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:orcl","system","123456");  
	 	          Statement stmt = con.createStatement();
	 	          
		 		 int id=0;
				 ResultSet rs=stmt.executeQuery("SELECT MAX(image_id) FROM ORACLIMAGES");
			     while(rs.next()) id= rs.getInt(1)+1;   
			     
		          File  directory = new File(FILE_DIR1); 
		          String sql121= " CREATE OR REPLACE DIRECTORY FILE_DIR1 as '"+FILE_DIR1+"' " ; 
		           
		          stmt.executeQuery( sql121 );  
			       for (File file : directory.listFiles())
			      {   
			    	   // could also use a FileNameFilter
			          if(file.getName().toLowerCase().endsWith(".png") || file.getName().toLowerCase().endsWith(".jpg")  )
			          { 
			        	  IMG2 = file.getName(); 
			        	  sql121 =  " DECLARE  " +   
			        	          " image ORDSYS.ORDIMAGE; \r\n" + 
			        	          " query_signature ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
			        	          " query_image ORDSYS.ORDIMAGE; \r\n" + 
			        	          " query_signature1 ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
			        	          " query_image1 ORDSYS.ORDIMAGE;"+  
			        	          " BEGIN \n" + 
			        	          " insert into ORACLIMAGES(image_id,image,signature,image_path) values("+id+",ordsys.ordimage.init('FILE','FILE_DIR1','"+IMG2+"'),ORDSYS.ORDImageSignature.init(),'"+file.getAbsolutePath()+"');"+ 
			        	          " SELECT image,  signature INTO  query_image, query_signature FROM ORACLIMAGES   WHERE image_id = "+id+" FOR UPDATE; "+ 
			        	          "query_signature.generateSignature(query_image); " + 
			        	          " UPDATE ORACLIMAGES SET  signature = query_signature  WHERE image_id = "+id+";"+  
			        	          " END;" ;   
			        	             stmt.execute(sql121); 
			        	             id++;   
		  System.out.println("-->"+IMG2);  
			          } }  
			       
		            stmt.close();   con.close(); 
		        } catch(SQLException | ClassNotFoundException e) { e.printStackTrace() ;} 
               
                 
                 
          //   set uploading to false   for(int i=0;i<100000;i++) { System.out.println("i"+i);	 } 
                    	  
                     
               
           }   
              uploading.setVisible(false);  success.setVisible(true);  
              
               
        } 
        
               
          
         
        
         
        
	//===================================== initialize folder for image search ================================  
    @FXML
    private void folderFilechooser(ActionEvent event){
         DirectoryChooser folder = new DirectoryChooser() ;
         File f =  folder.showDialog(null) ;
         
         if(f !=null){   
        	 FILE_DIR2   = f.getAbsolutePath(); 
              System.out.println("*****   "+FILE_DIR2 );
              next3.setDisable(false);
          	
         }
         
         
         
    }
    
    
    
   
    
    
    
    
      
   
    
    
    
  
    	
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws URISyntaxException {
    	
    	
    	bluepane.setStyle("-fx-background-color: #1A33D5");
    	
    	 
    	 
    	
       
    	
    	
          if (event.getSource() == next) { 
              pane1.setVisible(false);
              pane2.setVisible(true); 
              pane3.setVisible(false); 
              
              texture = texture1.getValue() ;
              color = color1.getValue() ;
              shape  = shap1.getValue() ;
              location = location1.getValue() ;
               
              /*
              System.out.println(""+texture);
              System.out.println(""+color);
              System.out.println(""+shape);
              System.out.println(""+location );
              
             */    
         }
          
          
          
          if (event.getSource() == db) {
        	  next2.setDisable(false);
          }
          
          if (event.getSource() == dir) {
        	  next2.setDisable(false);
          }
          
           
          
          
          if (event.getSource() == next2) {
             // pane2.setVisible(false);
              //pane3.setVisible(true);
              
              if(db.isSelected()) {
            	  choose = false; 
              }
              if(dir.isSelected()) {
            	  choose = true; 
              }
              
              if(choose) {
            	  
            	  pane2.setVisible(false);
                  pane3.setVisible(true);
              }
              else {
            	  pane2.setVisible(false);
                  pane4.setVisible(true); 
              }
              
              //added for slideer rules
              advanced_anchor.setVisible(false);
              
              if(choose) {
     	         File  directory2 = new File(FILE_DIR2);
     		     int imagesinfolder = directory2.listFiles().length;  
     		     if(imagesinfolder>=15) prefferedmaximage.setMax(15) ;
     		     else prefferedmaximage.setMax(imagesinfolder);   
     	         }  
     	         else {
     	        	 try { 
      		 			 Class.forName("oracle.jdbc.driver.OracleDriver");   
      					 Connection con=DriverManager.getConnection(  
     					 "jdbc:oracle:thin:@localhost:1521:orcl","system","123456"); 
       			          Statement stmt = con.createStatement();  
     			             
       			           ResultSet rs= stmt.executeQuery( "select count(*) from ORACLIMAGES" ); 
       			           System.out.println("image counts in db  "); 
     			          int  imagesindb=0;
     			          while(rs.next()) imagesindb=rs.getInt(1);
     			        
     			           System.out.println("image counts in db "+imagesindb);
     	        	       if(imagesindb>=15) prefferedmaximage.setMax(15) ;  
     	        	       else prefferedmaximage.setMax(imagesindb);  
     	        	 } catch(SQLException | ClassNotFoundException e) { e.printStackTrace() ;} 
     	         }
              
              
              
        }
          
          if (event.getSource() == advanced ){   
          	if(advance_wanted%2==0) advanced_anchor.setVisible(true); 
          	else {advanced_anchor.setVisible(false); }
          	advance_wanted++;
          }
          
          if(event.getSource() == next3){
              pane3.setVisible(false);
              pane4.setVisible(true);   
        }
       
          
        
          
          
          if (event.getSource() == home) {
        	  pane2.setVisible(false);
        	  panelogo.setVisible(true );
        	  pane1.setVisible(true); 
        	  pane2.setVisible(false); 
        	  pane3.setVisible(false); 
        	  pane4.setVisible(false); 
              myresultimages.setVisible(false); 
              uploading.setVisible(false);
              success.setVisible(false);

        } 
          
          
          if (event.getSource() == search ) {

        	  try {
        		  Desktop.getDesktop().browse(new URI("https://drive.google.com/open?id=1YkxBof0EoADE21-SOiCiiBOWlzrfiale"));
       	    } catch (IOException e) {
       	        e.printStackTrace();
       	    } 
          }
         
          
          
          /* if (event.getSource() == search ){ 
           myresultimages.setVisible(true);  
           FlowPane imagePane = new FlowPane(); 
           ScrollPane scroll = new ScrollPane(imagePane);
           scroll.setFitToWidth(true); 
           scroll.setPrefSize(520, 515);  
           imagePane.setHgap(2);   imagePane.setVgap(5);  
           imagePane.setRowValignment(VPos.CENTER);
           imagePane.setColumnHalignment(HPos.LEFT); 
           Label score_res;
           Pane mypanelabel;
           Image   image;
           VBox vbox;
           ImageView newImage;
           for(int i=0;i<10;i++) {   
        	    image  = new  Image("file:///D:\\changed\\img1.png");  
                newImage = new ImageView(image);   
                Tooltip.install(newImage, new Tooltip("dfdddddd"));
                newImage.setFitHeight(250); newImage.setFitWidth(250);  
                vbox= new VBox(); 
                vbox.getChildren().add(newImage);  
                mypanelabel = new Pane();
              
               score_res= new Label("Score :"+i); 
               score_res.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
               score_res.setTextFill(Color.WHITE);
               mypanelabel.setPrefSize(250, 20);
               
                
               mypanelabel.setBackground(new Background(new BackgroundFill(Color.web("#2262c6"), new CornerRadii(2),new Insets(1)))); 
               score_res.translateXProperty().bind(mypanelabel.widthProperty().subtract(score_res.widthProperty()).divide(2)); 
               mypanelabel.getChildren().add(score_res); 
               vbox.getChildren().add(mypanelabel);
               imagePane.getChildren().add(vbox);  
               imagePane.setStyle("-fx-background-color:transparent;"); 
           } 
           
           bluepane.setStyle("-fx-background-color: #fffff");
           myresultimages.getChildren().add(scroll); 
           
           success.setVisible(true );
           
           
            
        }*/
        
         
        if (event.getSource() == result ){
            panelogo.setVisible(false);
            
            
            number_of_imagesresults =(int)prefferedmaximage.getValue() ; 
            wheight =(int)wheight1.getValue() ;
        	   System.out.println("wheight dddddddddddddddddddddddddddddd: "+wheight);
            
            
            System.out.println("wheight"+wheight+" ----- number_of_imagesresults :"+number_of_imagesresults);   
            
           // paneresult.setVisible(true); 
            
            
            
 //search in folder
            if(choose) {
            	
            	 
 				
				 try {  
 		 			 Class.forName("oracle.jdbc.driver.OracleDriver");   
 					 Connection con=DriverManager.getConnection(  
					 "jdbc:oracle:thin:@localhost:1521:orcl","system","123456"); 
  			          Statement stmt = con.createStatement();  
			          OracleResultSet rset ;  
			          String sql121= " CREATE OR REPLACE DIRECTORY FILE_DIR1 as '"+FILE_DIR1+"' " ;
			          stmt.executeQuery( sql121 ); 
			          sql121= " CREATE OR REPLACE DIRECTORY FILE_DIR2 as '"+FILE_DIR2+"' " ;
			          stmt.executeQuery( sql121 ); 
			          
				      String result_query; 
				     
				    
				      
				      
				      
				  //============================
				        
				        
				      
				      
				      
				      
				    String[]   images1_path  =  new String[number_of_imagesresults];
	 		        Float[]    images1_score =  new Float[ number_of_imagesresults];
	 				
				     int counter=0;
				     
			          File  directory = new File(FILE_DIR2);
			           int imagesinfolder = directory.listFiles().length;
			           
			           String image_path=null;
				       for (File file : directory.listFiles())
				      { 
				    	  
				          // could also use a FileNameFilter
				          if(file.getName().toLowerCase().endsWith(".png") || file.getName().toLowerCase().endsWith(".jpg")  )
				          { 
				        	  IMG2 = file.getName();
				        	 image_path=file.getAbsolutePath();

					          sql121 =  " DECLARE  " +   
					          " image ORDSYS.ORDIMAGE; \r\n" + 
					          " query_signature ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
					          " query_image ORDSYS.ORDIMAGE; \r\n" + 
					          " query_signature1 ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
					          " query_image1 ORDSYS.ORDIMAGE;"+  
					          " BEGIN \n" +  
					          "  query_image := ORDSYS.ORDIMAGE.init('FILE','FILE_DIR1','"+IMG1+"'); " + 
						      "  query_image.setproperties;  " +  
						      "  query_image1 := ORDSYS.ORDIMAGE.init('FILE','FILE_DIR2','"+IMG2+"'); " + 
					          "  query_image1.setproperties;  " +   
					          "  query_signature  := ORDSYS.ORDIMAGESIGNATURE.init(); " + 
					          "  query_signature1 := query_signature; " +   
					          "  DBMS_LOB.CREATETEMPORARY(query_signature.signature, TRUE);  " + 
					          "  DBMS_LOB.CREATETEMPORARY(query_signature1.signature, TRUE);  " + 
					          "  query_signature.generateSignature(query_image);  " + 
					          "  query_signature1.generateSignature(query_image1);  " +  
					          "  UPDATE ORACLIMAGES SET  score=ORDSYS.ORDImageSignature.evaluateScore(query_signature,  query_signature1,'color="+color+",texture="+texture+",shape="+shape+",location="+location+"') " + 
					          "  WHERE image_id = 1; " + 
					          "  UPDATE ORACLIMAGES SET  similarity=ORDSYS.ORDImageSignature.isSimilar(query_signature1, query_signature,'color="+color+",texture="+texture+",shape="+shape+",location="+location+"',"+wheight+") " + 
					          "  WHERE image_id = 1; " +
					          "  UPDATE ORACLIMAGES SET image_path = '"+image_path+"' WHERE image_id = 1; " + 
					         
					         "DBMS_LOB.FREETEMPORARY(query_signature1.signature); " + 
					         "END; ";
					         stmt.execute(sql121); 
					         
		  // System.out.println("end sql");
					         
					         result_query ="SELECT * FROM ORACLIMAGES WHERE image_id = 1 "; 
							 ResultSet rs=stmt.executeQuery(result_query);
							 while(rs.next()) { 
								  
									if(rs.getInt("similarity")==1) {  
	     System.out.println("similariti true");
										
										if( counter   < number_of_imagesresults) { 
										 images1_score[counter] = rs.getFloat("score") ;
										 images1_path[counter] = rs.getString("image_path") ;
										counter++; 
										}
										else if(counter==number_of_imagesresults)
										{ 
		    System.out.println("ordering");
 											float tmp  ;  
											String tmp1 = null;  
									        for(int i=0; i < number_of_imagesresults; i++) 
									        {
									                for(int j=1; j < (number_of_imagesresults-i); j++)
									                {  
									                        if(images1_score[j-1] > images1_score[j])
									                        {   tmp = images1_score[j-1];  
									                                images1_score[j-1] = images1_score[j];  
									                                images1_score[j] = tmp; 
									                                
									                            tmp1 = images1_path[j-1];  
									                                images1_path[j-1] = images1_path[j];  
									                                images1_path[j] = tmp1;  
									                        } 
									                }
									        }
									        counter++;
										}
										else { 
			   System.out.println("editing");

										  for(int i=0 ;i<counter-2;i++){
											//encadrer entre deux 
											  if(images1_score[i] <= rs.getFloat("score") && images1_score[i+1] >= rs.getFloat("score"))
											  {  
		       System.out.println("image score bordered in the array replace the path by"+image_path);
												  images1_score[i+1]=rs.getFloat("score"); 
											     images1_path[i+1] = rs.getString("image_path") ;
		  //   break;
											  }
											  
											}   
									    }	
									  }
 									//System.out.println("-->"+image_path);
									} 
								}  
					         
				          }
				        
				       
				       
				       System.out.println("first is ended");       
				       
				       
				       
				     /* 
				       panelogo.setVisible(false); 
			           myresultimages.setVisible(true);  
			           FlowPane imagePane = new FlowPane(); 
			           ScrollPane scroll = new ScrollPane(imagePane);
			           scroll.setFitToWidth(true);
			           scroll.setPrefSize(518, 513);  
			         //  imagePane.setHgap(10);
			          // imagePane.setVgap(10); 
			           imagePane.setRowValignment(VPos.CENTER);
			           imagePane.setColumnHalignment(HPos.LEFT);   
			           
				      for(int i=0 ;i<counter-1;i++){   
				    	  // Image   image  = new  Image("file:///"+images1_path[i]);  
			               //ImageView newImage = new ImageView(image);  
			              // newImage.setFitHeight(250); newImage.setFitWidth(250); 
			               //imagePane.getChildren().add(newImage);  
				    	  
								  System.out.print("-->"+images1_path[i]); 
								// System.out.println("--Score :" + images1_score[i] ); 
				     }
				      myresultimages.getChildren().add(scroll); 
				      bluepane.setStyle("-fx-background-color: #fffff");
				      
				      
				      */
				      
				      
				      
				      
				        pane1.setVisible(false );
			            pane2.setVisible(false);
			            panelogo.setVisible(false); 
			           myresultimages.setVisible(true);  
			           FlowPane imagePane = new FlowPane(); 
			           ScrollPane scroll = new ScrollPane(imagePane);
			           scroll.setFitToWidth(true); 
			           scroll.setPrefSize(520, 515);  
			           imagePane.setHgap(2);   imagePane.setVgap(5);  
			           imagePane.setRowValignment(VPos.CENTER);
			           imagePane.setColumnHalignment(HPos.LEFT); 
			           Label score_res;
			           Pane mypanelabel;
			           Image   image;
			           VBox vbox;
			           ImageView newImage;
			           for(int i=0 ;i<counter-1;i++){  
			        	    image  = new Image("file:///"+images1_path[i]);  
			                newImage = new ImageView(image);   
			                Tooltip.install(newImage, new Tooltip("src :"+images1_path[i]));
			                newImage.setFitHeight(250); newImage.setFitWidth(250);  
			                vbox= new VBox(); 
			                vbox.getChildren().add(newImage); 
		  System.out.print("-->"+images1_path[i]); 
			                mypanelabel = new Pane(); 
			               score_res= new Label("Difference  :"+images1_score[i]+"%"); 
			               score_res.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
			               score_res.setTextFill(Color.WHITE);
			               mypanelabel.setPrefSize(250, 20); 
			               mypanelabel.setBackground(new Background(new BackgroundFill(Color.web("#2262c6"), new CornerRadii(2),new Insets(1)))); 
			               score_res.translateXProperty().bind(mypanelabel.widthProperty().subtract(score_res.widthProperty()).divide(2)); 
			               mypanelabel.getChildren().add(score_res); 
			               vbox.getChildren().add(mypanelabel);
			               imagePane.getChildren().add(vbox);  
			               imagePane.setStyle("-fx-background-color:transparent;"); 
			           }  
			           bluepane.setStyle("-fx-background-color: #fffff");
			           myresultimages.getChildren().add(scroll); 
			           ipload_label.setText("Search finished with success");
			           ipload_label1.setText("");
			           success.setVisible(true ); 
			           
			           stmt.close(); 
			           con.close(); 
			           
			           images1_path=null ;
			           images1_score= null;
			             
			              
			              
			        } catch(SQLException | ClassNotFoundException e) { e.printStackTrace() ;}    
			        
				
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            }
            
            
  //search in db
            else { 
            	
            	ArrayList<String> images1_path = new ArrayList<String>() ;
 				ArrayList<Float> images1_score = new ArrayList<Float>() ;
 				try { 
 					Class.forName("oracle.jdbc.driver.OracleDriver");   
 					Connection con=DriverManager.getConnection(  
 					"jdbc:oracle:thin:@localhost:1521:orcl","system","123456");  
 		          Statement stmt = con.createStatement();
 		 		  int id=10; 
 				 
 		          File  directory = new File(FILE_DIR1); 
 		          String sql121= " CREATE OR REPLACE DIRECTORY FILE_DIR1 as '"+FILE_DIR1+"' " ;
 		          stmt.executeQuery( sql121 );  
 		            
 		          sql121= " DECLARE " +   
 				          " image ORDSYS.ORDIMAGE; \r\n" + 
 				          " query_signature ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
 				          " query_image ORDSYS.ORDIMAGE; \r\n" + 
 				          " query_signature1 ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
 				          " query_image1 ORDSYS.ORDIMAGE;"+  
 				          " BEGIN \n" +  
 				          " UPDATE ORACLIMAGES SET  image = ORDSYS.ORDIMAGE.init('FILE','FILE_DIR1','"+IMG1+"')  WHERE image_id=1 ;" +
 				          " UPDATE ORACLIMAGES SET  image_path =  '"+full_path1+"' WHERE image_id=1 ;" +
 		          		  " SELECT image,  signature INTO  query_image, query_signature FROM ORACLIMAGES   WHERE image_id =  1  FOR UPDATE; "+ 
 		        	      "query_signature.generateSignature(query_image); " + 
 		        	      " UPDATE ORACLIMAGES SET  signature = query_signature  WHERE image_id =1 ;"+   
 		        	      "END; ";  
 		          
 		         stmt.execute(sql121); 
 		          
 		                 ResultSet rs=stmt.executeQuery("SELECT MAX(image_id) FROM ORACLIMAGES");
 		                 int max=0;
 		                 while(rs.next())  max=rs.getInt(1)+1;  //max=rs.getInt(1)+1;
 		                
 		                 System.out.println("end : "+IMG1);
 		                  
 		                 
 			        	  for(id=10;id<max;id++ ) {  
 			        		 System.out.println("tap : "+id);
 					          sql121 =  " DECLARE  " +   
 					          " image ORDSYS.ORDIMAGE; \r\n" + 
 					          " query_signature ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
 					          " query_image ORDSYS.ORDIMAGE; \r\n" + 
 					          " query_signature1 ORDSYS.ORDIMAGESIGNATURE; \r\n" + 
 					          " query_image1 ORDSYS.ORDIMAGE;"+  
 					          " BEGIN \n" +  
 	                          "  SELECT image,  signature INTO  query_image , query_signature  FROM ORACLIMAGES    WHERE image_id = 1  FOR UPDATE  ;\r\n" +   
 	                          "  SELECT image,  signature INTO  query_image1 , query_signature1  FROM ORACLIMAGES  WHERE image_id ="+id+" FOR UPDATE;\r\n" +   
 					          "  UPDATE ORACLIMAGES SET   score= ORDSYS.ORDImageSignature.evaluateScore(query_signature,  query_signature1,'color="+color+",texture="+texture+",shape="+shape+",location="+location+"') " + 
 					          "  WHERE image_id ="+id+" ;" + 
 					          "  UPDATE ORACLIMAGES SET  similarity= ORDSYS.ORDImageSignature.isSimilar(query_signature1, query_signature,'color="+color+",texture="+texture+",shape="+shape+",location="+location+"',"+wheight+") " + 
 						      "  WHERE image_id ="+id+";" +   
 					          "END; ";
 					         stmt.execute(sql121);
 							 //step4 execute query  
 							 
 							
 			        	  }  
 			        	  System.out.println("end");
 			        	  
 			        	  rs=stmt.executeQuery("SELECT * FROM ORACLIMAGES WHERE similarity=1 Order by score ");
 								  
 						  int counter=0; 
 						  while(rs.next()) {  
 								 // OrdImage img = (OrdImage)((OracleResultSet) rs).getORAData( 2, OrdImage.getORADataFactory() ); 
 							  
 							  
 								  if(rs.getInt("similarity")==1  &&  counter < number_of_imagesresults ) //rs.getFloat("score") < 15 )
 								  { 
 									 
 									 images1_path.add(rs.getString("image_path"));
 									 images1_score.add(rs.getFloat("score")); 
 									 counter++;
 									  
 							      }
 								  else break ;
 											
 										}   
 						   Iterator itr = images1_path.iterator();
 						   Iterator itr2 = images1_score.iterator();
 					       pane1.setVisible(false );
 				           pane2.setVisible(false);
 				           panelogo.setVisible(false); 
 				           myresultimages.setVisible(true);  
 				           FlowPane imagePane = new FlowPane(); 
 				           ScrollPane scroll = new ScrollPane(imagePane);
 				           scroll.setFitToWidth(true); 
 				           scroll.setPrefSize(520, 515);  
 				           imagePane.setHgap(2);   imagePane.setVgap(5);  
 				           imagePane.setRowValignment(VPos.CENTER);
 				           imagePane.setColumnHalignment(HPos.LEFT); 
 				           Label score_res;
 				           Pane mypanelabel;
 				           Image   image;
 				           VBox vbox;
 				           ImageView newImage;
 				           
 				    	  while(itr.hasNext()) { 
 				    		  String path0=(String) itr.next();
 				        	      image  = new  Image("file:///"+path0);    
 				                newImage = new ImageView(image);   
 				                Tooltip.install(newImage, new Tooltip("src :"+path0));
 				                
 				                newImage.setFitHeight(250); newImage.setFitWidth(250);  
 				                vbox= new VBox(); 
 				                vbox.getChildren().add(newImage); 
 			  System.out.print("-->"+path0); 
 				                mypanelabel = new Pane(); 
 				               score_res= new Label("Difference  :"+itr2.next()+"%"); 
 				               score_res.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
 				               score_res.setTextFill(Color.WHITE);
 				               mypanelabel.setPrefSize(250, 20); 
 				               mypanelabel.setBackground(new Background(new BackgroundFill(Color.web("#2262c6"), new CornerRadii(2),new Insets(1)))); 
 				               score_res.translateXProperty().bind(mypanelabel.widthProperty().subtract(score_res.widthProperty()).divide(2)); 
 				               mypanelabel.getChildren().add(score_res); 
 				               vbox.getChildren().add(mypanelabel);
 				               imagePane.getChildren().add(vbox);  
 				               imagePane.setStyle("-fx-background-color:transparent;"); 
 				           }  
 				           bluepane.setStyle("-fx-background-color: #fffff");
 				           myresultimages.getChildren().add(scroll); 
 				           ipload_label.setText("Search finished with success");
 				           ipload_label1.setText("");
 				           success.setVisible(true );
 				           
 				           
 				                  
 				    System.out.println("end "+id);
 			        	  
 			   } catch(SQLException | ClassNotFoundException e) { e.printStackTrace() ;}  
 			 
            	
            	
            	
            	
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
           
        }
    }
    
    
    
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    		
    	
    	    pane1.setVisible(true);
    	    panelogo.setVisible(true);
    	    uploading.setVisible(false);
    	    success.setVisible(false);
    	    
    	    db.setToggleGroup(group);
            dir.setToggleGroup(group);
            
    	    db.setSelected(false);
    		dir.setSelected(false);
        	
    		  next.setDisable(true);
    		  next2.setDisable(true);
    		  next3.setDisable(true);
    		  
    		  
    		//  search.setTootip(new Tooltip("dfede"));
       
            
    }    
    
}
