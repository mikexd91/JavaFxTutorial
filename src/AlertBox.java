import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class AlertBox {
	public static void display(String title, String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
	    window.setMinWidth(250);
	    
	    Label label = new Label();
	    label.setText(message);
	    Button closeButton = new Button ("close the window");
	    closeButton.setOnAction(e -> window.close());
	    
	    VBox layout = new VBox(10);
	    layout.getChildren().addAll(label,closeButton);
	    layout.setAlignment(Pos.CENTER);
	    
	    Scene scene = new Scene(layout);
	    window.setScene(scene);
	    window.showAndWait();
	    
	}
}
