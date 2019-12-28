package application;

//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Car {
	
	private String cName,model,year;
	private double price;
	
	Car(String cn,String m,double p,String y){
		
		setMake(cn);
		setModel(m);
		setPrice(p);
		setYear(y);
	}
	
	Car(){
		cName="Not Found.";
		model="Not found.";
		price=0.0;
		year = "Not Found";
	}
	
	public void setMake(String n) {
		this.cName = n;
	}
	
	public void setModel(String m) {
		this.model=m;
	}
	public void setYear(String y) {
		this.year = y;
	}
	
	public void setPrice(double p) {
		this.price=p;
	}
	
	public String getMake() {
		return cName;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getModel() {
		return model;
	}
	
	public double getPrice() {
		return price;
	}
	
	abstract void packageA();
	abstract void packageB();
	abstract ImageView getImage(String m);
	
}
