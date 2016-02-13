import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

	Button button;
	Stage window;
	Scene scene0,scene1,scene2;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)throws Exception{
		window = primaryStage;
		
		// *************************borderpane tutorial scene 0
		HBox topMenu =  new HBox();
		Button buttonA = new Button("File");
		Button buttonB = new Button("Edit");
		Button buttonC = new Button("View");
		topMenu.getChildren().addAll(buttonA,buttonB,buttonC);
		
		VBox leftMenu =  new VBox();
		Button buttonD = new Button("branch");
		Button buttonE = new Button("tag");
		Button buttonF = new Button("master");
		leftMenu.getChildren().addAll(buttonD,buttonE,buttonF);
		
		Label label0 = new Label("Welcome to scene0");
		Button button0 = new Button("go to scene 1");
		button0.setOnAction(e -> window.setScene(scene1));
		
		VBox layout0 = new VBox(20);
		layout0.getChildren().addAll(label0,button0);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setCenter(layout0);
		
		scene0 = new Scene(borderPane,300,250);
		//***********************************************
		
		//*********************Scene 1(pop up, confirm box, link to scene 2)**********
		
		//label 1 and button 1
		Label label1 = new Label("Welcome to scene1");
		Button button1 = new Button("go to scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		
		Button button3 = new Button("alert box");
		button3.setOnAction(e -> AlertBox.display("flash pop", "awesome"));
		
		//button 3 - pop up
		Button button4 = new Button("confirm box");
		button4.setOnAction(e->{
			boolean result = confirmBox.display("Title of window","are you sure you want to send naked pic?");
			System.out.println(result);
		});
		
		//button close program
		Button closeButton = new Button("close button");
		closeButton.setOnAction(e -> closeProgram() );
		
		
		//layout 1 - children are laid out in a vertical column
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1,button1,button3,button4,closeButton);
		scene1 = new Scene(layout1,200,200);
		
		
		//************************scene 2********************
		//button 2
		Button button2 = new Button("go to scene 1");
		button2.setOnAction(e -> window.setScene(scene1));
		
		//layout 2 - stackpane
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2,200,200);
		
		
		window.setOnCloseRequest(e-> {
			e.consume();
			closeProgram();
		});
		
		window.setScene(scene0);
		window.setTitle("flashpoint");
		window.show();
	}
	
	private void closeProgram(){
		Boolean answer =  confirmBox.display("Title","Are you sure you want to exit?");
		if(answer){
			window.close();
		}
	}
	
}
