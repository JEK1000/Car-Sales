package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Model extends Car {
	
	private double price,mileage;
	private String make,model,year;
	
	public Model(String cn, String m, double p,double mile,String y) {
		
		super(cn, m, p,y);
		setPrice(p);
		setModel(m);
		setMake(cn);
		this.mileage=mile;
	}

	
	Model(){
		price=0.0;
		mileage=0.0;
		make="Not Found.";
		model="Not Found.";
	}
	
	public void setPrice(double p) {
		this.price=p;
	}
	
	public void setMake(String m) {
		this.make=m;
	}
	
	public void setModel(String mod) {
		this.model=mod;
	}
	
	
	public String getMake() {
		return make;
	}
	
	public void setYear(String y) {
		this.year = y;
	}
	
	public String getModel() {
		return model;
	}

	public double getPrice() {
		return price;
	}
	public double getMileage() {
		return mileage;
	}
	
	public String getYear() {
		return year;
	}
	
	@Override
	public void packageA() {}

	@Override
	public void packageB() {}

	@Override
	ImageView getImage(String mod) {
		
		Image s40,s60,s70,s80;
		String m = mod;
		s40 = new Image("volvoS40.jpg");
		s60 = new Image("volvoS60.jpg");
		s70 = new Image("volvoS70.jpg");
		s80 = new Image("volvoS80.jpg");
		ImageView i;
		
		switch(m) {
			case "s40":
				i = new ImageView(s40);
				 return i;
			case "s60":
				i = new ImageView(s60);
				return i;
			case "s70":
				i = new ImageView(s70);
				return i;
			case "s80":
				i = new ImageView(s80);
				return i;
		}
		return null;
	}


}
