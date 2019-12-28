package application;


import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene2 extends Main implements Interface{
	
	private BorderPane pane2;
	private ImageView imageS40,imageS60,imageS70,imageS80;
	private String fName,lName,email,number;
	private HBox hb2,hb3;
	private VBox vb;
	private GridPane gp;
	private final double prefSizeHeight = 600;
	private final double prefSizeWidth = 800;
	private double total;
	private String monthlyPayment;
	Double newPayment;
	Random rand = new Random();
	Car[] car = new Model[4];
	Model[] c = (Model[])car;
	
	public Scene2(User fields,Stage s) {
		
		pane2 = new BorderPane(); 
		this.fName = fields.getFirstName();
		this.lName = fields.getLastName();
		this.email = fields.getEmail();
		this.number = fields.getPhoneNumber();
	}
	
	
	public BorderPane getScene2() {

		pane2.setPrefSize(prefSizeWidth,prefSizeHeight);
		hb2 = topHBox();
		gp = getCars();
		vb = getUserSelection();
		hb3 = bottomHBox();
		pane2.setTop(hb2);
		pane2.setLeft(gp);
		pane2.setRight(vb);
		pane2.setBottom(hb3);
		return pane2;
	}
	
	public void displayScene2(Stage s) {
		
		Scene scene = new Scene(getScene2());
		s.setScene(scene);
    	s.show();
	}
	
	public HBox topHBox() {
		
		Label greet,fn,accNum;
		final int min = 100000;
		HBox hb;
		int randNum = rand.nextInt(min)+1;
		
		greet = new Label("Hello, ");
		accNum = new Label("Account Number: "+randNum);
		fn = new Label(fName+" | \t");		
		hb = new HBox();
		hb.setStyle("-fx-background-color:lightblue");
		hb.setPrefSize(800,2);
		hb.setAlignment(Pos.TOP_RIGHT);
		hb.setPadding(new Insets(0,10,0,0));
		hb.getChildren().addAll(greet,fn, accNum);
		return hb;
	}
	
	public HBox bottomHBox() {
		Label l = new Label("");
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		
		hb.setStyle("-fx-background-color:lightblue");
		hb.setPrefSize(800,20);
		hb.getChildren().add(l);
		return hb;
	}

	
	public GridPane getCars() {
		
		GridPane imageBox = new GridPane();
		Label s40,s60,s70,s80;
		Button details1 = new Button("More Details");
		Button details2 = new Button("More Details");
		Button details3 = new Button("More Details");
		Button details4 = new Button("More Details");
		
		VBox v,v2,v3,v4;
		
		for(int i = 0; i < car.length; i++) {
			c[0] = new Model("Volvo","S40",27700,400,"2019");
			c[1] = new Model("Volvo","S60",32500,10,"2019");
			c[2] = new Model("Volvo","S70",36000,540,"2019");
			c[3] = new Model("Volvo","S80",44000,12,"2019");
		}
		
		imageS40 = c[0].getImage("s40");
		imageS60 = c[1].getImage("s60");
		imageS70 = c[2].getImage("s70");
		imageS80 = c[3].getImage("s80");
		
		details1.setAlignment(Pos.BOTTOM_LEFT);

		s40 = new Label("Make: "+c[0].getMake()+"\nModel: "+c[0].getModel()+"\nPrice: "
		+String.format("%.0f",c[0].getPrice())+"\nMileage: "+String.format("%.0f",c[0].getMileage())+"\nYear: "+c[0].getYear());
		v = new VBox(s40,details1);
		v.setAlignment(Pos.TOP_LEFT);
			
		s60 = new Label("Make: "+c[1].getMake()+"\nModel: "+c[1].getModel()+"\nPrice: "
		+String.format("%.0f",c[1].getPrice())+"\nMileage: "+String.format("%.0f",c[1].getMileage())+"\nYear: "+c[1].getYear());
		v2 = new VBox(s60,details2);
		v2.setAlignment(Pos.TOP_LEFT);
			
		s70 = new Label("Make: "+c[2].getMake()+"\nModel: "+c[2].getModel()+"\nPrice: "
		+String.format("%.0f",c[2].getPrice())+"\nMileage: "+String.format("%.0f",c[2].getMileage())+"\nYear: "+c[2].getYear());
		v3 = new VBox(s70,details3);
		v3.setAlignment(Pos.TOP_LEFT);
			
		s80 = new Label("Make: "+c[3].getMake()+"\nModel: "+c[3].getModel()+"\nPrice: "
		+String.format("%.0f",c[3].getPrice())+"\nMileage: "+String.format("%.0f",c[3].getMileage())+"\nYear: "+c[3].getYear());
		v4 = new VBox(s80,details4);
		v4.setAlignment(Pos.TOP_LEFT);

		
		imageS40.setFitWidth(200);
		imageS40.setPreserveRatio(true);
		imageS60.setFitWidth(200);
		imageS60.setPreserveRatio(true);
		imageS70.setFitWidth(200);
		imageS70.setPreserveRatio(true);
		imageS80.setFitWidth(200);
		imageS80.setPreserveRatio(true);
		
		imageBox.setVgap(10);
		imageBox.setHgap(10);
		imageBox.add(imageS40,0,0);
		imageBox.add(imageS60,0,1);
		imageBox.add(imageS70,0,2);
		imageBox.add(imageS80,0,3);
		imageBox.add(v,1,0);
		imageBox.add(v2,1,1);
		imageBox.add(v3,1,2);
		imageBox.add(v4,1,3);
		imageBox.setPadding(new Insets(5));
		imageBox.setMaxHeight(250);
		imageBox.setMaxWidth(600);
		
		details1.setOnAction(e->{
			Stage s = new Stage();
			HBox vb = new HBox();
			vb = getS40();
			Scene scene1 = new Scene(vb);
			s.setScene(scene1);
			s.show();				
		});
		
		details2.setOnAction(e->{
			Stage s = new Stage();
			HBox vb = new HBox();
			vb = getS60();
			Scene scene1 = new Scene(vb);
			s.setScene(scene1);
			s.show();		
		});
			
		details3.setOnAction(e->{
			Stage s = new Stage();
			BorderPane vb = new BorderPane();
			vb = getS70();
			Scene scene1 = new Scene(vb);
			s.setScene(scene1);
			s.show();			
		});
		
		details4.setOnAction(e->{
			Stage s = new Stage();
			BorderPane vb = new BorderPane();
			vb = getS80();
			Scene scene1 = new Scene(vb);
			s.setScene(scene1);
			s.show();			

		});
		return imageBox;
	}	
	
	
	public VBox getUserSelection() {
		
		Label taxTotal = new Label("");
		Label taxT = new Label("");
		Label titleTags= new Label("");
		Label ttPrice = new Label("");
		Label cashDCount = new Label("");
		Label tradeIn,paint;
		Label monthlyCharge = new Label();
		Label model,totalPrice,priceTotal,months;
		Button reset = new Button("Reset");
		Button calc = new Button("Calculate");
		Button b = new Button("Enter");
		Button b2 = new Button("Enter");
		CheckBox paintOpt,cash;
		ToggleGroup tg,tg2;
		RadioButton S40,S60,S70,S80,basicPack,advPack,fin;
		ComboBox<Integer> monthlyTerm;
		TextField trade;
		HBox paymentOpt;
		HBox hb,hb2,hb3,hb4,hb5,hb7;
		VBox vb,vb2;	
		VBox vboxSummary = new VBox();
		final double tax = 0.06;
		final double titleTagsPrice = 325.00;
		final Double interestRate = 0.07;

		totalPrice = new Label("");
		priceTotal = new Label("");
		paint = new Label("");
		cash = new CheckBox("Cash Payment");
		months = new Label(" Months ");
		monthlyTerm = new ComboBox<>();
		monthlyTerm.getItems().addAll(12,24,36,48,60);
		tradeIn = new Label("Trade-In Value: ");
		trade = new TextField();
		trade.setPrefWidth(100);		
		
		fin = new RadioButton("Finance 7%");	
	
		b2.setOnAction(e->{
			try {
			String tradeVal = "";
			tradeVal = trade.getText();
			Double tv = Double.parseDouble(tradeVal);
			
			while(tv < 0) {
			if(tv < 0) 
				throw new IllegalArgumentException();
			else if(tv > 0) 
				return;
			
			}
			while(tv > total) {
				if(tv > total) 
					throw new Exception();
				else if(tv<total)
					return;
			}
			total-=tv;
			Double d2;
			if(calc.isPressed() && monthlyPayment!=null) {
				d2 = newPayment*=total;
				monthlyPayment = String.format("%.2f",d2);
			}
					
			b2.setText("Done");
			b2.setDisable(true);
			
			}catch(IllegalArgumentException er) {
				Stage s = new Stage();
				Label input = new Label("Enter a positve number.");
				Button ok = new Button("OK");
				ok.setOnAction(err->{
					s.close();
				});
				VBox h = new VBox(40,input,ok);
				h.setPrefSize(200, 150);
				h.setAlignment(Pos.CENTER);
				Scene s2 = new Scene(h);
				s.setScene(s2);
				s.show();
			}
			catch(Exception errr) {
				Stage s = new Stage();
				Label input = new Label("Input cannot be greater than the car's value");
				Button ok = new Button("OK");
				ok.setOnAction(err->{
					s.close();
				});
				VBox h = new VBox(40,input,ok);
				h.setPrefSize(280, 150);
				h.setAlignment(Pos.CENTER);
				Scene s2 = new Scene(h);
				s.setScene(s2);
				s.show();
			}
		});
	
		HBox hbTn = new HBox(tradeIn,trade,b2);
		hbTn.setAlignment(Pos.CENTER_RIGHT);
		VBox vbTradein = new VBox(hbTn);
		
		vbTradein.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: lightgrey;");
		
		vbTradein.setMaxHeight(100);
		vbTradein.setAlignment(Pos.CENTER_RIGHT);
		
		for(int i = 0; i < car.length; i++) {
			c[0] = new Model("Volvo","S40",27700,400,"2019");
			c[1] = new Model("Volvo","S60",32500,10,"2019");
			c[2] = new Model("Volvo","S70",36000,540,"2019");
			c[3] = new Model("Volvo","S80",44000,12,"2019");
		}

		model = new Label("Model:");
		
		S40 = new RadioButton("S40");
		S60 = new RadioButton("S60");
		S70 = new RadioButton("S70");
		S80 = new RadioButton("S80");
		basicPack = new RadioButton("Basic Package");
		advPack = new RadioButton("Advanced Package");
		paintOpt = new CheckBox("Matallic Paint");
		
		tg = new ToggleGroup();	
		tg2 = new ToggleGroup();	
		S40.setToggleGroup(tg);
		S60.setToggleGroup(tg);
		S70.setToggleGroup(tg);
		S80.setToggleGroup(tg);
		basicPack.setToggleGroup(tg2);
		advPack.setToggleGroup(tg2);

		hb = new HBox(5,model,S40,S60,S70,S80);
		hb2 = new HBox(basicPack);
		hb3 = new HBox(advPack);
		hb5 = new HBox(paintOpt);
		vb2 = new VBox(vbTradein);
		hb4 = new HBox(reset,calc);
		hb7 = new HBox(cash);
		paymentOpt = new HBox(monthlyTerm,months);
		vb = new VBox(10,hb,hb2,hb3,hb5,hb7,vb2,fin,paymentOpt,vboxSummary,hb4);

		vb.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 1;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: grey;");
		vb.setMaxHeight(100);
		
		basicPack.setDisable(true);
		advPack.setDisable(true);
		paintOpt.setDisable(true);
		calc.setDisable(true);
		cash.setDisable(true);
		monthlyTerm.setDisable(true);
		fin.setDisable(true);
		
		reset.setOnAction(e->{
			S40.setDisable(false);
			S60.setDisable(false);
			S70.setDisable(false);
			S80.setDisable(false);
			basicPack.setDisable(true);
			advPack.setDisable(true);
			paintOpt.setDisable(true);
			basicPack.setSelected(false);
			advPack.setSelected(false);
			paintOpt.setSelected(false);
			S40.setSelected(false);
			S60.setSelected(false);
			S70.setSelected(false);
			S80.setSelected(false);
			totalPrice.setText("");
			b.setDisable(false);
			b.setText("Enter");
			b2.setDisable(false);
			b2.setText("Enter");
			trade.setText("");
			taxT.setText("");
			titleTags.setText("");
			priceTotal.setText("");
			ttPrice.setText("");
			taxTotal.setText("");
			calc.setDisable(true);
			cash.setDisable(true);
			cash.setSelected(false);
			monthlyTerm.setDisable(true);
			fin.setDisable(true);
			fin.setSelected(false);
			monthlyTerm.setValue(0);
			monthlyCharge.setText("");
			cashDCount.setText("");
			paint.setText("");
			total = 0;
		});
		
		fin.setOnAction(e->{
			if(fin.isSelected()) {
				monthlyTerm.setDisable(false);
				cash.setDisable(true);
			}
			if(!monthlyTerm.isFocused()) {
				monthlyCharge.setText("");
			}
		});
		
		
		monthlyTerm.setOnAction(e->{
			String mp2 = "";
			Integer t = monthlyTerm.getValue();
			Double monthlyIR = interestRate/12;
			Double math = monthlyIR+1;
			Double math2 = Math.pow(math, t);
			Double math3 = math2*monthlyIR;
			Double math4 = Math.pow(math, t)-1;
			Double math5 = total*(math3/math4);
			Double mp = math5;
			mp2 = String.format("%.2f",mp);
			monthlyPayment = mp2;
			newPayment = newMonthlyPayment(math3,math4);
		});
		
		cash.setOnAction(e->{
			if(cash.isSelected())
				total-=750;
			else
				total = 0;
			cash.setDisable(true);
			fin.setDisable(true);
		});
	
		S40.setOnAction(e ->{
		if(S40.isSelected()) 
			basicPack.setDisable(false);
			advPack.setDisable(true);
			paintOpt.setDisable(false);
			S60.setDisable(true);
			S70.setDisable(true);
			S80.setDisable(true);
			total+=c[0].getPrice();
			advPack.setDisable(true);
			calc.setDisable(true);
			cash.setDisable(false);
			fin.setDisable(false);
		});
		
		S60.setOnAction(e ->{
		if(S60.isSelected()) 
			basicPack.setDisable(false);
			advPack.setDisable(true);
			paintOpt.setDisable(false);
			S40.setDisable(true);
			S70.setDisable(true);
			S80.setDisable(true);
			cash.setDisable(false);
			calc.setDisable(true);
			fin.setDisable(false);
			total+=c[1].getPrice();
		});
		
		S70.setOnAction(e ->{
		if(S70.isSelected()) 
			advPack.setDisable(false);
			basicPack.setDisable(false);
			paintOpt.setDisable(false);
			S40.setDisable(true);
			S60.setDisable(true);
			S80.setDisable(true);
			calc.setDisable(true);
			cash.setDisable(false);
			fin.setDisable(false);
			total+=c[2].getPrice();
		});
		
		S80.setOnAction(e ->{
		if(S80.isSelected())
			advPack.setDisable(false);
			basicPack.setDisable(false);
			paintOpt.setDisable(false);
			calc.setDisable(true);
			S40.setDisable(true);
			S60.setDisable(true);
			S70.setDisable(true);
			cash.setDisable(false);
			fin.setDisable(false);
			total+=c[3].getPrice();
				
		});	

		
		paintOpt.setOnAction(e->{
			calc.setDisable(false);
			total+=650;
			paintOpt.setDisable(true);
			if(paintOpt.isSelected() && monthlyPayment != null) {
				Double d2;
				d2 = newPayment*=total;
				monthlyPayment = String.format("%.2f",d2);
				if(calc.isPressed())
				monthlyCharge.setText("Payment: $"+monthlyPayment+" /Month");
			}
			if(!fin.isSelected()) {
				monthlyCharge.setText("");
			}
		});
		
		basicPack.setOnAction(e ->{
			calc.setDisable(false);
			if(basicPack.isSelected()) {
				Double d;
				total+=2200;
			advPack.setDisable(true);
			
				if(basicPack.isSelected() && monthlyPayment!=null ) {
					d = newPayment*=total;
					monthlyPayment = String.format("%.2f",d);
				if(calc.isPressed())
					monthlyCharge.setText("Payment: $"+monthlyPayment+" /Month");
				}

			if(!fin.isSelected()) {
				monthlyCharge.setText("");
			}
		}
		});
		
		advPack.setOnAction(e->{
			calc.setDisable(false);
			if(advPack.isSelected()) {
				total+=3250;
			basicPack.setDisable(true);
			if(advPack.isSelected() && monthlyPayment!=null) {
				Double d;
				d = newPayment*=total;
				monthlyPayment = String.format("%.2f",d);
			if(calc.isPressed())	
				monthlyCharge.setText("Payment: $"+monthlyPayment+" /Month");
			}
			if(!fin.isSelected()) {
				monthlyCharge.setText("");
			}
		}
		});
		

		calc.setOnAction(e->{
	
			if(cash.isSelected()) {
				cashDCount.setText("Cash Discount: -$750.00");
			}
			if(paintOpt.isSelected()) 
				paint.setText("Metallic Paint: $650.00");
				
			if(monthlyPayment != null) {
				monthlyCharge.setText("Payment: $"+monthlyPayment+" /Month");
			}			
			if(!fin.isSelected()) {
				monthlyCharge.setText("");
			}
			String grandTotal;
			double taxx = (taxRate(tax)*total);
			String getTax = String.format("%.2f",taxx);
			double tags = (titleTags(titleTagsPrice));
			String getTags = String.format("%.2f",tags);
			double totalCarPrice = (taxRate(tax)*total)+total+titleTags(titleTagsPrice);
			grandTotal = String.format("%.2f",totalCarPrice);
			
			taxT.setText("Tax:  $"+getTax);
			titleTags.setText("Title & Tags:  $"+getTags);
			priceTotal.setText("Total:  $"+grandTotal);
			VBox v = new VBox(titleTags,taxT,paint,cashDCount,monthlyCharge,priceTotal);
			vboxSummary.getChildren().addAll(v);
			
		});
		return vb;
	}
	
	public double newMonthlyPayment(double m1,double m2) {
		Double math1 = m1;
		Double math2 = m2;
		Double divide;
		divide = (math1/math2);
		return divide;
	}
	
	
	public HBox getS40() {
		Label title,bPack,features;
		title = new Label("S40 Package");
		bPack = new Label("Basic Package:\t\t$2,200");
		features = new Label("Navigation System\n\nLeather Seats\n\n"
							+ "Auto Temperature Control\n\nPower Sunroof\n\n"
							+ "WirelessPHone connectivity");
		HBox vb = new HBox(title);
		vb.setPadding(new Insets(0,0,20,0));
		VBox vb2 = new VBox(15,bPack,features);
		VBox wrap = new VBox(vb,vb2);
		wrap.setPadding(new Insets(0,0,0,5));
		wrap.setPrefSize(300, 250);
		vb.setAlignment(Pos.TOP_CENTER);
		HBox vb1 = new HBox(wrap);
		return vb1;
	}
	
	public HBox getS60() {
		Label title,bPack,features;
		title = new Label("S60 Package");
		bPack = new Label("Basic Package:\t\t$2,200");
		features = new Label("Navigation System\n\nTailored Dashboard\n\n"
							+ "Auto Temperature Control\n\n"
							+ "Bluetooth\n\nLane Assist");
		HBox vb = new HBox(title);
		vb.setPadding(new Insets(0,0,20,0));
		VBox vb2 = new VBox(15,bPack,features);
		VBox wrap = new VBox(vb,vb2);
		wrap.setPadding(new Insets(0,0,0,5));
		wrap.setPrefSize(300, 250);
		vb.setAlignment(Pos.TOP_CENTER);
		HBox vb5 = new HBox(wrap);
		return vb5;
	}
	
	public BorderPane getS70() {
		Label title,bPack,features,advFeatures,advDetails;
		title = new Label("S70 Package");
		bPack = new Label("Basic Package:\t\t$2,200\n\n\n\n");
		advFeatures = new Label("Advanced Package:\t$3,250\n");
		features = new Label("Navigation System\n\nLeather Seats\n\n"
							+ "Auto Temperature Control\n\n"
							+ "Wireless Phone Charging\n\nBose Speakers");
		
		advDetails = new Label("\nIncludes Basic Package*\n\nFull LED Headlights\n\n360° Surroundview Camera\n\nGraphical Head Up Display");
		HBox vb = new HBox(title);
		VBox vb3 = new VBox(advFeatures,advDetails);
		vb3.setPadding(new Insets(18,0,0,120));
		vb.setPadding(new Insets(0,0,20,0));
		VBox vb2 = new VBox(bPack,features);
		VBox wrap = new VBox(vb,vb2);
		wrap.setPadding(new Insets(0,0,0,5));
		wrap.setPrefSize(300, 250);
		vb.setAlignment(Pos.TOP_CENTER);
		BorderPane vb5 = new BorderPane();
		vb5.setPadding(new Insets(5));
		vb5.setPrefHeight(300);
		vb5.setTop(vb);
		vb5.setLeft(vb2);
		vb5.setRight(vb3);
		
		return vb5;
	}
	
	public BorderPane getS80() {
		Label title,bPack,features,advFeatures,advDetails;
		title = new Label("S80 Package");
		bPack = new Label("Basic Package:\t\t$2,200\n\n\n\n");
		advFeatures = new Label("Advanced Package:\t$3,250\n");
		features = new Label("Navigation System\n\nLeather Seats\n\n"
							+ "Auto Temperature Control\n\n"
							+ "Wireless Phone Charging\n\nLane Assist\n\nBose Speakers");
		
		advDetails = new Label("\nIncludes Basic Package*\n\nFull LED Headlights\n\n360° Surroundview Camera"
				+ "\n\nGraphical Head Up Display\n\nHeated Seats\n\nApple Car Play");
		HBox vb = new HBox(title);
		VBox vb3 = new VBox(advFeatures,advDetails);
		vb3.setPadding(new Insets(18,0,0,120));
		vb.setPadding(new Insets(0,0,20,0));
		VBox vb2 = new VBox(bPack,features);
		VBox wrap = new VBox(vb,vb2);
		wrap.setPadding(new Insets(0,0,0,5));
		wrap.setPrefSize(300, 250);
		vb.setAlignment(Pos.TOP_CENTER);
		BorderPane vb5 = new BorderPane();
		vb5.setPadding(new Insets(5));
		vb5.setPrefHeight(300);
		vb5.setTop(vb);
		vb5.setLeft(vb2);
		vb5.setRight(vb3);
		
		return vb5;
	}


	@Override
	public double taxRate(double tax) {
		double t= tax;
		return t;
		
	}


	@Override
	public double titleTags(double t) {
		double tags = t;
		return tags;
	}
}
