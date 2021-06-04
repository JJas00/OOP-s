package airline_reservation_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Airline_Reservation_System {
	
	Flight economyclass;
	Flight economy_businessclass;
	Flight economy_firstclass;
	BufferedReader br;
	
	Airline_Reservation_System(){
		this.economyclass = new Type1_Flight();
		this.economy_businessclass = new Type2_Flight();
		this.economy_firstclass = new Type3_Flight();
		this.br=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Airline_Reservation_System airline_system = new Airline_Reservation_System();
		while(true){
			System.out.print("Choose Flight Type\n 1.economyclass\n 2.economy_businessclass\n 3.economy_firstclass");
			int choice = Integer.parseInt(airline_system.br.readLine());
			switch(choice){
			case 1:
				airline_system.economyclass.get_available_seats();
				break;
			case 2:
				airline_system.economy_businessclass.get_available_seats();
				break;
			case 3:
				airline_system.economy_firstclass.get_available_seats();
				break;
			}
		}	
		}
		
}
