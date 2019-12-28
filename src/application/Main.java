package application;

import javafx.application.Application;
import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	private TextField name,lName,address,number;
	private AnchorPane pane;
	protected BorderPane pane2;
	private VBox infoBox;
	private HBox nameBox,lNameBox,addressBox,numberBox;
	private Label l,fName,lastN,email,pNum;
	private HBox labelBox,fnBox,lnBox,eBox,pNumBox,sBox;
	private Button submit;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Scene scene = new Scene(getMenu(primaryStage));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Volvo Sale");
	    	primaryStage.show();
	    	primaryStage.setOnCloseRequest(e->{
	    		Platform.exit();
	    		System.exit(0);
	    	});
	    	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AnchorPane getMenu(Stage stage) {
		
		pane = new AnchorPane();
		pane.setPrefSize(800,600);
		
		l = new Label("Enter your information below:");
		fName = new Label("First Name:");
		lastN = new Label("Last Name:");
		email = new Label("Email:");
		pNum = new Label("Phone Number:");
		
		name = new TextField();
		lName = new TextField();
		address = new TextField();
		number = new TextField();
		
		submit = new Button("Submit");
		
		name.setPrefWidth(250);
		lName.setPrefWidth(250);
		address.setPrefWidth(250);
		number.setPrefWidth(250);
		submit.setPrefWidth(250);
		
		labelBox = new HBox(l);
		fnBox = new HBox(fName);
		lnBox = new HBox(lastN);
		eBox = new HBox(email);
		pNumBox = new HBox(pNum);
		sBox = new HBox(submit);
		
		nameBox = new HBox(name);
		lNameBox = new HBox(lName);
		addressBox = new HBox(address);
		numberBox = new HBox(number);
	
		labelBox.setAlignment(Pos.CENTER);
		nameBox.setAlignment(Pos.CENTER);
		lNameBox.setAlignment(Pos.CENTER);
		addressBox.setAlignment(Pos.CENTER);
		numberBox.setAlignment(Pos.CENTER);
		sBox.setAlignment(Pos.CENTER);
		
		labelBox.setPadding(new Insets(20,0,20,0));
		nameBox.setPadding(new Insets(0,0,10,0));
		lNameBox.setPadding(new Insets(0,0,10,0));
		addressBox.setPadding(new Insets(0,0,10,0));
		numberBox.setPadding(new Insets(0,0,10,0));
		sBox.setPadding(new Insets(20,0,0,0));
		
		fnBox.setPadding(new Insets(0,0,0,55));
		lnBox.setPadding(new Insets(0,0,0,55));
		eBox.setPadding(new Insets(0,0,0,55));
		pNumBox.setPadding(new Insets(0,0,0,55));

		infoBox = new VBox(
				labelBox,fnBox,nameBox,lnBox,
				lNameBox,eBox,addressBox,pNumBox,numberBox,sBox
				);
		infoBox.setPrefSize(350,350);
		infoBox.setLayoutX(230);
		infoBox.setLayoutY(150);
		infoBox.setStyle("-fx-background-color:lightblue");
		
		pane.getChildren().addAll(infoBox);
		
		submit.setOnAction(event->{
			try {
				int num1;
			User u;
			String fn,ln,mail,num;
			fn = name.getText();
			ln = lName.getText();
			mail = address.getText();
			num = number.getText();
			if(fn.isEmpty() || ln.isEmpty() || mail.isEmpty() || num.isEmpty()) {
				num1 = Integer.parseInt(fn);
			}
			u = new User(fn,ln,mail,num);
			Scene2 s = new Scene2(u,stage);
			s.displayScene2(stage);
			
			stage.setOnCloseRequest(e->{
	    		Platform.exit();
	    		System.exit(0);
			});
			}catch(NumberFormatException e) {
				Stage s = new Stage();
				Label input = new Label("Enter valid input.");
				Button ok = new Button("OK");
				ok.setOnAction(f->{
					s.close();
				});
				VBox h = new VBox(40,input,ok);
				h.setPrefSize(200, 150);
				h.setAlignment(Pos.CENTER);
				Scene s2 = new Scene(h);
				s.setScene(s2);
				s.show();		
			}

			});
		return pane;
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}