package application;
	
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
import model.characters.*;
import model.characters.Character;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;



import java.io.IOException;
import java.util.ArrayList;



import org.w3c.dom.Node;



import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;

public class Main extends Application implements EventHandler<ActionEvent> {
	public static Stage Window;
	public static Scene s1, s2;
	public static Character character;
	public static Cell cell;
    public static Hero selectedHero;
	///update:
	public static ArrayList<Pair<Button, Hero>> AvailHeroButtons = new ArrayList< Pair< Button, Hero>>();

	//button is the key
	//hero is the value
	public static Image billimg = new Image("/bill.jpg");
	
	public static Image davidimg = new Image("/david.jpg");
	public static Image ellieimg = new Image("/ellie.jpg");
	public static Image tommyimg = new Image("/tommy.jpg");
	public static Image rileyimg = new Image("/riley.jpg");
	public static Image tessimg = new Image("/tess.jpg");
	public static Image joelimg = new Image("/joel.jpg");
	public static Image henryimg = new Image("/henry.jpg");
	public static Image imgzombie1 = new Image("/zombie 1.jpg");
	public static Image gun = new Image("/gun.gif");
	public static Image potion = new Image("/potion.gif");
	public static Image fire = new Image("/supplyyy.gif");
	public static Image moveIcon = new Image("/move.jpg");
	public static Image black = new Image("/black.jpeg");
	public static Image win = new Image("/youwonn.png");
	public static Image lose = new Image("/youlost.jpg");
	public void start(Stage primaryStage) {
        try {
			Game.loadHeroes("Heroes.csv");
			} 
        catch (IOException e1) {
			e1.printStackTrace();
			}

		
		//try {
        	Window = primaryStage;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1200,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Window.setScene(scene);
			Window.setTitle("The Last Of Us");					
					//CreateScene1();
			//HBox h = DisplayAvailHeroes();
			 

//			 b.setOnAction(e-> {
//				 Window.setScene(s2);
//				});
		    
			//s1 = new Scene(h,400,400);
			BorderPane bp = new BorderPane();
			//bp.setBackground(new Background(img));
			Image img = new Image("/desktop-wallpaper-the-last-of-us-last-of-us-rain-background-the-last-of-us-remastered.jpg");
			//ImageView view = new ImageView(img);
			
			BackgroundImage backgroundImg = new BackgroundImage(
	                img,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.DEFAULT,
	                new BackgroundSize(
	                        BackgroundSize.AUTO,
	                        BackgroundSize.AUTO,
	                        true,
	                        true,
	                        false,
	                        true
	                )	        );
			
			bp.setBackground(new Background(backgroundImg));
			Button b = new Button();
			b.setOpacity(0);
			b.setPrefSize(900, 200);
			Label l = new Label("Are you ready to face your doom?");
			StackPane p = new StackPane();
			p.getChildren().add(l);
			p.getChildren().add(b);
			Font font = Font.font("Impact", FontWeight.EXTRA_BOLD, 50);
			l.setFont(font);
			l.setTextFill(Color.WHITESMOKE);
			
			
	       // Shadow shadow = new Shadow(2, Color.WHITESMOKE);
	        //l.setEffect(shadow);
			
	        DropShadow dropShadow = new DropShadow();
	        dropShadow.setOffsetX(2.5);
	        dropShadow.setOffsetY(2.5);
	        dropShadow.setColor(Color.GRAY);

	        // Apply the DropShadow effect to the Text
	        l.setEffect(dropShadow);

	        // Create a Timeline animation
	        Timeline timeline = new Timeline();
	        timeline.getKeyFrames().addAll(
	                new KeyFrame(Duration.ZERO, new KeyValue(dropShadow.spreadProperty(), 1)),
	                new KeyFrame(Duration.seconds(1), new KeyValue(dropShadow.spreadProperty(), 0))
	        );
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.setAutoReverse(true);
	        timeline.play();

	        
	        
	        bp.setTop(p);
			p.setTranslateY(50);
			p.setTranslateX(150);
	        b.setBackground(new Background(backgroundImg));

	        
	        
	        
//			view.setFitHeight(650);
//			view.setFitWidth(1300);
			//bp.setCenter(view);
			
		//	b.setFont(font);
		//	bp.setTop(b);
			//bp.setBottom(b);
			bp.setAlignment(b, Pos.BOTTOM_CENTER);
			
			Scene s0 = new Scene(new StackPane(bp),1300,650);
		
			Window.setScene(s0);
			BorderPane bpS1 = DisplayAvailHeroes();
			
			
			s1 = new Scene(new StackPane(bpS1),1300,650);	

			
			Window.show();
//			TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1));
//			translateTransition.setNode(bpS1);
//			TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1));
//			translateTransition.setNode(bptemp);
//			b.setOnAction(e ->{
//				translateTransition2.setInterpolator(Interpolator.EASE_BOTH);
//				translateTransition2.setFromX(0) ;  // Fade out the second sce
//				
//			translateTransition.setInterpolator(Interpolator. EASE_BOTH);
//			translateTransition.setFromX(1300) ; // Start with full opacity
//			translateTransition.setToX(0) ;  // Fade out the second scene
//		translateTransition.setOnFinished(e1 -> Window.setScene(s1));
// // Switch to the second scene
//		translateTransition2.play();             
//
//		translateTransition.play();             
//            
//			//Window.setScene(s1);
//			});
			FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.35));
	        fadeTransition.setNode(bp);
	        fadeTransition.setCycleCount(1);
	        fadeTransition.setAutoReverse(true);
	      

	        // Handle scene transition
	        b.setOnMouseClicked(event -> {
	            fadeTransition.setFromValue(1.0);  // Start with full opacity
	            fadeTransition.setToValue(0.0);  
	            fadeTransition.setOnFinished(e -> Window.setScene(s1));  // Switch to the second scene

	            fadeTransition.play();  
	           // fadeTransition2.play();             // Play the transition animation
// Play the transition animation
	        });
	        
//			b.setOnAction(e ->{
//				CreateScene1();
//				Window.setScene(s1);
//			});
			Window.show();

	}
	
	
	public static void CreateScene1() {
		BorderPane bp = DisplayAvailHeroes();
		s1 = new Scene(new StackPane(bp),1200,600);	
	}

	
	
	
	public static BorderPane DisplayAvailHeroes() {
//		
		BorderPane bp = new BorderPane();
		 Image imgS1 = new Image("/darkforestt.jpg");

		BackgroundImage backgroundImg = new BackgroundImage(
                imgS1,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        true,
                        true,
                        false,
                        true
                )	        );
		
		bp.setBackground(new Background(backgroundImg));
		
		HBox HMed = new HBox();
		HBox HExp = new HBox();
		HBox HFigh = new HBox();
		bp.setTop(HMed);
		HMed.setAlignment(Pos.CENTER);

		bp.setCenter(HFigh);
		HFigh.setAlignment(Pos.CENTER);
		
		bp.setBottom(HExp);
		HExp.setAlignment(Pos.CENTER);

		DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.5);
        dropShadow.setOffsetY(2.5);
        dropShadow.setColor(Color.BLACK);

        // Apply the DropShadow effect to the Text

        // Create a Timeline animation
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(dropShadow.spreadProperty(), 1)),
                new KeyFrame(Duration.seconds(1), new KeyValue(dropShadow.spreadProperty(), 0))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();

//		HMed.setBackground(new Background(new BackgroundFill(Color.rgb(150, 222, 209), null, null)));
//		HFigh.setBackground(new Background(new BackgroundFill(Color.rgb(159, 226, 191), null, null)));
//		HExp.setBackground(new Background(new BackgroundFill(Color.rgb(161, 226, 159), null, null)));

		for(int i =0; i<Game.availableHeroes.size(); i++) {
			Button b = new Button();
			Label l = new Label(Game.availableHeroes.get(i).toString());
			Font font = Font.font("Impact", FontWeight.EXTRA_LIGHT, 15);
			l.setFont(font);
			l.setTextFill(Color.WHITESMOKE);
			//b.setPrefSize(80, 100);
			b.setPrefWidth(400);
			b.setPrefHeight(200);
l.setPrefSize(400,200);

			AvailHeroButtons.add(new Pair<Button, Hero>(b, Game.availableHeroes.get(i)));
			if(Game.availableHeroes.get(i) instanceof Medic)
				{
				
				
				//b.setStyle("-fx-background-color: black;");
				
				if(Game.availableHeroes.get(i).getName().equals("Bill")) {
					
					
				  ImageView imageView = new ImageView(billimg);
				  imageView.setFitWidth(120);
				  imageView.setFitHeight(150);
				  imageView.setEffect(dropShadow);

				StackPane p = new StackPane();
				HMed.getChildren().add(p);
				p.getChildren().add(l);
				l.setGraphic(imageView);
				b.setOpacity(0);
				p.getChildren().add(b);

				}
				if(Game.availableHeroes.get(i).getName().equals("Ellie Williams")) {
					  ImageView imageView = new ImageView(ellieimg);
					  imageView.setFitWidth(120);
					  imageView.setFitHeight(150);
					 // b.setGraphic(imageView);
					  imageView.setEffect(dropShadow);

					  StackPane p = new StackPane();
						HMed.getChildren().add(p);
						l.setGraphic(imageView);
						p.getChildren().add(l);
						b.setOpacity(0);
						p.getChildren().add(b);
					}
				if(Game.availableHeroes.get(i).getName().equals("Henry Burell")) {
					  ImageView imageView = new ImageView(henryimg);
					  imageView.setFitWidth(120);
					  imageView.setFitHeight(150);
					 // b.setGraphic(imageView);
					  imageView.setEffect(dropShadow);

					  StackPane p = new StackPane();
						HMed.getChildren().add(p);
						l.setGraphic(imageView);
						p.getChildren().add(l);
						p.getChildren().add(b);

						b.setOpacity(0);
					}
				}
			else if(Game.availableHeroes.get(i) instanceof Fighter)
			{
			//	HFigh.getChildren().add(b);

			//b.setStyle("-fx-background-color: #9FE2BF;");
			
			if(Game.availableHeroes.get(i).getName().equals("Joel Miller")) {
				  ImageView imageView = new ImageView(joelimg);
				  imageView.setFitWidth(120);
				  imageView.setFitHeight(150);
				//  b.setGraphic(imageView);
				  imageView.setEffect(dropShadow);

				  StackPane p = new StackPane();
					HFigh.getChildren().add(p);
					l.setGraphic(imageView);
					p.getChildren().add(l);
					p.getChildren().add(b);

					b.setOpacity(0);
				}
				if(Game.availableHeroes.get(i).getName().equals("David")) {
					  ImageView imageView = new ImageView(davidimg);
					  imageView.setFitWidth(120);
					  imageView.setFitHeight(150);
					//  b.setGraphic(imageView);
					  imageView.setEffect(dropShadow);

					  StackPane p = new StackPane();
						HFigh.getChildren().add(p);
						l.setGraphic(imageView);
						p.getChildren().add(l);
						p.getChildren().add(b);

						b.setOpacity(0);
					}
				
			
			}
			else if(Game.availableHeroes.get(i) instanceof Explorer)
			{
			//	HExp.getChildren().add(b);

				if(Game.availableHeroes.get(i).getName().equals("Tess")) {
					  ImageView imageView = new ImageView(tessimg);
					  imageView.setFitWidth(120);
					  imageView.setFitHeight(150);
					 // b.setGraphic(imageView);
					  imageView.setEffect(dropShadow);

					  
					  StackPane p = new StackPane();
						HExp.getChildren().add(p);
						l.setGraphic(imageView);
						p.getChildren().add(l);
						p.getChildren().add(b);

						b.setOpacity(0);
					}
					if(Game.availableHeroes.get(i).getName().equals("Riley Abel")) {
						  ImageView imageView = new ImageView(rileyimg);
						  imageView.setFitWidth(120);
						  imageView.setFitHeight(150);
						//  b.setGraphic(imageView);
						  imageView.setEffect(dropShadow);

						  
						  StackPane p = new StackPane();
							HExp.getChildren().add(p);
							l.setGraphic(imageView);
							p.getChildren().add(l);
							p.getChildren().add(b);
							b.setOpacity(0);
						}
					if(Game.availableHeroes.get(i).getName().equals("Tommy Miller")) {
						  ImageView imageView = new ImageView(tommyimg);
						  imageView.setFitWidth(120);
						  imageView.setFitHeight(150);
						//  b.setGraphic(imageView);
						  imageView.setEffect(dropShadow);

						  
						  StackPane p = new StackPane();
							HExp.getChildren().add(p);
							l.setGraphic(imageView);
							p.getChildren().add(l);
							p.getChildren().add(b);
							b.setOpacity(0);
						}
			}
			
			b.setOnAction(e -> {
				Button clicked = (Button) e.getSource();
				Game.startGame(handleStartGame(clicked));
				selectedHero = handleStartGame(clicked);
				createscene2();
				 Window.setScene(s2);


			});
		
	}
		return bp;

	}
	
	
	public static VBox DisplayHeroes() {
		VBox V = new VBox();
		V.setSpacing(10);
		for(int i =0; i<Game.heroes.size(); i++) {
			Button l = new Button(Game.heroes.get(i).getName());
			l.setStyle("-fx-background-color:#000000; -fx-border-color: black; -fx-border-width: 2px;");
			Font font = Font.font("Impact", FontWeight.EXTRA_LIGHT, 15);
			l.setFont(font);
			l.setTextFill(Color.WHITESMOKE);
			l.setTranslateX(20);
			
			V.getChildren().add(l);	
			int f = i;
			l.setOnMouseEntered(e ->{
				l.setPrefSize(600, 250);
				l.setWrapText(true);
				l.setText(Game.heroes.get(f).toString());
				ImageView imageView = heroImg(Game.heroes.get(f));
				l.setGraphic(imageView);
				imageView.setFitWidth(80);
				imageView.setFitHeight(110);
			});
			l.setOnMouseExited(e ->{
				l.setGraphic(null);
				l.setPrefSize(100, 50);

				l.setText(Game.heroes.get(f).getName());
			});
			l.setOnAction(e -> {
			    selectedHero = Game.heroes.get(f);
			    createscene2();
			 });  
			
		}
		
		return V;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Hero handleStartGame(Button clicked) {
		Hero h = null;
		for(int i =0; i<AvailHeroButtons.size(); i++) {
			if(clicked.equals( AvailHeroButtons.get(i).getKey()))
			{	
				h = AvailHeroButtons.get(i).getValue();
			break;
			}
	}
		return h;

	}
	
	public static GridPane map(){
		GridPane G = new GridPane();
		G.setPrefSize(825, 650);
		G.setBackground(new Background(new BackgroundFill(Color.rgb(159, 226, 191), null, null)));
		 Image imgS1 = new Image("/map (1).jpg");
		 G.setTranslateX(130);
		 G.setTranslateY(10);
		 BackgroundImage backgroundImg = new BackgroundImage(
	             imgS1,
	             BackgroundRepeat.NO_REPEAT,
	             BackgroundRepeat.NO_REPEAT,
	             BackgroundPosition.DEFAULT,
	             BackgroundSize.DEFAULT
	             );
			
			G.setBackground(new Background(backgroundImg));
			DropShadow dropShadow = new DropShadow();
	        dropShadow.setOffsetX(0.5);
	        dropShadow.setOffsetY(0.5);
	        dropShadow.setColor(Color.BLACK);

	        // Apply the DropShadow effect to the Text

	        // Create a Timeline animation
	        Timeline timeline = new Timeline();
	        timeline.getKeyFrames().addAll(
	                new KeyFrame(Duration.ZERO, new KeyValue(dropShadow.spreadProperty(), 0.5)),
	                new KeyFrame(Duration.seconds(1), new KeyValue(dropShadow.spreadProperty(), 0))
	        );
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.setAutoReverse(true);
	        timeline.play();

	      
	        DropShadow dropShadowInv = new DropShadow();
	        dropShadowInv.setOffsetX(0.5);
	        dropShadowInv.setOffsetY(0.5);
	        dropShadowInv.setColor(Color.BLACK);

	        // Apply the DropShadow effect to the Text

	        // Create a Timeline animation
//	        Timeline timelineInv = new Timeline();
//	        timelineInv.getKeyFrames().addAll(
//	                new KeyFrame(Duration.ZERO, new KeyValue(dropShadowInv.spreadProperty(), 0.5)),
//	                new KeyFrame(Duration.seconds(1), new KeyValue(dropShadowInv.spreadProperty(), 0))
//	        );
//	        timelineInv.setCycleCount(Timeline.INDEFINITE);
//	        timelineInv.setAutoReverse(true);
//	        timelineInv.play();
	        
	        // Apply the DropShadow effect to the Text

	        // Create a Timeline animation
        
	        
	      

	        
		for (int i = 14; i >= 0 ; i--) {
			for (int j = 0; j < Game.map[i].length; j++) {
				
				Button button = new Button();
				 button.setPrefSize(40, 40);
				 button.setOpacity(0);
				 StackPane p = new StackPane();
				 //p.getChildren().add(button);
				 button.setOpacity(0);
				 Label l = new Label();
				 p.getChildren().addAll(l,button);
				 G.add(p,j,14-i);
				 
				 
				 
				 if (((Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter()== null)
						 || Game.map[i][j] instanceof TrapCell ) &&  Game.map[i][j].isVisible()){
						button.setStyle("-fx-background-color:#FFFFFF; -fx-border-color: white; -fx-border-width: 0px;");
				
				 }
				 
				 if ((Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero)){
					// button.setText(((CharacterCell) Game.map[i][j]).getCharacter().getName());
					 Hero h = (Hero) ((CharacterCell) Game.map[i][j]).getCharacter();
					 if(h instanceof Medic)
						{
						
						 if(h.getName().equals("Bill")) {
								
								
							  ImageView imageView = new ImageView(billimg);
							  imageView.setFitWidth(40);
							  imageView.setFitHeight(40);

							l.setGraphic(imageView);
							button.setOpacity(0);
							
							if(selectedHero.equals(h))
								  imageView.setEffect(dropShadow);


							}
							if(h.getName().equals("Ellie Williams")) {
								
								  ImageView imageView = new ImageView(ellieimg);
								  imageView.setFitWidth(40);
								  imageView.setFitHeight(40);
								  if(selectedHero.equals(h))
									  imageView.setEffect(dropShadow);
								  l.setGraphic(imageView);
									button.setOpacity(0);
								}
							if(h.getName().equals("Henry Burell")) {
								
								  ImageView imageView = new ImageView(henryimg);
								  imageView.setFitWidth(40);
								  imageView.setFitHeight(40);
								  if(selectedHero.equals(h))
									  imageView.setEffect(dropShadow);
								  l.setGraphic(imageView);
									button.setOpacity(0);
								}
//						button.setStyle("-fx-background-color: white;");
//						Image image = new Image("C:\\Users\\malak\\Desktop\\Programming II\\GUI\\Milestone2-SolutionOld-Bonus\\src\\medic.png");
//						  ImageView imageView = new ImageView(image);
//						  imageView.setFitWidth(30);
//						  imageView.setFitHeight(30);
//
//						  l.setGraphic(imageView);
						}
					else if(h instanceof Fighter)
					{
//
						if(h.getName().equals("Joel Miller")) {
							 ImageView imageView = new ImageView(joelimg);
							  imageView.setFitWidth(40);
							  imageView.setFitHeight(40);
							  if(selectedHero.equals(h))
								  imageView.setEffect(dropShadow);
							  l.setGraphic(imageView);
								button.setOpacity(0);
							}
							if(h.getName().equals("David")) {
								 ImageView imageView = new ImageView(davidimg);
								  imageView.setFitWidth(40);
								  imageView.setFitHeight(40);
								  if(selectedHero.equals(h))
									  imageView.setEffect(dropShadow);
								  l.setGraphic(imageView);
									button.setOpacity(0);
								}
							
//						button.setStyle("-fx-background-color: white;");
//					Image image = new Image("C:\\Users\\malak\\Desktop\\Programming II\\GUI\\Milestone2-SolutionOld-Bonus\\src\\fighter.jpg");
//					  ImageView imageView = new ImageView(image);
//					  imageView.setFitWidth(30);
//					  imageView.setFitHeight(30);
//
//					  button.setGraphic(imageView);
					}
					else if(h instanceof Explorer)
					{
						if(h.getName().equals("Tess")) {
							ImageView imageView = new ImageView(tessimg);
							  imageView.setFitWidth(40);
							  imageView.setFitHeight(40);
							  if(selectedHero.equals(h))
								  imageView.setEffect(dropShadow);
							  l.setGraphic(imageView);
								button.setOpacity(0);
							}
							if(h.getName().equals("Riley Abel")) {
								ImageView imageView = new ImageView(rileyimg);
								  imageView.setFitWidth(40);
								  imageView.setFitHeight(40);
								  if(selectedHero.equals(h))
									  imageView.setEffect(dropShadow);
								  l.setGraphic(imageView);
									button.setOpacity(0);
								}
							if(h.getName().equals("Tommy Miller")) {
								ImageView imageView = new ImageView(tommyimg);
								  imageView.setFitWidth(40);
								  imageView.setFitHeight(40);
								  if(selectedHero.equals(h))
									  imageView.setEffect(dropShadow);
								  l.setGraphic(imageView);
									button.setOpacity(0);
								}
//						button.setStyle("-fx-background-color: white;");
//					Image image = new Image("C:\\Users\\malak\\Desktop\\Programming II\\GUI\\Milestone2-SolutionOld-Bonus\\src\\explorer.png");
//					  ImageView imageView = new ImageView(image);
//					  imageView.setFitWidth(30);
//					  imageView.setFitHeight(30);
//
//					  button.setGraphic(imageView);
					}
					 int x = i;
					 int y = j; 
					 if(selectedHero != null){
						 Hero hero = (Hero)((CharacterCell)Game.map[x][y]).getCharacter();
						 button.setOnAction(e -> {
							 selectedHero.setTarget(hero);
						 });
					 	}
					 }
				 
				 if ((Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie)&&  Game.map[i][j].isVisible()){
					 //button.setText("Z");
					 
						 ImageView imageView = new ImageView(imgzombie1);
						  imageView.setFitWidth(40);
						  imageView.setFitHeight(40);
						  l.setGraphic(imageView);
							button.setOpacity(0);
//							  TranslateTransition transition = new TranslateTransition(Duration.INDEFINITE, l);
//							  
//						        transition.setFromY(0);
//						        transition.setToY(-10);
//						        transition.setInterpolator(Interpolator.EASE_BOTH);
//						        transition.setAutoReverse(true);
//						        transition.setCycleCount(TranslateTransition.INDEFINITE);
//						        transition.play();
//						        
//								 l.setEffect(dropShadowInv);
							Timeline timelineZom = new Timeline();
							timelineZom.setCycleCount(Timeline.INDEFINITE);
							timelineZom.setAutoReverse(true);

					        // Define the initial and target positions for the button
					        double initialPosition = 5;
					        double targetPosition = -5;

					        // Create the key frames for the timeline animation
					        KeyFrame initialPositionFrame = new KeyFrame(Duration.ZERO,
					                new KeyValue(l.translateYProperty(), initialPosition, Interpolator.EASE_BOTH));
					        KeyFrame targetPositionFrame = new KeyFrame(Duration.seconds(1),
					                new KeyValue(l.translateYProperty(), targetPosition, Interpolator.EASE_BOTH));

					        // Add the key frames to the timeline
					        timelineZom.getKeyFrames().addAll(initialPositionFrame, targetPositionFrame);

					        // Start the timeline animation
					        timelineZom.play();


					 if(selectedHero != null){
						 Zombie z = (Zombie) ((CharacterCell) Game.map[i][j]).getCharacter();
						 button.setOnAction(e -> {
						    selectedHero.setTarget(z);
						 });  
					 }	 
				 }
				 if ((Game.map[i][j] instanceof CollectibleCell && ((CollectibleCell)Game.map[i][j]).getCollectible() instanceof Vaccine)&&  Game.map[i][j].isVisible()){
					// button.setText("V");
					 button.setStyle("-fx-background-color: white;");
						  ImageView imageView = new ImageView(potion);
						  imageView.setFitWidth(30);
						  imageView.setFitHeight(30);
						  l.setGraphic(imageView);
						  //button.setGraphic(imageView);
				 }
				 if ((Game.map[i][j] instanceof CollectibleCell && ((CollectibleCell)Game.map[i][j]).getCollectible() instanceof Supply)&&  Game.map[i][j].isVisible()){
				//	 button.setText("S");
					// button.setStyle("-fx-background-color: white;");
						//Image image = new Image("C:\\Users\\malak\\Desktop\\Programming II\\GUI\\Milestone2-SolutionOld-Bonus\\src\\treasure.jpeg");
						  ImageView imageView = new ImageView(fire);
						  imageView.setFitWidth(30);
						  imageView.setFitHeight(30);

						  l.setGraphic(imageView);
				 }
				 else if ( ! Game.map[i][j].isVisible()){
					//button.setStyle("-fx-background-color:#000000; -fx-border-color: black; -fx-border-width: 0px;");
					 button.setOpacity(0.25);
					 

					 
					 l.setText("");
					 button.setEffect(dropShadowInv);
}
//				 
				 
				
			}
			}
		
		
		
		return G;
		
	}
	
	public static VBox controller(){
		VBox v = new VBox();
		v.setSpacing(15);
		Font font = Font.font("Impact", FontWeight.EXTRA_BOLD, 20);
		
		v.setTranslateX(-50);
		v.setTranslateY(50);

		
		Button attackButton = new Button();
		StackPane pAtt = new StackPane();
		Label Attlabel = new Label("Attack");
		pAtt.getChildren().addAll(attackButton, Attlabel);
		attackButton.setPrefSize(150, 120);
		Attlabel.setFont(font);
		Attlabel.setTextFill(Color.WHITESMOKE);
		Attlabel.setTranslateY(50);
		ImageView att = new ImageView(gun);
		att.setFitHeight(100);
		att.setFitWidth(150);
		attackButton.setStyle("-fx-background-color:#000000; -fx-border-color: black; -fx-border-width: 1px;");
		attackButton.setGraphic(att);
		
		
		Button cureButton = new Button();
		StackPane pCure = new StackPane();
		Label CureLabel = new Label("Cure");
		pCure.getChildren().addAll(cureButton, CureLabel);
		cureButton.setPrefSize(150, 120);
		CureLabel.setFont(font);
		CureLabel.setTextFill(Color.WHITESMOKE);
		CureLabel.setTranslateY(50);
		ImageView cure = new ImageView(potion);
		cure.setFitHeight(100);
		cure.setFitWidth(150);
		cureButton.setStyle("-fx-background-color:#000000; -fx-border-color: black; -fx-border-width: 1px;");
		cureButton.setGraphic(cure);

		Button usespecialButton = new Button();
		StackPane pSpecial = new StackPane();
		Label SpecialLabel = new Label("Use Special");
		pSpecial.getChildren().addAll(usespecialButton, SpecialLabel);
		usespecialButton.setPrefSize(150, 120);
		SpecialLabel.setFont(font);
		SpecialLabel.setTextFill(Color.WHITESMOKE);
		SpecialLabel.setTranslateY(50);
		ImageView special = new ImageView(fire);
		special.setFitHeight(100);
		special.setFitWidth(150);
		usespecialButton.setStyle("-fx-background-color:#000000; -fx-border-color: black; -fx-border-width: 1px;");
		usespecialButton.setGraphic(special);

		Button endturnButton =  new Button("End Turn");
		endturnButton.setPrefSize(150, 120);
		endturnButton.setFont(font);
		endturnButton.setTextFill(Color.WHITESMOKE);
		endturnButton.setStyle("-fx-background-color:#000000; -fx-border-color: black; -fx-border-width: 1px;");
		endturnButton.setTranslateX(10);

		v.getChildren().addAll(pAtt,pCure,pSpecial , endturnButton);
		
		attackButton.setOnAction(e -> {
			 try {
				 selectedHero.attack();
				 createscene2();
    	   		 createscene3();
					} 
		        catch (NotEnoughActionsException e1 ) {
					//e1.getMessage();
					Alert alert = new Alert(AlertType.NONE);
			        alert.setTitle("Pop-up Message");
			        alert.setHeaderText(null);
			        alert.setContentText(e1.getMessage());

			     // Enable the close button
			        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

			        // Set the result to close the dialog when the close button is clicked
			        alert.setResult(ButtonType.CLOSE);

			        // Show the alert and wait for it to be closed
			        alert.showAndWait();
					}
			    catch(InvalidTargetException e1){
			    	Alert alert = new Alert(AlertType.NONE);
			        alert.setTitle("Pop-up Message");
			        alert.setHeaderText(null);
			        alert.setContentText(e1.getMessage());

			     // Enable the close button
			        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

			        // Set the result to close the dialog when the close button is clicked
			        alert.setResult(ButtonType.CLOSE);

			        // Show the alert and wait for it to be closed
			        alert.showAndWait();			    }
			 });
			 
			 
			 
			 usespecialButton.setOnAction(e -> {
				 try {
					 
					((Hero) selectedHero).useSpecial();
					 createscene2();
	    	   		 createscene3();
						} 
			        catch (NoAvailableResourcesException e1 ) {
						//e1.getMessage();
						Alert alert = new Alert(AlertType.NONE);
				        alert.setTitle("Pop-up Message");
				        alert.setHeaderText(null);
				        alert.setContentText(e1.getMessage());

				     // Enable the close button
				        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

				        // Set the result to close the dialog when the close button is clicked
				        alert.setResult(ButtonType.CLOSE);

				        // Show the alert and wait for it to be closed
				        alert.showAndWait();	
				        }
				 
				    catch(InvalidTargetException e1){
				    	Alert alert = new Alert(AlertType.NONE);
				        alert.setTitle("Pop-up Message");
				        alert.setHeaderText(null);
				        alert.setContentText(e1.getMessage());

				     // Enable the close button
				        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

				        // Set the result to close the dialog when the close button is clicked
				        alert.setResult(ButtonType.CLOSE);

				        // Show the alert and wait for it to be closed
				        alert.showAndWait();					    }
				 });
			
			 
			 cureButton.setOnAction(e -> {
				 try {
					((Hero) selectedHero).cure();
					 createscene2();
						} 
			        catch (NoAvailableResourcesException e1 ) {
						Alert alert = new Alert(AlertType.NONE);
				        alert.setTitle("Pop-up Message");
				        alert.setHeaderText(null);
				        alert.setContentText(e1.getMessage());

				     // Enable the close button
				        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

				        // Set the result to close the dialog when the close button is clicked
				        alert.setResult(ButtonType.CLOSE);

				        // Show the alert and wait for it to be closed
				        alert.showAndWait();							}
				    catch(InvalidTargetException e1){
				    	Alert alert = new Alert(AlertType.NONE);
				        alert.setTitle("Pop-up Message");
				        alert.setHeaderText(null);
				        alert.setContentText(e1.getMessage());

				     // Enable the close button
				        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

				        // Set the result to close the dialog when the close button is clicked
				        alert.setResult(ButtonType.CLOSE);

				        // Show the alert and wait for it to be closed
				        alert.showAndWait();					    }
				 catch(NotEnoughActionsException e1){
				    	Alert alert = new Alert(AlertType.NONE);
				        alert.setTitle("Pop-up Message");
				        alert.setHeaderText(null);
				        alert.setContentText(e1.getMessage());

				     // Enable the close button
				        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

				        // Set the result to close the dialog when the close button is clicked
				        alert.setResult(ButtonType.CLOSE);

				        // Show the alert and wait for it to be closed
				        alert.showAndWait();					 }
				 });
				
			 endturnButton.setOnAction(e -> {
					 try {
						 Game.endTurn();
						 createscene2();
		    			 createscene3();

							} 
				        catch (NotEnoughActionsException e1 ) {
						
							Alert alert = new Alert(AlertType.NONE);
					        alert.setTitle("Pop-up Message");
					        alert.setHeaderText(null);
					        alert.setContentText(e1.getMessage());

					     // Enable the close button
					        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

					        // Set the result to close the dialog when the close button is clicked
					        alert.setResult(ButtonType.CLOSE);

					        // Show the alert and wait for it to be closed
					        alert.showAndWait();
							}
					    catch(InvalidTargetException e1){
					    	Alert alert = new Alert(AlertType.NONE);
					        alert.setTitle("Pop-up Message");
					        alert.setHeaderText(null);
					        alert.setContentText(e1.getMessage());

					     // Enable the close button
					        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

					        // Set the result to close the dialog when the close button is clicked
					        alert.setResult(ButtonType.CLOSE);

					        // Show the alert and wait for it to be closed
					        alert.showAndWait();			    }
					 });
		
		
		return v;
	}
	
	
	 public static void  createscene2() {
		 BorderPane b = new BorderPane();
		b.setBackground(new Background(new BackgroundFill(Color.rgb(159, 226, 191), null, null)));
	 Image imgS1 = new Image("/darkforest.jpg");
	 BackgroundImage backgroundImg = new BackgroundImage(
             imgS1,
             BackgroundRepeat.NO_REPEAT,
             BackgroundRepeat.NO_REPEAT,
             BackgroundPosition.DEFAULT,
             new BackgroundSize(
                     BackgroundSize.AUTO,
                     BackgroundSize.AUTO,
                     true,
                     true,
                     false,
                     true
             )	        );
		
		b.setBackground(new Background(backgroundImg));
		
		 GridPane g = map();
		
		 b.setCenter(g);
		 
		 VBox vCont = new VBox();
		 vCont.getChildren().addAll(controller());
		 b.setRight(vCont);
		 vCont.setPrefSize(100, 650);
		 Label l = new Label();
			Font font = Font.font("Impact", FontWeight.EXTRA_LIGHT, 15);
			l.setFont(font);
			l.setTextFill(Color.WHITESMOKE);
			l.setText("Currently playing : \n"+selectedHero.toString());
			ImageView imageView = heroImg(selectedHero);
			imageView.setFitHeight(110);
			imageView.setFitWidth(80);
			l.setGraphic(imageView);

		 VBox v = new VBox();
		 BorderPane moveButton =  new BorderPane();
		 v.getChildren().addAll(l,DisplayHeroes(),moveButton);
			l.setTranslateX(20);
			v.setSpacing(25);
			v.setPrefSize(250,650);
		 b.setLeft(v);
		 
		// double height 
		 g.setPrefSize(600,300);

		 

			moveButton.setPrefSize(75, 150);
			moveButton.setTranslateX(20);


			BackgroundImage backgroundImgMove = new BackgroundImage(
	                moveIcon,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.DEFAULT,
	                new BackgroundSize(75,150, true,
	                        true,
	                        true,
	                        false
	                )	        );
			
			moveButton.setBackground(new Background(backgroundImgMove));
			int x = selectedHero.getLocation().x;
	        int y = selectedHero.getLocation().y;
	        Button up = new Button();
	        
	        Button down = new Button();

	        
	        Button left = new Button();

        
	        Button right = new Button();
      

	        moveButton.setTop(up);
	        up.setTranslateX(50);
	      up.setPrefSize(50, 50);
	      up.setOpacity(0);
	      
	        moveButton.setLeft(left);
	        moveButton.setAlignment(left, Pos.CENTER_LEFT);
	        left.setPrefSize(50, 60);
	        left.setOpacity(0);

	        moveButton.setBottom(down);
	        down.setTranslateX(50);
	        down.setPrefSize(50, 50);
	        down.setOpacity(0);

	        moveButton.setRight(right);
	        right.setTranslateX(-90);
	        right.setTranslateY(5);
	        right.setPrefSize(50, 60);
	        right.setOpacity(0);

	        
	            up.setOnAction(e->{ 
	            	try {
	            		checkTrapCell(x+1 , y);
	    				selectedHero.move(Direction.UP);
	    				createscene2();
	    				createscene3();

	    			} catch (NotEnoughActionsException e1 ) {
	    				
	    				Alert alert = new Alert(AlertType.WARNING);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();				}
	    		    catch(MovementException e1){
	    		    	Alert alert = new Alert(AlertType.NONE);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();		   
	    		        }
	            }
	            		);
	            down.setOnAction(e->{
	        
	            	try {
	            		checkTrapCell(x-1 , y);
	    				selectedHero.move(Direction.DOWN);
	    				createscene2();
	    				createscene3();

	    			} catch (NotEnoughActionsException e1 ) {
	    				//e1.getMessage();
	    				Alert alert = new Alert(AlertType.WARNING);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();				}
	    		    catch(MovementException e1){
	    		    	Alert alert = new Alert(AlertType.NONE);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();		   
	    		        }
	            }
	            		);
	            
	            left.setOnAction(e->{
	            	try {
	            		checkTrapCell(x, y-1);
	    				selectedHero.move(Direction.LEFT);
	    				createscene2();
	    				createscene3();

	    			} catch (NotEnoughActionsException e1 ) {
	    			
	    				Alert alert = new Alert(AlertType.WARNING);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();				}
	    		    catch(MovementException e1){
	    		    	Alert alert = new Alert(AlertType.NONE);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();		   
	    		        }
	            }
		);
	            
	            
	            right.setOnAction(e->{
	            	try {
	            		checkTrapCell(x , y+1);
	    				selectedHero.move(Direction.RIGHT);
	    				createscene2();
	    				createscene3();
	    			} catch (NotEnoughActionsException e1 ) {
	    				Alert alert = new Alert(AlertType.WARNING);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();				}
	    		    catch(MovementException e1){
	    		    	Alert alert = new Alert(AlertType.NONE);
	    		        alert.setTitle("Pop-up Message");
	    		        alert.setHeaderText(null);
	    		        alert.setContentText(e1.getMessage());

	    		        // Enable the close button
	    		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

	    		        // Set the result to close the dialog when the close button is clicked
	    		        alert.setResult(ButtonType.CLOSE);

	    		        // Show the alert and wait for it to be closed
	    		        alert.showAndWait();		   
	    		        }
	            
	            
	            
	        });
	    
				 
		 
		 
		 
		 
		 
		 
		 s2 = new Scene (b, 1300,650);
		 
		// Window.hide();
		 Window.setScene(s2);
		// Window.show();
	 }
	 
	 
        
        public static void  createscene3() {   	
        				
		
        	
	   		 if(Game.checkWin()) {
	   			 BorderPane b = new BorderPane();
	   			 
	   			BackgroundImage backgroundImg = new BackgroundImage(
		                win,
		                BackgroundRepeat.NO_REPEAT,
		                BackgroundRepeat.NO_REPEAT,
		                BackgroundPosition.DEFAULT,
		                new BackgroundSize(
		                        BackgroundSize.AUTO,
		                        BackgroundSize.AUTO,
		                        true,
		                        true,
		                        false,
		                        true
		                )	        );
				
				b.setBackground(new Background(backgroundImg));
				
	   			 Label l = new Label("SURVIVOR");
	   			Font font = Font.font("Impact", FontWeight.EXTRA_BOLD, 50);
	   			l.setFont(font);
				l.setTextFill(Color.WHITESMOKE);
	   			 b.setTop(l);
		        b.setTop(l);
				l.setTranslateY(50);
				l.setTranslateX(750);
				
				DropShadow dropShadow = new DropShadow();
		        dropShadow.setOffsetX(2.5);
		        dropShadow.setOffsetY(2.5);
		        dropShadow.setColor(Color.GRAY);

		        // Apply the DropShadow effect to the Text
		        l.setEffect(dropShadow);

		        // Create a Timeline animation
		        Timeline timeline = new Timeline();
		        timeline.getKeyFrames().addAll(
		                new KeyFrame(Duration.ZERO, new KeyValue(dropShadow.spreadProperty(), 1)),
		                new KeyFrame(Duration.seconds(1), new KeyValue(dropShadow.spreadProperty(), 0))
		        );
		        timeline.setCycleCount(Timeline.INDEFINITE);
		        timeline.setAutoReverse(true);
		        timeline.play();
		        
	   			 Scene s3 = new Scene(b,1300,650);
	   	   		// Window.hide();
	   	   		 Window.setScene(s3);
	   	   		// Window.show();
	   	   		 return;
	   		 }
	   		 if(Game.checkGameOver()) {
	   			
	   			 
	   			 BorderPane b = new BorderPane();
	   			 
		   			BackgroundImage backgroundImg = new BackgroundImage(
			                lose,
			                BackgroundRepeat.NO_REPEAT,
			                BackgroundRepeat.NO_REPEAT,
			                BackgroundPosition.DEFAULT,
			                new BackgroundSize(
			                        BackgroundSize.AUTO,
			                        BackgroundSize.AUTO,
			                        true,
			                        true,
			                        false,
			                        true
			                )	        );
					
					b.setBackground(new Background(backgroundImg));
					
		   			 Label l = new Label("Prepare to die, loser!");
		   			Font font = Font.font("Impact", FontWeight.EXTRA_BOLD, 50);
		   			l.setFont(font);
					l.setTextFill(Color.WHITESMOKE);
			        b.setTop(l);
					l.setTranslateY(50);
					l.setTranslateX(750);
					
					DropShadow dropShadow = new DropShadow();
			        dropShadow.setOffsetX(2.5);
			        dropShadow.setOffsetY(2.5);
			        dropShadow.setColor(Color.GRAY);

			        // Apply the DropShadow effect to the Text
			        l.setEffect(dropShadow);

			        // Create a Timeline animation
			        Timeline timeline = new Timeline();
			        timeline.getKeyFrames().addAll(
			                new KeyFrame(Duration.ZERO, new KeyValue(dropShadow.spreadProperty(), 1)),
			                new KeyFrame(Duration.seconds(1), new KeyValue(dropShadow.spreadProperty(), 0))
			        );
			        timeline.setCycleCount(Timeline.INDEFINITE);
			        timeline.setAutoReverse(true);
			        timeline.play();
			        
		   			 Scene s3 = new Scene(b,1300,650);
	   			 
	   			 
	   	   		// Window.hide();
	   	   		 Window.setScene(s3);
	   	   		// Window.show();
	   	   		 return;
	   		 }
   	   		 return;
        }
        
        
        public static void checkTrapCell(int x , int y) {
    		if ((x < 0 || y < 0 || x > Game.map.length - 1 || y > Game.map.length - 1) || 
    				(selectedHero.getActionsAvailable() < 1 ))
    			return;
    		
    		else {
    			
        	if(Game.map[x][y] instanceof TrapCell) {
        		Alert alert = new Alert(AlertType.WARNING);
		        alert.setTitle("Pop-up Message");
		        alert.setHeaderText(null);
		        alert.setContentText("You entered a trap cell");
		        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		        // Set the result to close the dialog when the close button is clicked
		        alert.setResult(ButtonType.CLOSE);
		        // Show the alert and wait for it to be closed
		        alert.showAndWait();		
        	}
        	
    		}
        	
        }
        
        
        public static ImageView heroImg(Hero h) {
   		 ImageView v = new ImageView();

        	 if(h.getName().equals("Bill")) 
        		 v = new ImageView(billimg) ;      	 
				if(h.getName().equals("Ellie Williams")) 
	        		 v = new ImageView(ellieimg) ;      	 

				if(h.getName().equals("Henry Burell")) 
	        		 v = new ImageView(henryimg) ;      	 
					
				if(h.getName().equals("Joel Miller")) 
	        		 v = new ImageView(joelimg) ;      	 
				
				if(h.getName().equals("David")) 
	        		 v = new ImageView(davidimg) ;      	 

				if(h.getName().equals("Tess")) 
	        		 v = new ImageView(tessimg) ;      	 
				
				if(h.getName().equals("Riley Abel"))
	        		 v = new ImageView(rileyimg) ;      	 


				if(h.getName().equals("Tommy Miller")) 
	        		 v = new ImageView(tommyimg) ;      	 

				
				return v;
        }
        
        
	 
	 
	 
	 
	 
	 
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
