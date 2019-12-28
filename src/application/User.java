package application;

public class User {
	
	private String name,lName,email,pNumber;
	
	User(String n, String ln, String e, String pNum){
		
		setFirstName(n);
		setlastName(ln);
		setEmail(e);
		setNum(pNum);
	}

	User(){
		name = "First name not Found";
		lName = "Last name not Found";
		email = "Email not Found";
		pNumber = "Phone Number not Found";
	}
	
	//setter
	
	public void setFirstName(String n) {
		name = n;
	}
	
	public void setlastName(String ln) {
		lName = ln;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public void setNum(String pNum) {
		pNumber = pNum;
	}
	
	
	//getter
	
	public String getFirstName() {
		return name;
	}
	
	public String getLastName() {
		return lName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return pNumber;
	}
	
}
