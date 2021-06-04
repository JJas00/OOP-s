package airline_reservation_system;

public class Passenger {
	
	//Instance Variables
	public String passengerName;
	public String seat;
	public double weight;
	public double charges;
	
	//Getters
	public String getName() {
		return passengerName;
	}
	
	public String getSeat(){
		return seat;
	}
	
	//Setters
	public void setName(String name) {
		this.passengerName = name;
	}
	
	public void setSeat(String seating){
		this.seat = seating;
	}
	
	public void buyExcessBaggage(){
		
	}
	
	public void makePayment(){
		
	}

}// Passenger